package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;

public class VacanciesPage {

    private static final By vacanciesButton = By.xpath("//div[text()='Вакансии']");
    private static final By townField = By.xpath("//input[@placeholder='Все города']");
    private static final By companyField = By.xpath("//div[@class='v-select__selections']");

    public void clickVacanciesButton() {
        $(vacanciesButton).click();
    }

    public void fillTownField(String value) {
        $(townField).click();
        $(By.xpath("//div[text()='\n" +
                "        " + value + "\n" +
                "        ']")).click();
    }

    public void fillCompanyField(String value) {
        $(companyField).click();
        $(By.xpath("//div[text()='\n" +
                "                      " + value + "\n" +
                "                    ']")).click();
    }


    public void getVacancyTitles() {
        sleep(2000);
        ElementsCollection vacancies = $$x("//div[@class='block-vacancy__title']//h5");
        System.out.println(vacancies.stream()
                .map(SelenideElement::getText)
                .collect(Collectors.toList()));
    }

    public boolean verifyVacancies(String city, String company) {
        ElementsCollection vacancies = $$x("//div[@class='block-vacancy']");

        boolean containsCity = vacancies.stream()
                .anyMatch(vacancy -> vacancy.getText().contains(city));
        boolean containsCompany = vacancies.stream()
                .anyMatch(vacancy -> vacancy.getText().contains(company));

        return containsCity && containsCompany;
    }
}
