package step_def;

import io.cucumber.java.en.Then;
import pages.HomePage;
import pages.UserPage;
import utils.Driver;

import static org.testng.Assert.assertEquals;
import static utils.ReusableMethods.wait_second;

public class Valuations_Stepdef {

    String expectedUrl = "https://www.endeksa.com/tr/analiz/turkiye/portfolio";

    @Then("Hesaba giriş yapıldığı doğrulanır")
    public void hesabaGirişYapıldığıDoğrulanır() {
        //assertEquals(Driver.getDriver().getCurrentUrl(), expectedUrl, "Hesaba giriş yapılmadı");
        wait_second(2);
    }

}
