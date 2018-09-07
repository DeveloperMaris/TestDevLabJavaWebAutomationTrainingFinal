package general;

import lombok.Data;
import pages.signup.SignUpPageObject;

@Data
public class TestContext {

    private User user;
    private SignUpPageObject signUpPage;

    public TestContext() {
        this.user = new User();
        this.signUpPage = new SignUpPageObject();
    }

}
