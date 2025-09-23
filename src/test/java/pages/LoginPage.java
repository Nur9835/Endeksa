package pages;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.io.File;
import java.io.IOException;

import static utils.ReusableMethods.*;

public class LoginPage {


    public LoginPage(WebDriver driver){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[@ng-click='toggleMailLogin()']")
    private WebElement emailButton;

    @FindBy(xpath = "//input[@id='mail-input']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@name='passwordIO']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button//span[text()='Giriş Yap']")
    private WebElement loginButton;


    @FindBy(xpath = "//button[contains(.,'Ücretsiz Kaydol / Giriş Yap')]")
    private WebElement loginButtonWithPhonenumber;


    @FindBy(id = "phone-nput")
    private WebElement phoneNumberInput;


    @FindBy(xpath = "//a[@href='/tr/register']")
    private WebElement registerLink;



    @FindBy(xpath = "//span[contains(text(),'One or more validation errors occurred')]")
    private WebElement errorMessage;


    @FindBy(xpath = "//span[normalize-space()='Hatalı parola veya e-posta adresi']")
    private WebElement errorMessage2;

    @FindBy(xpath = "//span[contains(text(),'Hatalı OTP kodu')]")
    private WebElement errorOTP;


    private LoginData loginData;


    public void loadUserFromJson(String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        loginData = mapper.readValue(new File(path), LoginData.class);
    }

    public void fillLoginFromUser() throws InterruptedException {
        fillLoginWithEmail(
                loginData.getEmail(),
                loginData.getPassword()
        );
    }


    public void goToRegisterPage() {
        registerLink.click();
    }

    public void clickPhoneWithLoginButton () throws InterruptedException {
        loginButtonWithPhonenumber.click();
        wait_second(5);
    }


    public void clickEmailButton () throws InterruptedException {
        emailButton.click();
        wait_second(3);
    }


    public void clickLoginButton () throws InterruptedException {
        loginButton.click();
        wait_second(10);

    }



    public void setPhoneNumber(String phonenumber){
        wait_second(3);
        phoneNumberInput.sendKeys(phonenumber);
    }

    public void fillLoginWithEmail(String email, String password) throws InterruptedException {
        wait_second(1);
        emailInput.sendKeys(email);
        wait_second(1);
        passwordInput.sendKeys(password);
        wait_second(1);

    }


    public WebElement getErrorMessage() {
        return errorMessage;
    }


    public WebElement getErrorMessage2() {
        return errorMessage2;
    }


    public WebElement getErrorOTP() {
        return errorOTP;
    }


    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getLoginButtonWithPhonenumber (){
        return loginButtonWithPhonenumber;
    }

}
