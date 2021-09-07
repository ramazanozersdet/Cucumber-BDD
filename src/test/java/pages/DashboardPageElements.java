package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.BaseClass;

import java.util.List;

public class DashboardPageElements extends BaseClass {

    @FindBy(xpath="(//li[@class = 'main-menu-first-level-list-item'])[1]")
    public WebElement Db_Admin;

    @FindBy(id = "menu_admin_UserManagement")
    public WebElement Db_Admin_User_Management;

    @FindBy(id="menu_admin_viewSystemUsers")
    public WebElement Db_Admin_User_Management_Users;

    @FindBy(id = "welcome")
    public WebElement Db_welcomeSing;

    @FindBy(partialLinkText = "Logout")
    public WebElement Db_welcome_logout;

    @FindBy(partialLinkText = "Support")
    public WebElement DB_welcome_support;

    @FindBy(id="notification")
    public WebElement Db_notifications;

    @FindBy(id="MP_link")
    public WebElement Db_marketplace;

    @FindBy(xpath = "//span[text()='Assign Leave']")
    public WebElement Db_AssignLeave;

    @FindBy(id = "menu_pim_viewPimModule")
    public WebElement pim_button;

    @FindBy(id = "menu_pim_addEmployee")
    public WebElement add_employment;

    @FindBy(xpath = "//div[@id='mainMenu']/ul/li")
    public List<WebElement> dashtabs;

    public DashboardPageElements(){
        PageFactory.initElements(driver,this);
    }

}
