package git;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SearchSelenideRepo {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    void openGitSelenide() {
        open("/selenide/selenide");
        $("[data-content='Wiki']").click();
        $("#wiki-pages-filter").setValue("SoftAssertions").pressEnter();
        $(byText("SoftAssertions")).click();
        $$("h4").findBy(text("Using JUnit5 extend test class")).sibling(0)
               .shouldHave(text("class Tests"));
    }

}
