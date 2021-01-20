package util;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base extends DriverCreation {


    public void click(By locator) {
        waitForVisible(locator);
        getDriver().findElement(locator).click();

    }

    public void writeText(By locator, String keys) {
        waitForVisible(locator);
        clear(locator);
        getDriver().findElement(locator).sendKeys(keys);
    }

    public void waitForVisible(By locator) {

        WebDriverWait wait = new WebDriverWait(getDriver(), 30);

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    public void waitForNotVisible(By locator) {

        WebDriverWait wait = new WebDriverWait(getDriver(), 30);

        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));

    }

    public String getElementText(By locator) {
        waitForVisible(locator);
        return getDriver().findElement(locator).getAttribute("value");
    }

    public void clear(By locator) {

        getDriver().findElement(locator).clear();
    }


}
