import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SolutionsTest {

    String confirmMessage = "Build like the best";

    @BeforeAll

    static void beforeAll() {

        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
    }

    @Test

    void solutionsTest() {

        // Открыть github.com
        open("https://github.com/");
        // Выбрать в меню Solutions->Enterprise (при помощи команды hover)
        $(".header-menu-wrapper").$(byText("Solutions")).hover();
        $(byText("Enterprise")).click();
        // Проверить заголовок
        $("div h1").shouldHave(Condition.text(confirmMessage));
    }
}
