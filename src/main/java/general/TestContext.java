package general;

import lombok.Data;
import pages.account.AccountPageObject;
import pages.confirmation.ConfirmationPageObject;
import pages.flights.FlightListPageObject;
import pages.header.NavigationPageObject;
import pages.homepage.HomepagePageObject;
import pages.login.LoginPageObject;
import pages.signup.SignUpPageObject;

@Data
public class TestContext {

    // --- Context objects ---

    private User user;
    private Flight flight;

    // --- Page Objects ---

    private NavigationPageObject navigation;
    private HomepagePageObject homepage;
    private SignUpPageObject signUpPage;
    private LoginPageObject loginPage;
    private AccountPageObject accountPage;
    private FlightListPageObject flightListPage;
    private ConfirmationPageObject confirmationPage;

    public TestContext() {
        this.user = new User();
        this.flight = new Flight();
        this.navigation = new NavigationPageObject();
        this.homepage = new HomepagePageObject();
        this.signUpPage = new SignUpPageObject();
        this.loginPage = new LoginPageObject();
        this.accountPage = new AccountPageObject();
        this.flightListPage = new FlightListPageObject();
        this.confirmationPage = new ConfirmationPageObject();
    }

}
