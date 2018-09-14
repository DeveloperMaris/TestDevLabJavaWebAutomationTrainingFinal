package stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import general.TestContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfirmationSteps {

    private TestContext test;

    public ConfirmationSteps(TestContext testContext) {
        this.test = testContext;
    }

    @And("^I am in Confirmation page$")
    public void iAmInConfirmationPage() {
        test.getNavigation().waitUntilPageLoadingIsFinished();

        assertThat(test.getConfirmationPage().isBookingSummaryAvailable()).isTrue();
        assertThat(test.getConfirmationPage().isConfirmationButtonVisible()).isTrue();
    }

    @And("^I confirm the booking$")
    public void iConfirmTheBooking() {
        test.getConfirmationPage().selectConfirmationButtonAndWait();
    }

    @And("^Flight confirmation data are correct$")
    public void flightConfirmationDataAreCorrect() {
        personalDataAreCorrect();
        flightBookingDataAreCorrect();
    }

    @And("^Personal data are correct$")
    public void personalDataAreCorrect() {
        assertThat(test.getConfirmationPage().getFirstName()).isEqualTo(test.getUser().getFirstName());
        assertThat(test.getConfirmationPage().getLastName()).isEqualTo(test.getUser().getLastName());
        assertThat(test.getConfirmationPage().getEmail()).isEqualTo(test.getUser().getEmailAddress());
    }

    @And("^Flight booking data are correct$")
    public void flightBookingDataAreCorrect() {
        assertThat(test.getConfirmationPage().getAdultCount()).isEqualTo(test.getFlight().getAdultCount());
        assertThat(test.getConfirmationPage().getChildCount()).isEqualTo(test.getFlight().getChildCount());
        assertThat(test.getConfirmationPage().getInfantCount()).isEqualTo(test.getFlight().getInfantCount());
        // Can not compare prices, because they may be different.
        // assertThat(test.getConfirmationPage().getPrice()).isEqualTo(test.getFlight().getFlightPrice());
    }
}
