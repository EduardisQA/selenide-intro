package com.taotas.selenideintro;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;


public class GoogleTest {

    @Test
    void shouldSearch() {
        open("https://google.com/ncr");

        element(byName("q")).setValue("selenide").pressEnter();

        elements("#search .g").shouldHave(sizeGreaterThanOrEqual(6))
                .first().shouldHave(text("Selenide: concise UI tests in Java"))
                .find(".r>a").click();
   }
}

