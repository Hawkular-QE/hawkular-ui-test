package org.qe.hawkular.tests;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.driver.HawkularSeleniumLocalWebDriver;
import org.qe.hawkular.element.HawkularLoginPageConstants;
import org.qe.hawkular.element.HawkularManagementConsolePageConstants;
import org.qe.hawkular.element.HawkularRegistrationPageConstants;
import org.qe.hawkular.page.HawkularLoginPage;
import org.qe.hawkular.page.HawkularRegistrationPage;
import org.qe.hawkular.util.HawkularDataProvider;
import org.qe.hawkular.util.HawkularUtils;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.saucelabs.testng.SauceOnDemandTestListener;

public class ExperimentalModeTest extends HawkularSeleniumLocalWebDriver {
	
	WebDriver driver = null;	
	
	@BeforeSuite
	public void prepareUser() throws MalformedURLException {
		WebDriver driver = createLocalDriver();
		HawkularRegistrationPage registration = new HawkularRegistrationPage(driver);
		driver.get(HawkularSeleniumWebDriver.hawkularUrl);
		System.out.println(driver.getTitle());
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
	public void hawkularLoginTest()	throws Exception {
		WebDriver driver = createLocalDriver();
		driver.get(HawkularSeleniumWebDriver.hawkularUrl);
		Reporter.log(driver.getTitle());

		HawkularLoginPage loginPage = new HawkularLoginPage(driver);
		loginPage.loginAs(HawkularRegistrationPageConstants.username, HawkularRegistrationPageConstants.password);		
		
		WebElement elem = driver.findElement(By.id("hawkularLogo"));
		System.out.println("FOUND: " + elem.getText());
		elem.click();		

		WebElement elemAI = driver.findElement(By.xpath("//*[contains(text(),'Install Agent')]"));
		Reporter.log("FOUND: " + elemAI.getText());
		Reporter.log("Is 'install agent' displayed - " + elemAI.isDisplayed());
		
		elem.click();	
		Reporter.log("Is 'install agent' displayed - " + elemAI.isDisplayed());

		loginPage.logout();
	}
}
