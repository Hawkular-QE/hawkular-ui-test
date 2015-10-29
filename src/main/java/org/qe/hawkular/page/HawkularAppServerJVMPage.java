package org.qe.hawkular.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qe.hawkular.element.HawkularAppServerJVMConstants;
import org.qe.hawkular.util.HawkularUtils;

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
    String heapUsageGreaterThanPercents = HawkularAppServerJVMConstants.heapUsageGreaterThanPercents;
    String heapUsageLessThanPercents = HawkularAppServerJVMConstants.heapUsageLessThanPercents;

    By heapUsageGreaterSwitchLocator = HawkularAppServerJVMConstants.heapUsageGreaterSwitchLocator;
    By heapUsageLessSwitchLocator = HawkularAppServerJVMConstants.heapUsageLessSwitchLocator;

    By createAlertEveryTimeOptionLocator = HawkularAppServerJVMConstants.createAlertEveryTimeOptionLocator;

    public void openAlertSettings() {
        HawkularUtils util = new HawkularUtils(driver);
        util.navigateTo(alertSettingsLocator);
        util.waitForElementPresent(alertSettingsOpenVerifyLocator);
    }

    public void changeHeapUsageGreaterThan(float percent) {
        HawkularUtils util = new HawkularUtils(driver);

        util.sendKeysTo(alertSettingHeapUsageGreaterLocator, heapUsageGreaterThanPercents);
    }

    public void changeHeapUsageLessThan(float percent) {
        HawkularUtils util = new HawkularUtils(driver);
        util.sendKeysTo(alertSettingHeapUsageLessLocator, heapUsageLessThanPercents);
    }

    public void setOptionCreateAlertEveryTime() {
        HawkularUtils util = new HawkularUtils(driver);
        // TODO util.navigateTo();
    }

}
