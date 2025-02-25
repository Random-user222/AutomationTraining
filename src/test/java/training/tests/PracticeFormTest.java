package training.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import propertyUtility.PropertyUtility;
import training.pages.CommonPage;
import training.pages.HomePage;
import training.pages.PracticeFormPage;

import static extentUtility.ExtentManager.logEvents;
import static extentUtility.ReportEventType.INFO_STEP;
import static extentUtility.ReportEventType.PASS_STEP;
import static training.constants.MenuKeys.FORMS_MENU;
import static training.constants.SubMenuKeys.PRACTICE_FORM_SUBMENU;
import java.util.*;
public class PracticeFormTest extends BaseTest{

    private java.time.format.DateTimeFormatter DateTimeFormatter;

    //Creem o metoda de test care sa mearga de pe pagina principala pana pe pagina PracticeForms;
    @Test
    public void navigateFromHomePageToPracticeFormPage() {
        homePage.isPageLoaded();
        logEvents(PASS_STEP, "Verify if the page is loaded correctly");
        homePage.selectMenu(FORMS_MENU);
        logEvents(INFO_STEP, "Select Forms Menu from Home Page");
        commonPage.isPageLoaded();
        logEvents(PASS_STEP, "Verify if the page is loaded correctly");
        commonPage.selectSubMenu(PRACTICE_FORM_SUBMENU);
        logEvents(INFO_STEP, "Select Practice Form SubMenu from Common Page");
        PracticeFormPage practiceFormPage = new PracticeFormPage(driver);
        propertyUtility = new PropertyUtility("PracticeFormTest");
        Map <String, Object> practiceFormDataEntry = propertyUtility.getAllProperties();
        practiceFormPage.isPageLoaded();
        logEvents(PASS_STEP, "Verify if the page is loaded correctly");
        practiceFormPage.fillEntireFormWithPropertiesData(practiceFormDataEntry);
        logEvents(INFO_STEP, "Filling the form using Data Properties");
//        List <String> subjectList = List.of("Accounting", "Maths");
//        List <String> hobbiesList = List.of("Sports", "Music");
//        practiceFormPage.fillEntireForm("Stanciu", "Ionut", "itschool@gmail.com", "Male", "0707808080", subjectList, hobbiesList,
//                "Marte nr 12", "11 January 2004", "NCR", "Delhi");
//        practiceFormPage.fillEntireForm(
//                propertyUtility.getProperty("firstName"),
//                propertyUtility.getProperty("lastName"),
//                propertyUtility.getProperty("email"),
//                propertyUtility.getProperty("gender"),
//                propertyUtility.getProperty("phoneNumber"),
//                propertyUtility.getPropertyAsList("subject"),
//                propertyUtility.getPropertyAsList("hobbies"),
//                propertyUtility.getProperty("address"),
//                propertyUtility.getProperty("DOB"),
//                propertyUtility.getProperty("state"),
//                propertyUtility.getProperty("city")
//        );
    }
}


