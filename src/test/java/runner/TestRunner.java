import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources",          // Path to your .feature files
    glue = "stepdefinitions",                 // Package containing your step defs (adjust as needed)
    plugin = { "pretty", "html:target/cucumber-reports" }, // Reports
    monochrome = true
)
public class TestRunner {
    // This class remains empty. It is used only as a holder for the above annotations.
}
