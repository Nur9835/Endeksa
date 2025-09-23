package step_def;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ChangePasswordPage;
import pages.HomePage;
import pages.UserPage;
import utils.Driver;

import static utils.ReusableMethods.assertWarningVisible;
import static utils.ReusableMethods.wait_second;

public class User_Stepdef {

    UserPage userPage= new UserPage(Driver.getDriver());
    HomePage homePage =new HomePage(Driver.getDriver());
    ChangePasswordPage changePasswordPage=new ChangePasswordPage(Driver.getDriver());

    @And("Kullanıcı bilgilerindeki Telefon numarası inputuna  telefon numarası {string} alanına girilir")
    public void kullanıcıBilgilerindekiTelefonNumarasıInputunaTelefonNumarasıAlanınaGirilir(String arg0) {
        userPage.setPhoneInput(arg0);
    }

    @Then("Kullanılan telefon numarası uyarısı alındığı doğrulanır")
    public void kullanılanTelefonNumarasıUyarısıAlındığıDoğrulanır() {
        wait_second(5);
        assertWarningVisible(userPage.getusedPhoneWarning(), "Kullanılan telefon numarası");
    }


    @Then("Hesaba telefon numarası ile {string} kayıt yaptığı doğrulanır")
    public void hesabaTelefonNumarasıIleGirişYaptığıDoğrulanır(String arg0) throws InterruptedException {
        homePage.clickSettingMenu();
        wait_second(5);
        userPage.assertPhoneNumberInputValue(arg0);
    }


    @Then("Hesaba telefon numarası ile {string}  ve mail adresi {string}  ile kayıt yaptığı doğrulanır")
    public void hesabaTelefonNumarasıIleVeMailAdresiIleKayıtYaptığıDoğrulanır(String arg0, String arg1) throws InterruptedException {
        homePage.clickSettingMenu();
        wait_second(5);
        userPage.assertPhoneNumberInputValue(arg0);
        wait_second(5);
        userPage.assertEmailInputValue(arg1);
    }


    @When("Profil sayfasındaki Parola Değiştir butonuna tıklanır")
    public void profilSayfasındakiParolaDeğiştirButonunaTıklanır() {
        wait_second(5);
        userPage.goToChangePassword();
    }


    @And("Mevcut Parola alanına {string} ve Yeni Parola alanına {string} Yeni Parola Tekrarı alanına {string} girilir")
    public void mevcutParolaAlanınaVeYeniParolaAlanınaYeniParolaTekrarıAlanınaGirilir(String arg0, String arg1, String arg2) throws InterruptedException {
        changePasswordPage.fillChangePassword(arg0,arg1,arg2);
    }


    @And("Tamam butonunun enable olduğu doğrulanır ve tıklanır")
    public void tamamButonununEnableOlduğuDoğrulanırVeTıklanır() {changePasswordPage.clickSubmitButton();}


    @Then("Kaydedildi mesajı sistemde görülür")
    public void kaydedildiMesajıSistemdeGörülür() {
        Assert.assertEquals(changePasswordPage.getToastMessage(), "Kaydedildi", "Toast mesajı beklenenle eşleşmiyor!");
    }

    @When("Hesaptan çıkış yapılır")
    public void hesaptanÇıkışYapılır() {homePage.logOut();}




}
