package step_definition;

import com.TestBaseClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import instagram.HomePg;
import instagram.LoginPg;

public class Step_Definition extends TestBaseClass {
    LoginPg loginPg;
    HomePg homePg;

    public Step_Definition() throws Exception {
        System.out.println(" Step_Definition class");
        loginPg = new LoginPg(driver,properties);
        homePg = new HomePg(driver,properties);
    }
    @Given("^We enter username in instagram page$")
    public void we_enter_username_in_instagram_page() {
       loginPg.enterInstaUserName();
    }

    @Then("^We enter password in instagram page$")
    public void we_enter_password_in_instagram_page() {
     loginPg.enterInstaPassword();
    }

    @Then("^We click login button$")
    public void we_click_login_button()  {
     loginPg.clickLoginBtn();
    }

    @Then("^We verifying that we navigating to home page$")
    public void we_verifying_that_we_navigating_to_home_page()  {

        System.out.println("verifying the home page");

    }





}
