package step_def;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.LoginPage;
import pages.RegisterPage;
import utils.Driver;
import utils.ReusableMethods;

import java.io.IOException;

import static org.testng.Assert.*;
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
        wait_second(2);
    }


    @And("Gizlilik sözleşmesini onayla")
    public void gizlilikSözleşmesiniOnayla() throws InterruptedException {
        registerPage.acceptPrivacy();
        wait_second(2);
    }

    @And("Üye ve Ziyaretçi Aydınlatma sözleşmesini onayla")
    public void üyeVeZiyaretçiAydınlatmaSözleşmesiniOnayla() throws InterruptedException {
        registerPage.acceptKvkk();
        wait_second(2);
    }


    @And("Kaydol butonuna tıklanır")
    public void kaydolButonunaTıklanır() throws InterruptedException {
        registerPage.clickRegisterButton();
        wait_second(10);
    }

    @And("Sizi Hangisi En İyi Tanımlıyor? seçeneklerinden {string} seçilir")
    public void siziHangisiEnİyiTanımlıyorSeçeneklerindenSeçilir(String arg0) {
        wait_second(2);
        registerPage.selectUserType(arg0);
        wait_second(2);
    }


    @When("Ad alanına {string}, Soyad alanına {string}, E-posta alanına {string}  Telefon numarasına {string} Parola alanına {string} ve Parola Tekrarına {string} girilir")
    public void adAlanınaSoyadAlanınaEPostaAlanınaTelefonNumarasınaParolaAlanınaVeParolaTekrarınaGirilir(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) throws InterruptedException {
        registerPage.fillRegisterWithEmailwithPhone(arg0,arg1,arg2,arg3,arg4,arg5);
        wait_second(2);
    }

    @Then("Parola en az sekiz karakter olmalı uyarısı alındığı doğrulanır")
    public void parolaEnAzSekizKarakterOlmalıUyarısıAlındığıDoğrulanır() {
        String  characterClass  = registerPage.getPasswordMustCharacter().getAttribute("class");
        Assert.assertFalse(
                 characterClass.contains("done"),
                "Parola uyarısı 'done' olmamalı! Şu anki class: " + characterClass
        );

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



    @Then("Parola  {string} en az bir rakam ve bir harf içermeli")
    public void parolaEnAzBirRakamVeBirHarfIçermeli(String arg0) {
        String  letterClass = registerPage.getMustContainAtLeastOneLetterWarning().getAttribute("class");
        String  digitClass  = registerPage.getMustContainAtLeastOneDigitWarning().getAttribute("class");

        boolean anyWarningDone = (letterClass.contains("done")) || digitClass.contains("done");

        Assert.assertTrue(anyWarningDone,
                "Parola en az bir rakam ve bir harf içermeli! Letter class: "
                        + letterClass + ", Digit class: " + digitClass);


    }

    @Then("Parolada herhangi bir uyarı vermemeli")
    public void paroladaHerhangiBirUyarıVermemeli() {

        String  letterClass = registerPage.getMustContainAtLeastOneLetterWarning().getAttribute("class");
        String  digitClass  = registerPage.getMustContainAtLeastOneDigitWarning().getAttribute("class");
        String  characterClass  = registerPage.getPasswordMustCharacter().getAttribute("class");
        Assert.assertEquals("done", letterClass);
        Assert.assertEquals("done", digitClass);
        Assert.assertEquals("done", characterClass);
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
        wait_second(40);
    }

    @And("Hesabınız aktive edildi. Devam etmek için lütfen giriş yapınınız. uyarısı alındığı doğrulanır")
    public void hesabınızAktiveEdildiDevamEtmekIçinLütfenGirişYapınınızUyarısıAlındığıDoğrulanır() {
      //  assertWarningVisible(registerPage.getActivedAccount(), "Hesabınız aktive edildi. Devam etmek için lütfen giriş yapınınız.");
    }


    @When("Ad  Soyad  E-posta Parola  Parola Tekrarını doldur")
    public void adSoyadEPostaParolaParolaTekrarınıDoldur() throws IOException, InterruptedException {
        registerPage.loadUserFromJson("src/test/resources/testData/User.json");
        registerPage.fillRegisterFromUser();
    }

    @And("Kaydol butonuna tıklanamaz olmalı")
    public void kaydolButonunaTıklanamazOlmalı() throws InterruptedException {
        wait_second(2);
      //registerPage.getRegisterButton().getAttribute("disabled");
        registerPage.clickRegisterButton();
        wait_second(6);
        assertEquals(Driver.getDriver().getCurrentUrl(), expectedUrl, "Kayıt oluşmamalı");
        wait_second(2);
    }

    @When("Parola alanına {string} ve Parola Tekrarına {string} girilir")
    public void parolaAlanınaVeParolaTekrarınaGirilir(String arg0, String arg1) {
      registerPage.fillOnlyPassword(arg0,arg1);
    }

    @And("Kullanım sözleşmesini onaylama")
    public void kullanımSözleşmesiniOnaylama() {
        wait_second(2);
        scroll(registerPage.getPasswordInput());
        wait_second(2);
    }
}

