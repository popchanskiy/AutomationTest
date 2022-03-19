package lesson10.pages.forms.practice_form_page;

import com.codeborne.selenide.*;
import io.qameta.allure.*;
import lesson10.pages.*;
import lesson10.pages.components.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormPage extends BasePage {
    private final SelenideElement firstNameField = $("#firstName");
    private final SelenideElement lastNameField = $("#lastName");
    private final SelenideElement emailField = $("#userEmail");
    private final SelenideElement genderRadioBtn = $("#genterWrapper");
    private final SelenideElement mobileField = $("#userNumber");
    //private final SelenideElement dateOfBirthField = $("#dateOfBirthInput");
    private final SelenideElement subjectsField = $("#subjectsInput");
    //private final SelenideElement hobbiesRadioBtn = $(byText(String.valueOf("")));
    private final SelenideElement pictureUploadField = $("#uploadPicture");
    private final SelenideElement addressField = $("#currentAddress");
    private final SelenideElement stateSelect = $("#react-select-3-input");
    private final SelenideElement citySelect = $("#react-select-4-input");
    private final SelenideElement submitBtn = $("#submit");

    @Step("open page")
    public StudentRegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    @Step("set name field")
    public StudentRegistrationFormPage setFirstName(String value) {
        firstNameField.setValue(value);
        return this;
    }

    @Step("set last name field")
    public StudentRegistrationFormPage setLastName(String lastName) {
        lastNameField.setValue(lastName);
        return this;
    }

    @Step("set email field")
    public StudentRegistrationFormPage setEmail(String email) {
        emailField.setValue(email);
        return this;
    }

    @Step("set gender field")
    public StudentRegistrationFormPage setGender(String gender) {
        genderRadioBtn.$(byText(gender)).click();
        return this;
    }

    @Step("set mobile field")
    public StudentRegistrationFormPage setMobile(String mobile) {
        mobileField.setValue(mobile);
        return this;
    }

    @Step("set date field")
    public StudentRegistrationFormPage setDate(String day, String month, String year) {
        new DataPickerComponent().setDate(day, month, year);
        return this;
    }

    @Step("set subject field")
    public StudentRegistrationFormPage setSubject(String subject) {
        subjectsField
                .setValue(subject)
                .pressEnter();
        return this;
    }

    @Step("set hobbies field")
    public StudentRegistrationFormPage setHobbies(String hobbies) {
        $(byText(String.valueOf(hobbies))).click();
        return this;
    }

    @Step("upload picture file")
    public StudentRegistrationFormPage uploadPicture(String filePath) {
        pictureUploadField.uploadFromClasspath(filePath);
        return this;
    }

    @Step("set address field")
    public StudentRegistrationFormPage setAddress(String address) {
        addressField.setValue(address);
        return this;
    }

    @Step("select state field")
    public StudentRegistrationFormPage selectState(String state) {
        stateSelect.setValue(String.valueOf(state))
                .pressEnter();
        return this;
    }

    @Step("select city field")
    public StudentRegistrationFormPage selectCity(String city) {
        citySelect.setValue(String.valueOf(city))
                .pressEnter();
        return this;
    }

    @Step("submit button field")
    public void submitBtnClick() {
        submitBtn
                .scrollIntoView(true)
                .scrollTo()
                .click();
    }

}
