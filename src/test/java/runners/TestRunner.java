package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue ="stepDefinitions", //we need glue
        dryRun = false, //when set as true, will run over feature steps and identify the missing implement
        tags = "@dash",
        plugin ={"pretty","html:target/cucumber-default-reports/reports.html",
        "rerun:target/FailedTest.txt","json:target/cucumber.json"}
)

public class TestRunner {
}
