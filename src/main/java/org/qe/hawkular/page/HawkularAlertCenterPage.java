package org.qe.hawkular.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qe.hawkular.element.HawkularAlertCenterPageConstants;
import org.qe.hawkular.util.HawkularUtils;

public class HawkularAlertCenterPage {

    public final WebDriver driver;

    public HawkularAlertCenterPage(WebDriver driver) {
        this.driver = driver;
    }

    By alertCenterLocator = HawkularAlertCenterPageConstants.alertCenterLocator;
    By lastJvmHeapUsedAlertDetailLocator = HawkularAlertCenterPageConstants.lastJvmHeapUsedAlertDetailLocator;
    By alertDetailResourcePathLocator = HawkularAlertCenterPageConstants.alertDetailResourcePathLocator;

    public void navigateToAlertCenter() {
        HawkularUtils util = new HawkularUtils(driver);
        util.navigateTo(alertCenterLocator);
    }

    public void navigateToLastHeapUsedAlert() {
        HawkularUtils util = new HawkularUtils(driver);
        util.waitForElementPresent(lastJvmHeapUsedAlertDetailLocator, 300);
        util.navigateTo(lastJvmHeapUsedAlertDetailLocator);
    }

    public void change() {
        HawkularUtils util = new HawkularUtils(driver);
        util.navigateTo(lastJvmHeapUsedAlertDetailLocator);
    }

    public String getResourcePathFromDetail() {
        HawkularUtils util = new HawkularUtils(driver);
        util.assertElementPresent(alertDetailResourcePathLocator);
        return util.getElementsText(alertDetailResourcePathLocator);
    }

}