package org.qe.hawkular.page;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qe.hawkular.element.HawkularAppServerPageConstants;
import org.qe.hawkular.util.HawkularUtils;

public class HawkularAppServerPage {

    public final WebDriver driver;

    public HawkularAppServerPage(WebDriver driver) {
        this.driver = driver;
    }

    By localAppServerLink = HawkularAppServerPageConstants.localWildfyServerLink;
    By appServerJvmtabLocator = HawkularAppServerPageConstants.appServerJvmtabLocator;
    By appServerDatasourcesLink = HawkularAppServerPageConstants.appServerDatasourcesLink;
    By appServerJVMLink = HawkularAppServerPageConstants.appServerJVMLink;
    By appServerDeploymentsLink = HawkularAppServerPageConstants.appServerDeploymentsLink;
    By appServerDeploymentsLocator = HawkularAppServerPageConstants.appServerDeploymentsLocator;
    By appServerWarFileLocator = HawkularAppServerPageConstants.appServerWarFileLocator;
    By appServerRHALocator = HawkularAppServerPageConstants.appServerRHALocator;
    By appServerRHASearchLocator = HawkularAppServerPageConstants.appServerRHASearchLocator;

    public void verifyLocalAppServerExists() {
        HawkularUtils util = new HawkularUtils(driver);
        Assert.assertTrue(util.waitForElementPresent(localAppServerLink));
    }

    public void navigateToLocalAppServer() {
        HawkularUtils util = new HawkularUtils(driver);
        util.navigateTo(localAppServerLink);
    }

    public boolean verifyAppServerJVMTabNavigation() {
        HawkularUtils util = new HawkularUtils(driver);
        return util.waitForElementPresent(appServerJvmtabLocator);
    }

    public void navigateToDeploymentsTab() {
        HawkularUtils util = new HawkularUtils(driver);
        util.navigateTo(appServerDeploymentsLink);
    }

    public void navigateToDatasourcesTab() {
        HawkularUtils util = new HawkularUtils(driver);
        util.navigateTo(appServerDatasourcesLink);
    }

    public void navigateToJVMTab() {
        HawkularUtils util = new HawkularUtils(driver);
        util.navigateTo(appServerJVMLink);
    }

    public boolean verifyAppServerDeploymentsTabNavigation() {
        HawkularUtils util = new HawkularUtils(driver);
        return util.waitForElementPresent(appServerDeploymentsLocator);
    }

    public boolean verifyAppServerWarExists() {
        HawkularUtils util = new HawkularUtils(driver);
        return util.waitForElementPresent(appServerWarFileLocator);
    }

    public void navigateToRHATab() {
        HawkularUtils util = new HawkularUtils(driver);
        util.navigateTo(appServerRHALocator);
    }

    public void navigateToRHASearchTab() {
        HawkularUtils util = new HawkularUtils(driver);
        util.navigateTo(appServerRHASearchLocator);
    }
}
