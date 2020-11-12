package tests;

import main.BaseTest;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.*;

public class CheckArchiveDepositSizeTest extends BaseTest {

    @Test
    void checkArchiveDepositSizeTest() {

        $(byText("Вклады")).hover();
        $(byTitle("Депозиты")).click();
        $(byText("Архивные счета и депозиты")).click();
        $$x("//div[contains(@id,\"archive-account-saving\")]").shouldHaveSize(9);
    }
}
