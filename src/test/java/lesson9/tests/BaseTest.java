package lesson9.tests;

import com.codeborne.selenide.*;
import lesson9.pages.forms.practice_form_page.*;
import org.junit.jupiter.api.*;

public class BaseTest {
    StudentRegistrationFormPage automationPracticeForm= new StudentRegistrationFormPage();
    SubmittingReportPage submittingReportPage=new SubmittingReportPage();

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = false;
        Configuration.headless = false;
        //Configuration.browserSize="1900*108";
        Configuration.browser = "chrome";
        Configuration.browserSize ="1920x1080"; //1920x1080
    }
}
