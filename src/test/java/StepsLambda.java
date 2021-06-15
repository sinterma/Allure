import com.codeborne.selenide.Condition;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class StepsLambda {
    private static final String BASE_URL = "https://github.com";
    private static final String REPOSITORY= "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 68;


@Test
@Severity(SeverityLevel.BLOCKER)
public void testIssueSearch () {
    step ("Открываем главную страницу", (s) -> {
        s.parameter("URL",BASE_URL);
        open(BASE_URL);
    });
    step("Ищем репозиторий" + REPOSITORY, (s) -> {
        s.parameter("repository", REPOSITORY);
        $("[name=q]").setValue(REPOSITORY).pressEnter();
    });
    step("Переходим в репозиторий" + REPOSITORY,(s) -> {
        s.parameter("repository", REPOSITORY);
        $(By.linkText(REPOSITORY)).click();
    });
    step("Открываем таб Issues в репозитории", () -> {
        $(byText("Issues")).click();
    });
    step("Проверяем, что Issue с номером" + ISSUE_NUMBER + "существует", (s) -> {
        s.parameter("number", ISSUE_NUMBER);
        $(withText("#68")).should((Condition.visible));
    });

    }
}