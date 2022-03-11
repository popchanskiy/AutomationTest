package ru.bugred.users.UI_test.pages.starter_page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import ru.bugred.users.UI_test.pages.starter_page.page_components.*;

import static com.codeborne.selenide.Selenide.$;

public class StarterPage {
    private SelenideElement table = $("table");
    private SelenideElement pageHeader = $("p");

    public StarterPage openPage() {
        Selenide.open("http://users.bugred.ru/");
        table.shouldBe(Condition.exist);
        pageHeader.shouldHave(Condition.text("  " +
                "— бесплатный тестовый проект с багами и методами SOAP / REST. "));
        return this;
    }

    public MainMenuBtns checkMainMenuBtns() {
        return new MainMenuBtns();
    }

    public ResultTable checkResultTable() {
        return new ResultTable();
    }

    public SearchBar checkSearch() {
        return new SearchBar();
    }


}
