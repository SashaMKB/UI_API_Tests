import Driver.SelenideApplicationDriver;
import Pages.PracticeFormPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PracticeFormTests {
    String firstName, secondName, email, number, subject, address, state, city;

    private final SelenideApplicationDriver selenideApplicationDriver = new SelenideApplicationDriver();


    @BeforeEach
    public void setUp() {
        selenideApplicationDriver.openPage("https://demoqa.com/automation-practice-form");
    }


    @AfterEach
    public void tearDown() {
        selenideApplicationDriver.closePage();
    }

    @Test
    public void fillCorrectAllFieldsTest() {
        PracticeFormPage page = new PracticeFormPage();
        firstName = "name";
        secondName = "Name";
        email = "emai@example.com";
        number = "9177777777";
        subject = "Maths";
        address = "address";
        state = "NCR";
        city = "Delhi";
        page.fillAllFields(firstName, secondName, email, number, subject, address, state, city);
        assertThat(page.checkThatAllFieldsFillCorrect()).isTrue();
    }

    @Test
    public void fillIncorrectEmailTest() {
        PracticeFormPage page = new PracticeFormPage();
        firstName = "name";
        secondName = "Name";
        email = "email+email";
        number = "9177777777";
        subject = "Maths";
        address = "address";
        state = "NCR";
        city = "Delhi";
        page.fillAllFields(firstName, secondName, email, number, subject, address, state, city);
        assertThat(page.checkFieldEmailFillCorrect()).isFalse();
    }

    @Test
    public void fillIncorrectNumberTest() {
        PracticeFormPage page = new PracticeFormPage();
        firstName = "name";
        secondName = "Name";
        email = "emai@example.com";
        number = "917777772";
        subject = "Maths";
        address = "address";
        state = "NCR";
        city = "Delhi";
        page.fillAllFields(firstName, secondName, email, number, subject, address, state, city);
        assertThat(page.checkFieldNumberFillCorrect()).isFalse();
    }
}
