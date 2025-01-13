package training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class HomePage extends BasePage {

    //Indentificam WebElement-ele specifice paginii;
    @FindBy(xpath = "//h5")
    private List < WebElement > menuListElement;

    @FindBy(xpath = "//img[@class='banner-image']")
    private WebElement pageTitle;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Implementarea proprie pentru HomePage a metodei abstracte din BasePage;
    @Override
    public void isPageLoaded() {
        Assert.assertTrue(pageTitle.getAttribute("alt").equals("Selenium Online Training"),"Page is not loaded correctly");
    }

    //Facem o metoda care sa faca click pe un meniu ales;
    public void selectMenu(String menuName){
        elementsHelper.scrollDownMethod();
        elementsHelper.selectElementByTextFromList(menuName, menuListElement);
    }
}
