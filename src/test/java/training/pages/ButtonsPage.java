package training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ButtonsPage extends BasePage {
    @FindBy (id = "doubleClickBtn")
    private WebElement doubleClickButton;

    @FindBy (id = "rightClickBtn")
    private WebElement rightClickButton;

    @FindBy (xpath = "//button[text()='Click Me']")
    private WebElement normalClickButton;

    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    //Metode cu actiuni specifice;
    public void doubleClick() {
        Actions actions = new Actions(driver);
        elementsHelper.waitForElement(doubleClickButton);
        elementsHelper.threadSleep(200);
        actions.doubleClick(doubleClickButton).perform();
        System.out.println(doubleClickButton.isDisplayed());
    }

    public void rightClick(){
        Actions actions = new Actions(driver);
        elementsHelper.waitForElement(rightClickButton);
        actions.contextClick(rightClickButton).perform();
        System.out.println(rightClickButton.isDisplayed());
    }

    public void normalClickButton(){
        Actions actions = new Actions(driver);
        elementsHelper.waitForElement(normalClickButton);
        actions.click(normalClickButton).perform();
        System.out.println(normalClickButton.isDisplayed());
    }

    @Override
    public void isPageLoaded() {
    }
}
