package org.qe.hawkular.tests;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumLocalWebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.HawkularLoginPageConstants;
import org.qe.hawkular.element.HawkularManagementConsolePageConstants;
import org.qe.hawkular.element.HawkularRegistrationPageConstants;
import org.qe.hawkular.page.HawkularConsoleAddUrlPage;
import org.qe.hawkular.page.HawkularLoginPage;
import org.qe.hawkular.page.HawkularRegistrationPage;
import org.qe.hawkular.page.HawkularAppServerPage;
import org.qe.hawkular.util.HawkularUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Test case to navigate to app server and JVM/deployment tab of the app server
 *
 * @author Sunil Kondkar
 */

public class HawkularAppServerTest extends HawkularSeleniumLocalWebDriver {
	WebDriver driver = null;
	
    @BeforeSuite
    public void prepareUser() throws MalformedURLException {
        WebDriver driver = createLocalDriver();
        driver.get(HawkularSeleniumWebDriver.hawkularUrl);
        _logger.info(driver.getTitle());
        HawkularRegistrationPage registration = new HawkularRegistrationPage(
                driver);
        registration.registerUserIfDoesNotExist(HawkularRegistrationPageConstants.username2, HawkularRegistrationPageConstants.password2, HawkularRegistrationPageConstants.confirmPassword2, HawkularRegistrationPageConstants.firstName2, HawkularRegistrationPageConstants.lastName2, HawkularRegistrationPageConstants.email2);

    }

	@AfterMethod
	public void closeSession() {
		driver.quit();
	}

    @Test
    public void hawkularAppServerInventoryTest() throws Exception {
        driver = createLocalDriver();

        driver.get(HawkularSeleniumWebDriver.hawkularUrl);
        _logger.info(driver.getTitle());
        HawkularLoginPage loginPage = new HawkularLoginPage(driver);
        HawkularUtils util = new HawkularUtils(driver);
        util.assertTitle(HawkularLoginPageConstants.loginTitle);
        loginPage.loginAs(HawkularRegistrationPageConstants.username2,
                HawkularRegistrationPageConstants.password2);

        HawkularConsoleAddUrlPage addUrlPage = new HawkularConsoleAddUrlPage(
                driver);
        addUrlPage.verifyConsoleImagePresent();
        HawkularAppServerPage appServerPage = new HawkularAppServerPage(driver);
        addUrlPage.navigateToAppServersMenu();
        addUrlPage.verifyAppServersMenuNavigation();
        appServerPage.verifyLocalAppServerExists();
        appServerPage.navigateToLocalAppServer();
        appServerPage.verifyAppServerOverviewTabNavigation();
        loginPage.logout();
    }
    
    @Test
    public void hawkularAppServerDeploymentsTest() throws Exception {
        driver = createLocalDriver();

        driver.get(HawkularSeleniumWebDriver.hawkularUrl);
        _logger.info(driver.getTitle());
        HawkularLoginPage loginPage = new HawkularLoginPage(driver);
        HawkularUtils util = new HawkularUtils(driver);
        util.assertTitle(HawkularLoginPageConstants.loginTitle);
        loginPage.loginAs(HawkularRegistrationPageConstants.username2,
                HawkularRegistrationPageConstants.password2);

        HawkularConsoleAddUrlPage addUrlPage = new HawkularConsoleAddUrlPage(
                driver);
        addUrlPage.verifyConsoleImagePresent();
        HawkularAppServerPage appServerPage = new HawkularAppServerPage(driver);
        addUrlPage.navigateToAppServersMenu();
        addUrlPage.verifyAppServersMenuNavigation();
        appServerPage.verifyLocalAppServerExists();
        appServerPage.navigateToLocalAppServer();
        appServerPage.verifyAppServerOverviewTabNavigation();
        appServerPage.navigateToDeploymentsTab();
        appServerPage.verifyAppServerDeploymentsTabNavigation();
        appServerPage.verifyAppServerWarExists();
        
    }
    
    @Test
    public void hawkularURLTraitsTest() throws Exception {
        driver = createLocalDriver();

        driver.get(HawkularSeleniumWebDriver.hawkularUrl);
        _logger.info(driver.getTitle());
        HawkularLoginPage loginPage = new HawkularLoginPage(driver);
        HawkularUtils util = new HawkularUtils(driver);
        util.assertTitle(HawkularLoginPageConstants.loginTitle);
        loginPage.loginAs(HawkularRegistrationPageConstants.username2,
                HawkularRegistrationPageConstants.password2);

        HawkularConsoleAddUrlPage addUrlPage = new HawkularConsoleAddUrlPage(
                driver);
        addUrlPage.verifyConsoleImagePresent();
        addUrlPage.navigateToURLsMenu();
        addUrlPage.addURLIfDoesNotExist(HawkularManagementConsolePageConstants.testURL);
        addUrlPage.verifyURLTraitsExists();
        addUrlPage.deleteURL();
        addUrlPage.verifyUrlDoesnotExist();
        loginPage.logout();
        
    }

}

