package step_def;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.RegisterPage;
import utils.Driver;

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
}
