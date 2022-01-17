package gmail.com.varlamvanadia1996;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class StepsTest {

    private static final String REPOSITORY = "NadezhdaVarlamova/qa_guru_6";
    private static final String TITLE = "Hello";

    @Owner("Nadezhda Varlamova")
    @Feature("Issues")
    @Story("Проверка наличия Issues c заголовком Hello")
    @DisplayName("Проверка наличия Issues c заголовком Hello с лямбда шагами")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void lambdaStepsTestIssueName(){
        Allure.parameter("Репозиторий", REPOSITORY);
        Allure.parameter("Заголовок Issue", TITLE);

        step("Открываем страницу", () -> {
            open("https://github.com/");});
        step("Поиск репозитория " + REPOSITORY, ()->{
            $(".header-search-input").click();
            $(".header-search-input").setValue(REPOSITORY).pressEnter(); });
        step("Переходим в репозиторий " + REPOSITORY, ()->{
           $(linkText(REPOSITORY)).click(); });
        step("Открываем таб Issue", ()->{
            $(partialLinkText("Issue")).click(); });
        step("Проверяем наличие Issue с заголовком " + TITLE, ()->{
            $(withText(TITLE)).shouldBe(visible); });
    }

    @AfterEach
    public void saveSources(){
        Allure.addAttachment("Page Source", "text/html", WebDriverRunner.source(), "html");
    }
}
