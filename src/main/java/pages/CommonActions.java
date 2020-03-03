package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

import static java.lang.Thread.sleep;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;
import static utilities.TestUtilities.waitDriver;

public class CommonActions {
    public void waitVisibilityOfWebElement(WebElement element){
        waitDriver.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitVisibilityOfElementBy(By elementBy) {
        waitDriver.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }

    public void clickOnElement(WebElement webElement){
        waitVisibilityOfWebElement(webElement);
        webElement.click();
    }

    public void clickOnElementWithJS(WebElement element){
        waitVisibilityOfWebElement(element);
        JavascriptExecutor js = (JavascriptExecutor) Driver.driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void moveToElement(WebElement webElement) {
        Actions action = new Actions(Driver.driver);
        action.moveToElement(webElement).perform();
    }

    public void selectWebElementByVisibleText(WebElement webElement, String visibleText){
        waitVisibilityOfWebElement(webElement);
        Select selectWebElement = new Select(webElement);
        selectWebElement.selectByVisibleText(visibleText);
    }

    public String getPageTitle() {
        return Driver.driver.getTitle();
    }

    public void pageFactoryInitElements(Object pageObject) {
        PageFactory.initElements(Driver.driver, pageObject);
    }

    public void fillInField(WebElement webElement, String text){
        waitVisibilityOfWebElement(webElement);
        webElement.clear();
        webElement.sendKeys(text);
    }

    public void isElementDisplayed(WebElement webElement){
        waitVisibilityOfWebElement(webElement);
        assertTrue(webElement.isDisplayed());
    }

    public void isElementNotDisplayed(By elementBy) {
        waitVisibilityOfElementBy(elementBy);
        assertTrue(Driver.driver.findElements(elementBy).isEmpty());
    }

    public void isAlertText(String message) {
        assertEquals(message, Driver.driver.switchTo().alert().getText());
    }

    public String getElementText(WebElement element){
        return element.getAttribute("value");
    }
}
