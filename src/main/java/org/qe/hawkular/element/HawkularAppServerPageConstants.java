package org.qe.hawkular.element;

import org.openqa.selenium.By;

public class HawkularAppServerPageConstants {
    

    public static final By localWildfyServerLink = By.xpath("//a[contains(@href,'/hawkular-ui/app/app-details/') and contains(@href,'~Local/jvm')]");
    public static final By appServerJvmtabLocator = By.xpath("//*[text()='JVM Status']");
    public static final By appServerDeploymentsLink = By.linkText("Deployments");
    public static final By appServerDatasourcesLink = By.linkText("Datasources");
    public static final By appServerJVMLink = By.linkText("JVM");
    public static final By appServerDeploymentsLocator = By.xpath("//*[text()='Deployment Status']");
    public static final By appServerWarFileLocator = By.xpath("//*[text()='hawkular-accounts.war']");
    public static final By appServerRHALocator = By.xpath("//li[@class='dropdown']//a[contains(text(),'Red Hat Access')]");
    public static final By appServerRHASearchLocator = By.xpath("//a[@href='/hawkular-ui/access/search']");
    public static final By appServerRHASupportmyCasesLocator = By.xpath("//a[@href='/hawkular-ui/access/myCases']");
   
}
