package org.qe.hawkular.element;

import org.openqa.selenium.By;

public class HawkularAlertCenterPageConstants {

    public static final By alertCenterLocator = By.xpath("//a[contains(text(),'Alert Center')]");
    public static final By lastJvmHeapUsedAlertDetailLocator = By
            .xpath("//*[contains(text(),'JVM Heap Used for')][1]/..//a/i");
    public static final By alertDetailResourcePathLocator = By
            .xpath("//div[@class='hk-alert-center-detail']//label[contains(text(),'Resource Path')]/..//*[@class='hk-input-text']");
    public static final By alertDetailStateButtonLocator = By
            .xpath("//*[@data-id='status']");
    public static final By alertDetailStateResolvedButtonLocator = By
            .xpath("//*[@data-id='status']/..//span[contains(text(),'Resolved')]/..");
    public static final By alertDetailCommentLocator = By
            .xpath("//textarea[@ng-model='acd.comments']");
    public static final By alertDetailCommentButtonLocator = By
            .xpath("//button[@ng-click='acd.save()']");

}