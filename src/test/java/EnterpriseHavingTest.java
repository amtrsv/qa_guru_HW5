import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class EnterpriseHavingTest {

    @BeforeAll
    static void beforeAll() {
        //Configuration.holdBrowserOpen = true;
        //Configuration.baseUrl = "https://github.com/";
        //Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000; // секунды

    }

    @Test
    void findSolutionEnteprise() {

        //На главной странице GitHub выберите меню Solutions -> Enterprize с помощью команды hover для Solutions.
        open("https://github.com/");
        $("ul.d-lg-flex.list-style-none").$(byText("Solutions")).hover();

        //Убедитесь что загрузилась нужная страница (например что заголовок - "Build like the best."
        $("[href='/enterprise']").click();
        $("#js-global-screen-reader-notice").shouldHave(text("The AI Powered Developer Platform"));
    }

    @AfterAll
    static void clearCookies() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        closeWebDriver();
    }
}
