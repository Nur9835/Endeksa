package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class DeleteAccountPage {

    public DeleteAccountPage(WebDriver driver){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@placeholder='hesabı sil']")
    private WebElement deleteAccountConfirmationInput;

    @FindBy(xpath = "//button[@ng-click='continueDelete();']")
    private WebElement deleteButton;

    public void setDeleteAccountConfirmationInput(String deleteString) {
        deleteAccountConfirmationInput.sendKeys(deleteString);
    }

    public void clickDeleteAccountButton () throws InterruptedException {
        deleteButton.click();
    }



}
