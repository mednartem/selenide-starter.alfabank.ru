package tests;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.*;

public class AlfaBankTests {

    @BeforeEach
    void setUp() {
        open("https://alfabank.ru/");
    }

    @Test
    void checkSizeOfArchiveDepositTest() {
        $(byTitle("Вклады")).hover();
        $(byTitle("Депозиты")).click();
        $(byText("Архивные счета и депозиты")).click();
        $$("[data-test-id^=\"tabs-list-tabTitle\"]").find(text("Депозиты")).click();
        $$("[data-widget-name=\"CatalogCard\"]").shouldHaveSize(5);
    }

    @Test
    void checkSizeOfDepositInsuranceTest() {
        int depositInsuranceIndex = 0;
        $(byTitle("Вклады")).click();
        $("button[data-test-id=\"tabs-list-tabTitle-0\"]").sibling(depositInsuranceIndex).click();
        $$("[data-test-id^=\"accordion-item\"]").shouldHave(size(4), itemWithText("Страхованию подлежат"));
    }
}
