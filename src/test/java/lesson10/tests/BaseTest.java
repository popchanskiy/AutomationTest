package lesson10.tests;

import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.*;
import io.qameta.allure.selenide.*;
import lesson10.helpers.*;
import lesson10.pages.forms.practice_form_page.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.*;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {
    StudentRegistrationFormPage automationPracticeForm = new StudentRegistrationFormPage();
    SubmittingReportPage submittingReportPage = new SubmittingReportPage();

    @BeforeAll
    static void setup() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.remote = Configurator.getRemoteURL();
        Configuration.browser = Configurator.getBrowser();
        Configuration.browserVersion = Configurator.getBrowserVersion();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }

}
