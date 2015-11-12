package org.qe.hawkular.element;

import org.openqa.selenium.By;

public class HawkularAppServerJVMConstants {

    public static final By alertSettingsLocator = By.xpath("id('hk-jvm-metrics')//a[@ng-click='jac.openSetup()']");

    public static final By alertSettingsOpenVerifyLocator = By.xpath("//h4[text()='JVM Alert Settings']");
    public static final By alertSettingHeapUsageGreaterLocator = By.id("usage-greater");
    public static final By alertSettingHeapUsageLessLocator = By.id("usage-less");
    public static final By heapUsageGreaterSwitchLocator = By.id("usage-greater-switch");
    public static final By heapUsageLessSwitchLocator = By.id("usage-less-switch");

    public static final By alertSettingNonHeapUsageGreaterLocator = By.id("usage-greater2");
    public static final By alertSettingNonHeapUsageLessLocator = By.id("usage-less2");

    public static final By alertSettingNonHeapUsageButtonLocator = By.xpath("//*[@heading='Non-Heap Usage']/a");

    public static final By heapUsageCreateAlertEveryTimeOptionLocator = By
            .xpath("//*[@id='hk-heap']//label[@for='every-time-heap']");
    public static final By heapUsageCreateAlertWhenConditionOptionLocator = By
            .xpath("//*[@id='hk-heap']//label[@for='greater-time-heap']");

    public static final By nonHeapUsageCreateAlertEveryTimeOptionLocator = By
            .xpath("//*[@id='hk-non-heap']//label[@for='every-time-heap']");
    public static final By nonHeapUsageCreateAlertWhenConditionOptionLocator = By
            .xpath("//*[@id='hk-non-heap']//label[@for='greater-time-heap']");

    public static final By createAlertConditionTimeLocator = By.id("dw-duration");

    public static final By createAlertConditionTimeUnitLocator = By
            .xpath("//*[@id='hk-heap']//button[@data-id='responseUnit']");

    public static final By createAlertConditionTimeUnitMilisecondsLocator = By
            .xpath("//*[@id='hk-heap']//span[text()='miliseconds']");
    public static final By createAlertConditionTimeUnitSecondsLocator = By
            .xpath("//*[@id='hk-heap']//span[text()='seconds']");
    public static final By createAlertConditionTimeUnitMinutesLocator = By
            .xpath("//*[@id='hk-heap']//span[text()='minutes']");
    public static final By createAlertConditionTimeUnitHoursLocator = By
            .xpath("//*[@id='hk-heap']//span[text()='hours']");
    // TODO ....
    public static final By createAlertNotificationEmailLocator = By.id("email-heap");

    public static final By createAlertSaveLocator = By
            .xpath("//button[@ng-click='jas.save()' and not(@disabled='disabled')]");
    public static final By createAlertCancelLocator = By
            .xpath("//div[@class='modal-footer']//button[@ng-click='jas.cancel()']");

    public static final By createAlertVerifySaveLocator = By
            .xpath("//div[@id='toast-container']//*[contains(text(),'Alert settings successfully saved')]");

}