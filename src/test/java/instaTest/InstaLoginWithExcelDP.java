package instaTest;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

public class InstaLoginWithExcelDP {

    WebDriver driver;

    public InstaLoginWithExcelDP() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\91812\\git\\SeleniumFrameWork\\src\\main\\resources\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://www.instagram.com/");

    }

    @DataProvider
    public Object[][] excelDataReading() throws Exception {
        FileInputStream io = new FileInputStream("C:\\Users\\91812\\git\\SeleniumFrameWork\\src\\main\\resources\\test_data\\test_data_excel.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(io);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        XSSFRow row = sheet.getRow(0);
        int rowCount = sheet.getLastRowNum();
        int colCount = row.getLastCellNum();
        Object[][] object = new Object[rowCount][colCount];

        for (int i = 1; i <= rowCount; i++) {
            row = sheet.getRow(i);
            for (int j = 0; j < colCount; j++) {

                XSSFCell cell = row.getCell(j);
                String s = cell.getStringCellValue();
                object[i - 1][j] = s;

            }
        }


        return object;
    }


    @Test(dataProvider = "excelDataReading")
    public void loginWithMultipleLoginIds(String s1, String s2) {
        System.out.println(s1 + "  " + s2);
        driver.get("https://www.instagram.com/");

        WebElement uname = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));

        uname.sendKeys(s1);
        password.sendKeys(s2);

    }
}
