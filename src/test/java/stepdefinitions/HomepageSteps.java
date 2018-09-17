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
        test.getHomepage().flightSection.selectFlightsOption(test.getFlight().getTripType());
        test.getFlight().setTripDataType(test.getHomepage().flightSection.getSelectedFlightOptionDataType());
    }

    @And("^I set ([^\\”]*) class tickets$")
    public void iSetClassTickets(String className) {
        test.getFlight().setClassType(className.toLowerCase());
        test.getHomepage().flightSection.selectFlightsClassTicketRadioBox(test.getFlight().getClassType());
    }

    @And("^I set ([^\\”]*) as departure airport$")
    public void iSetDepartureAirport(String airportName) {
        test.getHomepage().flightSection.enterFlightsDepartureAirport(airportName);
        test.getHomepage().flightSection.waitWhileFlightsAirportListIsLoading();
        test.getHomepage().flightSection.selectFlightsAirportFromList(airportName);
        assertThat(test.getHomepage().flightSection.getFlightsDepartureAirportCode()).isNotEmpty();
        test.getFlight().setLocationFromCode(test.getHomepage().flightSection.getFlightsDepartureAirportCode());
        test.getFlight().setLocationFrom(test.getHomepage().flightSection.getFlightsDepartureAirportName());
    }

    @And("^I set ([^\\”]*) as arrival airport$")
    public void iSetArrivalAirport(String airportName) {
        test.getHomepage().flightSection.enterFlightsArrivalAirport(airportName);
        test.getHomepage().flightSection.waitWhileFlightsAirportListIsLoading();
        test.getHomepage().flightSection.selectFlightsAirportFromList(airportName);
        assertThat(test.getHomepage().flightSection.getFlightsArrivalAirportCode()).isNotEmpty();
        test.getFlight().setLocationToCode(test.getHomepage().flightSection.getFlightsArrivalAirportCode());
        test.getFlight().setLocationTo(test.getHomepage().flightSection.getFlightsArrivalAirportName());
    }

    @And("^I set (\\w+).(\\w+).(\\w+) as departure date$")
    public void iSetAsDepartureDate(String day, String month, String year) {
        test.getFlight().setDepartureDate(year + "-" + month + "-" + day);
        test.getHomepage().flightSection.enterFlightsDepartureDate(test.getFlight().getDepartureDate());
    }

    @And("^I set (\\w+).(\\w+).(\\w+) as return date$")
    public void iSetAsReturnDate(String day, String month, String year) {
        test.getFlight().setArrivalDate(year + "-" + month + "-" + day);
        test.getHomepage().flightSection.enterFlightsArrivalDate(test.getFlight().getArrivalDate());
    }

    @And("^I select guests field$")
    public void iSelectGuestsField() {
        test.getHomepage().flightSection.selectFlightsGuestsField();
    }


    @And("^I set (\\w+) adults$")
    public void iSetAdults(String count) {
        test.getFlight().setAdultCount(count);

        test.getHomepage().flightSection.setFlightsGuestsModalPopupAdultCount(test.getFlight().getAdultCount());
    }

    @And("^I set (\\w+) children$")
    public void iSetChildren(String count) {
        test.getFlight().setChildCount(count);

        test.getHomepage().flightSection.setFlightsGuestsModalPopupChildCount(test.getFlight().getChildCount());
    }

    @And("^I set (\\w+) infant$")
    public void iSetInfant(String count) {
        test.getFlight().setInfantCount(count);

        test.getHomepage().flightSection.setFlightsGuestsModalPopupInfantCount(test.getFlight().getInfantCount());
    }

    @And("^I click on Done button in guests popup$")
    public void iClickOnDoneButtonInGuestsPopup() {
        test.getHomepage().flightSection.selectFlightsGuestsModalPopupDoneButton();
    }

    @And("^I search for a flight$")
    public FlightListPageObject iSearchForAFlight() {
        test.getHomepage().flightSection.selectFlightsSearchButton();
        return page(FlightListPageObject.class);
    }
}
