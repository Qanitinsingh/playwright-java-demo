package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/resources/Features/Home.feature",
        glue = {"pages.steps"}, plugin =
        {"com.aventstack.chaintest.plugins.ChainTestCucumberListener:"}, monochrome = true,
        tags = "@SmokeTest"
)
public class ExecutionManager extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)   //  THIS ENABLES PARALLEL
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
