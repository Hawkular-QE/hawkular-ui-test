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
    By rhAccessManageOrganizationsOptionLocator = HawkularManageOrganizationsConstants.rhAccessManageOrganizationsOptionLocator;
    By removeOrganizationButton = HawkularManageOrganizationsConstants.removeOrganizationButton;
    By removeOrganizationButtonConfirm = HawkularManageOrganizationsConstants.removeOrganizationButtonConfirm;
    By removeOrganizationVerify = HawkularManageOrganizationsConstants.removeOrganizationVerify;

    public void toManageOrganizationsTab() {
        HawkularUtils util = new HawkularUtils(driver);
        util.navigateTo(rhAccessDropdownLocator);
        util.navigateTo(rhAccessManageOrganizationsOptionLocator);
    }

    public void removeOrganization(int lineNumber) {
        HawkularUtils util = new HawkularUtils(driver);
        util.navigateTo(removeOrganizationButton);
        util.navigateTo(removeOrganizationButtonConfirm);
        util.waitForElementPresent(removeOrganizationVerify);
    }

}
