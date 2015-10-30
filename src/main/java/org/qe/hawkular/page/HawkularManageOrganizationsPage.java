package org.qe.hawkular.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qe.hawkular.element.HawkularManageOrganizationsConstants;
import org.qe.hawkular.util.HawkularUtils;

/**
 * @author vprusa
 */
public class HawkularManageOrganizationsPage {

    public final WebDriver driver;

    public HawkularManageOrganizationsPage(WebDriver driver) {
        this.driver = driver;
    }

    By rhAccessDropdownLocator = HawkularManageOrganizationsConstants.rhAccessDropdownLocator;
    By rhAccessManageOrgOptionLocator = HawkularManageOrganizationsConstants.rhAccessManageOrgOptionLocator;

    By createOrgButtonLocator = HawkularManageOrganizationsConstants.createOrgButtonLocator;
    By organizationNameLocator = HawkularManageOrganizationsConstants.organizationNameLocator;
    String organizationName = HawkularManageOrganizationsConstants.organizationName;
    By modalCreateOrgButtonLocator = HawkularManageOrganizationsConstants.modalCreateOrgButtonLocator;
    By createOrgVerifyLocator = HawkularManageOrganizationsConstants.createOrgVerifyLocator;

    By removeOrgButtonLocator = HawkularManageOrganizationsConstants.removeOrgButtonLocator;
    By removeOrgButtonConfirmLocator = HawkularManageOrganizationsConstants.removeOrgButtonConfirmLocator;
    By removeOrgVerifyLocator = HawkularManageOrganizationsConstants.removeOrgVerifyLocator;

    public void toManageOrganizationsTab() {
        HawkularUtils util = new HawkularUtils(driver);
        util.navigateTo(rhAccessDropdownLocator);
        util.navigateTo(rhAccessManageOrgOptionLocator);
    }

    public void createOrganization() {
        HawkularUtils util = new HawkularUtils(driver);
        util.navigateTo(createOrgButtonLocator);
        util.sendKeysTo(organizationNameLocator, organizationName);
        util.navigateTo(modalCreateOrgButtonLocator);
        util.waitForElementPresent(createOrgVerifyLocator);
    }

    public void removeOrganization(int lineNumber) {
        HawkularUtils util = new HawkularUtils(driver);
        util.navigateTo(removeOrgButtonLocator);
        util.navigateTo(removeOrgButtonConfirmLocator);
        util.waitForElementPresent(removeOrgVerifyLocator);
    }

}
