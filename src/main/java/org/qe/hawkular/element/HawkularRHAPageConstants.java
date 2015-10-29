package org.qe.hawkular.element;

import org.openqa.selenium.By;

public class HawkularRHAPageConstants {

    public static final By usernameLocator = By.id("rha-login-user-id");
    public static final By passwordLocator = By.id("rha-login-password");
    public static final By signinLocator = By.xpath("//button[text()='Sign in']");
    public static final By cancelLocator = By.xpath("//button[text()='Cancel']");
    public static final By rhaiframeLocator = By.xpath("//iframe[@src='/support.html#/search']");
    public static final By modaldialogLocator = By.id("rha-login-modal-header");
    public static final By logoutLocator = By.xpath("//span/a[contains(text(),'Log Out')]");
    public static final By rhaiframeLocatormyCases = By.xpath("//iframe[@src='/support.html#/case/list']");
}