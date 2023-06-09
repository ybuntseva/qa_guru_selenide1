import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    @BeforeAll

    static void beforeAll() {

        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test

    void dragAndDropTest() {
        open("/drag_and_drop");
        // Перетащить прямоугольник A на место прямоугольника B
        SelenideElement elementA = $("#column-a");
        SelenideElement elementB = $("#column-b");
//        actions().moveToElement(elementB).click(elementA).perform(); // Selenide.actions() не работает
        $("#column-a").dragAndDrop(DragAndDropOptions.to("#column-b"));
        // Проверить, что прямоугольники поменялись местами
        $("#column-a").shouldHave(Condition.text("B"));
        $("#column-b").shouldHave(Condition.text("A"));
    }
}
