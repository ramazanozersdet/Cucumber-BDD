package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.CommonMethods;

public class LoginStepDefinitions extends CommonMethods {

    @When("login with valid credentials")
    public void login_with_valid_credentials() {
        login.loginwithvalidcredentialsToHrms();
    }

    @Then("verify the dashboard logo is displayed")
    public void verify_the_dashboard_logo_is_displayed() {
        Assert.assertTrue(dash.Db_welcomeSing.isDisplayed());
    }

    @When("login with invalid credentials")
    public void login_with_invalid_credentials() {
        login.loginToHrms("admin34","kkfjdkkm");
    }

    @Then("verify the error message")
    public void verify_the_error_message() {
        Assert.assertTrue(login.spanMessage.isDisplayed());
    }

    @When("login with empty username")
    public void login_with_empty_username() {
        login.loginToHrms("","admin123");
    }

    @Then("verify the error message {string}")
    public void verify_the_error_message(String string) {
        Assert.assertTrue(login.spanMessage.getText().equals(string));
    }

    @When("login with empty password")
    public void login_with_empty_password() {
        login.loginToHrms("Admin","");
    }

}
