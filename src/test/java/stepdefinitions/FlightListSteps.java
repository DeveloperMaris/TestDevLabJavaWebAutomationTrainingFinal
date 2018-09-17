package stepdefinitions;

import cucumber.api.java.en.And;
import general.TestContext;

import static org.assertj.core.api.Assertions.assertThat;

public class FlightListSteps {

    private TestContext test;

    public FlightListSteps(TestContext testContext) {
        this.test = testContext;
    }

    @And("^I am in Flight List page$")
    public void iAmInFlightListPage() {
        test.getNavigation().waitUntilPageLoadingIsFinished();

        assertThat(test.getFlightListPage().isFlightSearchFormAvailable()).isTrue();
    }

    @And("^I book the first flight offer available$")
    public void iBookTheFirstFlightOfferAvailable() {
        assertThat(test.getFlightListPage().getFlightListElements().size()).isGreaterThanOrEqualTo(1);

        test.getFlight().setFlightPrice(test.getFlightListPage().getFlightPrice(test.getFlightListPage().getFlightListElements().first()));

        String[] firstFlightCodes = test.getFlightListPage().getFirstFlightCodes(test.getFlightListPage().getFlightListElements().first());

        assertThat(firstFlightCodes[0]).isEqualTo(test.getFlight().getLocationFromCode());
        assertThat(firstFlightCodes[1]).isEqualTo(test.getFlight().getLocationToCode());

        String[] secondFlightCodes = test.getFlightListPage().getSecondFlightCodes(test.getFlightListPage().getFlightListElements().first());

        assertThat(secondFlightCodes[0]).isEqualTo(test.getFlight().getLocationToCode());
        assertThat(secondFlightCodes[1]).isEqualTo(test.getFlight().getLocationFromCode());

        test.getFlightListPage().selectFlight(test.getFlightListPage().getFlightListElements().first());
    }
}
