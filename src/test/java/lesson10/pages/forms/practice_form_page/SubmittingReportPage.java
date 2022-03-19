package lesson10.pages.forms.practice_form_page;

import com.codeborne.selenide.*;
import io.qameta.allure.*;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.*;

public class SubmittingReportPage {
    private SelenideElement modalPage = $("#example-modal-sizes-title-lg");

    @Step("check table should be")
    public SubmittingReportPage pageShouldBe(Condition condition) {
        modalPage.shouldBe(condition);
        return this;
    }

    @Step("check table contains valid values")
    public SubmittingReportPage tableShouldHaveTexts(String... exactTexts) {
        $$(".table td:last-child").shouldHave(exactTexts(exactTexts));
        return this;
    }
}
