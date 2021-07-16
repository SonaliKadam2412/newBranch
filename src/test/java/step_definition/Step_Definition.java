package step_definition;

import com.TestBaseClass;
import instagram.HomePg;
import instagram.LoginPg;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Step_Definition extends TestBaseClass {
    LoginPg loginPg;
    HomePg homePg;

    public Step_Definition() throws Exception {
        System.out.println(" Step_Definition class");
        loginPg = new LoginPg(driver,properties);
        homePg = new HomePg(driver,properties);
    }

    @Given("We enter username in instagram page")
    public void weEnterUsernameInInstagramPage() {
        loginPg.enterInstaUserName();

    }

    @Then("We enter password in instagram page")
    public void weEnterPasswordInInstagramPage() {
        loginPg.enterInstaPassword();
    }

    @Then("We click login button")
    public void weClickLoginButton() {
        loginPg.clickLoginBtn();
    }

    @Then("We verifying that we navigating to home page")
    public void weVerifyingThatWeNavigatingToHomePage() {
        System.out.println("verifyHomePage");
    }
}
