package org.qe.hawkular.tests;

import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumLocalWebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.*;
import org.qe.hawkular.page.*;
import org.qe.hawkular.util.HawkularUtils;
import org.testng.annotations.Test;


public class HawkularWarActionTest extends HawkularSeleniumLocalWebDriver {
	
	   
	@Test
	public void HawkularRedeployTest()	throws Exception {
		WebDriver driver = createLocalDriver();

		driver.get(HawkularSeleniumWebDriver.hawkularUrl);
		System.out.println(driver.getTitle());

		HawkularLoginPage loginPage = new HawkularLoginPage(driver);

		loginPage.verifyLoginTitle();

		loginPage = new HawkularLoginPage(driver);
		loginPage.loginAs(HawkularRegistrationPageConstants.username2,
				HawkularRegistrationPageConstants.password2);

				
			
		
		HawkularConsoleAddUrlPage clickAppServer= new HawkularConsoleAddUrlPage(driver);
		clickAppServer.navigateToAppServersMenu();
		
		
		HawkularAppServerPage selectAppServer= new HawkularAppServerPage(driver);
		
		selectAppServer.verifyLocalAppServerExists();
		selectAppServer.navigateTOLocalAppServer();
		selectAppServer.navigateTODeploymentsTab();
		
		
		HawkularDepoymentActionPage testRedeploy = new HawkularDepoymentActionPage(driver);
		testRedeploy.clickToRedeployFirstWar();
		testRedeploy.verfiySuccess();
				
		
		driver.quit();
	}

	@Test
	public void HawkularEnableWarTest() throws Exception {
		WebDriver driver = createLocalDriver();

		driver.get(HawkularSeleniumWebDriver.hawkularUrl);
		System.out.println(driver.getTitle());

		HawkularLoginPage loginPage = new HawkularLoginPage(driver);

		loginPage.verifyLoginTitle();

		loginPage = new HawkularLoginPage(driver);
		loginPage.loginAs(HawkularRegistrationPageConstants.username2,
				HawkularRegistrationPageConstants.password2);

			
		
		
		HawkularConsoleAddUrlPage clickAppServer= new HawkularConsoleAddUrlPage(driver);
		clickAppServer.navigateToAppServersMenu();
		
		
		HawkularAppServerPage selectAppServer= new HawkularAppServerPage(driver);
		
		selectAppServer.verifyLocalAppServerExists();
		selectAppServer.navigateTOLocalAppServer();
		selectAppServer.navigateTODeploymentsTab();
		
		
		HawkularDepoymentActionPage testEnableWar = new HawkularDepoymentActionPage(driver);
		testEnableWar.clickToEnableWar();
		testEnableWar.verfiySuccess();
				
		driver.quit();

}
	

	@Test
	public void HawkularDisableWarTest()	throws Exception {
		WebDriver driver = createLocalDriver();

		driver.get(HawkularSeleniumWebDriver.hawkularUrl);
		System.out.println(driver.getTitle());

		HawkularLoginPage loginPage = new HawkularLoginPage(driver);

		loginPage.verifyLoginTitle();

		loginPage = new HawkularLoginPage(driver);
		loginPage.loginAs(HawkularRegistrationPageConstants.username2,
				HawkularRegistrationPageConstants.password2);

			
				
		HawkularConsoleAddUrlPage clickAppServer= new HawkularConsoleAddUrlPage(driver);
		clickAppServer.navigateToAppServersMenu();
		
		
		HawkularAppServerPage selectAppServer= new HawkularAppServerPage(driver);
		
		selectAppServer.verifyLocalAppServerExists();
		selectAppServer.navigateTOLocalAppServer();
		selectAppServer.navigateTODeploymentsTab();
		
		
		HawkularDepoymentActionPage testDisableWar = new HawkularDepoymentActionPage(driver);
		testDisableWar.clickToDisableFirstWar();
		testDisableWar.verfiySuccess();
				
		driver.quit();
	}

	}

