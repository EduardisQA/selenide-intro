package com.taotas.selenideintro;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import java.lang.module.Configuration;

import static com.codeborne.selenide.Selenide.*;

public class TodoMvcTest {

    @Test
    void completesTask() {
        // open TodoMcv page
        open("http://todomvc.com/examples/emberjs/");

        //add task: "a", "b", "c"
        element("#new-todo").setValue("a").pressEnter();
        element("#new-todo").setValue("b").pressEnter();
        element("#new-todo").setValue("c").pressEnter();

        //task should be "a", "b", "c"
        elements("#todo-list>li").shouldHave(CollectionCondition.exactTexts("a", "b", "c"));

        //toggle "b"
        //1. among all tasks 2. find the one with "b" text
        //3. find its "toggle" checkbox 4. click it
        elements("#todo-list>li").findBy(Condition.exactText("b"))
                .find(".toggle").click();
        //completed tasks should be b
        elements("#todo-list>li").filterBy(Condition.cssClass("completed"))
                .shouldHave(CollectionCondition.exactTexts("b"));
        elements("#todo-list>li").filterBy(Condition.not(Condition.cssClass("completed")))
                .shouldHave(CollectionCondition.exactTexts("a", "c"));
    }

}
