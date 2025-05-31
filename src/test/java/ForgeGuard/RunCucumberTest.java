package ForgeGuard;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.core.options.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber") // Use the Cucumber engine
@SelectClasspathResource("ForgeGuard") // Path to your feature files (inside src/test/resources)
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "ForgeGuard") // Step definitions package
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, json:target/cucumber.json") // Plugins for reporting
public class RunCucumberTest {
}
