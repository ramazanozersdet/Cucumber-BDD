package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import testbase.BaseClass;
import utils.CommonMethods;

public class Hooks {

    @Before
    public void startTest(){
        BaseClass.setup();
    }

    @After
    public void endTest(Scenario scenario){

        byte[] screenshot = new byte[0];
        if (scenario.isFailed()){
            screenshot= CommonMethods.takeScreenShot("failed/"+scenario.getName());
        }else{
            screenshot= CommonMethods.takeScreenShot("passed/"+scenario.getName());
        }

        scenario.attach(screenshot,"image/png", scenario.getName());
        BaseClass.tearDown();
    }
}