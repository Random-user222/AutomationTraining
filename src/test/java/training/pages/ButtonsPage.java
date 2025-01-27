package training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.plaf.PanelUI;

import static extentUtility.ExtentManager.logEvents;
import static extentUtility.ReportEventType.INFO_STEP;

public class ButtonsPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(ButtonsPage.class);
    @FindBy (id = "doubleClickBtn")
    private WebElement doubleClickButton;

    @FindBy (id = "rightClickBtn")
    private WebElement rightClickButton;

    @FindBy (xpath = "//button[text()='Click Me']")
    private WebElement normalClickButton;

    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    public void interactWithAllButtons(){
        doubleClick();
        rightClick();
        normalClickButton();
    }

    //Metode cu actiuni specifice;
    public void doubleClick() {
        Actions actions = new Actions(driver);
        logEvents(INFO_STEP, "Creating Actions method");
        elementsHelper.waitForElement(doubleClickButton);
        logEvents(INFO_STEP, "Wait for the element");
        elementsHelper.threadSleep(200);
        actions.doubleClick(doubleClickButton).perform();
        logEvents(INFO_STEP, "Using Actions to double click on the element");
        System.out.println(doubleClickButton.isDisplayed());
    }

    public void rightClick(){
        Actions actions = new Actions(driver);
        logEvents(INFO_STEP, "Creating Actions method");
        elementsHelper.waitForElement(rightClickButton);
        logEvents(INFO_STEP, "Wait for the element");
        actions.contextClick(rightClickButton).perform();
        logEvents(INFO_STEP, "Using Actions to right click on the element");
        System.out.println(rightClickButton.isDisplayed());
    }

    public void normalClickButton(){
        Actions actions = new Actions(driver);
        logEvents(INFO_STEP, "Creating Actions method");
        elementsHelper.waitForElement(normalClickButton);
        logEvents(INFO_STEP, "Wait for the element");
        actions.click(normalClickButton).perform();
        logEvents(INFO_STEP, "Using Actions to click on the element");
        System.out.println(normalClickButton.isDisplayed());
    }

    @Override
    public void isPageLoaded() {
    }
}
