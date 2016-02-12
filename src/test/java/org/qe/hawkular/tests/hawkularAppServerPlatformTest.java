package org.qe.hawkular.tests;

import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumLocalWebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.HawkularRegistrationPageConstants;
import org.qe.hawkular.page.HawkularDatasourcesPage;
import org.qe.hawkular.page.HawkularLoginPage;
import org.qe.hawkular.page.hawkularApplicationServerPlatformPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
*
* @author Prachi Yadav
*/

public class hawkularAppServerPlatformTest extends HawkularSeleniumLocalWebDriver {
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
    public void hawkularApplicationServerPlatformTest() throws Exception {
        driver = hawkularLoginToDeployments();
        _logger.info(" Veryfing newly added Platform tab");
        
        hawkularApplicationServerPlatformPage verify = new hawkularApplicationServerPlatformPage(driver);
        
        verify.checkAppPlatform();
    
}
}
