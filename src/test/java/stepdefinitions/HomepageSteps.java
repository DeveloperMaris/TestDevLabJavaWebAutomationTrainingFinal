package stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import general.TestContext;

import static org.assertj.core.api.Assertions.assertThat;

public class HomepageSteps {

    private TestContext test;

    public HomepageSteps(TestContext testContext) {
        this.test = testContext;
    }

    @Given("^I am in Home page$")
    public void iAmInHomePage() {
        test.getNavigation().waitUntilPageLoadingIsFinished();

        assertThat(test.getHomepage().isMainSectionVisible()).isTrue();
    }

    @And("^I select ([^\\”]*) menu in booking section$")
    public void iSelectMenuInBookingSection(String menu) {
        test.getHomepage().selectBookingMenu(menu);
    }

    @And("^I select ([^\\”]*) flight option$")
    public void iSelectFlightOption(String flightOption) {
        test.getHomepage().selectFlightOption(flightOption);
    }

    @And("^I set ([^\\”]*) class tickets$")
    public void iSetClassTickets(String className) {
        test.getHomepage().selectClassTicketRadioBox(className.toLowerCase());
    }
}
