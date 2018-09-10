package pages.login;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.account.AccountPageObject;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPageObject {

    // --- Selectors ---

    private SelenideElement getLoginForm() {
        return $("#loginfrm");
    }

    private SelenideElement getEmailField() {
        return $("input[name='username']");
    }

    private SelenideElement getPasswordField() {
        return $("input[name='password']");
    }

    private SelenideElement getLoginButton() {
        return $("#loginfrm .loginbtn");
    }

    // --- Methods ---

    public void enterEmail(String email) {
        getEmailField().sendKeys(email);
    }

    public void enterPassword(String password) {
        getPasswordField().sendKeys(password);
    }

    public AccountPageObject selectLoginButton() {
        getLoginButton().click();
        return page(AccountPageObject.class);
    }

    // --- Validation Methods ---

    public boolean isLoginFormVisible() {
        return getLoginForm().isDisplayed();
    }

    public void waitUntilLoginButtonIsVisible() {
        getLoginButton().waitUntil(Condition.visible, 5000);
    }

}
