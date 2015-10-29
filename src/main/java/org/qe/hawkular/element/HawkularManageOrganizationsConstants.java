package org.qe.hawkular.element;

import org.openqa.selenium.By;

public class HawkularManageOrganizationsConstants {

    public static final By rhAccessDropdownLocator = By
            .xpath("//li[@class='dropdown']//a[contains(text(),'Red Hat Access')]");
    public static final By rhAccessManageOrganizationsOptionLocator = By
            .id("organizationsOption");
    public static final By removeOrganizationButton = By
            .xpath("//div[@class='hk-organizations']//tr[1]//td[2]/button/..//i[contains(@class,'fa-trash-o')]");
    public static final By removeOrganizationButtonConfirm = By
            .xpath("//button[@Text='Delete']");
    public static final By removeOrganizationVerify = By
            .xpath("//*[contains(text(), 'Organization successfully deleted.')]");

}
