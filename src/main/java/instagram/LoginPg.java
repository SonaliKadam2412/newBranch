package instagram;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Properties;

public class LoginPg {
    WebDriver driver;
    Properties properties;

    public LoginPg(WebDriver driver, Properties properties) throws Exception {
        this.driver=driver;
        this.properties=properties;
        PageFactory.initElements(driver, this);

    }

    @FindBy(name = "username")
    WebElement userName;
    @FindBy(xpath = "//input[@name='username']/preceding-sibling::span")
    WebElement userNamePlaceHolder;
    @FindBy(xpath = "//input[@name='password']/preceding-sibling::span")
    WebElement passwordPlaceHolder;
    @FindBy(xpath = "//h1[text()='Instagram']")
    WebElement instagramTitle;
    @FindBy(name = "password")
    WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginBtn;

    @FindBy(xpath = "//div[text()='or']")
    WebElement orFieldInLoginPage;
    @FindBy(xpath = "//span[text()='Log in with Facebook']")
    WebElement loginWithFbInLoginPage;
    @FindBy(xpath = "//a[text()='Forgot password?']")
    WebElement forgotPwdLinkInLoginPage;
    @FindBy(xpath = "//span[text()='Sign up']")
    WebElement signUpInLoginPage;
    @FindBy(xpath = "//span[text()='Sign up']/../..")
    WebElement signupTextInLoginPage;



    public void verifyInstaLoginPage() {

        Assert.assertEquals(userNamePlaceHolder.getText().trim(), "Phone number, username, or email");
        Assert.assertEquals(passwordPlaceHolder.getText().trim(), "Password");
        Assert.assertTrue(instagramTitle.isDisplayed());
        Assert.assertTrue(orFieldInLoginPage.isDisplayed());
        Assert.assertTrue(loginWithFbInLoginPage.isDisplayed());
        Assert.assertTrue(forgotPwdLinkInLoginPage.isDisplayed());
        Assert.assertTrue(signUpInLoginPage.isDisplayed());
        Assert.assertTrue(signupTextInLoginPage.isDisplayed());
        Assert.assertEquals(driver.findElements(By.xpath("//img")).size(), 7);
        Assert.assertEquals(driver.findElements(By.xpath("//footer[@role='contentinfo']//a/div")).size(), 10);

    }

    public void login() {
        verifyInstaLoginPage();
        enterInstaUserName();
        enterInstaPassword();
        clickLoginBtn();
    }

    public void enterInstaUserName() {
        String user_Name_Instagram = properties.getProperty("username");
        userName.sendKeys(user_Name_Instagram);
    }

    public void enterInstaPassword() {
        String password_Instagram = properties.getProperty("password");
        password.sendKeys(password_Instagram);
        loginBtn.click();
    }

    public void clickLoginBtn() {
        Assert.assertTrue(loginBtn.isDisplayed());
        loginBtn.click();
    }


}
