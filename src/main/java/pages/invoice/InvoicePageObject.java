package pages.invoice;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class InvoicePageObject {

    // --- Selectors ---

    private SelenideElement getInvoiceTitle() {
        return $(By.xpath("//table[@id='invoiceTable']/descendant::div[contains(text(), 'Invoice')]"));
    }

    private SelenideElement getInvoiceStatusElement() {
        return $(By.xpath("//table[@id='invoiceTable']/descendant::tr[1]//div"));
    }

    private SelenideElement getFlightDepartTypeAndClassElement() {
        return $(By.xpath("(//table[@id='invoiceTable']//table[@align='center']//td//h5[contains(text(), 'Type')])[1]"));
    }

    private SelenideElement getFlightReturnTypeAndClassElement() {
        return $(By.xpath("(//table[@id='invoiceTable']//table[@align='center']//td//h5[contains(text(), 'Type')])[2]"));
    }

    private SelenideElement getInvoiceUserNameAndLastnameElement() {
        return $(By.xpath("//table[@id='invoiceTable']//td[./div[contains(text(), 'Customer Details')]]//div[2]"));
    }

    private SelenideElement getInvoiceUserPhoneNumberElement() {
        return $(By.xpath("//table[@id='invoiceTable']//td[./div[contains(text(), 'Customer Details')]]//div[4]"));
    }

    private SelenideElement getDepartFromFlightAirlineCodeElement() {
        return $(By.xpath("//table[@id='invoiceTable']/tbody/tr[3]/descendant::tr[./td/h5/strong[contains(text(), 'Date')]][1]/following-sibling::tr[1]/td[2]"));
    }

    private SelenideElement getDepartFromFlightAirlineNameElement() {
        return $(By.xpath("//table[@id='invoiceTable']/tbody/tr[3]/descendant::tr[./td/h5/strong[contains(text(), 'Date')]][1]/following-sibling::tr[1]/td[3]"));
    }

    private SelenideElement getDepartToFlightAirlineCodeElement() {
        return $(By.xpath("//table[@id='invoiceTable']/tbody/tr[3]/descendant::tr[./td/h5/strong[contains(text(), 'Date')]][1]/following-sibling::tr[2]/td[2]"));
    }

    private SelenideElement getDepartToFlightAirlineNameElement() {
        return $(By.xpath("//table[@id='invoiceTable']/tbody/tr[3]/descendant::tr[./td/h5/strong[contains(text(), 'Date')]][1]/following-sibling::tr[2]/td[3]"));
    }

    private SelenideElement getArrivalFromFlightAirlineCodeElement() {
        return $(By.xpath("//table[@id='invoiceTable']/tbody/tr[3]/descendant::tr[./td/h5/strong[contains(text(), 'Date')]][2]/following-sibling::tr[1]/td[2]"));
    }

    private SelenideElement getArrivalFromFlightAirlineNameElement() {
        return $(By.xpath("//table[@id='invoiceTable']/tbody/tr[3]/descendant::tr[./td/h5/strong[contains(text(), 'Date')]][2]/following-sibling::tr[1]/td[3]"));
    }

    private SelenideElement getArrivalToFlightAirlineCodeElement() {
        return $(By.xpath("//table[@id='invoiceTable']/tbody/tr[3]/descendant::tr[./td/h5/strong[contains(text(), 'Date')]][2]/following-sibling::tr[2]/td[2]"));
    }

    private SelenideElement getArrivalToFlightAirlineNameElement() {
        return $(By.xpath("//table[@id='invoiceTable']/tbody/tr[3]/descendant::tr[./td/h5/strong[contains(text(), 'Date')]][2]/following-sibling::tr[2]/td[3]"));
    }

    // --- Methods ---

    public String getPageTitle() {
        return "Invoice";
    }

    public String getInvoiceStatus() {
        return getInvoiceStatusElement().getText();
    }

    public String getFlightDepartTypeAndClass() {
        return getFlightDepartTypeAndClassElement().getText();
    }

    public String getFlightReturnTypeAndClass() {
        return getFlightReturnTypeAndClassElement().getText();
    }

    public String getUserName() {
        return getInvoiceUserNameAndLastnameElement().getText().split(" ")[0];
    }

    public String getUserLastname() {
        return getInvoiceUserNameAndLastnameElement().getText().split(" ")[1];
    }

    public String getUserPhoneNumber() {
        return getInvoiceUserPhoneNumberElement().getText();
    }

    public String getDepartFromFlightAirlineCode() {
        return getDepartFromFlightAirlineCodeElement().getText();
    }

    public String getDepartFromFlightAirlineName() {
        return getDepartFromFlightAirlineNameElement().getText();
    }

    public String getDepartToFlightAirlineCode() {
        return getDepartToFlightAirlineCodeElement().getText();
    }

    public String getDepartToFlightAirlineName() {
        return getDepartToFlightAirlineNameElement().getText();
    }

    public String getArrivalFromFlightAirlineCode() {
        return getArrivalFromFlightAirlineCodeElement().getText();
    }

    public String getArrivalFromFlightAirlineName() {
        return getArrivalFromFlightAirlineNameElement().getText();
    }

    public String getArrivalToFlightAirlineCode() {
        return getArrivalToFlightAirlineCodeElement().getText();
    }

    public String getArrivalToFlightAirlineName() {
        return getArrivalToFlightAirlineNameElement().getText();
    }

    // --- Validation Methods ---

    public void waitUntilInvoiceTitleIsDisplayed() {
        getInvoiceTitle().waitUntil(Condition.visible, 5000);
    }

    public boolean isInvoiceTitleVisible() {
        return getInvoiceTitle().isDisplayed();
    }


}
