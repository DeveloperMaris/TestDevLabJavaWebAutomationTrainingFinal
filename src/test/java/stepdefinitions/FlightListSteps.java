package stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import general.TestContext;

import static org.assertj.core.api.Assertions.assertThat;

public class FlightListSteps {

    private TestContext test;

    public FlightListSteps(TestContext testContext) {
        this.test = testContext;
    }

    @And("^I am in Flight List page$")
    public void iAmInFligthListPage() {
        test.getNavigation().waitUntilPageLoadingIsFinished();

        assertThat(test.getFlightListPage().isFlightSearchFormAvailable()).isTrue();
    }

    @And("^I book the first flight offer available$")
    public void iBookTheFirstFlightOfferAvailable() {
        assertThat(test.getFlightListPage().getFlightListElements().size()).isGreaterThanOrEqualTo(1);
        test.getFlightListPage().selectFlight(test.getFlightListPage().getFlightListElements().first());
    }
}
