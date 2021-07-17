package instaTest;

import com.TestBaseClass;
import instagram.HomePg;
import instagram.LoginPg;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class InstaTest extends TestBaseClass {
    HomePg homePg;
    LoginPg loginPg;

    public InstaTest() throws Exception {
        loginPg = new LoginPg(driver, properties);
        homePg = new HomePg(driver, properties);

    }

    @Test
    public void instaLogin() {
        loginPg.login();

    }






    @AfterMethod
    public void afterMethod() {
        driver.close();
    }
}
