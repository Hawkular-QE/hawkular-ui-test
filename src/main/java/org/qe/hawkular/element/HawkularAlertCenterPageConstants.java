package org.qe.hawkular.element;

import org.openqa.selenium.By;

public class HawkularAlertCenterPageConstants {

    public static final By alertCenterLocator = By.xpath("//a[contains(text(),'Alert Center')]");
    public static final By lastJvmHeapUsedAlertDetailLocator = By
            .xpath("//*[contains(text(),'JVM Heap Used for')][1]/..//a/i");
    public static final By alertDetailResourcePathLocator = By
            .xpath("//div[@class='hk-alert-center-detail']//label[contains(text(),'Resource Path')]/..//*[@class='hk-input-text']");

}