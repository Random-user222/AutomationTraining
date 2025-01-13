package training.helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ElementsHelper {

    WebDriver driver;
    JavascriptExecutor js;


    public ElementsHelper(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }

    public void scrollDownMethod() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
    }

    public void scrollUpMethod() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(300,0)");
    }

    public void scrollByCoordonates(int y1, int y2) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + y1 + "," + y2 + ")");
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public void fillElement(WebElement input, String text) {
        input.sendKeys(text);
    }

    public void selectElementUsingKeys(WebElement element, String value, Keys key) {
        fillElement(element, value);
        element.sendKeys(key);
    }

    public void uploadFileToElement(WebElement element) {
        String pictureFilePath = "src/test/resources/Screenshot1.png";
        File file = new File(pictureFilePath);
        element.sendKeys(file.getAbsolutePath());
    }

    public void selectElementByTextFromList(String elementName, List<WebElement> elementsList) {
        for (WebElement element : elementsList) {
            if (element.getText().equals(elementName)) {
                element.click();
                break;
            }
        }
    }

    public void keyboardEnters(WebElement element ,Keys keys){
        element.sendKeys(keys);
    }

    public void waitForElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void threadSleep(long milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void scrollDown() {
    }
}

