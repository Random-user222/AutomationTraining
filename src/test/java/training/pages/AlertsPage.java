package training.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

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
    public void interactWithAllAlerts(){
        clickFirstAlertButton();
        interactWithWaitingAlert();
        clickThirdButton();
        clickFourthButton();
    }

    public void clickFirstAlertButton(){
        firstAlertButton.click();
        Alert clickOk = driver.switchTo().alert();
        clickOk.accept();
    }

    public void interactWithWaitingAlert(){
        clickSecondAlertButton();
        waitForSecondAlert();
        acceptSecondAlert();
    }

    public void clickSecondAlertButton(){
        secondAlert.click();
    }

    public void waitForSecondAlert(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptSecondAlert(){
        Alert timerAlert = driver.switchTo().alert();
        timerAlert.accept();
    }

    public void clickThirdButton(){
        thirdButton.click();
        Alert confirmBoxAlert = driver.switchTo().alert();
        confirmBoxAlert.dismiss();
    }

    public void clickFourthButton(){
        fourthButton.click();
        Alert promtAlert = driver.switchTo().alert();
        promtAlert.sendKeys("Emanuel");
        promtAlert.accept();
    }

    @Override
    public void isPageLoaded() {
        Assert.assertEquals(pageTitleElement.getText(), "Alerts", "Title is invalid and actual value is: " +pageTitleElement.getText());
    }
}
