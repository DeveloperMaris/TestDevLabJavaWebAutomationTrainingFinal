package pages.account;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AccountPageObject {

    // --- Selectors ---

    private SelenideElement getAccountDataField() {
        return $(".RTL h3");
    }

    // --- Methods ---

    public String getAccountName() {
        return getAccountDataField().getText().split(" ")[1];
    }

    public String getAccountLastname() {
        return getAccountDataField().getText().split(" ")[2];
    }

    // --- Validation Methods ---

    public boolean isAccountDataVisible() {
        return getAccountDataField().isDisplayed();
    }

    public void waitUntilAccountDataLoadingIsFinished() {
        getAccountDataField().waitUntil(Condition.visible, 5000);
    }
}
