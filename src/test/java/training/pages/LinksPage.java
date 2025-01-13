package training.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Set;

public class LinksPage extends BasePage{
    @FindBy (id = "simpleLink")
    private WebElement linkThatOpenNewTab;

    @FindBy (id = "created")
    private WebElement createdElement;

    @FindBy (id = "no-content")
    private WebElement noContentElement;

    @FindBy (id = "moved")
    private WebElement movedElement;

    @FindBy (id = "bad-request")
    private WebElement badRequestElement;

    @FindBy (id = "unauthorized")
    private WebElement unauthorizedElement;

    @FindBy (id = "forbidden")
    private WebElement forbiddenElement;

    @FindBy (id = "invalid-url")
    private WebElement notFoundElement;

    public LinksPage(WebDriver driver) {
        super(driver);
    }

    //Metode specifice pt a gestiona mai multe tab-uri/windows deschise;
    public void clickOnFirstLink(){
        elementsHelper.clickElement(linkThatOpenNewTab);
        ((JavascriptExecutor) driver).executeScript("window.open('https://demoqa.com/links', 'https://demoqa.com/');");
        Set<String> windowHandles = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<>(windowHandles);

        if (tabs.size() > 1) {
            driver.switchTo().window(tabs.remove(2));
            driver.close();
            driver.switchTo().window(tabs.get(1));
            driver.close();
        }
    }

    public void firstLinkWithResponse(){
        elementsHelper.clickElement(createdElement);
        elementsHelper.scrollDownMethod();
    }


    @Override
    public void isPageLoaded() {
    }
}
