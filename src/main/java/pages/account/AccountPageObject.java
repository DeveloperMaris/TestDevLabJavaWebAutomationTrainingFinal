package pages.account;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.CollectionElement;
import org.openqa.selenium.By;
import pages.invoice.InvoicePageObject;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;

public class AccountPageObject {

    // --- Selectors ---

    private SelenideElement getAccountDataField() {
        return $(".RTL h3");
    }

    private ElementsCollection getInvoiceButtons() {
        return $$(By.xpath("//a[contains(text(), 'Invoice')]"));
    }

    // --- Methods ---

    public String getAccountName() {
        return getAccountDataField().getText().split(" ")[1];
    }

    public String getAccountLastname() {
        return getAccountDataField().getText().split(" ")[2];
    }

    // Warning: Web page opens a new tab after this step
    public InvoicePageObject selectNewestInvoiceButton() {
        getInvoiceButtons().first().click();
        return page(InvoicePageObject.class);
    }

    // --- Validation Methods ---

    public boolean isAccountDataVisible() {
        return getAccountDataField().isDisplayed();
    }

    public void waitUntilAccountDataLoadingIsFinished() {
        getAccountDataField().waitUntil(Condition.visible, 5000);
    }
}
