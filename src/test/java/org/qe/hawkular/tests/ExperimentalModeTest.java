package org.qe.hawkular.tests;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.driver.HawkularSeleniumLocalWebDriver;
import org.qe.hawkular.element.HawkularInstallAgentConstants;
import org.qe.hawkular.element.HawkularRegistrationPageConstants;
import org.qe.hawkular.page.HawkularLoginPage;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExperimentalModeTest extends HawkularSeleniumLocalWebDriver {
	
	WebDriver driver = null;	
	
	@BeforeMethod
	public void startUp() throws MalformedURLException{
		driver = createLocalDriver();
		driver.get(HawkularSeleniumWebDriver.hawkularUrl);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void hawkularLoginTest()	throws Exception {
		HawkularLoginPage loginPage = new HawkularLoginPage(driver);
		loginPage.loginAs(HawkularRegistrationPageConstants.username, HawkularRegistrationPageConstants.password);				
		WebElement elem = driver.findElement(HawkularInstallAgentConstants.logoLocator);
		elem.click();		
		WebElement elemAI = driver.findElement(HawkularInstallAgentConstants.installAgentLocator);
		askSubject(elemAI);		
		elem.click();	
		askSubject(elemAI);		
	}

	private void askSubject(Object asked) {  	// -> utils ?
		Reporter.log(HawkularInstallAgentConstants.testSubject + ((WebElement) asked).isDisplayed());		
	}
}
