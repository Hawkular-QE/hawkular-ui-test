package org.qe.hawkular.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Utility class for methods: to navigate to a location or wait for if element is present or not.
 *
 */
public class HawkularUtils {

    WebDriver driver;

    public HawkularUtils(WebDriver driver) {
        this.driver = driver;
    }

    public boolean assertTitle(String title) {
        return driver.getTitle().equals(title);
    }

    public void navigateTo(By navigationLink) {
        waitForElementPresent(navigationLink);
        driver.findElement(navigationLink).click();
    }

    public void sendKeysTo(By navigationLink, CharSequence... cs) {
        waitForElementPresent(navigationLink);
        driver.findElement(navigationLink).clear();
        driver.findElement(navigationLink).sendKeys(cs);
    }

    public boolean waitForElementPresent(By element, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        return driver.findElement(element).isDisplayed();
    }

    public boolean waitForElementPresent(By element) {
        return waitForElementPresent(element, 60);
    }

    public void waitForElementNotPresent(By element, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    public void waitForElementNotPresent(By element) {
        waitForElementNotPresent(element, 60);
    }

    public void assertElementPresent(By element) {
        Assert.assertTrue(waitForElementPresent(element));
    }

    public String getElementsText(By element) {
        WebElement we = driver.findElement(element);
        return we.getText();
    }

}
