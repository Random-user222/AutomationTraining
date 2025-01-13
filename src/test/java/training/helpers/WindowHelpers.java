package training.helpers;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class WindowHelpers {
    public WebDriver driver;

    public WindowHelpers(WebDriver driver) {
        this.driver = driver;
    }

    //Facem o metoda care sa faca switch intre windows;
    public void switchToWindow(int index){
        List <String> windowsList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowsList.get(index));
    }

    //Facem o metoda care sa inchida window sau tab;
    public void closeWindowOrTab(){
        driver.close();
    }
}
