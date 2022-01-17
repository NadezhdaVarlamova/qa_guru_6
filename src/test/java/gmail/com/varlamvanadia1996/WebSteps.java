package gmail.com.varlamvanadia1996;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {

    @Step("Открываем страницу")
    public void openMainPage(){
        open("https://github.com/");
    }

    @Step("Поиск репозитория {repository}")
    public void searchRepository(String repository){
        $(".header-search-input").click();
        $(".header-search-input").setValue(repository).pressEnter();
    }

    @Step("Переходим в репозиторий {repository}")
    public void openRepository(String repository){
        $(linkText(repository)).click();
    }

    @Step("Открываем таб Issue")
    public void openIssueTab(){
        $(partialLinkText("Issue")).click();
        attachPageSource();
    }

    @Step("Проверяем наличие Issue с заголовком {title}")
    public void shouldSeeIssueWithTitle(String title){
        $(withText(title)).shouldBe(visible);
    }

    @Attachment(value = "Screenshot", type = "text/html", fileExtension = "html")
    public byte[] attachPageSource() {
        return WebDriverRunner.source().getBytes(StandardCharsets.UTF_8);
    }
}
