import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step ("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step ("Ищем репозиторий {repository}")
    public void searchForRepository (String repository) {
        $("[name=q]").click();
        $("[name=q]").setValue(repository).pressEnter();
    }

    @Step ("Переходим в репозиторий {repository}")
    public void GoToRepository (String repository) {
        $(By.linkText(repository)).click();
    }

    @Step ("Открываем таб Issues в репозитории")
    public void openIssueTab () {
        $(byText("Issues")).click();
    }

    @Step ("Проверяем, что Issue с номером {number} существует")
    public void shouldSeeIssueWithNumber(int number) {
        $(withText("#" + number)).should((Condition.exist));
    }

}
