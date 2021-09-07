package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "@target/failed-test",
        glue ="stepDefinitions", //we need glue
        dryRun = false, //when set as true, will run over feature steps and identify the missing implement
        monochrome = false, //when set as true, will format the console outcome
        //strict = false //when set as true, will fail the execution when undefined step is found
        plugin ={"pretty","html:target/cucumber-default-reports/reports.html","target/failed-test"} //will print the steps inside the console
)

public class FailedRunner {
}
