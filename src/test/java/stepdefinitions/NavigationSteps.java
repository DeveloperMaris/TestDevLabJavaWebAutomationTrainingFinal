package stepdefinitions;

import cucumber.api.java.en.And;
import general.TestContext;

public class NavigationSteps {

    private TestContext test;

    public NavigationSteps(TestContext testContext) {
        this.test = testContext;
    }

    @And("^I select My Account button in Navigation bar$")
    public void iSelectMyAccountButtonInNavigationBar() {
        test.getNavigation().selectMyAccountButton();
    }

    @And("^I select Sign Up button in Navigation bar$")
    public void iSelectSignUpButtonInNavigationBar() {
        test.getNavigation().selectSignUpButton();
    }

    @And("^I select Login button in Navigation bar$")
    public void iSelectLoginButtonInNavigationBar() {
        test.getNavigation().selectLoginButton();
    }

    @And("^I select User Account button in Navigation bar$")
    public void iSelectUserAccountButtonInNavigationBar() {
        test.getNavigation().selectUserAccountButton(test.getUser().getFirstName());
    }

    @And("^I select Home button in Navigation bar$")
    public void iSelectHomeButtonInNavigationBar() {
        test.getNavigation().selectHomeButton();
    }

    @And("^I click on Logout button$")
    public void iClickOnLogoutButton() {
        test.getNavigation().selectLogoutButton();
    }

    @And("^I select Account button in Navigation bar$")
    public void iSelectAccountButtonInNavigationBar() {
        test.getNavigation().selectAccountButton();
    }
}
