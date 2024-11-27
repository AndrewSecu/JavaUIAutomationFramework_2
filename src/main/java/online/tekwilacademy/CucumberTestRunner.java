package online.tekwilacademy;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/online/tekwilacademy/features",
        glue = "online.tekwilacademy.stepdefinitions",
        tags = "@run"
)

public class CucumberTestRunner {
}