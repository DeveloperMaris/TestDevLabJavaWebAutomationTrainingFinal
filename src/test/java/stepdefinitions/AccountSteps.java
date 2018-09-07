package stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import general.TestContext;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountSteps {

    private TestContext test;

    public AccountSteps(TestContext testContext) {
        this.test = testContext;
    }

    @Given("^I have an existing account$")
    public void iHaveAnExistingAccount() {

    }

}
