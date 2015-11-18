package org.qe.hawkular.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qe.hawkular.element.HawkularAppServerJVMConstants;
import org.qe.hawkular.util.HawkularUtils;
import org.testng.Assert;

/**
 * @author vprusa
 */
public class HawkularAppServerJVMPage {

    public final WebDriver driver;

    public HawkularAppServerJVMPage(WebDriver driver) {
        this.driver = driver;
    }

    // JVM Page / common
    By alertSettingsLocator = HawkularAppServerJVMConstants.alertSettingsLocator;
    By alertSettingsOpenVerifyLocator = HawkularAppServerJVMConstants.alertSettingsOpenVerifyLocator;

    public void openAlertSettings() {
        HawkularUtils util = new HawkularUtils(driver);
        util.navigateTo(alertSettingsLocator);
        util.waitForElementPresent(alertSettingsOpenVerifyLocator);
    }

    By createAlertSaveLocator = HawkularAppServerJVMConstants.createAlertSaveLocator;
    By createAlertCancelLocator = HawkularAppServerJVMConstants.createAlertCancelLocator;
    By createAlertVerifySaveLocator = HawkularAppServerJVMConstants.createAlertVerifySaveLocator;

    /**
     * Save button is not enabled if current configuration equals to previous configuration
     */
    public void saveAndVerify(float heapUsageGreaterThen) {
        HawkularUtils util = new HawkularUtils(driver);
        if (!util.waitForElementPresent(createAlertSaveLocator)) {
            setHeapUsageGreaterThan(heapUsageGreaterThen);
        }
        util.navigateTo(createAlertSaveLocator);
        util.assertElementPresent(createAlertVerifySaveLocator);
    }

    // Heap Usage
    By heapUsageGreaterLocator = HawkularAppServerJVMConstants.createAlertHeapUsageGreaterLocator;
    By heapUsageUsageLessLocator = HawkularAppServerJVMConstants.createAlertHeapUsageUsageLessLocator;

    public void setHeapUsageGreaterThan(float percent) {
        HawkularUtils util = new HawkularUtils(driver);
        util.sendKeysTo(heapUsageGreaterLocator, String.valueOf(percent));
    }

    public void setHeapUsageLessThan(float percent) {
        HawkularUtils util = new HawkularUtils(driver);
        util.sendKeysTo(heapUsageUsageLessLocator, String.valueOf(percent));
    }

    By heapUsageGreaterSwitchLocator = HawkularAppServerJVMConstants.createAlertHeapUsageGreaterSwitchLocator;
    By heapUsageLessSwitchLocator = HawkularAppServerJVMConstants.createAlertHeapUsageLessSwitchLocator;

    By createAlertHeapUsageEveryTimeOptionLocator = HawkularAppServerJVMConstants.createAlertHeapUsageEveryTimeOptionLocator;
    By createAlertHeapUsageWhenConditionOptionLocator = HawkularAppServerJVMConstants.createAlertHeapUsageWhenConditionOptionLocator;
    By createAlertHeapUsageConditionTimeLocator = HawkularAppServerJVMConstants.createAlertHeapUsageConditionTimeLocator;
    By createAlertHeapUsageConditionTimeUnitLocator = HawkularAppServerJVMConstants.createAlertHeapUsageConditionTimeUnitLocator;

    public void setHeapUsageOptionCreateAlert() {
        this.setHeapUsageOptionCreateAlert(null);
    }

    public void setHeapUsageOptionCreateAlert(By timeLocator, CharSequence... cs) {
        HawkularUtils util = new HawkularUtils(driver);
        if (timeLocator == null || cs == null) {
            util.navigateTo(createAlertHeapUsageEveryTimeOptionLocator);
        } else {
            util.navigateTo(createAlertHeapUsageWhenConditionOptionLocator);
            util.sendKeysTo(createAlertHeapUsageConditionTimeLocator, cs);
            util.navigateTo(createAlertHeapUsageConditionTimeUnitLocator);
            util.navigateTo(timeLocator);
        }
    }

    By createAlertHeapUsageNotificationEmailLocator = HawkularAppServerJVMConstants.createAlertHeapUsageNotificationEmailLocator;

    public void setHeapUsageEmail(CharSequence... cs) {
        HawkularUtils util = new HawkularUtils(driver);
        util.sendKeysTo(createAlertHeapUsageNotificationEmailLocator, cs);
    }

    public void setLocalHeapUsageEmail() {
        String email = System.getProperty("notifEmail");
        Assert.assertTrue(email != null);
        CharSequence cs = (CharSequence) (email);
        setHeapUsageEmail(cs);
    }

    // Non-Heap Usage
    By createAlertNonHeapUsageUsageButtonLocator = HawkularAppServerJVMConstants.createAlertNonHeapUsageUsageButtonLocator;

    public void toNonHeapUsage() {
        HawkularUtils util = new HawkularUtils(driver);
        util.navigateTo(createAlertNonHeapUsageUsageButtonLocator);
    }

    By createAlertNonHeapUsageUsageGreaterLocator = HawkularAppServerJVMConstants.createAlertNonHeapUsageUsageGreaterLocator;
    By createAlertNonHeapUsageUsageLessLocator = HawkularAppServerJVMConstants.createAlertNonHeapUsageUsageLessLocator;

    public void setNonHeapUsageLessThan(float percent) {
        HawkularUtils util = new HawkularUtils(driver);
        util.sendKeysTo(createAlertNonHeapUsageUsageLessLocator, String.valueOf(percent));
    }

    public void setNonHeapUsageGreaterThan(float percent) {
        HawkularUtils util = new HawkularUtils(driver);
        util.sendKeysTo(createAlertNonHeapUsageUsageGreaterLocator, String.valueOf(percent));
    }

    By createAlertNonHeapUsageGreaterSwitchLocator = HawkularAppServerJVMConstants.createAlertNonHeapUsageGreaterSwitchLocator;
    By createAlertNonHeapUsageLessSwitchLocator = HawkularAppServerJVMConstants.createAlertNonHeapUsageLessSwitchLocator;

    By createAlertNonHeapUsageEveryTimeOptionLocator = HawkularAppServerJVMConstants.createAlertNonHeapUsageEveryTimeOptionLocator;

    By createAlertNonHeapUsageWhenConditionOptionLocator = HawkularAppServerJVMConstants.createAlertNonHeapUsageWhenConditionOptionLocator;
    By createAlertNonHeapUsageConditionTimeLocator = HawkularAppServerJVMConstants.createAlertNonHeapUsageConditionTimeLocator;
    By createAlertNonHeapUsageConditionTimeUnitLocator = HawkularAppServerJVMConstants.createAlertNonHeapUsageConditionTimeUnitLocator;

    public void setNonHeapUsageOptionCreateAlert() {
        this.setNonHeapUsageOptionCreateAlert(null);
    }

    public void setNonHeapUsageOptionCreateAlert(By timeLocator, CharSequence... cs) {
        HawkularUtils util = new HawkularUtils(driver);
        if (timeLocator == null || cs == null) {
            util.navigateTo(createAlertNonHeapUsageEveryTimeOptionLocator);
        } else {
            util.navigateTo(createAlertNonHeapUsageWhenConditionOptionLocator);
            util.sendKeysTo(createAlertNonHeapUsageConditionTimeLocator, cs);
            util.navigateTo(createAlertNonHeapUsageConditionTimeUnitLocator);
            util.navigateTo(timeLocator);
        }
    }

    By createAlertNonHeapUsageNotificationEmailLocator = HawkularAppServerJVMConstants.createAlertNonHeapUsageNotificationEmailLocator;

    public void setNonHeapUsageEmail(CharSequence... cs) {
        HawkularUtils util = new HawkularUtils(driver);
        util.sendKeysTo(createAlertNonHeapUsageNotificationEmailLocator, cs);
    }

    public void setLocalNonHeapUsageEmail() {
        String email = System.getProperty("notifEmail");
        Assert.assertTrue(email != null);
        CharSequence cs = (CharSequence) (email);
        setNonHeapUsageEmail(cs);
    }

}
