package training.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static extentUtility.ExtentManager.logEvents;
import static extentUtility.ReportEventType.INFO_STEP;

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
        logEvents(INFO_STEP, "Interact With First Alert");
        interactWithWaitingAlert();
        logEvents(INFO_STEP, "Interact With Waiting Alert");
        interactWithThirdAlert();
        logEvents(INFO_STEP, "Interact With Third Alert");
        interactWithPromptAlert(alertText);
        logEvents(INFO_STEP, "Interact With Prompt Alert");
    }

    //Metode care sa interactioneze cu alertele;
    public void interactWithFirstAlert(){
        elementsHelper.clickElement(firstAlertButton);
        logEvents(INFO_STEP, "Click On The First Alert Button");
        alertHelpers.acceptAlert();
        logEvents(INFO_STEP, "Accept First Alert");
    }

    public void interactWithWaitingAlert(){
        elementsHelper.clickElement(secondAlert);
        logEvents(INFO_STEP, "Click On The Second Alert Button");
        alertHelpers.timerAlert();
        logEvents(INFO_STEP, "Wait For Second Alert And Accept");
    }

    public void interactWithThirdAlert(){
        elementsHelper.clickElement(thirdButton);
        logEvents(INFO_STEP, "Click On Third Alert Button");
        alertHelpers.dismissAlert();
        logEvents(INFO_STEP, "Dismiss Third Alert");
    }

    public void interactWithPromptAlert(String text){
        elementsHelper.clickElement(fourthButton);
        logEvents(INFO_STEP, "Click On Forth Alert Button");
        alertHelpers.promptAlert(text);
        logEvents(INFO_STEP, "Write " +text +" And Click On Accept");
    }

    @Override
    public void isPageLoaded() {
        Assert.assertEquals(pageTitleElement.getText(), "Alerts", "Title is invalid and actual value is: " +pageTitleElement.getText());
    }
}
