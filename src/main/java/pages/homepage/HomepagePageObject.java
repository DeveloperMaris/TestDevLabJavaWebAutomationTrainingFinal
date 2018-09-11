package pages.homepage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.flights.FlightListPageObject;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class HomepagePageObject {

    // --- Selectors ---

    private SelenideElement getMainSection() {
        return $("#body-section .promo-section.jumbotron.hero-section");
    }

    private SelenideElement getSection() {
        return $("#body-section .promo-section.jumbotron.hero-section");
    }

    private SelenideElement getBookingMenu(String menuName) {
        // return $(By.xpath("//div[@id='body-section']/descendant::a[span[contains(lower-case(text()), '" + menuLink + "')]]"));
        // return $("div#body-section a[href*='" + menuLink + "' i]");
        return $(By.xpath("//div[@id='body-section']/descendant::a[span[contains(text(), '" + menuName + "')]]"));
    }

    private SelenideElement getFlightsOptionRadioBox(String option) {
        return $(By.xpath("//div[@class='pure-checkbox'][./label[contains(text(), '" + option + "')]]/div[contains(@class, 'iradio_square-grey')]"));
    }

    private SelenideElement getFlightsClassTicketSelect() {
        return $("select[name='cabinclass']");
    }

    private SelenideElement getFlightsAirportLoaderElement() {
        return $("#select2-drop .select2-searching");
    }

    private SelenideElement getFlightsDepartueAirportField() {
        return $("#s2id_location_from > a");
    }

    private SelenideElement getFlightsAraivalAirportField() {
        return $("#s2id_location_to > a");
    }

    private SelenideElement getFlightsAirportTextInput() {
        return $("#select2-drop .select2-input");
    }

    private SelenideElement getFlightsAirportFromList(String airportName) {
        return $(By.xpath("//div[@id='select2-drop']//ul[contains(@class, 'select2-result')]/li[.//*[contains(text(), '" + airportName + "')]]"));
    }

    private SelenideElement getFlightsDepartureDateInput() {
        return $("input[name='departure']");
    }

    private SelenideElement getFlightsArrivalDateInput() {
        return $("input[name='arrival']");
    }

    private SelenideElement getFlightsGuestsField() {
        return $("input[name='totalManualPassenger']");
    }

    private SelenideElement getFlightsGuestsModalPopupAdultSelect() {
        return $("select[name='madult']");
    }

    private SelenideElement getFlightsGuestsModalPopupChildSelect() {
        return $("select[name='mchildren']");
    }

    private SelenideElement getFlightsGuestsModalPopupInfantSelect() {
        return $("select[name='minfant']");
    }

    private SelenideElement getFlightsGuestsModalPopupDoneButton() {
        return $(".modal-footer #sumManualPassenger");
    }

    private SelenideElement getFlightsSearchButton() {
        return $("#flights button[type='submit']");
    }
    // --- Methods ---

    public void selectBookingMenu(String menuName) {
        // FIXME: Don't like this approach, but it works and is generic, while the Page will contain menus named with Capital first character.
        String formattedMenuName = menuName.substring(0, 1).toUpperCase() + menuName.substring(1).toLowerCase();
        getBookingMenu(formattedMenuName).click();
    }

    public void selectFlightsOption(String chosenOption) {
        getFlightsOptionRadioBox(chosenOption).click();
    }

    public void selectFlightsClassTicketRadioBox(String className) {
        getFlightsClassTicketSelect().selectOptionByValue(className);
    }

    public void enterFlightsDepartureAirport(String airportName) {
        getFlightsDepartueAirportField().click();
        getFlightsAirportTextInput().sendKeys(airportName);
    }

    public void enterFlightsArrivalAirport(String airportName) {
        getFlightsAraivalAirportField().click();
        getFlightsAirportTextInput().sendKeys(airportName);
    }

    public void selectFlightsAirportFromList(String airportName) {
        getFlightsAirportFromList(airportName).click();
    }

    public void enterFlightsDepartureDate(String date) {
        getFlightsDepartureDateInput().sendKeys(date);
    }

    public void enterFlightsArrivalDate(String date) {
        getFlightsArrivalDateInput().sendKeys(date);
    }

    public void selectFlightsGuestsField() {
        getFlightsGuestsField().click();
    }

    public void setFlightsGuestsModalPopupAdultCount(String value) {
        getFlightsGuestsModalPopupAdultSelect().selectOptionByValue(value);
    }

    public void setFlightsGuestsModalPopupChildCount(String value) {
        getFlightsGuestsModalPopupChildSelect().selectOptionByValue(value);
    }

    public void setFlightsGuestsModalPopupInfantCount(String value) {
        getFlightsGuestsModalPopupInfantSelect().selectOptionByValue(value);
    }

    public void selectFlightsGuestsModalPopupDoneButton() {
        getFlightsGuestsModalPopupDoneButton().click();
    }

    public FlightListPageObject selectFlightsSearchButton() {
        getFlightsSearchButton().click();
        return page(FlightListPageObject.class);
    }

    // --- Validation Methods ---

    public boolean isMainSectionVisible() {
        return getMainSection().isDisplayed();
    }

    public void waitWhileFlightsAirportListIsLoading() {
        getFlightsAirportLoaderElement().waitUntil(Condition.not(Condition.visible), 5000);
    }

}
