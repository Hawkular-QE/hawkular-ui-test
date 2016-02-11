package org.qe.hawkular.tests;

import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumLocalWebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.HawkularRegistrationPageConstants;
import org.qe.hawkular.page.HawkularLoginPage;
import org.qe.hawkular.page.hawkularApplicationTransactionPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class hawkularAppTransactionTest extends HawkularSeleniumLocalWebDriver {
	WebDriver driver = null;
	
    public WebDriver hawkularLoginToDeployments() throws Exception {
        driver = createLocalDriver();

        driver.get(HawkularSeleniumWebDriver.hawkularUrl);
        System.out.println(driver.getTitle());

        HawkularLoginPage loginPage = new HawkularLoginPage(driver);

        loginPage.verifyLoginTitle();

        loginPage = new HawkularLoginPage(driver);
        loginPage.loginAs(HawkularRegistrationPageConstants.username,
                HawkularRegistrationPageConstants.password);
        
        return driver;

    }       
	
	
    @AfterMethod
   	public void closeSession() {
   		driver.quit();
   	}

    
    @Test
    public void hawkularApplicationTransactionTest() throws Exception { 
    	
    	_logger.info("verifying the newly added transaction tab and its Element");
    	
        driver = hawkularLoginToDeployments();
        hawkularApplicationTransactionPage verify = new hawkularApplicationTransactionPage(driver);
        
        verify.checkAppTransaction();
    
}

}
