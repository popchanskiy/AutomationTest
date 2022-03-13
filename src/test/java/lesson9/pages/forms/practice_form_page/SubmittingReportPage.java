package lesson9.pages.forms.practice_form_page;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.*;

public class SubmittingReportPage  {
    private SelenideElement modalPage = $("#example-modal-sizes-title-lg");

    public SubmittingReportPage pageShouldBe(Condition condition) {
        modalPage.shouldBe(condition);
        return this;
    }


        public SubmittingReportPage tableShouldHaveTexts(String... exactTexts) {
            $$(".table td:last-child").shouldHave(exactTexts(exactTexts));
            return this;
    }
}
