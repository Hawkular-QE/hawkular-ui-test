package org.qe.hawkular.element;

import org.openqa.selenium.By;

public class HawkularAppServerJVMConstants {

    public static final By alertSettingsLocator = By.xpath("id('hk-jvm-metrics')//x:a");
    
    public static final By alertSettingsOpenVerifyLocator = By.linkText("JVM Alert Settings");
    public static final By alertSettingHeapUsageGreaterLocator = By.id("usage-greater");
    public static final By alertSettingHeapUsageLessLocator = By.id("usage-less");
    public static final String heapUsageGreaterThanPercents = "60.00";
    public static final String heapUsageLessThanPercents = "40.00";
    public static final By heapUsageGreaterSwitchLocator = By.id("usage-greater-switch");
    public static final By heapUsageLessSwitchLocator = By.id("usage-less-switch");
    public static final By createAlertEveryTimeOptionLocator = By.linkText("Every time conditions are met.");
    public static final By createAlertWhenConditionOptionLocator = By.linkText("Only when conditions are met for greater than:");
    public static final By createAlertConditionTimeLocator = By.id("dw-duration");
   
    public static final By createAlertConditionTimeUnitLocator = By.xpath("id('hk-heap')//button[@data-id='responseUnit']");
   
    public static final By createAlertConditionTimeUnitMilisecondsLocator = By.xpath("id('hk-heap')//span[text()='miliseconds']");
    public static final By createAlertConditionTimeUnitSecondsLocator = By.xpath("id('hk-heap')//span[text()='seconds']");
    public static final By createAlertConditionTimeUnitMinutesLocator = By.xpath("id('hk-heap')//span[text()='minutes']");
    public static final By createAlertConditionTimeUnitHoursLocator = By.xpath("id('hk-heap')//span[text()='hours']");
    
    public static final By createAlertNotificationEmailLocator = By.id("email-heap");

}
