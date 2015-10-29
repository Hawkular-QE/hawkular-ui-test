package org.qe.hawkular.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.qe.hawkular.element.HawkularRHAPageConstants;
import org.qe.hawkular.element.HawkularCreateCaseConstants;
import org.qe.hawkular.util.HawkularUtils;
import org.testng.Assert;

/**
 * @author vprusa
 */
public class HawkularRedHatAccessPage {

	WebDriver driver;

	private String username;
	private String password;

	By usernameLocator = HawkularRHAPageConstants.usernameLocator;
	By passwordLocator = HawkularRHAPageConstants.passwordLocator;
	By signinLocator = HawkularRHAPageConstants.signinLocator;
	By rhaiframeLocator = HawkularRHAPageConstants.rhaiframeLocator;
	By cancelLocator = HawkularRHAPageConstants.cancelLocator;
	By modaldialogLocator = HawkularRHAPageConstants.modaldialogLocator;
	By logoutLocator = HawkularRHAPageConstants.logoutLocator;
	By rhaiframeLocatormyCases = HawkularRHAPageConstants.rhaiframeLocatormyCases;
	By rhaiframeLocatorLogin = HawkularCreateCaseConstants.rhaiframeLocatorLogin;
	
	public HawkularRedHatAccessPage(WebDriver driver) {
		this.driver = driver;
		username = System.getProperty("rhausername");
		password = System.getProperty("rhapassword");
		if (username == null || password == null) {
			Assert.assertTrue(false,
					"Missing credentials for Red Hat Access, please check READEME.md");
		}
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void loginHere() {
		HawkularUtils util = new HawkularUtils(driver);
		util.sendKeysTo(usernameLocator, username);
		util.sendKeysTo(passwordLocator, password);
		util.navigateTo(signinLocator);
	}
	
	public void logoutHere() {
		HawkularUtils util = new HawkularUtils(driver);
		util.navigateTo(logoutLocator);
	}

	public void switchFrameFocus() {
		WebElement frame = driver.findElement(rhaiframeLocator);
		driver.switchTo().frame(frame);
	}
	
	public void switchFrameFocusMyCases() {
		WebElement frame = driver.findElement(rhaiframeLocatormyCases);
		driver.switchTo().frame(frame);
	}


	public void switchFrameFocusCreateCase() {
		WebElement frame = driver.findElement(rhaiframeLocatorLogin);
		driver.switchTo().frame(frame);
	}
	
	public void switchFrameFocus(boolean defaultFrame) {
		if (defaultFrame == false) {
			switchFrameFocus();
		} else {
			driver.switchTo().defaultContent();
			try {
				Thread.sleep(10000); // TODO nasty sleep -> elegant (iframe animation)
			} catch (InterruptedException e) {
				e.printStackTrace();
				Assert.assertTrue(false,
						"Error occured when waiting after switching frames");
			}
		}
	}

	public void cancleLogin() {
		HawkularUtils util = new HawkularUtils(driver);
		util.navigateTo(cancelLocator);
	}

}