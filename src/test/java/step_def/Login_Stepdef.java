package step_def;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;
import utils.Driver;
import utils.ReusableMethods;
import static utils.ReusableMethods.*;

public class Login_Stepdef {
    HomePage homePage=new HomePage(Driver.getDriver());
    LoginPage loginPage= new LoginPage(Driver.getDriver());
    ProfilePage profilePage= new ProfilePage(Driver.getDriver());


    @Given("Web sitesine gidilir")
    public void web_sitesine_gidilir() {
        Driver.getDriver();
        wait_second(5);
        homePage.acceptCookies();
        wait_second(5);

    }

    @When("Eposta ile giriş")
    public void epostaIleGiriş() throws InterruptedException {
        homePage.clickSigninButton();
        wait_second(5);
        loginPage.clickEmailButton();
    }

    @Then("Hesaba  {string} giriş yaptığı doğrulanır")
    public void hesabaGirişYaptığıDoğrulanır(String arg0) throws InterruptedException {
        homePage.clickSettingMenu();
        wait_second(5);
        profilePage.assertEmailInputValue(arg0);
    }

    @And("E-posta alanına {string} Parola alanına {string} girilir ve Giriş Yap butonu tıklanır")
    public void ePostaAlanınaParolaAlanınaGirilirVeGirişYapButonuTıklanır(String arg0, String arg1) throws InterruptedException {
        loginPage.fillLoginWithEmail(arg0,arg1);
    }


    @When("Kaydol Giriş Yap butonu tıklanır")
    public void kaydolGirişYapButonuTıklanır() throws InterruptedException {
        homePage.clickSigninButton();
    }

    @And("Telefon numarası alanına {string} girilir")
    public void telefonNumarasıAlanınaGirilir(String arg0) {
        loginPage.setPhoneNumber(arg0);

    }

    @And("Ücretsiz Kaydol Giriş Yap butonu tıklanır")
    public void ücretsizKaydolGirişYapButonuTıklanır() throws InterruptedException {
        loginPage.clickPhoneWithLoginButton();
        wait_second(5);



    }

    @And("sms doğrulama")
    public void smsDoğrulama() {
        //API sorgusu ile OTP bilgisi çekilemediği için manuel işlem devam edildi
        wait_second(30);

    }


    @Then("Hesaba telefon numarası ile {string} giriş yaptığı doğrulanır")
    public void hesabaTelefonNumarasıIleGirişYaptığıDoğrulanır(String arg0) throws InterruptedException {
        homePage.clickSettingMenu();
        wait_second(5);
        profilePage.assertPhoneNumberInputValue(arg0);
    }


}
