package org.qe.hawkular.tests;

import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumLocalWebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.*;
import org.qe.hawkular.page.*;
import org.testng.annotations.Test;

public class HawkularDatasourcesTest extends HawkularSeleniumLocalWebDriver {

    public WebDriver hawkularLoginToDeployments() throws Exception {
        WebDriver driver = createLocalDriver();

        driver.get(HawkularSeleniumWebDriver.hawkularUrl);
        System.out.println(driver.getTitle());

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
        selectAppServer.navigateToDatasourcesTab();

        return driver;
    }

    @Test
    public void hawkularAddJDBCDriversTest() throws Exception {
        WebDriver driver = hawkularLoginToDeployments();
        HawkularDatasourcesPage page = new HawkularDatasourcesPage(
                driver);
        page.navigateAddDriverTab();
        page.loadDriverFile();
        page.defineDriverParams();
        page.addDriverSubmit();
        page.verifyDriverUploadSuccess(); 
        //driver.quit();
    }

    @Test
    public void hawkularExportJDRTest() throws Exception {
        WebDriver driver = hawkularLoginToDeployments();
        HawkularDatasourcesPage page = new HawkularDatasourcesPage(
                driver);
        page.exportJDR();
        page.verifyExportJDRSuccess();
        driver.quit();
    }

}
