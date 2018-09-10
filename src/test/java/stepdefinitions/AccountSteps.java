package stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import general.TestContext;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountSteps {

    private TestContext test;

    public AccountSteps(TestContext testContext) {
        this.test = testContext;
    }


    @And("^I am in My Account page$")
    public void iAmInMyAccountPage() {
        test.getNavigation().waitUntilPageLoadingIsFinished();
        test.getAccountPage().waitUntilAccountDataLoadingIsFinished();

        assertThat(test.getAccountPage().isAccountDataVisible()).isTrue();
    }

    @And("^I have an existing account$")
    public void iHaveAnExistingAccount() {
        test.getNavigation().waitUntilPageLoadingIsFinished();

        assertThat(test.getAccountPage().getAccountName()).isEqualTo(test.getUser().getFirstName());
        assertThat(test.getAccountPage().getAccountLastname()).isEqualTo(test.getUser().getLastName());
    }
}
