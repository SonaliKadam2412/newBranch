package instaTest;

import com.TestBaseClass;
import instagram.HomePg;
import instagram.LoginPg;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.ExcelUtilities;

import java.io.FileInputStream;
import java.io.IOException;

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
