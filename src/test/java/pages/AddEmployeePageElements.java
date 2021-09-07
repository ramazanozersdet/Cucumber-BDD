package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.BaseClass;

public class AddEmployeePageElements extends BaseClass{

    @FindBy(id ="firstName" )
    public WebElement firstName_field;

    @FindBy(id ="middleName" )
    public WebElement middleName_field;

    @FindBy(id ="lastName" )
    public WebElement lastName_field;

    @FindBy(id ="employeeId" )
    public WebElement employeeId_field;

    @FindBy(id ="photofile" )
    public WebElement photograph_field;

    @FindBy(id ="chkLogin" )
    public WebElement createLogin_checkBox;

    @FindBy(id ="btnSave" )
    public WebElement saveButton_field;

    @FindBy(xpath = "(//span[@class='validation-error'])[1]")
    public WebElement firstNameRequired_error;

    @FindBy(xpath = "(//span[@class='validation-error'])[2]")
    public WebElement lastNameRequired_error;

    @FindBy(xpath = "//input[@name='user_name']")
    public WebElement userName_CreateLogin;

    @FindBy(xpath = "//input[@name='user_password']")
    public WebElement password_CreateLogin;

    @FindBy(xpath = "//input[@name='re_password']")
    public WebElement confirmPassword;

    @FindBy(xpath = "(//h1)[1]")
    public  WebElement header;

    @FindBy(id = "employeeId")
    public WebElement id_employed;

    @FindBy(id = "menu_pim_viewEmployeeList")
    public WebElement viewEmployeeList;

    @FindBy(id = "empsearch_id")
    public WebElement search_id;

    @FindBy(id = "searchBtn")
    public WebElement searchBtn;

    @FindBy(xpath = "//table[@id='resultTable']/tbody/tr/td[1]")
    public WebElement select_record;

    @FindBy(id = "btnDelete")
    public WebElement btnDelete;


    public AddEmployeePageElements(){
        PageFactory.initElements(driver,this);
    }


}
