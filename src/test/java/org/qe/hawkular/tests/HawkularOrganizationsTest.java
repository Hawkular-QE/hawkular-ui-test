package org.qe.hawkular.tests;

import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumLocalWebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.HawkularRegistrationPageConstants;
import org.qe.hawkular.page.HawkularLoginPage;
import org.qe.hawkular.page.HawkularManageOrganizationsPage;
import org.testng.annotations.Test;

/**
 * @author vprusa
 */
public class HawkularOrganizationsTest extends HawkularSeleniumLocalWebDriver {

    public WebDriver hawkularLogin() throws Exception {
        WebDriver driver = createLocalDriver();

        driver.get(HawkularSeleniumWebDriver.hawkularUrl);
        System.out.println(driver.getTitle());

        HawkularLoginPage loginPage = new HawkularLoginPage(driver);

        loginPage.verifyLoginTitle();

        loginPage = new HawkularLoginPage(driver);
        loginPage.loginAs(HawkularRegistrationPageConstants.username2,
                HawkularRegistrationPageConstants.password2);

        return driver;
    }

    @Test
    public void hawkularCreateNewOrgTest() throws Exception {
        WebDriver driver = hawkularLogin();
        HawkularManageOrganizationsPage page = new HawkularManageOrganizationsPage(driver);

        page.toManageOrganizationsTab();
        page.createOrganization();

        driver.quit();
    }

    @Test
    public void hawkularDeleteOrgTest() throws Exception {
        WebDriver driver = hawkularLogin();
        HawkularManageOrganizationsPage page = new HawkularManageOrganizationsPage(driver);

        page.toManageOrganizationsTab();
        page.removeOrganization(0);

        driver.quit();
    }

}
