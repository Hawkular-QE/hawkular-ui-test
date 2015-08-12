package org.qe.hawkular.element;

import org.openqa.selenium.By;

public class HawkularAppServerPageConstants {
    

    public static final By localWildfyServerLink = By.xpath("//a[@href='/hawkular-ui/app/app-details/haw-alpha3~Local/jvm']");
    public static final By appServerJvmtabLocator = By.xpath("//*[text()='JVM Status']");
    public static final By AppServerDeploymentsLink = By.linkText("Deployments");
    public static final By appServerDeploymentstabLocator = By.xpath("//*[text()='Deployment Status']");
    public static final By appServerWarFileLocator = By.xpath("//*[text()='hawkular-accounts.war']");
    
}
