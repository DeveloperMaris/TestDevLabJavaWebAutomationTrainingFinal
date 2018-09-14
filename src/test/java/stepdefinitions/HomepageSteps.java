package stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import general.TestContext;
import pages.flights.FlightListPageObject;

import static com.codeborne.selenide.Selenide.page;
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
        test.getFlight().setTripType(flightOption);
        test.getHomepage().selectFlightsOption(test.getFlight().getTripType());
        test.getFlight().setTripDataType(test.getHomepage().getSelectedFlightOptionDataType());
    }

    @And("^I set ([^\\”]*) class tickets$")
    public void iSetClassTickets(String className) {
        test.getFlight().setClassType(className.toLowerCase());
        test.getHomepage().selectFlightsClassTicketRadioBox(test.getFlight().getClassType());
    }

    @And("^I set ([^\\”]*) as departure airport$")
    public void iSetDepartureAirport(String airportName) {
        test.getFlight().setLocationFrom(airportName);
        test.getHomepage().enterFlightsDepartureAirport(test.getFlight().getLocationFrom());
        test.getHomepage().waitWhileFlightsAirportListIsLoading();
        test.getHomepage().selectFlightsAirportFromList(test.getFlight().getLocationFrom());
    }

    @And("^I set ([^\\”]*) as arrival airport$")
    public void iSetArrivalAirport(String airportName) {
        test.getFlight().setLocationTo(airportName);
        test.getHomepage().enterFlightsArrivalAirport(test.getFlight().getLocationTo());
        test.getHomepage().waitWhileFlightsAirportListIsLoading();
        test.getHomepage().selectFlightsAirportFromList(test.getFlight().getLocationTo());
    }

    @And("^I set (\\w+).(\\w+).(\\w+) as departure date$")
    public void iSetAsDepartureDate(String day, String month, String year) {
        test.getFlight().setDepartureDate(year + "-" + month + "-" + day);
        test.getHomepage().enterFlightsDepartureDate(test.getFlight().getDepartureDate());
    }

    @And("^I set (\\w+).(\\w+).(\\w+) as return date$")
    public void iSetAsReturnDate(String day, String month, String year) {
        test.getFlight().setArrivalDate(year + "-" + month + "-" + day);
        test.getHomepage().enterFlightsArrivalDate(test.getFlight().getArrivalDate());
    }

    @And("^I select guests field$")
    public void iSelectGuestsField() {
        test.getHomepage().selectFlightsGuestsField();
    }


    @And("^I set (\\w+) adults$")
    public void iSetAdults(String count) {
        test.getFlight().setAdultCount(count);

        test.getHomepage().setFlightsGuestsModalPopupAdultCount(test.getFlight().getAdultCount());
    }

    @And("^I set (\\w+) children$")
    public void iSetChildren(String count) {
        test.getFlight().setChildCount(count);

        test.getHomepage().setFlightsGuestsModalPopupChildCount(test.getFlight().getChildCount());
    }

    @And("^I set (\\w+) infant$")
    public void iSetInfant(String count) {
        test.getFlight().setInfantCount(count);

        test.getHomepage().setFlightsGuestsModalPopupInfantCount(test.getFlight().getInfantCount());
    }

    @And("^I click on Done button in guests popup$")
    public void iClickOnDoneButtonInGuestsPopup() {
        test.getHomepage().selectFlightsGuestsModalPopupDoneButton();
    }

    @And("^I search for a flight$")
    public FlightListPageObject iSearchForAFlight() {
        test.getHomepage().selectFlightsSearchButton();
        return page(FlightListPageObject.class);
    }
}
