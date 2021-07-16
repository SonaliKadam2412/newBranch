package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBaseClass {
    static public WebDriver driver;
    static public Properties properties;
    final String project_path = System.getProperty("user.dir");

    public TestBaseClass() throws Exception {
        FileInputStream property_io = new FileInputStream(project_path + "\\src\\main\\resources\\configuration\\config.properties");
        properties = new Properties();
        properties.load(property_io);

        launchBrowser();
        launchUrl();

    }


    private void launchBrowser() {

        String browser = properties.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", project_path + "\\src\\main\\resources\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", project_path + "\\src\\main\\resources\\drivers\\msedgedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", project_path + "\\src\\main\\resources\\drivers\\geckodriver.exe");
            driver = new ChromeDriver();
        } else {

            System.out.println("Give valid browser name in configuration file");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();



    }

    private void launchUrl(){
        String url = properties.getProperty("url");
        driver.get(url);

    }

}
