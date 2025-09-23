package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.NoSuchElementException;

import static utils.ReusableMethods.*;

public class HomePage {

    public HomePage(WebDriver driver){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@href='/tr/signin' and contains(@class,'menu-item')]")
    private WebElement signinButton;

    @FindBy(xpath = "//li[contains(@class,'nav-item-signin')]//a[contains(@class,'menu-item-signin')]")
    private WebElement profileMenu;

    @FindBy(xpath = "//ul[@class='sub-nav']/li[contains(@class,'subnav-item')]/a[@href='/tr/account/user']")
    private WebElement settingMenu;

    @FindBy(xpath = "//button[@aria-label='Tümünü Kabul Et']")
    private WebElement acceptCookiesButton;

    @FindBy(xpath = "//a[@ng-click='$root.signOut()']")
    public WebElement signOutLink;


    public void logOut(){
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(profileMenu).perform();
        wait_second(5);
        signOutLink.click();
    }

    public void clickSigninButton() throws InterruptedException {
        signinButton.click();
        wait_second(3);
    }

    public void clickSettingMenu() throws InterruptedException {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(profileMenu).perform();
        wait_second(5);
        settingMenu.click();
    }

    public void acceptCookies() {
        wait_second(3);
        try {
            if(acceptCookiesButton.isDisplayed() && acceptCookiesButton.isEnabled()) {
                wait_second(3);
                acceptCookiesButton.click();
                wait_second(3);
            }
        } catch (NoSuchElementException e) {
            // Buton yoksa hiçbir şey yapma
        }
    }

    public void acceptCookies2() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3));
            WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Tümünü Kabul Et']")));
            acceptButton.click();
            wait_second(1);
        } catch (TimeoutException e) {
            // Buton yoksa test kırılmasın, devam et
        }
    }



}
