package training.pages;

import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PracticeFormPage extends BasePage{

    //WebElemente specifice pentru pagina:
    @FindBy (xpath = "//h1")
    private WebElement pageTitleElement;

    @FindBy (id = "firstName")
    private WebElement firstNameinput;

    @FindBy (id = "lastName")
    private WebElement lastNameinput;

    @FindBy (id = "userEmail")
    private WebElement emailInput;

    @FindBy (xpath = "//label[@for='gender-radio-1']")
    private WebElement maleGenderElement;

    @FindBy (xpath = "//label[@for='gender-radio-2']")
    private WebElement femaleGenderElement;

    @FindBy (xpath = "//label[@for='gender-radio-3']")
    private WebElement otherGenderElement;

    @FindBy (id = "userNumber")
    private WebElement phoneNumberInput;

    @FindBy (id = "subjectsInput")
    private WebElement subjectsInput;

    @FindBy (xpath = "//label[text()=\"Sports\"]")
    private WebElement hobbiesInput;

    @FindBy (xpath = "//label[text()=\"Reading\"]")
    private WebElement hobbiesInput2;

    @FindBy (xpath = "//label[text()=\"Music\"]")
    private WebElement musicHobbyElement;

    @FindBy (id = "currentAddress")
    private WebElement currentAddress;

    @FindBy (id = "uploadPicture")
    private WebElement uploadPicture;

    @FindBy (id = "dateOfBirthInput")
    private WebElement dateOfBirth;
    @FindBy (id = "dateOfBirthInput")
    private WebElement defaultElement;

    @FindBy (xpath = "//*[@id=\"react-select-3-input\"]")
    private WebElement stateInput;
    @FindBy (xpath = "//*[@id=\"react-select-4-input\"]")
    private WebElement cityInput;

    @FindBy (id = "submit")
    private WebElement submitButton;

    @FindBy (id = "closeLargeModal")
    private WebElement closeForm;

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    //Metode specifice paginii:
    public void fillEntireForm(String firstName, String lastName, String emailValue, String gender, String phoneNumber, List<String> subjects, List<String> hobbies,
                               String address, String DOB, String state, String city){
        fillFirstAndLastName(firstName, lastName);
        emailInput(emailValue);
        genderLabel(gender);
        elementsHelper.scrollDownMethod();
        phoneNumberInput(phoneNumber);
        selectSubject(subjects);
        hobbiesInput(hobbies);
        currentAddress(address);
        dateOfBirth(DOB);
        elementsHelper.scrollDownMethod();
        stateAndCity(state, city);
        elementsHelper.threadSleep(2000);
        submitButton();
    }

    public void fillEntireFormWithPropertiesData(Map<String, Object> practiceFormData){
        fillFirstAndLastName((String) practiceFormData.get("firstName"), (String) practiceFormData.get("lastName"));
        emailInput((String) practiceFormData.get("email"));
        genderLabel((String) practiceFormData.get("gender"));
        elementsHelper.scrollDownMethod();
        phoneNumberInput((String) practiceFormData.get("phoneNumber"));
        selectSubject((List <String>) practiceFormData.get("subject"));
        hobbiesInput((List <String>) practiceFormData.get("hobbies"));
        currentAddress((String) practiceFormData.get("address"));
        dateOfBirth((String) practiceFormData.get("DOB"));
        elementsHelper.scrollDownMethod();
        stateAndCity((String) practiceFormData.get("state"), (String) practiceFormData.get("city"));
        elementsHelper.threadSleep(2000);
        submitButton();
    }

    //Metode specifice pentru fiecare input al formularului;
    public void emailInput(String emailValue) {
        emailInput.sendKeys(emailValue);
    }

    public void fillFirstAndLastName(String firstName, String lastName) {
        elementsHelper.fillElement(firstNameinput, firstName);
        elementsHelper.fillElement(lastNameinput, lastName);
    }

    public void genderLabel(String gender) {
        List<WebElement> genderListElement = new ArrayList<>();
        genderListElement.add(maleGenderElement);
        genderListElement.add(femaleGenderElement);
        genderListElement.add(otherGenderElement);

        elementsHelper.selectElementByTextFromList(gender, genderListElement);
    }

    public void phoneNumberInput(String phoneNumber){
        elementsHelper.fillElement(phoneNumberInput, phoneNumber);
    }

    public void selectSubject(List <String> subjectList){
        for (String subject : subjectList){
            elementsHelper.selectElementUsingKeys(subjectsInput, subject, Keys.ENTER);
        }
    }

    public void hobbiesInput(List <String> hobbiesList){
        List <WebElement> hobbiesElementsList = List.of(hobbiesInput, hobbiesInput2, musicHobbyElement);
        for (String hobby : hobbiesList ){
            elementsHelper.selectElementByTextFromList(hobby, hobbiesElementsList);
        }
    }

    public void currentAddress(String address){
        elementsHelper.fillElement(currentAddress, address);
    }

    public void uploadPicture(){
        elementsHelper.uploadFileToElement(uploadPicture);
    }

    public void dateOfBirth(String dateOfBirthValue){
        elementsHelper.selectElementUsingKeys(dateOfBirth, dateOfBirthValue, Keys.HOME);
        for (int index = 1; index <= 11; index++){
            defaultElement.sendKeys(Keys.DELETE);
        }
        dateOfBirth.sendKeys(Keys.ENTER);
    }

    public void stateAndCity(String stateValue, String cityValue){
        elementsHelper.selectElementUsingKeys(stateInput, stateValue, Keys.ENTER);
        elementsHelper.selectElementUsingKeys(cityInput, cityValue, Keys.ENTER);
    }

    public void submitButton(){
        elementsHelper.clickElement(submitButton);
    }

    public void closeTheForm(){
        elementsHelper.clickElement(closeForm);
    }

    @Override
    public void isPageLoaded() {
        elementsHelper.waitForElement(pageTitleElement);
        Assert.assertEquals(pageTitleElement.getText(), "Practice Form", "Title is invalid and actual value is: " +pageTitleElement.getText());
    }
}
