package training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import static extentUtility.ExtentManager.logEvents;
import static extentUtility.ReportEventType.*;

public class TextBoxPage extends BasePage{
    @FindBy(xpath = "//h1")
    private WebElement pageTitleElement;

    @FindBy (id = "userName")
    private WebElement nameField;

    @FindBy (id = "userEmail")
    private WebElement emailField;

    @FindBy (id = "currentAddress")
    private WebElement addressField;

    @FindBy (id = "permanentAddress")
    private WebElement permanentAddressField;

    @FindBy (xpath = "//*[@id=\"submit\"]")
    private WebElement submitButton;

    @FindBy (id = "output")
    private WebElement informationsFromForm;

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    //Metoda unde chemam toate metodele pentru completarea formularului;
    public void fillFormFromTextBox() {
        nameField();
        emailField();
        currentAddress();
        permanentAddress();
        logEvents(INFO_STEP, "Filling the inputs form the site");
        elementsHelper.scrollDownMethod();
        logEvents(PASS_STEP, "Using Scroll Down Method to reach the next element");
        elementsHelper.threadSleep(200);
        logEvents(PASS_STEP, "Using ThreadSleep to wait");
        submitButton();
        logEvents(INFO_STEP, "Click on the Submit Button after filling the form");
        informationFromForm();
        logEvents(INFO_STEP, "Printing the information from the form");
        elementsHelper.scrollDownMethod();
        logEvents(PASS_STEP, "Using Scroll Down Method to reach the next element");
        elementsHelper.threadSleep(200);
        logEvents(PASS_STEP, "Using ThreadSleep to wait");
    }

    //Metode pt a completa field-urile formularului;
    public void nameField(){
        elementsHelper.fillElement(nameField, "Stanciu Ionut");
    }

    public void emailField(){
        elementsHelper.fillElement(emailField, "itschool@gmail.com");
    }

    public void currentAddress(){
        elementsHelper.fillElement(addressField, "Marte, nr 13");
    }

    public void permanentAddress(){
        elementsHelper.fillElement(permanentAddressField, "Iad, nr 44");
    }

    public void submitButton(){
        Actions actions = new Actions(driver);
        actions.scrollToElement(submitButton);
        elementsHelper.clickElement(submitButton);
    }

    //Metoda pt a printa in consola datele introduse in formular;
    public void informationFromForm(){
        informationsFromForm.getText();
        System.out.println("The informations from form: " +informationsFromForm.getText());
    }

    @Override
     public void isPageLoaded() {
        elementsHelper.waitForElement(pageTitleElement);
        Assert.assertEquals(pageTitleElement.getText(), "Text Box", "Title is invalid and actual value is: " +pageTitleElement.getText());
    }
}
