package lesson9.tests;

import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.*;
import io.qameta.allure.selenide.*;
import lesson9.pages.forms.practice_form_page.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.*;

public class BaseTest {
    StudentRegistrationFormPage automationPracticeForm = new StudentRegistrationFormPage();
    SubmittingReportPage submittingReportPage = new SubmittingReportPage();

    @BeforeAll
    static void setup() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        //Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

}
