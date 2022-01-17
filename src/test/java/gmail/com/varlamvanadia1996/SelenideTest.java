package gmail.com.varlamvanadia1996;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideTest {
    private static final String REPOSITORY = "NadezhdaVarlamova/qa_guru_6";
    private static final String TITLE = "Hello";

    @Owner("Nadezhda Varlamova")
    @Feature("Issues")
    @Story("Проверка наличия Issues c заголовком Hello")
    @DisplayName("Проверка наличия Issues c заголовком Hello чистый Selenide")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void testIssueName(){
        Allure.parameter("Репозиторий", REPOSITORY);
        Allure.parameter("Заголовок Issue", TITLE);

        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com/");
        $(".header-search-input").click();
        $(".header-search-input").setValue(REPOSITORY).pressEnter();
        $(linkText(REPOSITORY)).click();
        $(partialLinkText("Issue")).click();
        $(withText(TITLE)).shouldBe(visible);
    }
}
