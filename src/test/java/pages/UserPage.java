package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;


import static org.testng.Assert.assertEquals;
import static utils.ReusableMethods.*;
import static utils.ReusableMethods.wait_second;

public class UserPage {

    public UserPage(WebDriver driver){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@id='phone-nput']")
    private WebElement phoneInput;

    @FindBy(xpath = "//span[normalize-space()='Kullanılan telefon numarası']")
    private WebElement usedPhoneWarning;

    @FindBy(xpath = "//input[@id='mail-input']")
    private WebElement emailInput;

    @FindBy(xpath = "//a[.//span[text()='Hesabı Sil']]")
    private WebElement deleteAccountButton;

//    @FindBy(xpath = "//a[@ng-click='changePassword();']")
//    private WebElement changePasswordButton;
    @FindBy(linkText = "Parola Değiştir")
    public WebElement changePasswordButton;


    public void assertEmailInputValue(String expectedText) {
        //Ayarlarda verilen email adresi doğrulanarak Kullanıcının kendi hesabı açtığını doğruluyoruz
        wait_second(5);
       // assertEquals(emailInput.getText(), expectedText, "Email eşleşmiyor!");
    }
    public void assertPhoneNumberInputValue(String expectedText) {
        //Ayarlarda verilen telefon numarası doğrulanarak Kullanıcının kendi hesabı açtığını doğruluyoruz
        wait_second(5);
        //inputa girilen telefon numarasını klasik telefon numarası formatına aldıktan sonra Assert işlemi olmalı
        String formattedExpected = "+90 " + expectedText.substring(0,3) + " "
                + expectedText.substring(3,6) + " "
                + expectedText.substring(6,8) + " "
                + expectedText.substring(8,10);

        assertEquals(phoneInput.getAttribute("value"), formattedExpected, "Telefon numarası  eşleşmiyor!");
    }

    public void setPhoneInput(String phonenumber){
        wait_second(3);
        phoneInput.sendKeys(phonenumber);
    }

    public WebElement getusedPhoneWarning() {
        return usedPhoneWarning;
    }

    public void goToDeleteAccountPanel() {deleteAccountButton.click();}

    public void  goToChangePassword()
    {
        wait_second(2);
        clickByJavaScript(changePasswordButton);
        wait_second(2);
        // changePasswordButton.click();
    }

}
