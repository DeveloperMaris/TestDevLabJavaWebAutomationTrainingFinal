package stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import general.TestContext;

public class InvoiceSteps {

    private TestContext test;

    public InvoiceSteps(TestContext testContext) {
        this.test = testContext;
    }

    @And("^I am in Invoice page$")
    public void iAmInInvoicePage() {
        test.getNavigation().waitUntilPageLoadingIsFinished();


    }

    @Then("^new booking contains correct flight details$")
    public void newBookingContainsCorrectFlightDetails() {

    }

}
