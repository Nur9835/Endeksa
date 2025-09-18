package step_def;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import utils.Driver;

import static org.testng.Assert.assertEquals;
import static utils.ReusableMethods.wait_second;

public class Home_Stepdef {

    HomePage homePage= new HomePage(Driver.getDriver());

    String expectedUrl = "https://www.endeksa.com/tr/";


    @When("Kullanıcı bilgileri sayfasına gidilir")
    public void kullanıcıBilgileriSayfasınaGidilir() throws InterruptedException {
        homePage.clickSettingMenu();
    }


    @Then("Ana sayfaya yönlendirdiği doğrulanır")
    public void anaSayfayaYönlendirdiğiDoğrulanır() {
        assertEquals(Driver.getDriver().getCurrentUrl(), expectedUrl, "Ana Sayfaya yönelendirildi ");
        wait_second(2);
    }



}
