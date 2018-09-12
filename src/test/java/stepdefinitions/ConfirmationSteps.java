package stepdefinitions;

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
}
