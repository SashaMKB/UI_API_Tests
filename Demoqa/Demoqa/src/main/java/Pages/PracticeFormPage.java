package Pages;

import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class PracticeFormPage {

    public PracticeFormPage() {
//        $(By.xpath("//h5[text()='Forms']")).click();
//        $(By.xpath("//[text()='Forms']")).click();
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


    //возможно, стоит вынести работу с каждым элементом в отдельные методы
    public void fillAllFields(String firstName, String secondName, String email, String number,
                              String subject, String address, String state, String city) {
        $(firstNameField).sendKeys(firstName);
        $(secondNameField).sendKeys(secondName);
        $(emailField).sendKeys(email);
        $(numberField).sendKeys(number);
        $(currentAddressField).sendKeys(address);
        $(genderMaleField).click();
        $(hobbiesSportField).click();

        $(subjectField).setValue(subject.substring(0, 2));
        $(By.xpath("//*[text()='" + subject + "']")).click();

        $(pictureField).uploadFile(new File("src/test/resources/1.jpg"));

        $(stateField).click();
        $(By.xpath("//*[text()='" + state + "']")).click();
        $(cityField).click();
        $(By.xpath("//*[text()='" + city + "']")).click();
        $(submitButton).click();
    }


    public boolean checkThatAllFieldsFillCorrect() {
        return $(successButton).isDisplayed();
    }


}
