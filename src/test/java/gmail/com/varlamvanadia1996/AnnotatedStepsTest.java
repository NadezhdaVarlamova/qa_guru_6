package gmail.com.varlamvanadia1996;

import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnnotatedStepsTest {

    private static final String REPOSITORY = "NadezhdaVarlamova/qa_guru_6";
    private static final String TITLE = "Hello";
    WebSteps webSteps = new WebSteps();

    @Owner("Nadezhda Varlamova")
    @Feature("Issues")
    @Story("Проверка наличия Issues c заголовком Hello")
    @DisplayName("Проверка наличия Issues c заголовком Hello с шагами аннотацией")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void annotatedStepsTestIssueName(){
        Allure.parameter("Репозиторий", REPOSITORY);
        Allure.parameter("Заголовок Issue", TITLE);
        webSteps.openMainPage();
        webSteps.searchRepository(REPOSITORY);
        webSteps.openRepository(REPOSITORY);
        webSteps.openIssueTab();
        webSteps.shouldSeeIssueWithTitle(TITLE);
    }

    @AfterEach
    public void saveSources(){
        webSteps.attachPageSource();
    }
}
