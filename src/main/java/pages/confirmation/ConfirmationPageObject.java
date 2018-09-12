package pages.confirmation;

import com.codeborne.selenide.Condition;
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

    private SelenideElement getPleaseWaitElement() {
        return $("#waiting");
    }

    private SelenideElement getRotationLoader() {
        return $("#rotatingDiv");
    }

    // --- Methods ---

    public InvoicePageObject selectConfirmationButtonAndWait() {
        getConfirmationButton().click();
        waitUntilPleaseWaitLabelIsGone();
        waitUntilRotatingLoaderIsGone();
        return page(InvoicePageObject.class);
    }

    // --- Validation Methods ---

    public boolean isBookingSummaryAvailable() {
        return getBookingSummaryElement().isDisplayed();
    }

    public boolean isConfirmationButtonVisible() {
        return getConfirmationButton().isDisplayed();
    }

    public void waitUntilPleaseWaitLabelIsGone() {
        getPleaseWaitElement().waitUntil(Condition.not(Condition.visible), 5000);
    }

    public void waitUntilRotatingLoaderIsGone() {
        getRotationLoader().waitUntil(Condition.not(Condition.visible), 5000);
    }

}
