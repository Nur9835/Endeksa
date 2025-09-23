package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "rerun:Failed/failed_scenario.txt"
        },
        features = "src/test/resources/features",
        glue = {"step_def", "hooks"},
        dryRun = false,
        monochrome = false,
        tags = "@user2"   // sadece @login taglı senaryolar çalışır
)
public class Runner {
}
