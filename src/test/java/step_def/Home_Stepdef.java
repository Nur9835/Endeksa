package step_def;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import utils.Driver;

public class Home_Stepdef {

    HomePage homePage= new HomePage(Driver.getDriver());


    @When("Kullanıcı bilgileri sayfasına gidilir")
    public void kullanıcıBilgileriSayfasınaGidilir() throws InterruptedException {
        homePage.clickSettingMenu();
    }


}
