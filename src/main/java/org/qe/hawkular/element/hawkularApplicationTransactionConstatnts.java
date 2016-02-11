package org.qe.hawkular.element;

import org.openqa.selenium.By;

/**
*
* @author Prachi Yadav
*/

public class hawkularApplicationTransactionConstatnts {
	
	public static final By transactionMetrics= By.xpath(".//*[@id='hk-deployments']/div[2]/div[1]/div[2]/h3");
	public static final By transactionGraph= By.xpath(".//*[@id='hk-deployments']/div[2]/div[1]/div[3]/div[2]/div");
	public static final By transactionsAlert= By.xpath(".//*[@id='hk-deployments']/div[2]/div[2]/div/div[1]/h2");
	public static final By transactionStatus= By.xpath(".//*[@id='hk-deployments']/div[1]/h3");


}