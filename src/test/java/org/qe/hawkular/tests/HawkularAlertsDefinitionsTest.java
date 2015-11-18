package org.qe.hawkular.tests;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumLocalWebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.*;
import org.qe.hawkular.page.*;
import org.qe.hawkular.util.SSHClient;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HawkularAlertsDefinitionsTest extends HawkularSeleniumLocalWebDriver {

    protected static final Logger log = Logger.getLogger(SSHClient.class.getName());
    protected static final int MAIL_CYCLE_CHECK_INTERVAL_SEC = 60;
    protected static final String MAIL_TYPE_JVM_HEAP_USAGE = "jvm_pheap";
    protected static final String MAIL_TYPE_JVM_NON_HEAP_USAGE = "jvm_nheap";
    protected static final String MAIL_FILE_PATH = "/var/spool/mail/hudson";

    public WebDriver hawkularLoginToJVM() throws Exception {
        WebDriver driver = createLocalDriver();

        driver.get(HawkularSeleniumWebDriver.hawkularUrl);
        log.info(driver.getTitle());

        HawkularLoginPage loginPage = new HawkularLoginPage(driver);

        loginPage.verifyLoginTitle();

        loginPage = new HawkularLoginPage(driver);
        loginPage.loginAs(HawkularRegistrationPageConstants.username2,
                HawkularRegistrationPageConstants.password2);

        HawkularConsoleAddUrlPage clickAppServer = new HawkularConsoleAddUrlPage(
                driver);
        clickAppServer.navigateToAppServersMenu();

        HawkularAppServerPage selectAppServer = new HawkularAppServerPage(
                driver);

        selectAppServer.verifyLocalAppServerExists();
        selectAppServer.navigateToLocalAppServer();
        return driver;
    }

    @Test
    public void hawkularAlertSettingsTest() throws Exception {
        // Needs to reset Alert definition settings to run again, because Save button in modal dialog is disabled when values are same
        WebDriver driver = hawkularLoginToJVM();
        defineJVMAlerts(driver, 60f, 30f);
        checkAllMailNotifs(driver);
        driver.close();
    }

    public void defineJVMAlerts(WebDriver driver, float heapUsageGreaterThan, float heapUsageLessThan)
            throws Exception {
        HawkularAppServerJVMPage page = new HawkularAppServerJVMPage(
                driver);
        // page.navigateToJVMTab();  // so far its default page of application server

        // Heap Usage
        page.openAlertSettings();
        page.setHeapUsageGreaterThan(heapUsageGreaterThan);
        page.setHeapUsageLessThan(heapUsageLessThan);
        page.setHeapUsageOptionCreateAlert();
        page.setLocalHeapUsageEmail();

        // Non-Heap Usage
        page.toNonHeapUsage();

        page.setNonHeapUsageGreaterThan(heapUsageGreaterThan);
        page.setNonHeapUsageLessThan(heapUsageLessThan);
        page.setNonHeapUsageOptionCreateAlert();
        page.setLocalNonHeapUsageEmail();

        page.saveAndVerify(heapUsageGreaterThan + 1);
    }

    public String getAlertResourcePathFromAlertDetail(WebDriver driver, final String mail_type_jvm_heap_used)
            throws Exception {
        // navigate to {HAWKULAR_SERVER:8080}/hawkular-ui/alerts-center and check triggered
        HawkularAlertCenterPage page = new HawkularAlertCenterPage(
                driver);
        page.navigateToAlertCenter();
        if (mail_type_jvm_heap_used.matches(MAIL_TYPE_JVM_HEAP_USAGE)) {
            page.navigateToLastHeapUsedAlert();
        } else {
            page.navigateToLastNonHeapUsedAlert();
        }
        String resourcePath = page.getResourcePathFromDetail();
        log.info("Alert resourcePath: " + resourcePath);
        page.detailChangeStateToResolved();
        page.detailAddComment("Automation test - added comment to confirm State change");
        page.navigateToAlertCenter();
        return resourcePath;
    }

    public void checkAllMailNotifs(WebDriver driver) throws Exception {
        checkMailNotif(driver, MAIL_TYPE_JVM_HEAP_USAGE);
        checkMailNotif(driver, MAIL_TYPE_JVM_NON_HEAP_USAGE);
    }

    //MAIL_TYPE_JVM_HEAP_USED
    public void checkMailNotif(WebDriver driver, final String mail_type_jvm_heap_used)
            throws Exception {
        String resourcePath = getAlertResourcePathFromAlertDetail(driver, mail_type_jvm_heap_used);
        // waiting for mail to appear and check Message-ID with regexp
        for (int i = 0; i < MAIL_CYCLE_CHECK_INTERVAL_SEC; i++) {
            if (checkMailForResourcePathString(resourcePath, mail_type_jvm_heap_used))
                return;
            Thread.sleep(1000);
        }
        Assert.fail();
    }

    public boolean checkMailForResourcePathString(String resourcePath, final String mail_type_jvm_heap_used)
            throws Exception {
        // resourcePath example: /t;28026b36-8fe4-4332-84c8-524e173a68bf/e;test/f;vprusa-hawk-ms6-test4/r;vprusa-hawk-ms6-test4~Local~~
        // example: Message-ID: 28026b36-8fe4-4332-84c8-524e173a68bf-vprusa-hawk-ms6-test4~Local_jvm_pheap-1447262157428
        SSHClient c = SSHClient.fromProperties();
        c.execCommnad("cd ~");
        c.execCommnad("grep 'Message-ID:.*" + mail_type_jvm_heap_used + "' " + MAIL_FILE_PATH);
        String s = c.getLastOutput();
        c.execCommnad("sed -i -E 's/(Message-ID).*(" + mail_type_jvm_heap_used + ")/ALREADY_CHECKED/' "
                + MAIL_FILE_PATH);

        String x = resourcePath.substring(resourcePath.indexOf("\t;") + 4, resourcePath.indexOf("/e;"));
        return (s != null && s.contains(x));
    }

}
