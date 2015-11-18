package org.qe.hawkular.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qe.hawkular.element.HawkularAlertCenterPageConstants;
import org.qe.hawkular.util.HawkularUtils;

import junit.framework.Assert;

public class HawkularAlertCenterPage {

    public final WebDriver driver;
    protected static final int ALERT_CENTER_REALOAD_ITERATTIONS = 10;

    public HawkularAlertCenterPage(WebDriver driver) {
        this.driver = driver;
    }

    By alertCenterLocator = HawkularAlertCenterPageConstants.alertCenterLocator;
    By lastJvmHeapUsedAlertDetailLocator = HawkularAlertCenterPageConstants.lastJvmHeapUsedAlertDetailLocator;
    By lastJvmNonHeapUsedAlertDetailLocator = HawkularAlertCenterPageConstants.lastJvmNonHeapUsedAlertDetailLocator;
    By alertDetailResourcePathLocator = HawkularAlertCenterPageConstants.alertDetailResourcePathLocator;
    By alertDetailStateButtonLocator = HawkularAlertCenterPageConstants.alertDetailStateButtonLocator;
    By alertDetailStateResolvedButtonLocator = HawkularAlertCenterPageConstants.alertDetailStateResolvedButtonLocator;
    By alertDetailCommentLocator = HawkularAlertCenterPageConstants.alertDetailCommentLocator;
    By alertDetailCommentButtonLocator = HawkularAlertCenterPageConstants.alertDetailCommentButtonLocator;

    public void navigateToAlertCenter() {
        HawkularUtils util = new HawkularUtils(driver);
        util.navigateTo(alertCenterLocator);
    }

    public void navigateToLastHeapUsedAlert() {
        HawkularUtils util = new HawkularUtils(driver);
        util.navigateTo(alertCenterLocator);
        for (int i = 0; i < ALERT_CENTER_REALOAD_ITERATTIONS; i++) {
            util.refresh();
            if (util.existsElement(lastJvmHeapUsedAlertDetailLocator)) {
                util.navigateTo(lastJvmHeapUsedAlertDetailLocator);
                return;
            }
            util.refresh();
        }
        Assert.fail();
    }

    public void navigateToLastNonHeapUsedAlert() {
        HawkularUtils util = new HawkularUtils(driver);
        util.navigateTo(alertCenterLocator);
        for (int i = 0; i < ALERT_CENTER_REALOAD_ITERATTIONS; i++) {
            util.refresh();
            if (util.existsElement(lastJvmNonHeapUsedAlertDetailLocator)) {
                util.navigateTo(lastJvmNonHeapUsedAlertDetailLocator);
                return;
            }
            util.refresh();
        }
        Assert.fail();
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

    public void detailChangeStateToResolved() {
        HawkularUtils util = new HawkularUtils(driver);
        util.navigateTo(alertDetailStateButtonLocator);
        util.navigateTo(alertDetailStateResolvedButtonLocator);
    }

    public void detailAddComment(CharSequence comment) {
        HawkularUtils util = new HawkularUtils(driver);
        util.sendKeysTo(alertDetailCommentLocator, comment);
        util.navigateTo(alertDetailCommentButtonLocator);
    }

}