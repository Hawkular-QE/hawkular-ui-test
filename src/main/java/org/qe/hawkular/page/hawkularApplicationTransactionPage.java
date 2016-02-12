package org.qe.hawkular.page;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qe.hawkular.element.HawkularAppServerPageConstants;
import org.qe.hawkular.element.HawkularApplicationOverviewConstants;
import org.qe.hawkular.element.hawkularApplicationTransactionConstatnts;
import org.qe.hawkular.util.HawkularUtils;

public class hawkularApplicationTransactionPage {
	
	public final WebDriver driver;

	public hawkularApplicationTransactionPage(WebDriver driver) {

	    this.driver = driver;

	}
	
	
public void checkAppTransaction()
	
	{
		
		HawkularUtils utils = new HawkularUtils(driver);
		utils.navigateTo(HawkularApplicationOverviewConstants.ApplicationServerTab);
		utils.navigateTo( HawkularAppServerPageConstants.localWildfyServerLink);
		utils.navigateTo( HawkularAppServerPageConstants.appserverTransactionsTabLink);
		Assert.assertTrue(utils.waitForElementPresent(hawkularApplicationTransactionConstatnts.transactionMetrics));
		Assert.assertTrue(utils.waitForElementPresent(hawkularApplicationTransactionConstatnts.transactionGraph));
		Assert.assertTrue(utils.waitForElementPresent(hawkularApplicationTransactionConstatnts.transactionsAlert));
		Assert.assertTrue(utils.waitForElementPresent(hawkularApplicationTransactionConstatnts.transactionStatus));
		
	}
	


}
