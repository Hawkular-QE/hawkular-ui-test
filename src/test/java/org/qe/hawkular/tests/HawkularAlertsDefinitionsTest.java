package org.qe.hawkular.tests;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumLocalWebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.*;
import org.qe.hawkular.page.*;
import org.qe.hawkular.util.HawkularUtils;
import org.qe.hawkular.util.SSHClient;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HawkularAlertsDefinitionsTest extends HawkularSeleniumLocalWebDriver {

    protected static final Logger log = Logger.getLogger(SSHClient.class.getName());
    protected static final int MAIL_CYCLE_CHECK_INTERVAL_SEC = 60;
    protected static final String MAIL_TYPE_JVM_HEAP_USED = "jvm_pheap";
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
        WebDriver driver = hawkularLoginToJVM();
        defineJVMAlerts(driver, 60f, 30f);
        checkMailNotif(driver);
    }

    public void defineJVMAlerts(WebDriver driver, float heapUsageGreaterThan, float heapUsageLessThan)
            throws Exception {
        HawkularAppServerJVMPage page = new HawkularAppServerJVMPage(
                driver);
        // page.navigateToJVMTab();  // so far its default page of application server
        page.openAlertSettings();
        page.setHeapUsageGreaterThan(heapUsageGreaterThan);
        page.setHeapUsageLessThan(heapUsageLessThan);
        page.setOptionCreateAlert();
        page.setLocalEmail();
        page.saveAndVerify(heapUsageGreaterThan + 1);
    }

    public String getAlertResourcePathFromAlertDetail(WebDriver driver) throws Exception {
        // navigate to {HAWKULAR_SERVER:8080}/hawkular-ui/alerts-center and check triggered
        HawkularAlertCenterPage page = new HawkularAlertCenterPage(
                driver);
        page.navigateToAlertCenter();
        page.navigateToLastHeapUsedAlert();
        String resourcePath = page.getResourcePathFromDetail();
        log.info("Alert resourcePath: " + resourcePath);
        page.detailChangeStateToResolved();
        page.detailAddComment("Automation test - added comment to confirm State change");
        page.navigateToAlertCenter();
        return resourcePath;
    }

    public void checkMailNotif(WebDriver driver) throws Exception {
        // waiting for mail to appear and check Message-ID with regexp
        String resourcePath = getAlertResourcePathFromAlertDetail(driver);
        for (int i = 0; i < MAIL_CYCLE_CHECK_INTERVAL_SEC; i++) {
            if (checkMailForResourcePathString(resourcePath))
                return;
            Thread.sleep(1000);
        }
        Assert.fail();
    }

    public boolean checkMailForResourcePathString(String resourcePath) throws Exception {
        // resourcePath example: /t;28026b36-8fe4-4332-84c8-524e173a68bf/e;test/f;vprusa-hawk-ms6-test4/r;vprusa-hawk-ms6-test4~Local~~
        // example: Message-ID: 28026b36-8fe4-4332-84c8-524e173a68bf-vprusa-hawk-ms6-test4~Local_jvm_pheap-1447262157428
        SSHClient c = SSHClient.fromProperties();
        c.execCommnad("cd ~");
        c.execCommnad("grep 'Message-ID:.*" + MAIL_TYPE_JVM_HEAP_USED + "' " + MAIL_FILE_PATH);
        String s = c.getLastOutput();
        c.execCommnad("sed -i -E 's/(Message-ID).*(" + MAIL_TYPE_JVM_HEAP_USED + ")/ALREADY_CHECKED/' "
                + MAIL_FILE_PATH);

        String x = resourcePath.substring(resourcePath.indexOf("\t;") + 4, resourcePath.indexOf("/e;"));
        return (s != null && s.contains(x));
    }

}
