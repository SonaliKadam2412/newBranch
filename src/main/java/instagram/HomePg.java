package instagram;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public class HomePg {
    WebDriver driver;
    Properties properties;
    public HomePg(WebDriver driver, Properties properties) throws Exception {
        this.driver = driver;
        this.properties = properties;
        PageFactory.initElements(driver, this);
    }

}
