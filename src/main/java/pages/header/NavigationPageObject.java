package pages.header;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class NavigationPageObject {

    // --- Selectors ---

    private SelenideElement getLoadingIndicator() {
        return $("#preloader");
    }

    private SelenideElement getHomeButton() {
        return $(By.xpath("//nav/descendant::a[contains(text(), 'Home')]"));
    }

    private SelenideElement getMyAccountButton() {
        return $(By.xpath("//nav/descendant::li[@id = 'li_myaccount']/a"));
    }

    private SelenideElement getSignUpButton() {
        return $(By.xpath("//nav/descendant::a[contains(text(), 'Sign Up')]"));
    }

    private SelenideElement getLoginButton() {
        return $(By.xpath("//nav/descendant::a[contains(text(), 'Login')]"));
    }

    private SelenideElement getLogoutButton() {
        return $(By.xpath("//nav/descendant::a[contains(text(), 'Logout')]"));
    }

    private SelenideElement getUserAccountButton(String username) {
        return $(By.xpath("//nav/descendant::a[contains(text(), '" + username + "')]"));
    }

    // --- Methods ---

    public void selectMyAccountButton() {
        getMyAccountButton().click();
    }

    public void selectUserAccountButton(String name) {
        getUserAccountButton(name).click();
    }

    public void selectSignUpButton() {
        getSignUpButton().click();
    }

    public void selectLoginButton() {
        getLoginButton().click();
    }

    public void selectLogoutButton() {
        getLogoutButton().click();
    }

    public void selectHomeButton() {
        getHomeButton().click();
    }

    // --- Validation Methods ---

    public void waitUntilPageLoadingIsFinished() {
        getLoadingIndicator().waitUntil(Condition.attribute("style", "display: none;"), 5000);
    }

}
