package step_def;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import pages.RegisterPage;
import utils.Driver;
import utils.ReusableMethods;

import static org.testng.Assert.assertEquals;
import static utils.ReusableMethods.*;


public class Register_Stepdef {

    LoginPage loginPage= new LoginPage(Driver.getDriver());
    RegisterPage registerPage =new RegisterPage(Driver.getDriver());

    String expectedUrl = "https://www.endeksa.com/tr/register";


    @And("Ücretsiz Kaydol bağlantısına tıklanır")
    public void ücretsizKaydolBağlantısınaTıklanır() {
        loginPage.goToRegisterPage();
        wait_second(5);

    }

    @Then("Register sayfasına yönlendirildiği doğrulanır")
    public void registerSayfasınaYönlendirildiğiDoğrulanır() {
        assertEquals(Driver.getDriver().getCurrentUrl(), expectedUrl, "Kayıt sayfasına yönlendirilmedi");
        wait_second(2);
    }


    @When("Ad alanına {string}, Soyad alanına {string}, E-posta alanına {string} Parola alanına {string} ve Parola Tekrarına {string} girilir")
    public void adAlanınaSoyadAlanınaEPostaAlanınaParolaAlanınaVeParolaTekrarınaGirilir(String arg0, String arg1, String arg2, String arg3, String arg4) throws InterruptedException {
        registerPage.fillRegisterWithEmail(arg0,arg1,arg2,arg3,arg4);
        wait_second(2);
    }

    @And("Kullanım sözleşmesini onayla")
    public void kullanımSözleşmesiniOnayla() throws InterruptedException {
        registerPage.acceptTerms();
    }

    @And("Gizlilik sözleşmesini onayla")
    public void gizlilikSözleşmesiniOnayla() throws InterruptedException {
        registerPage.acceptPrivacy();
    }

    @And("Üye ve Ziyaretçi Aydınlatma sözleşmesini onayla")
    public void üyeVeZiyaretçiAydınlatmaSözleşmesiniOnayla() throws InterruptedException {
        registerPage.acceptKvkk();
    }


    @And("Kaydol butonuna tıklanır")
    public void kaydolButonunaTıklanır() throws InterruptedException {
        registerPage.clickRegisterButton();
    }

    @And("Sizi Hangisi En İyi Tanımlıyor? seçeneklerinden {string} seçilir")
    public void siziHangisiEnİyiTanımlıyorSeçeneklerindenSeçilir(String arg0) {
        registerPage.selectUserType(arg0);
    }


    @When("Ad alanına {string}, Soyad alanına {string}, E-posta alanına {string}  Telefon numarasına {string} Parola alanına {string} ve Parola Tekrarına {string} girilir")
    public void adAlanınaSoyadAlanınaEPostaAlanınaTelefonNumarasınaParolaAlanınaVeParolaTekrarınaGirilir(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) throws InterruptedException {
        registerPage.fillRegisterWithEmailwithPhone(arg0,arg1,arg2,arg3,arg4,arg5);
        wait_second(2);
    }

    @Then("Parola en az sekiz karakter olmalı uyarısı alındığı doğrulanır")
    public void parolaEnAzSekizKarakterOlmalıUyarısıAlındığıDoğrulanır() {
        assertWarningVisible(registerPage.getPasswordMustCharacter(), "Parola en az sekiz karakter olmalı");
    }

    @Then("Kullanılan e-posta adresi uyarısı alındığı doğrulanır")
    public void kullanılanEPostaAdresiUyarısıAlındığıDoğrulanır() {
        assertWarningVisible(registerPage.getUsedEmailWarning(), "Kullanılan e-posta adresi");
    }

    @Then("Geçersiz e-posta uyarısı alındığı doğrulanır")
    public void geçersizEPostaUyarısıAlındığıDoğrulanır() {
        assertWarningVisible(registerPage.getErrorEmailWarning(), "Geçersiz e-posta");
    }

    @Then("Geçersiz telefon numarasıı uyarısı alındığı doğrulanır")
    public void geçersizTelefonNumarasııUyarısıAlındığıDoğrulanır() {
        assertWarningVisible(registerPage.getErrorPhoneWarning(), "Geçersiz telefon numarası");
    }

    @Then("Parolalar eşleşmiyor uyarısı alındığı doğrulanır")
    public void parolalarEşleşmiyorUyarısıAlındığıDoğrulanır() {
        assertWarningVisible(registerPage.getPasswordsDontMatchWarning(), "Parolalar eşleşmiyor");
    }


    @Then("Parola en az bir rakam veya harf içermeli")
    public void parolaEnAzBirRakamVeyaHarfIçermeli() {
        boolean letterVisible = isElementDisplayed(registerPage.getMustContainAtLeastOneLetterWarning());
        boolean digitVisible = isElementDisplayed(registerPage.getMustContainAtLeastOneDigitWarning());

        Assert.assertTrue(letterVisible || digitVisible,
                "En az bir uyarı (harf veya rakam) görünmeli!");
    }

    @Then("Parola  {string} en az bir rakam ve bir harf içermeli")
    public void parolaEnAzBirRakamVeBirHarfIçermeli(String arg0) {
        boolean letterWarningVisible = isElementDisplayed(registerPage.getMustContainAtLeastOneLetterWarning());
        boolean digitWarningVisible = isElementDisplayed(registerPage.getMustContainAtLeastOneDigitWarning());

        Assert.assertTrue(letterWarningVisible || digitWarningVisible,
                "En az bir uyarı (harf veya rakam) görünmeli!");

    }

    @Then("Parolada herhangi bir uyarı vermemeli")
    public void paroladaHerhangiBirUyarıVermemeli() {
        assertWarningNotVisible(registerPage.getMustContainAtLeastOneLetterWarning(), "Harf eksik");
        assertWarningNotVisible(registerPage.getMustContainAtLeastOneDigitWarning(), "Rakam eksik");
        assertWarningNotVisible(registerPage.getPasswordMustCharacter(), "Parola en az 8 karakter olmalı");
    }

    @And("E-Posta ekleme alanında Bu Adımı Atla butonuna tıklanır ve çıkan Alert onaylanır")
    public void ePostaEklemeAlanındaBuAdımıAtlaButonunaTıklanırVeÇıkanAlertOnaylanır() {
        registerPage.clickSkipEmail();
    }

    @And("Ekrana Register işleminin devamı için çıkan popup'daki zorunlu alanlar {string}, {string}  girilir")
    public void ekranaRegisterIşlemininDevamıIçinÇıkanPopupDakiZorunluAlanlarGirilir(String arg0, String arg1) {
        registerPage.fillRegisterWithPhone(arg0,arg1);
    }

    @And("E-Posta ekleme alanına e-posta adresi {string} girilir")
    public void ePostaEklemeAlanınaÖncedenKayıtlıOlmayanEPostaAdresiGirilir(String arg0) {
        registerPage.addEmailWithPhoneRegister(arg0);
    }

    @And("E-posta adresine gönderilen kod E-posta doğrulama alanına eksiksiz girilir ve Doğrula butonu tıklanır")
    public void ePostaAdresineGönderilenKodEPostaDoğrulamaAlanınaEksiksizGirilirVeDoğrulaButonuTıklanır() {
        //API sorgusu ile OTP bilgisi çekilemediği için manuel işlem devam edildi
        wait_second(30);
    }

    @And("Eposta adresine gelen maildeki E-postamı Onayla butonu tıklanır")
    public void epostaAdresineGelenMaildekiEPostamıOnaylaButonuTıklanır() {
        //manuel
    }

    @And("Hesabınız aktive edildi. Devam etmek için lütfen giriş yapınınız. uyarısı alındığı doğrulanır")
    public void hesabınızAktiveEdildiDevamEtmekIçinLütfenGirişYapınınızUyarısıAlındığıDoğrulanır() {
        assertWarningVisible(registerPage.getActivedAccount(), "Hesabınız aktive edildi. Devam etmek için lütfen giriş yapınınız.");
    }


}
