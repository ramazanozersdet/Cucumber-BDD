package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/Dashboard.feature",
        glue ="stepDefinitions", //we need glue
        dryRun = false, //when set as true, will run over feature steps and identify the missing implement
        monochrome = false, //when set as true, will format the console outcome
        tags = "@regression",
        //strict = false //when set as true, will fail the execution when undefined step is found
        plugin ={"pretty","html:target/cucumber-default-reports/reports.html",
                "rerun:target/FailedTest.txt"} //will print the steps inside the console
)

public class RegressionRunner {
}
