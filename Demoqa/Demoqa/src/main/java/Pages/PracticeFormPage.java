package Pages;

import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class PracticeFormPage {

    public PracticeFormPage() {
    }

    private static final By firstNameField = By.id("firstName");
    private static final By secondNameField = By.id("lastName");
    private static final By emailField = By.id("userEmail");
    private static final By genderMaleField = By.xpath("//label[@for='gender-radio-1']");
    private static final By numberField = By.id("userNumber");
    private static final By subjectField = By.id("subjectsInput");
    private static final By hobbiesSportField = By.xpath("//label[@for='hobbies-checkbox-1']");
    private static final By pictureField = By.id("uploadPicture");
    private static final By currentAddressField = By.id("currentAddress");
    private static final By stateField = By.id("state");
    private static final By cityField = By.id("city");
    private static final By submitButton = By.id("submit");
    private static final By successButton = By.xpath("//div[text()='Thanks for submitting the form']");


    public void fillFirstName(String firstName) {
        $(firstNameField).sendKeys(firstName);
    }

    public void fillSecondName(String secondName) {
        $(secondNameField).sendKeys(secondName);
    }

    public void fillEmail(String email) {
        $(emailField).sendKeys(email);
    }

    public void fillNumber(String number) {
        $(numberField).sendKeys(number);
    }

    public void fillCurrentAddress(String address) {
        $(currentAddressField).sendKeys(address);
    }

    public void fillSubject(String subject) {
        $(subjectField).setValue(subject.substring(0, 2));
        $(By.xpath("//*[text()='" + subject + "']")).click();
    }

    public void fillPhoto() {
        $(pictureField).uploadFile(new File("src/test/resources/1.jpg"));
    }

    public void fillState(String state) {
        $(stateField).click();
        $(By.xpath("//*[text()='" + state + "']")).click();
    }

    public void fillCity(String city) {
        $(cityField).click();
        $(By.xpath("//*[text()='" + city + "']")).click();
    }

    public void fillGenderMaleFiled() {
        $(genderMaleField).click();
    }

    public void fillHobbiesSport() {
        $(hobbiesSportField).click();
    }

    public void fillAllFields(String firstName, String secondName, String email, String number,
                              String subject, String address, String state, String city) {
        fillFirstName(firstName);
        fillSecondName(secondName);
        fillEmail(email);
        fillNumber(number);
        fillSubject(subject);
        fillCurrentAddress(address);
        fillState(state);
        fillCity(city);
        fillGenderMaleFiled();
        fillHobbiesSport();
        $(submitButton).click();
    }


    public boolean checkThatAllFieldsFillCorrect() {
        return $(successButton).isDisplayed();
    }

    public boolean checkFieldEmailFillCorrect() {
        return ($(emailField).getCssValue("border-color")).equals("rgb(206, 212, 218)");
    }

    public  boolean checkFieldNumberFillCorrect() {
        return ($(numberField).getCssValue("border-color")).equals("rgb(206, 212, 218)");
    }


}
