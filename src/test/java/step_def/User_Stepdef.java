package step_def;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.HomePage;
import pages.UserPage;
import utils.Driver;

import static utils.ReusableMethods.assertWarningVisible;
import static utils.ReusableMethods.wait_second;

public class User_Stepdef {

    UserPage userPage= new UserPage(Driver.getDriver());
    HomePage homePage =new HomePage(Driver.getDriver());


    @And("Kullanıcı bilgilerindeki Telefon numarası inputuna  telefon numarası {string} alanına girilir")
    public void kullanıcıBilgilerindekiTelefonNumarasıInputunaTelefonNumarasıAlanınaGirilir(String arg0) {
        userPage.setPhoneInput(arg0);
    }

    @Then("Kullanılan telefon numarası uyarısı alındığı doğrulanır")
    public void kullanılanTelefonNumarasıUyarısıAlındığıDoğrulanır() {
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
}
