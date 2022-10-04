import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources"},
        glue = {"step_defs"},
        monochrome = true,
        plugin = {"pretty", "html:target/html-test-output.html" }
)

public class RunTest {
}
