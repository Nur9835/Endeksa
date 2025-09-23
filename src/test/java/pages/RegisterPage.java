package pages;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.io.File;
import java.io.IOException;

import static utils.ReusableMethods.*;


public class RegisterPage {

    public RegisterPage(WebDriver driver){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@id='inputBasicFirstName']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='inputBasicLastName']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='mail-input']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@id='phone-nput']")
    private WebElement phoneInput;

    @FindBy(xpath = "//input[@ng-model='registration.password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@ng-model='confirmPassword']")
    private WebElement confirmPasswordInput;

    @FindBy(id = "inputUyelikSozlesmesi")
    private WebElement termsCheckbox;

    @FindBy(id = "inputGizlilikSozlesmesi")
    private WebElement privacyCheckbox;

    @FindBy(id = "inputKvkk")
    private WebElement kvkkCheckbox;

    @FindBy(xpath = "//button//span[text()='Kaydol']")
    public WebElement registerButton;

    @FindBy(id = "bireysel")
    private WebElement individualUserRadioButton;

    @FindBy(id = "emlak")
    private WebElement realEstateRadioButton;

    @FindBy(id = "private")
    private WebElement privateWorkerRadioButton;

    @FindBy(id = "public")
    private WebElement publicWorkerRadioButton;

    @FindBy(xpath = "//span[contains(text(),'Parola en az 8 karakter olmalı')]")
    private WebElement passwordMustCharacter;

    @FindBy(xpath = "//span[normalize-space()='Kullanılan e-posta']")
    private WebElement usedEmailWarning;

    @FindBy(xpath = "//span[normalize-space()='Geçersiz e-posta']")
    private WebElement errorEmailWarning;

    @FindBy(xpath = "//span[normalize-space()='Geçersiz telefon numarası']")
    private WebElement errorPhoneWarning;

    @FindBy(xpath = "//span[normalize-space()='Parolalar eşleşmiyor']")
    private WebElement passwordsDontMatchWarning;

    @FindBy(xpath = "//span[normalize-space()='En az 1 harf içermeli']")
    private WebElement mustContainAtLeastOneLetterWarning;

    @FindBy(xpath = "//span[normalize-space()='En az 1 rakam içermeli']")
    private WebElement mustContainAtLeastOneDigitWarning;

    @FindBy(xpath = "//div[text()='Hesabınız aktive edildi. Devam etmek için lütfen giriş yapınınız.']")
    private WebElement activedAccount;

    @FindBy(xpath = "//button[@ng-click='skipSyncing()']")
    private WebElement skipThisStepButton;

    @FindBy(xpath = "//button[@ng-click='syncAccounts()']")
    private WebElement addEmailButton;


    @FindBy(id="mail-input")
    private WebElement emailInputWithPhoneRegister;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    private RegisterData user;

    public WebElement getEmailInput() {
        return emailInput;
    }

    public void loadUserFromJson(String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        user = mapper.readValue(new File(path), RegisterData.class);
    }

    public void fillRegisterFromUser() throws InterruptedException {
        fillRegisterWithEmail(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                user.getConfirmPassword()
        );
    }

    public void fillRegisterWithEmail(String firstName, String lastName, String email, String password, String confirmPassword) throws InterruptedException {
        firstNameInput.sendKeys(firstName);
        wait_second(3);
        lastNameInput.sendKeys(lastName);
        wait_second(3);
        emailInput.sendKeys(email);
        wait_second(3);
        scroll(emailInput);
        wait_second(3);
        passwordInput.sendKeys(password);
        wait_second(3);
        confirmPasswordInput.sendKeys(confirmPassword);
        wait_second(3);

    }

    public void fillOnlyPassword( String password, String confirmPassword){
        wait_second(3);
        scroll(emailInput);
        wait_second(3);
        passwordInput.sendKeys(password);
        wait_second(3);
        confirmPasswordInput.sendKeys(confirmPassword);
        wait_second(3);
    }



    public void fillRegisterWithEmailwithPhone(String firstName, String lastName, String email, String password, String confirmPassword, String phone) throws InterruptedException {
        firstNameInput.sendKeys(firstName);
        wait_second(3);
        lastNameInput.sendKeys(lastName);
        wait_second(3);
        emailInput.sendKeys(email);
        wait_second(3);
        scroll(emailInput);
        passwordInput.sendKeys(password);
        wait_second(3);
        confirmPasswordInput.sendKeys(confirmPassword);
        wait_second(3);
        phoneInput.sendKeys(phone);
        wait_second(3);
    }


    public void fillRegisterWithPhone(String firstName, String lastName){
        firstNameInput.sendKeys(firstName);
        wait_second(3);
        lastNameInput.sendKeys(lastName);
        wait_second(3);
        scroll(submitButton);

        wait_second(3);
        submitButton.click();
        wait_second(5);
    }

    public WebElement getUsedEmailWarning() {
        return usedEmailWarning;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public WebElement getErrorEmailWarning() {
        return errorEmailWarning;
    }

    public WebElement getErrorPhoneWarning() {
        return errorPhoneWarning;
    }
     public WebElement getPasswordMustCharacter() {
         return passwordMustCharacter;
     }


    public WebElement getPasswordsDontMatchWarning() {
        return passwordsDontMatchWarning;
    }

    public WebElement getMustContainAtLeastOneLetterWarning() {
        return mustContainAtLeastOneLetterWarning;
    }

    public WebElement getMustContainAtLeastOneDigitWarning() {
        return mustContainAtLeastOneDigitWarning;
    }


    public WebElement getActivedAccount() {
        return activedAccount;
    }

    public void clickRegisterButton() throws InterruptedException {
        wait_second(5);
        registerButton.click();
        wait_second(5);
    }

    public WebElement getRegisterButton() {
        return registerButton;
    }

    public void acceptTerms() throws InterruptedException {
        scroll(passwordInput);
        if (!termsCheckbox.isSelected()) {
            wait_second(3);
            termsCheckbox.click();
            wait_second(3);
        }
    }

    public void acceptPrivacy() throws InterruptedException {
        if (!privacyCheckbox.isSelected()) {
            wait_second(3);
            privacyCheckbox.click();
            wait_second(3);
        }
    }

    public void acceptKvkk() throws InterruptedException {
        if (!kvkkCheckbox.isSelected()) {
            wait_second(3);
            kvkkCheckbox.click();
            wait_second(3);
        }
    }

    public void selectUserType(String userType) {
        switch (userType.toLowerCase()) {
            case "bireysel kullanıcı, gayrimenkul yatırımcısıyım":
                individualUserRadioButton.click();
                wait_second(3);
                break;
            case "gayrimenkul profesyoneli, danışmanım":
                realEstateRadioButton.click();
                wait_second(3);
                break;
            case "özel sektör çalışanıyım":
                privateWorkerRadioButton.click();
                wait_second(3);
                break;
            case "kamu çalışanıyım":
                publicWorkerRadioButton.click();
                wait_second(3);
                break;
            default:
                throw new IllegalArgumentException("Geçersiz kullanıcı tipi: " + userType);
        }
    }

    public void clickSkipEmail(){
        skipThisStepButton.click();
        wait_second(3);
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
        wait_second(3);
    }

    public void addEmailWithPhoneRegister( String email){
        emailInputWithPhoneRegister.sendKeys(email);
        wait_second(3);
        addEmailButton.click();
    }

    public void verifyEmail(){

    }



}



