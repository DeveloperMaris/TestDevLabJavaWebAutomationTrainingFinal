package pages.confirmation;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
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

    private SelenideElement getFirstNameField() {
        return $(By.xpath("//label[contains(text(), 'First Name')]/following::input[1]"));
    }

    private SelenideElement getLastNameField() {
        return $(By.xpath("//label[contains(text(), 'Last Name')]/following::input[1]"));
    }

    private SelenideElement getEmailField() {
        return $(By.xpath("//label[contains(text(), 'Email')]/following::input[1]"));
    }

    private SelenideElement getAdultCountElement() {
        return $(By.xpath("//li[./b[contains(text(),'Adults')]]/span"));
    }

    private SelenideElement getChildCountElement() {
        return $(By.xpath("//li[./b[contains(text(),'Childs')]]/span"));
    }

    private SelenideElement getInfantsCountElement() {
        return $(By.xpath("//li[./b[contains(text(),'Infacts')]]/span"));
    }

    private SelenideElement getPriceElement() {
        return $(By.xpath("//tr[.//td[@class='booking-deposit-font']][2]//td[@class='text-right']"));
    }

    // --- Methods ---

    public String getFirstName() {
        return getFirstNameField().val();
    }

    public String getLastName() {
        return getLastNameField().val();
    }

    public String getEmail() {
        return getEmailField().val();
    }

    public String getAdultCount() {
        return getAdultCountElement().text();
    }

    public String getChildCount() {
        return getChildCountElement().text();
    }

    public String getInfantCount() {
        return getInfantsCountElement().text();
    }

    public String getPrice() {
        String priceText = getPriceElement().getText().substring(4);

        return priceText.substring(0, priceText.length() - 1);
    }

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
