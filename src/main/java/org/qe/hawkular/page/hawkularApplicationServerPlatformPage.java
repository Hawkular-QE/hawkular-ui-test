package org.qe.hawkular.page;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.qe.hawkular.element.HawkularAppServerPageConstants;
import org.qe.hawkular.element.HawkularApplicationOverviewConstants;
import org.qe.hawkular.element.hawkularApplicationServerPlatformConstants;
import org.qe.hawkular.util.HawkularUtils;

/**
*
* @author Prachi Yadav
*/


public class hawkularApplicationServerPlatformPage {
	
	public final WebDriver driver;

	public hawkularApplicationServerPlatformPage(WebDriver driver) {

	    this.driver = driver;

	}
	

	public void checkAppPlatform()
	
	{
		
		HawkularUtils utils = new HawkularUtils(driver);
		utils.navigateTo(HawkularApplicationOverviewConstants.ApplicationServerTab);
		utils.navigateTo(HawkularAppServerPageConstants.localWildfyServerLink);
		utils.navigateTo(HawkularAppServerPageConstants.appserverPlatformTabLink);
	//	Assert.assertTrue(utils.waitForElementPresent(hawkularApplicationServerPlatformConstants.platformMemoryUsageGraph));
		Assert.assertTrue(utils.waitForElementPresent(hawkularApplicationServerPlatformConstants.platformAlerts));
	//	Assert.assertTrue(utils.waitForElementPresent(hawkularApplicationServerPlatformConstants.platformCpuUsage));
	//	Assert.assertTrue(utils.waitForElementPresent(hawkularApplicationServerPlatformConstants.platformProcessor));
		Assert.assertTrue(utils.waitForElementPresent(hawkularApplicationServerPlatformConstants.platformFileSystemUsage));
		
	}
	

}
