package tests;

import main.BaseTest;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CheckInsuranceSizeTest extends BaseTest {

    @Test
    void checkArchiveDepositSizeTest() {
        int insuranceDepositButton = 0;

        $(byText("Вклады")).click();
        $("button[data-test-id=\"tabs-list-tabTitle-0\"]").sibling(insuranceDepositButton).click();
        $$("div[data-test-id^=\"accordion-header\"]").filter(visible).shouldHaveSize(4);
    }

}
