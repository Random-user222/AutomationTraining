package training.helpers;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertHelpers {

    public WebDriver driver;

    public AlertHelpers(WebDriver driver) {
        this.driver = driver;
    }

    public Alert switchToAlert(){
        return driver.switchTo().alert();
    }

    public void acceptAlert(){
        Alert acceptAlert = switchToAlert();
        acceptAlert.accept();
    }

    public void dismissAlert() {
        Alert dismissAlert = switchToAlert();
        dismissAlert.dismiss();
    }

    public void waitForAlert(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void timerAlert(){
        waitForAlert();
        acceptAlert();
    }

    public void promptAlert(String text){
        Alert promptTextAlert = switchToAlert();
        promptTextAlert.sendKeys(text);
        promptTextAlert.accept();
    }
}
