package step_def;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DeleteAccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.UserPage;
import utils.Driver;

import static utils.ReusableMethods.*;

public class Login_Stepdef {
    HomePage homePage=new HomePage(Driver.getDriver());
    LoginPage loginPage= new LoginPage(Driver.getDriver());
    UserPage userPage= new UserPage(Driver.getDriver());
    DeleteAccountPage deleteAccountPage = new DeleteAccountPage (Driver.getDriver());

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
        userPage.assertEmailInputValue(arg0);
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

    @Then("One or more validation errors occurred uyarısı alındığı doğrulanır")
    public void oneOrMoreValidationErrorsOccurredUyarısıAlındığıDoğrulanır() {
        assertWarningVisible(loginPage.getErrorMessage(), "One or more validation errors occurred");
    }


    @Then("Hatalı parola veya e-posta adresi uyarısı alındığı doğrulanır")
    public void hatalıParolaVeyaEPostaAdresiUyarısıAlındığıDoğrulanır() {
        assertWarningVisible(loginPage.getErrorMessage2(), "Hatalı parola veya e-posta adresi");
    }


    @And("E-posta alanına {string} Parola alanına {string} girilir")
    public void ePostaAlanınaParolaAlanınaGirilir(String arg0, String arg1) throws InterruptedException {
        loginPage.fillLoginWithEmail(arg0,arg1);
    }

    @Then("Giriş yap butonunun disable tıklanamaz olduğu doğrulanır")
    public void girişYapButonununDisableTıklanamazOlduğuDoğrulanır() {
        assertButtonNotVisible(loginPage.getLoginButton(), "Giriş Yap");
    }

    @And("Ücretsiz Kaydol Giriş Yap butonunun disable tıklanamaz olduğu doğrulanır")
    public void ücretsizKaydolGirişYapButonununDisableTıklanamazOlduğuDoğrulanır() {
        assertButtonNotVisible(loginPage.getLoginButtonWithPhonenumber(), "Ücretsiz Kaydol Giriş Yap");
    }

    @Then("Hesaba telefon numarası ile {string} giriş yaptığı doğrulanır")
    public void hesabaTelefonNumarasıIleGirişYaptığıDoğrulanır(String arg0) throws InterruptedException {
        homePage.clickSettingMenu();
        wait_second(5);
        userPage.assertPhoneNumberInputValue(arg0);
    }

    @And("sms doğrulamada hatalı kod yazılır")
    public void smsDoğrulamadaHatalıKodYazılır() {
        //MANUEL HATALI GİRİŞ YAPILIR
        wait_second(30);
    }


    @Then("Hatalı OTP kodu. Lütfen tekrar deneyin uyarısı alındığı doğrulanır")
    public void hatalıOTPKoduLütfenTekrarDeneyinUyarısıAlındığıDoğrulanır() {
        assertWarningVisible(loginPage.getErrorOTP(), "Hatalı OTP kodu. Lütfen tekrar deneyin");
    }

    @When("Profil sayfasındaki Hesabı Sil butonuna tıklanır")
    public void profilSayfasındakiHesabıSilButonunaTıklanır() {
        userPage.goToDeleteAccountPanel();
    }

    @And("Çıkan popupdaki inputa {string} girilir")
    public void çıkanPopupdakiInputaGirilir(String arg0) {
        deleteAccountPage.setDeleteAccountConfirmationInput(arg0);

    }

    @And("Sil butonunun enable olduğu doğrulanır ve tıklanır")
    public void silButonununEnableOlduğuDoğrulanırVeTıklanır() throws InterruptedException {
        deleteAccountPage.clickDeleteAccountButton();
    }

    @And("Giriş Yap butonu tıklanır")
    public void girişYapButonuTıklanır() throws InterruptedException {
        loginPage.clickLoginButton();
    }
}
