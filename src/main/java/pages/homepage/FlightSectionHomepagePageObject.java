package pages.homepage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.flights.FlightListPageObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class FlightSectionHomepagePageObject {

    // --- Selectors ---

    private SelenideElement getFlightsOptionRadioBox(String option) {
        return $(By.xpath("//div[@class='pure-checkbox'][./label[contains(text(), '" + option + "')]]/div[contains(@class, 'iradio_square-grey')]"));
    }

    private SelenideElement getSelectedFlightOptionRadioBox() {
        return $(By.xpath("//div[@class='pure-checkbox']/div[contains(@class, 'checked')]/following-sibling::label"));
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

    private SelenideElement getFlightsDepartureAirportInput() {
        return $("#location_from_code");
    }

    private SelenideElement getFlightsArivalAirportField() {
        return $("#s2id_location_to > a");
    }

    private SelenideElement getFlightsArivalAirportInput() {
        return $("#location_to_code");
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

    public String getSelectedFlightOptionDataType() {
        return getSelectedFlightOptionRadioBox().getAttribute("data-type");
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
        getFlightsArivalAirportField().click();
        getFlightsAirportTextInput().sendKeys(airportName);
    }

    public String getFlightsDepartureAirportCode() {
        return getFlightAirportCode(getFlightsDepartureAirportInput().getValue());
    }

    public String getFlightsArrivalAirportCode() {
        return getFlightAirportCode(getFlightsArivalAirportInput().getValue());
    }

    public String getFlightsDepartureAirportName() {
        return getFlightAirportName(getFlightsDepartureAirportInput().getValue());
    }

    public String getFlightsArrivalAirportName() {
        return getFlightAirportName(getFlightsArivalAirportInput().getValue());
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

    private String getFlightAirportName(String airportInfo) {
        Pattern pattern = Pattern.compile("\"label\":\"(.*)\"}");

        if (!airportInfo.isEmpty()) {
            Matcher matcher = pattern.matcher(airportInfo);
            if (matcher.find()) {
                return matcher.group(1);
            }
        }

        return "";
    }

    private String getFlightAirportCode(String airportInfo) {
        Pattern pattern = Pattern.compile("\"code\":\"(.*)\",");

        if (!airportInfo.isEmpty()) {
            Matcher matcher = pattern.matcher(airportInfo);
            if (matcher.find()) {
                return matcher.group(1);
            }
        }

        return "";
    }

    // --- Validation Methods ---

    public void waitWhileFlightsAirportListIsLoading() {
        getFlightsAirportLoaderElement().waitUntil(Condition.not(Condition.visible), 5000);
    }

}
