package stepdefinitions;

import cucumber.api.java.en.And;
import general.TestContext;

import static org.assertj.core.api.Assertions.assertThat;

public class SignUpSteps {

    private TestContext test;

    public SignUpSteps(TestContext testContext) {
        this.test = testContext;
    }

    @And("^I am in Sign Up page$")
    public void iAmInSignUpPage() {
        test.getNavigation().waitUntilPageLoadingIsFinished();

        assertThat(test.getSignUpPage().isLoginContainerVisible()).isTrue();
        assertThat(test.getSignUpPage().isSignUpButtonVisible()).isTrue();
    }

    @And("^I create a new account in Sign Up page$")
    public void iCreateNewAccount() {
        iEnterFirstName();
        iEnterLastName();
        iEnterMobileNumber();
        iEnterEmailAddress();
        iEnterPassword();
        iConfirmPassword();
        iSelectSignUpButtonInSignUpPage();

        test.getSignUpPage().waitUntilSignUpFormLoaderIsGone();
    }

    @And("^I enter First name in Sign Up page$")
    public void iEnterFirstName() {
        test.getSignUpPage().enterFirstName(test.getUser().getFirstName());
    }

    @And("^I enter Last name in Sign Up page$")
    public void iEnterLastName() {
        test.getSignUpPage().enterLastName(test.getUser().getLastName());
    }

    @And("^I enter Mobile number in Sign Up page$")
    public void iEnterMobileNumber() {
        test.getSignUpPage().enterMobileNumber(test.getUser().getMobileNumber());
    }

    @And("^I enter Email address in Sign Up page$")
    public void iEnterEmailAddress() {
        test.getSignUpPage().enterEmail(test.getUser().getEmailAddress());
    }

    @And("^I enter Password in Sign Up page$")
    public void iEnterPassword() {
        test.getSignUpPage().enterPassword(test.getUser().getPassword());
    }

    @And("^I confirm Password in Sign Up page$")
    public void iConfirmPassword() {
        test.getSignUpPage().enterConfirmationPassword(test.getUser().getPassword());
    }

    @And("^I select Sign up button in Sign up page$")
    public void iSelectSignUpButtonInSignUpPage() {
        test.getSignUpPage().selectSignUpButton();
    }

}
