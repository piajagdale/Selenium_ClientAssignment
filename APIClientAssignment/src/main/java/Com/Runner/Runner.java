package Com.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
				(
					features = "src/main/resources/Features/FeatureFile.feature",
					glue = {"Com/StepDefinetion"}
				)

public class Runner {

}
