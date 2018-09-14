package pages.flights;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.confirmation.ConfirmationPageObject;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;

public class FlightListPageObject {

    // --- Selectors ---

    private SelenideElement getFlightSearchFormElement() {
        return $("#body-section form[name='flightmanualSearch']");
    }

    private ElementsCollection getFlightList() {
        return $$("#load_data tr");
    }

    // --- Methods ---

    public ElementsCollection getFlightListElements() {
       return getFlightList();
    }

    public String getFlightPrice(SelenideElement flightElement) {
        String priceText = flightElement.findElementByCssSelector(".listing-price .strong").getText();
        return priceText.substring(0, priceText.length() - 1);
    }

    public ConfirmationPageObject selectFlight(SelenideElement flightElement) {
        flightElement.findElementByCssSelector("#bookbtn").click();
        return page(ConfirmationPageObject.class);
    }

    // --- Validation Methods ---

    public boolean isFlightSearchFormAvailable() {
        return getFlightSearchFormElement().isDisplayed();
    }

}
