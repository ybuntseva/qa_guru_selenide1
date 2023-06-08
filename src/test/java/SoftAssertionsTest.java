import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertionsTest {

    @BeforeAll
    static void beforeAll() {

        Configuration.pageLoadStrategy = "eager";
    }

    @Test

    void firstTest() {
        // Открыть github.com
        open("https://github.com/");
        // Ввести selenide в поиске
        $("[placeholder='Search GitHub']").setValue("selenide").pressEnter();
        // Открыть страницу Selenide
        $$("ul.repo-list li").first().$("a").click();
        // Перейти на вкладку Wiki
        $$("ul.UnderlineNav-body li").get(5).$("a").click();
        // Ввести soft в разделе Pages
        $("#wiki-pages-filter").setValue("soft");
        // Перейти на страницу SoftAssertions
        $$(".details-reset").get(17).$("a").click();
        // Проверить, что на странице SoftAssertions есть пример кода для JUnit5
        $("#user-content-3-using-junit5-extend-test-class").scrollIntoView(true);
        $("#wiki-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));
        sleep(10000);
    }
}
