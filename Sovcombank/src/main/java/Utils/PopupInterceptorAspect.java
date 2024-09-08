package Utils;

import com.codeborne.selenide.SelenideElement;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Aspect
public class PopupInterceptorAspect {
    @Before("execution(* com.codeborne.selenide.SelenideElement.click(..)) || " +
            "execution(* com.codeborne.selenide.SelenideElement.setValue(..)) || " +
            "execution(* com.codeborne.selenide.SelenideElement.getText(..))")
    public void closePopupIfPresent() {
        SelenideElement popup = $(By.xpath("//p[text()='Помочь тебе']"));
        if (popup.is(Condition.visible)) {
            popup.$("//button[@class='button close-btn']").click();
            System.out.println("Нашел");
        }
    }
}

