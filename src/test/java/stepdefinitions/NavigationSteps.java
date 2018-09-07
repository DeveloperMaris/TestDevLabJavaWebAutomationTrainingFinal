package stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import general.TestContext;

public class NavigationSteps {

    private TestContext test;

    public NavigationSteps(TestContext testContext) {
        this.test = testContext;
    }

    @And("^I navigate to Home page$")
    public void iNavigateToHomePage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
