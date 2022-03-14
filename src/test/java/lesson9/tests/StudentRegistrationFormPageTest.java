package lesson9.tests;

import com.github.javafaker.*;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;


public class StudentRegistrationFormPageTest extends BaseTest {
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String address = faker.address().fullAddress();
    String phoneNumber = faker.number().digits(10);

    @Owner("popchanskiy")
    @Feature("Student Registration Form")
    @Story("after filling form get result table")
    @DisplayName("check fillin form and get result table positive test")
    @Test
    void regFormShouldBeSubmittedAndVerified() {
        automationPracticeForm
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender("Male")
                .setMobile(phoneNumber)
                .setDate("1", "March", "1998")
                .setSubject("English")
                .setSubject("Hindi")
                .setHobbies("Sports")
                .setHobbies("Reading")
                //.uploadPicture("file.txt")
                .setAddress(address)
                .selectState("Haryana")
                .selectCity("Panipat")
                .submitBtnClick();
        submittingReportPage
                .pageShouldBe(visible)
                .tableShouldHaveTexts(firstName + " " + lastName, email, "Male", phoneNumber, "01 March,1998",
                        "English, Hindi", "Sports, Reading", "file.txt", address, "Haryana Panipat");

    }
}
