package org.qe.hawkular.element;

import org.openqa.selenium.By;

/**
 * @author vprusa
 */
public class HawkularManageOrganizationsConstants {

    /* Navigate */
    public static final By rhAccessDropdownLocator = By
            .xpath("//span[@class='pficon pficon-user']/../../a");
    public static final By rhAccessManageOrgOptionLocator = By
            .id("organizationsOption");

    /* Create organization */
    public static final By createOrgButtonLocator = By
            .xpath("//div[@class='blank-slate-pf-main-action']/button");
    public static final By organizationNameLocator = By
            .id("name");
    public static final String organizationName = "orgname.org";
    public static final By modalCreateOrgButtonLocator = By
            .xpath("//div[@class='modal-dialog']//button[text()='Create']");
    public static final By createOrgVerifyLocator = By
            .xpath("//div[contains(text(),'Organization successfully created.')]");

    /* Remove organization */
    public static final By removeOrgButtonLocator = By
            .xpath("//div[@class='hk-organizations']//tr[1]//td[2]/button/..//i[contains(@class,'fa-trash-o')]");
    public static final By removeOrgButtonConfirmLocator = By
            .xpath("//div[@class='modal-dialog']//button[text()='Delete']");
    public static final By removeOrgVerifyLocator = By
            .xpath("//div[contains(text(),'Organization successfully deleted.')]");

}
