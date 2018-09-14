package stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import general.TestContext;

import static com.codeborne.selenide.Selenide.switchTo;
import static org.assertj.core.api.Assertions.assertThat;

public class InvoiceSteps {

    private TestContext test;

    public InvoiceSteps(TestContext testContext) {
        this.test = testContext;
    }

    @And("^I am in Invoice page$")
    public void iAmInInvoicePage() {
        test.getNavigation().waitUntilPageLoadingIsFinished();
        test.getInvoicePage().waitUntilInvoiceTitleIsDisplayed();

        assertThat(test.getInvoicePage().isInvoiceTitleVisible()).isTrue();
    }

    @Then("^new booking contains correct flight details$")
    public void newBookingContainsCorrectFlightDetails() {
        assertThat(test.getInvoicePage().getUserName()).isEqualTo(test.getUser().getFirstName().toUpperCase());
        assertThat(test.getInvoicePage().getUserLastname()).isEqualTo(test.getUser().getLastName().toUpperCase());
        assertThat(test.getInvoicePage().getUserPhoneNumber()).isEqualTo(test.getUser().getMobileNumber());

        assertThat(test.getInvoicePage().getFlightDepartTypeAndClass()).contains(test.getFlight().getClassType().toLowerCase());
        assertThat(test.getInvoicePage().getFlightDepartTypeAndClass()).contains(test.getFlight().getTripDataType().toLowerCase());

        assertThat(test.getInvoicePage().getFlightReturnTypeAndClass()).contains(test.getFlight().getClassType().toLowerCase());
        assertThat(test.getInvoicePage().getFlightReturnTypeAndClass()).contains(test.getFlight().getTripDataType().toLowerCase());
    }

    @And("^I switch to Invoice page tab$")
    public void iSwitchToInvoicePageTab() {
        switchTo().window(test.getInvoicePage().getPageTitle());
    }
}
