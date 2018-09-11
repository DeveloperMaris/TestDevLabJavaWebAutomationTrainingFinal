package pages.confirmation;

import com.codeborne.selenide.SelenideElement;
import pages.invoice.InvoicePageObject;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ConfirmationPageObject {

    // --- Selectors ---

    private SelenideElement getBookingSummaryElement() {
        return $("div.summary");
    }

    private SelenideElement getConfirmationButton() {
        return $("#body-section button[type='submit']");
    }

    // --- Methods ---

    public InvoicePageObject selectConfirmationButton() {
        getConfirmationButton().click();
        return page(InvoicePageObject.class);
    }

    // --- Validation Methods ---

    public boolean isBookingSummaryAvailable() {
        return getBookingSummaryElement().isDisplayed();
    }

}
