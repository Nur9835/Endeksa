package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
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

    public void goToRegisterPage() {
        registerLink.click();
    }

    public void clickPhoneWithLoginButton () throws InterruptedException {
        loginButtonWithPhonenumber.click();
        wait_second(5);
    }


    public void clickEmailButton () throws InterruptedException {
        emailButton.click();

    }


    public void setPhoneNumber(String phonenumber){
        wait_second(3);
        phoneNumberInput.sendKeys(phonenumber);
    }

    public void fillLoginWithEmail(String email, String password) throws InterruptedException {
        wait_second(5);
        emailInput.sendKeys(email);
        wait_second(3);
        passwordInput.sendKeys(password);
        wait_second(3);
        loginButton.click();
        wait_second(10);
    }




}
