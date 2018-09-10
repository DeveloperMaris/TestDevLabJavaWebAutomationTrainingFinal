package stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import general.TestContext;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps {

    private TestContext test;

    public LoginSteps(TestContext testContext) {
        this.test = testContext;
    }

    @And("^I am in Login page$")
    public void iAmInLoginPage() {
        test.getNavigation().waitUntilPageLoadingIsFinished();

        assertThat(test.getLoginPage().isLoginFormVisible()).isTrue();
        test.getLoginPage().waitUntilLoginButtonIsVisible();
    }

    @When("^I login into existing account$")
    public void iLoginIntoExistingAccount() {
        test.getLoginPage().enterEmail(test.getUser().getEmailAddress());
        test.getLoginPage().enterPassword(test.getUser().getPassword());

        test.getLoginPage().selectLoginButton();

    }
}
