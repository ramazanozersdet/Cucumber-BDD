package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import utils.CommonMethods;
import utils.Constants;
import utils.ExcelUtility;

import java.util.List;
import java.util.Map;

public class AddEmployeeStepDefinitions extends CommonMethods {

    public static String name = "John";
    public static String lastname = "Wick";

    @Then("navigate to add employee page")
    public void navigate_to_add_employee_page() {
        click(dash.pim_button);
        click(dash.add_employment);
    }

    @Then("enter first and last name")
    public void enter_first_and_last_name() {
        sendText(addEmp.firstName_field, name);
        sendText(addEmp.lastName_field, lastname);

    }
    @Then("click on save Button")
    public void click_on_save_button() {
        click(addEmp.saveButton_field);

    }
    @Then("verify the employee is added succesfully")
    public void verify_the_employee_is_added_succesfully() {
        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='"+name+" "+lastname+"']")).getText().equals(name+" "+lastname));
    }

    @When("User enter first name as {string} middle name as {string} and last name as a {string}")
    public void user_enter_first_name_as_middle_name_as_and_last_name_as_a(String firstname, String middleName, String lastname) {
        sendText(addEmp.firstName_field,firstname);
        sendText(addEmp.middleName_field,middleName);
        sendText(addEmp.lastName_field,lastname);

    }
    @Then("verify that {string}  is added succesfully")
    public void verify_that_is_added_succesfully(String string) {
        Assert.assertTrue(personal.profile_header.getText().equals(string));

    }

    @When("check login details checkbox")
    public void check_login_details_checkbox() {
        click(addEmp.createLogin_checkBox);
    }

    @Then("enter login details")
    public void enter_login_details() {
        sendText(addEmp.userName_CreateLogin,"karpuzlu90");
        sendText(addEmp.password_CreateLogin,"Dbkari.123445");
        sendText(addEmp.confirmPassword,"Dbkari.123445");
    }

    @When("enter employee {string}, {string} and {string}")
    public void enter_employee_and(String firstName, String middleName, String lastName) {
        sendText(addEmp.firstName_field,firstName);
        sendText(addEmp.middleName_field,middleName);
        sendText(addEmp.lastName_field,lastName);

    }
    @Then("verify that {string}, {string} and {string} is successfully added")
    public void verify_that_and_is_successfully_added(String fName, String mName, String lName) {

        String fullName= fName+" "+mName+" "+lName;
        String fullprofileName= personal.profile_header.getText();
        Assert.assertEquals(fullprofileName,fullName);
    }

    @When("add multiple employess and verify they are added")
    public void add_multiple_employess_and_verify_they_are_added(io.cucumber.datatable.DataTable employees) {
        List<Map<String, String>>employeeNames = employees.asMaps();

        for(Map<String, String> employeeName : employeeNames){
            String firstName = employeeName.get("First Name");
            String middleName = employeeName.get("Middle Name");
            String lastName = employeeName.get("Last Name");

            sendText(addEmp.firstName_field, firstName);
            sendText(addEmp.middleName_field,middleName);
            sendText(addEmp.lastName_field, lastName);

            click(addEmp.saveButton_field);

            String actualName= personal.profile_header.getText();
            String expectedName= firstName+" "+middleName+" "+lastName;
            Assert.assertEquals(expectedName,actualName);
            click(dash.add_employment);
        }

    }

    @When("add multiple employees from {string} verify they are added successfully")
    public void add_multiple_employees_from_verify_they_are_added_successfully(String sheetName) {
        List<Map<String, String>> excelData = ExcelUtility.excelToListMap(Constants.TESTDATA_FILEPATH,sheetName);

        for(Map<String, String> excelemployeeName : excelData){
            String firstName = excelemployeeName.get("FirstName");
            String middleName = excelemployeeName.get("MiddleName");
            String lastName = excelemployeeName.get("LastName");
            String empID = excelemployeeName.get("EmployeeID");

            sendText(addEmp.firstName_field, firstName);
            sendText(addEmp.middleName_field,middleName);
            sendText(addEmp.lastName_field, lastName);
            sendText(addEmp.id_employed, empID);

            click(addEmp.saveButton_field);

            String actualName= personal.profile_header.getText();
            String expectedName= firstName+" "+middleName+" "+lastName;
            Assert.assertEquals(expectedName,actualName);
            click(dash.add_employment);
        }
    }

}
