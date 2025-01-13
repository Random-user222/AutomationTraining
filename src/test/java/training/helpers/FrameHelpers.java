package training.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameHelpers {

    public WebDriver driver;

    public FrameHelpers(WebDriver driver) {
        this.driver = driver;
    }

    //Facem o metada care isi muta focusul pe frame;
    public void switchOnFrame(WebElement element){
        driver.switchTo().frame(element);
    }

    public void switchToDefaultPage(){
        driver.switchTo().defaultContent();
    }
}
