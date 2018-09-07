package stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.When;
import general.TestContext;

public class LoginSteps {

    private TestContext test;

    public LoginSteps(TestContext testContext) {
        this.test = testContext;
    }

    @When("^I login this account$")
    public void iLoginThisAccount() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
