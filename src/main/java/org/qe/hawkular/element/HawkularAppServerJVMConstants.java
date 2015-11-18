package org.qe.hawkular.element;

import org.openqa.selenium.By;

public class HawkularAppServerJVMConstants {

    // JVM-Page/Common
    public static final By alertSettingsLocator = By.xpath("id('hk-jvm-metrics')//a[@ng-click='jac.openSetup()']");
    public static final By alertSettingsOpenVerifyLocator = By.xpath("//h4[text()='JVM Alert Settings']");

    public static final By createAlertSaveLocator = By
            .xpath("//button[@ng-click='jas.save()' and not(@disabled='disabled')]");
    public static final By createAlertCancelLocator = By
            .xpath("//div[@class='modal-footer']//button[@ng-click='jas.cancel()']");

    public static final By createAlertVerifySaveLocator = By
            .xpath("//div[@id='toast-container']//*[contains(text(),'Alert settings successfully saved')]");

    // Heap Usage
    public static final By createAlertHeapUsageGreaterLocator = By.id("usage-greater");
    public static final By createAlertHeapUsageUsageLessLocator = By.id("usage-less");
    public static final By createAlertHeapUsageGreaterSwitchLocator = By.id("usage-greater-switch");
    public static final By createAlertHeapUsageLessSwitchLocator = By.id("usage-less-switch");

    public static final By createAlertHeapUsageEveryTimeOptionLocator = By
            .xpath("//*[@id='hk-heap']//label[@for='every-time-heap']");
    public static final By createAlertHeapUsageWhenConditionOptionLocator = By
            .xpath("//*[@id='hk-heap']//label[@for='greater-time-heap']");

    public static final By createAlertHeapUsageConditionTimeLocator = By.id("dw-duration");
    public static final By createAlertHeapUsageConditionTimeUnitLocator = By
            .xpath("//*[@id='hk-heap']//button[@data-id='responseUnit']");

    public static final By createAlertHeapUsageConditionTimeUnitMilisecondsLocator = By
            .xpath("//*[@id='hk-heap']//span[text()='miliseconds']");
    public static final By createAlertHeapUsageConditionTimeUnitSecondsLocator = By
            .xpath("//*[@id='hk-heap']//span[text()='seconds']");
    public static final By createAlertHeapUsageConditionTimeUnitMinutesLocator = By
            .xpath("//*[@id='hk-heap']//span[text()='minutes']");
    public static final By createAlertHeapUsageConditionTimeUnitHoursLocator = By
            .xpath("//*[@id='hk-heap']//span[text()='hours']");

    public static final By createAlertHeapUsageNotificationEmailLocator = By.id("email-heap");

    // Non-Heap Usage
    public static final By createAlertNonHeapUsageUsageButtonLocator = By.xpath("//*[@heading='Non-Heap Usage']/a");
    public static final By createAlertNonHeapUsageUsageGreaterLocator = By.id("usage-greater2");
    public static final By createAlertNonHeapUsageUsageLessLocator = By.id("usage-less2");
    public static final By createAlertNonHeapUsageLessSwitchLocator = By.id("usage-nless-switch");
    public static final By createAlertNonHeapUsageGreaterSwitchLocator = By.id("usage-ngreater-switch");

    public static final By createAlertNonHeapUsageEveryTimeOptionLocator = By
            .xpath("//*[@id='hk-non-heap']//label[@for='every-time-heap']/input");
    public static final By createAlertNonHeapUsageWhenConditionOptionLocator = By
            .xpath("//*[@id='hk-non-heap']//label[@for='greater-time-heap']/input");

    public static final By createAlertNonHeapUsageConditionTimeLocator = By.id("dw-duration");
    public static final By createAlertNonHeapUsageConditionTimeUnitLocator = By
            .xpath("//*[@id='hknon--heap']//button[@data-id='responseUnit']");

    public static final By createAlertNonHeapUsageConditionTimeUnitMilisecondsLocator = By
            .xpath("//*[@id='hk-non-heap']//span[text()='miliseconds']");
    public static final By createAlertNonHeapUsageConditionTimeUnitSecondsLocator = By
            .xpath("//*[@id='hk-non-heap']//span[text()='seconds']");
    public static final By createAlertNonHeapUsageConditionTimeUnitMinutesLocator = By
            .xpath("//*[@id='hk-non-heap']//span[text()='minutes']");
    public static final By createAlertNonHeapUsageConditionTimeUnitHoursLocator = By
            .xpath("//*[@id='hk-non-heap']//span[text()='hours']");

    public static final By createAlertNonHeapUsageNotificationEmailLocator = By.xpath("//*[@id='hk-non-heap']//input[@id='email-heap']");

}