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

    By alertSettingsLocator = HawkularAppServerJVMConstants.alertSettingsLocator;
    By alertSettingsOpenVerifyLocator = HawkularAppServerJVMConstants.alertSettingsOpenVerifyLocator;

    By alertSettingHeapUsageGreaterLocator = HawkularAppServerJVMConstants.alertSettingHeapUsageGreaterLocator;
    By alertSettingHeapUsageLessLocator = HawkularAppServerJVMConstants.alertSettingHeapUsageLessLocator;

    By heapUsageGreaterSwitchLocator = HawkularAppServerJVMConstants.heapUsageGreaterSwitchLocator;
    By heapUsageLessSwitchLocator = HawkularAppServerJVMConstants.heapUsageLessSwitchLocator;

    By createAlertEveryTimeOptionLocator = HawkularAppServerJVMConstants.createAlertEveryTimeOptionLocator;

    By createAlertWhenConditionOptionLocator = HawkularAppServerJVMConstants.createAlertWhenConditionOptionLocator;
    By createAlertConditionTimeLocator = HawkularAppServerJVMConstants.createAlertConditionTimeLocator;
    By createAlertConditionTimeUnitLocator = HawkularAppServerJVMConstants.createAlertConditionTimeUnitLocator;
    By createAlertNotificationEmailLocator = HawkularAppServerJVMConstants.createAlertNotificationEmailLocator;

    By createAlertSaveLocator = HawkularAppServerJVMConstants.createAlertSaveLocator;
    By createAlertCancelLocator = HawkularAppServerJVMConstants.createAlertCancelLocator;
    By createAlertVerifySaveLocator = HawkularAppServerJVMConstants.createAlertVerifySaveLocator;

    public void openAlertSettings() {
        HawkularUtils util = new HawkularUtils(driver);
        util.navigateTo(alertSettingsLocator);
        util.waitForElementPresent(alertSettingsOpenVerifyLocator);
    }

    public void setHeapUsageGreaterThan(float percent) {
        HawkularUtils util = new HawkularUtils(driver);
        util.sendKeysTo(alertSettingHeapUsageGreaterLocator, String.valueOf(percent));
    }

    public void setHeapUsageLessThan(float percent) {
        HawkularUtils util = new HawkularUtils(driver);
        util.sendKeysTo(alertSettingHeapUsageLessLocator, String.valueOf(percent));
    }

    public void setOptionCreateAlert() {
        this.setOptionCreateAlert(null);
    }

    public void setOptionCreateAlert(By timeLocator, CharSequence... cs) {
        HawkularUtils util = new HawkularUtils(driver);
        if (timeLocator == null || cs == null) {
            util.navigateTo(createAlertEveryTimeOptionLocator);
        } else {
            util.navigateTo(createAlertWhenConditionOptionLocator);
            util.sendKeysTo(createAlertConditionTimeLocator, cs);
            util.navigateTo(createAlertConditionTimeUnitLocator);
            util.navigateTo(timeLocator);
        }
    }

    public void setEmail(CharSequence... cs) {
        HawkularUtils util = new HawkularUtils(driver);
        util.sendKeysTo(createAlertNotificationEmailLocator, cs);
    }

    public void setLocalEmail() {
        String notifSshUsername = System.getProperty("notifSshUsername");
        Assert.assertTrue(notifSshUsername != null);
        CharSequence cs = (CharSequence) (notifSshUsername + "@localhost");
        setEmail(cs);
    }

    /**
     * Save button is not enabled if current configuration equals to previous configuration
     */
    public void saveAndVerify(float heapUsageGreaterThen) {
        HawkularUtils util = new HawkularUtils(driver);
        if(!util.waitForElementPresent(createAlertSaveLocator)){
            setHeapUsageGreaterThan(heapUsageGreaterThen);
        }
        util.navigateTo(createAlertSaveLocator);
        util.assertElementPresent(createAlertVerifySaveLocator);
    }

}
