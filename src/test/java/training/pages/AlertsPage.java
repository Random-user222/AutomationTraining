package training.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AlertsPage extends BasePage{

    //Webelemente specifice pt pagina:
    @FindBy(xpath = "//h1")
    private WebElement pageTitleElement;

    @FindBy (id = "alertButton")
    private WebElement firstAlertButton;

    @FindBy (id = "timerAlertButton")
    private WebElement secondAlert ;

    @FindBy (id = "confirmButton")
    private WebElement thirdButton;

    @FindBy (xpath = "//button[@id='promtButton']")
    private WebElement fourthButton ;

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    //Metode specifice pt pagina:
    public void interactWithAllAlerts(String alertText){
        interactWithFirstAlert();
        interactWithWaitingAlert();
        interactWithThirdAlert();
        interactWithPromptAlert(alertText);
    }

    //Metode care sa interactioneze cu alertele;
    public void interactWithFirstAlert(){
        elementsHelper.clickElement(firstAlertButton);
        alertHelpers.acceptAlert();
    }

    public void interactWithWaitingAlert(){
        elementsHelper.clickElement(secondAlert);
        alertHelpers.timerAlert();
    }

    public void clickSecondAlertButton(){
        elementsHelper.clickElement(secondAlert);
    }

    public void waitForSecondAlert(){
        elementsHelper.waitForElement(secondAlert);
    }

    public void acceptSecondAlert(){
        Alert timerAlert = driver.switchTo().alert();
        timerAlert.accept();
    }

    public void interactWithThirdAlert(){
        elementsHelper.clickElement(thirdButton);
        alertHelpers.dismissAlert();
    }

    public void interactWithPromptAlert(String text){
        elementsHelper.clickElement(fourthButton);
        alertHelpers.promptAlert(text);
    }

    @Override
    public void isPageLoaded() {
        Assert.assertEquals(pageTitleElement.getText(), "Alerts", "Title is invalid and actual value is: " +pageTitleElement.getText());
    }
}
