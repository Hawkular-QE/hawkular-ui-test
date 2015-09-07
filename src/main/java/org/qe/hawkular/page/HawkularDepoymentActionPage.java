package org.qe.hawkular.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qe.hawkular.element.*;
import org.qe.hawkular.util.HawkularUtils;


public class HawkularDepoymentActionPage {
	
	public final WebDriver driver;

    public HawkularDepoymentActionPage(WebDriver driver) {

        this.driver = driver;
    }    
  
    By actionDropdown = HawkularRedeployConstants.actionDropdown;
    By selectRedeployWar = HawkularRedeployConstants.selectRedeployWar;
    By verifySuccess = HawkularRedeployConstants.verifySuccess;
    By verifySucceeded = HawkularRedeployConstants.verifySucceeded;
    By selectEnableWar = HawkularRedeployConstants.selectEnableWar;
    By selectDisableWar = HawkularRedeployConstants.selectDisableWar;
    
    
public void clickToRedeployFirstWar(){
	
	HawkularUtils utils = new HawkularUtils(driver);
	utils.waitForElementPresent(actionDropdown);
	driver.findElement(actionDropdown).click();
	utils.waitForElementPresent(selectRedeployWar);
        driver.findElement(selectRedeployWar).click();
	
}

public void verfiySuccess(){
	HawkularUtils utils = new HawkularUtils(driver);
	utils.waitForElementPresent(verifySuccess);
	utils.waitForElementPresent(verifySucceeded);

}



public void clickToEnableWar(){
	
	HawkularUtils utils = new HawkularUtils(driver);
	utils.waitForElementPresent(actionDropdown);
        driver.findElement(actionDropdown).click();
        utils.waitForElementPresent(selectEnableWar);
        driver.findElement(selectEnableWar).click();
}

public void clickToDisableFirstWar(){
	
	HawkularUtils utils = new HawkularUtils(driver);
	utils.waitForElementPresent(actionDropdown);
        driver.findElement(actionDropdown).click();
        utils.waitForElementPresent(selectDisableWar);
        driver.findElement(selectDisableWar).click();	
}


}
