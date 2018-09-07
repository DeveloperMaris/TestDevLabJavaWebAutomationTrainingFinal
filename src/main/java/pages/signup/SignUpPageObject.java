package pages.signup;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.account.AccountPageObject;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;

public class SignUpPageObject {

    // --- Selectors ---

    private SelenideElement getFirstNameField() {
        return $("input[name='firstname']");
    }

    private SelenideElement getLastNameField() {
        return $("input[name='lastname']");
    }

    private SelenideElement getMobileNumberField() {
        return $("input[name='phone']");
    }

    private SelenideElement getEmailField() {
        return $("input[name='email']");
    }

    private SelenideElement getPasswordField() {
        return $("input[name='password']");
    }

    private SelenideElement getConfirmPasswordField() {
        return $("input[name='confirmpassword']");
    }

    private SelenideElement getSignUpButton() {
        return $("#headersignupform .signupbtn");
    }

    private SelenideElement getFormTitle() {
        return $(".panel-heading");
    }

    private SelenideElement getErrorField() {
        return $(".alert-danger");
    }

    private ElementsCollection getErrorList() {
        return $$(".alert-danger p");
    }

    private SelenideElement getRotationLoader() {
        return $("#rotatingDiv");
    }

    // --- Methods ---

    public void enterFirstName(String firstName) {
        getFirstNameField().sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        getLastNameField().sendKeys(lastName);
    }

    public void enterMobileNumber(String number) {
        getMobileNumberField().sendKeys(number);
    }

    public void enterEmail(String email) {
        getEmailField().sendKeys(email);
    }

    public void enterPassword(String password) {
        getPasswordField().sendKeys(password);
    }

    public void enterConfirmationPassword(String password) {
        getConfirmPasswordField().sendKeys(password);
    }

    public AccountPageObject selectSignUpButton() {
        getSignUpButton().click();
        return page(AccountPageObject.class);
    }

    // --- Validation Methods ---

    public void waitUntilSignUpFormIsGone() {
        getRotationLoader().waitUntil(Condition.not(Condition.visible), 5000);
    }

}
