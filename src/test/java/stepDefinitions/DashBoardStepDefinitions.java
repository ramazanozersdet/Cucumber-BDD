package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

import java.util.ArrayList;
import java.util.List;

public class DashBoardStepDefinitions extends CommonMethods {

    @Then("verify the following dashboard tabs")
    public void verify_the_following_dashboard_tabs(io.cucumber.datatable.DataTable dashboard) {

        List<String> expectedDashTab=dashboard.asList();

        List<String> actualDashTabs=new ArrayList<>();

        for (WebElement dashTab: dash.dashtabs) {
            actualDashTabs.add(dashTab.getText());

        }
        System.out.println(actualDashTabs);
        System.out.println(expectedDashTab);

        Assert.assertTrue(expectedDashTab.equals(actualDashTabs));
        Assert.assertEquals(expectedDashTab,actualDashTabs);

    }

}
