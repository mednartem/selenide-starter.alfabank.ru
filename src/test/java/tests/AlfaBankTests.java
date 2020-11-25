package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.*;

public class AlfaBankTests {

    @Test
    void checkSizeOfArchiveDepositTest() {
        open("https://alfabank.ru/");
        $(byTitle("Вклады")).hover();
        $(byTitle("Депозиты")).click();
        $(byText("Архивные счета и депозиты")).click();
        $$("[data-test-id^='tabs-list-tabTitle']").find(text("Депозиты")).click();
        $$("[data-widget-name='CatalogCard']").shouldHaveSize(5);
    }

    @Test
    void checkSizeOfDepositInsuranceUseSiblingTest() {
        open("https://alfabank.ru/");
        int depositInsuranceIndex = 0;
        $(byTitle("Вклады")).click();
        $("button[data-test-id='tabs-list-tabTitle-0']").sibling(depositInsuranceIndex).click();
        $$("[data-test-id^='accordion-item']").shouldHave(size(4), itemWithText("Страхованию подлежат"));
        $("[data-widget-name='Link']").preceding(0).shouldHave(text("Популярные"));
        $("[data-test-id='tabs-list-tabTitle-0']").closest("div").shouldHave(text("Что такое вклад?"));
    }

    @Test
    void checkTextInTheCardUseClosestTest() {
        open("https://alfabank.ru/");
        $(byText("Подробнее")).closest("div").shouldHave(text("Получить карту"));
    }

    @Test
    void checkTextInTheCardUsePrecedingTest() {
        open("https://alfabank.ru/");
        $("[data-test-id='Mortgage-Benefits-Block-Main']")
                .$(".fWMAmd3")
                .preceding(0)
                .shouldHave(text("Досрочное погашение без визитов в банк"));
    }
}
