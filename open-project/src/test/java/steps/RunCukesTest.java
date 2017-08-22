package steps;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        dryRun = false,
        strict = true,
        //tags = "@category, @obrigatory",
        features = "src/test/resources/features/",
        glue = "steps",
        monochrome = false,
        plugin = {
                "pretty",
                "html:target/cucumber",
                "json:results/cucumber.json",
                "junit:results/cucumber.xml"
        }
)
public class RunCukesTest {
}
