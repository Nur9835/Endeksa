package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import static utils.ReusableMethods.scroll;
import static utils.ReusableMethods.wait_second;

public class ChangePasswordPage {

    public ChangePasswordPage(WebDriver driver){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "password")
    public WebElement currentPasswordInput;


    @FindBy(name = "newPassword")
    public WebElement newPasswordInput;

    @FindBy(name = "newPasswordConfirm")
    public WebElement newPasswordConfirmInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='toast-message']")
    private WebElement toastMessage;

    public void fillChangePassword(String password, String newPassword, String newPasswordConfirm) throws InterruptedException {
        currentPasswordInput.sendKeys(password);
        wait_second(1);
        newPasswordInput.sendKeys(newPassword);
        wait_second(1);
        newPasswordConfirmInput.sendKeys(newPasswordConfirm);
        wait_second(1);
    }

    public void clickSubmitButton() {submitButton.click();}

    public String getToastMessage(){
        return  toastMessage.getText().trim();
    }


}
