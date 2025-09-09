package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.Driver;

import java.io.ByteArrayInputStream;

public class Hooks {

    @Before
    public void setUpScenarios() {
        System.out.println("Before Metodu");
    }

    @After
    public void tearDownScenarios(Scenario scenario) {
        System.out.println("After Metodu");

        try {
            if (scenario.isFailed() && Driver.getDriver() != null) {
                byte[] screen = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                Allure.addAttachment("Failed Screenshot", new ByteArrayInputStream(screen));
            }
        } catch (Exception e) {
            System.out.println("Screenshot alınırken hata oluştu: " + e.getMessage());
        } finally {
            Driver.closeDriver();
            System.out.println("Driver kapatıldı.");
        }
    }
}
