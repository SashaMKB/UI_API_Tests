package Driver;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;

public class SelenideApplicationDriver {


    public void openPage(String pageUrl) {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = "chrome";
        open(pageUrl);
    }

    public void closePage() {
        closeWindow();
    }
}
