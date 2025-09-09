package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

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
    private WebElement registerButton;

    @FindBy(id = "bireysel")
    private WebElement individualUserRadioButton;

    @FindBy(id = "emlak")
    private WebElement realEstateRadioButton;


    @FindBy(id = "private")
    private WebElement privateWorkerRadioButton;

    @FindBy(id = "public")
    private WebElement publicWorkerRadioButton;


    public void fillRegisterWithEmail(String firstName, String lastName, String email, String password, String confirmPassword) throws InterruptedException {

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

    }

    public void clickRegisterButton() throws InterruptedException {
        wait_second(5);
        registerButton.click();
        wait_second(5);
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

}



