package ru.bugred.users.UI_test.tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import ru.bugred.users.UI_test.pages.starter_page.*;
import ru.bugred.users.UI_test.pages.starter_page.page_components.*;

public class StarterPageTest {
    StarterPage starterPage = new StarterPage();
    ResultTable table = new ResultTable();

    @DisplayName("Positive test for name search")
    @ParameterizedTest(name = "check search email {0} have {1} result rows")
    @CsvSource(value = {
            "Samantha Bray, 1",
            "lisa, 6",
    }, ignoreLeadingAndTrailingWhitespace = true)
    void checkGettingResultAfterSearchingByName(String expectedName, int resultAmount) {
        starterPage
                .openPage()
                .checkSearch()
                .searchBySecondNameWithEnter(expectedName);
        table
                .checkResultRowsQuantity(resultAmount)
                .checkNameValuePresent(expectedName);

    }

    @DisplayName("Positive test for email search")
    @ParameterizedTest(name = "check search email {0} have {1} result rows")
    @CsvSource(value = {
            "rambler, 3",
            "gfinley@example.org, 1",
    }, ignoreLeadingAndTrailingWhitespace = true)
    void checkGettingResultAfterSearchingByEmail(String expectedEmail, int resultAmount) {
        starterPage
                .openPage()
                .checkSearch()
                .searchEmailWithEnter(expectedEmail);
        table
                .checkResultRowsQuantity(resultAmount)
                .checkEmailValuePresent(expectedEmail);
    }

    @DisplayName("Negative test for email search with empty value")
    @ParameterizedTest
    @CsvSource(value = {
            " ,10",
            "  ,10",
            "   ,10",
            "\t,10",
            "\n,10"
    }, ignoreLeadingAndTrailingWhitespace = false)
    void checkSearchingByEmptyValue(String value, int resultAmount) {
        starterPage
                .openPage()
                .checkSearch()
                .searchEmailWithEnter(value);
        table
                .checkResultRowsQuantity(resultAmount);
    }
}
