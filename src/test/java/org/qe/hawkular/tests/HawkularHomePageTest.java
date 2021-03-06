package org.qe.hawkular.tests;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumLocalWebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.HawkularLoginPageConstants;
import org.qe.hawkular.element.HawkularManagementConsolePageConstants;
import org.qe.hawkular.element.HawkularRegistrationPageConstants;
import org.qe.hawkular.page.HawkularLoginPage;
import org.qe.hawkular.page.HawkularConsoleAddUrlPage;
import org.qe.hawkular.page.HawkularRegistrationPage;
import org.qe.hawkular.util.HawkularDataProvider;
import org.qe.hawkular.util.HawkularUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.saucelabs.testng.SauceOnDemandTestListener;

/**
 * Test case for menu navigation, add URL and Delete URL
 *
 */

public class HawkularHomePageTest extends HawkularSeleniumLocalWebDriver {
    WebDriver driver = null;

    @BeforeSuite
    public void prepateUser() throws MalformedURLException {
        WebDriver driver = createLocalDriver();
        HawkularRegistrationPage registration = new HawkularRegistrationPage(
                driver);
        driver.get(HawkularSeleniumWebDriver.hawkularUrl);
        _logger.info(driver.getTitle());
        registration.registerUserIfDoesNotExist(
                HawkularRegistrationPageConstants.username,
                HawkularRegistrationPageConstants.password,
                HawkularRegistrationPageConstants.confirmPassword,
                HawkularRegistrationPageConstants.firstName,
                HawkularRegistrationPageConstants.lastName,
                HawkularRegistrationPageConstants.email);

    }

    @AfterMethod
    public void closeSession() {
        driver.quit();
    }

    @Test
    public void hawkularAddURLTest() throws Exception {
        driver = createLocalDriver();

        driver.get(HawkularSeleniumWebDriver.hawkularUrl);
        _logger.info(driver.getTitle());

        HawkularLoginPage loginPage = new HawkularLoginPage(driver);

        HawkularUtils util = new HawkularUtils(driver);
        util.assertTitle(HawkularLoginPageConstants.loginTitle);

        loginPage.loginAs(HawkularRegistrationPageConstants.username,
                HawkularRegistrationPageConstants.password);

        HawkularConsoleAddUrlPage addUrlPage = new HawkularConsoleAddUrlPage(
                driver);
        addUrlPage.verifyConsoleImagePresent();
        addUrlPage.navigateToURLsMenu();
        addUrlPage.typeURL(HawkularManagementConsolePageConstants.testURL);
        addUrlPage.submitURL();
        addUrlPage.verifyUrlExists();
    }

    @Test
    public void hawkularDeleteURLTest() throws Exception {
        driver = createLocalDriver();

        driver.get(HawkularSeleniumWebDriver.hawkularUrl);
        _logger.info(driver.getTitle());

        HawkularLoginPage loginPage = new HawkularLoginPage(driver);

        HawkularUtils util = new HawkularUtils(driver);
        util.assertTitle(HawkularLoginPageConstants.loginTitle);

        loginPage.loginAs(HawkularRegistrationPageConstants.username,
                HawkularRegistrationPageConstants.password);

        HawkularConsoleAddUrlPage addUrlPage = new HawkularConsoleAddUrlPage(
                driver);
        addUrlPage.verifyConsoleImagePresent();
        addUrlPage.navigateToURLsMenu();
        addUrlPage.deleteURL();
        addUrlPage.verifyUrlDoesnotExist();
    }

    @Test
    public void hawkularMenuNavigationTest() throws Exception {
        driver = createLocalDriver();

        driver.get(HawkularSeleniumWebDriver.hawkularUrl);
        _logger.info(driver.getTitle());

        HawkularLoginPage loginPage = new HawkularLoginPage(driver);

        HawkularUtils util = new HawkularUtils(driver);
        util.assertTitle(HawkularLoginPageConstants.loginTitle);

        loginPage.loginAs(HawkularRegistrationPageConstants.username,
                HawkularRegistrationPageConstants.password);

        HawkularConsoleAddUrlPage addUrlPage = new HawkularConsoleAddUrlPage(
                driver);
        addUrlPage.verifyConsoleImagePresent();
        addUrlPage.urlsMenuExists();
        addUrlPage.appServersMenuExists();
        addUrlPage.navigateToAppServersMenu();
        addUrlPage.verifyAppServersMenuNavigation();
        addUrlPage.navigateToURLsMenu();
        addUrlPage.verifyURLsMenuNavigation();

    }

    @Test
    public void hawkularUrlFilterByNameTest() throws Exception {
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
        addUrlPage.typeURL(HawkularManagementConsolePageConstants.testURL);
        addUrlPage.submitURL();
        addUrlPage
                .typeURL(HawkularManagementConsolePageConstants.testanotherURL);
        addUrlPage.submitURL();
        addUrlPage.filterByName("redhat");
        addUrlPage.VerifyfilterByName();
    }

    @Test
    public void hawkularUrlFilterByStateTest() throws Exception {
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
        addUrlPage.filterByStateUp();
        addUrlPage.verifyFilterByStateUp();
        addUrlPage.filterByStateDown();
        addUrlPage.VerifyFilterByStateDown();
    }

    // To-do: Move login to hawkular to @BeforeSuite
}
