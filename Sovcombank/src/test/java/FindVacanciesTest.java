import Driver.SelenideApplicationDriver;
import Pages.VacanciesPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class FindVacanciesTest {


    private SelenideApplicationDriver selenideApplicationDriver = new SelenideApplicationDriver();


    @BeforeEach
    public void setUp() {
        selenideApplicationDriver.openPage("https://people.sovcombank.ru/");
    }


    @AfterEach
    public void tearDown() {
        selenideApplicationDriver.closePage();
    }

    @Test
    public void findVacanciesAndCheckResults() {
        VacanciesPage page = new VacanciesPage();

        String city = "Москва";
        String company = "Совкомбанк Технологии";

        page.clickVacanciesButton();
        page.fillTownField(city);
        page.fillCompanyField(company);
        page.getVacancyTitles();

        assertThat(page.verifyVacancies(city, company)).isTrue();
    }

}
