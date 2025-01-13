package training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

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

    @FindBy (id = "submit")
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
        submitButton();
        informationFromForm();
        elementsHelper.scrollDownMethod();
        elementsHelper.threadSleep(200);
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
