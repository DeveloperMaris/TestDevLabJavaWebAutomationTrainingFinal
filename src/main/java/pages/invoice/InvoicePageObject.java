package pages.invoice;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class InvoicePageObject {

    // --- Selectors ---

    private SelenideElement getInvoiceTitle() {
        return $(By.xpath("//table[@id='invoiceTable']/descendant::div[contains(text(), 'Invoice')]"));
    }

    private SelenideElement getUnpaidTitle() {
        return $(By.xpath("//table[@id='invoiceTable']/descendant::div[contains(text(), 'Unpaid')]"));
    }

    // --- Methods ---



    // --- Validation Methods ---



}
