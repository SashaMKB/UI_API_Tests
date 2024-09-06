package Driver;
import com.codeborne.selenide.Configuration;

import Utils.IApplicationDriver;

import static com.codeborne.selenide.Selenide.*;

public class SelenideApplicationDriver implements IApplicationDriver {

    @Override
    public void openPage(String pageUrl) {
        Configuration.browser = "chrome";
        open(pageUrl);
    }

    @Override
    public void closePage() {
        closeWindow();
    }
}
