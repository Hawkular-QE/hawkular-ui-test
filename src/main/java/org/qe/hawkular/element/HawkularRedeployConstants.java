package org.qe.hawkular.element;
import org.openqa.selenium.By;
public class HawkularRedeployConstants {

	
	public static final By actionDropdown =  By.id("dropdownMenu2");
	public static final By selectRedeployWar =  By.linkText("Redeploy");
	public static final By selectDisableWar =  By.linkText("Disable");
	public static final By selectEnableWar =  By.linkText("Enable");
	public static final By verifySuccess = By.cssSelector("div.toast-message");
	public static final By verifySucceeded = By.xpath("//*[contains(text(), 'succeeded')]");

	

}
