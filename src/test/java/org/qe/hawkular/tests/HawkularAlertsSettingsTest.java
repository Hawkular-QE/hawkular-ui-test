package org.qe.hawkular.tests;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumLocalWebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.HawkularLoginPageConstants;
import org.qe.hawkular.element.HawkularManagementConsolePageConstants;
import org.qe.hawkular.element.HawkularRegistrationPageConstants;
import org.qe.hawkular.page.HawkularAlertsSettingsPage;
import org.qe.hawkular.page.HawkularConsoleAddUrlPage;
import org.qe.hawkular.page.HawkularLoginPage;
import org.qe.hawkular.page.HawkularRegistrationPage;
import org.qe.hawkular.util.HawkularUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * Test case on alerts and alert settings
 *
 */

public class HawkularAlertsSettingsTest extends HawkularSeleniumLocalWebDriver {
	WebDriver driver = null;
	
	@BeforeSuite
	public void prepareUser() throws MalformedURLException {
		WebDriver driver = createLocalDriver();
		driver.get(HawkularSeleniumWebDriver.hawkularUrl);
		System.out.println(driver.getTitle());
		HawkularRegistrationPage registration = new HawkularRegistrationPage(
				driver);
		registration.registerUserIfDoesNotExist(HawkularRegistrationPageConstants.username, HawkularRegistrationPageConstants.password, HawkularRegistrationPageConstants.confirmPassword, HawkularRegistrationPageConstants.firstName, HawkularRegistrationPageConstants.lastName, HawkularRegistrationPageConstants.email);

	}

	@AfterMethod
	public void closeSession() {
		driver.quit();
	}
	
	@Test
	public void hawkularAlertsSettingsTest() throws Exception {
		driver = createLocalDriver();

		driver.get(HawkularSeleniumWebDriver.hawkularUrl);
		System.out.println(driver.getTitle());
		HawkularLoginPage loginPage = new HawkularLoginPage(driver);
		HawkularUtils util = new HawkularUtils(driver);
		util.assertTitle(HawkularLoginPageConstants.loginTitle);
		loginPage.loginAs(HawkularRegistrationPageConstants.username,
				HawkularRegistrationPageConstants.password);

		HawkularConsoleAddUrlPage addUrlPage = new HawkularConsoleAddUrlPage(
				driver);
		addUrlPage.verifyConsoleImagePresent();
		addUrlPage.typeURL(HawkularManagementConsolePageConstants.testURL);
		addUrlPage.submitURL();
		addUrlPage.verifyUrlExists();
		addUrlPage.navigateToURL();

		HawkularAlertsSettingsPage alertsSettings = new HawkularAlertsSettingsPage(driver);
		alertsSettings.navigateToAllAlerts();
		alertsSettings.verifyAllAlertsLinkPresent();
		alertsSettings.navigateToAlertsSettings();
		alertsSettings.verifyAlertSettingsOpened();
	}
}
