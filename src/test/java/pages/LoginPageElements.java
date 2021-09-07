package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.PageInitializer;
import utils.ConfigsReader;

public class LoginPageElements extends PageInitializer {

    @FindBy(id="txtUsername")
    public WebElement userNametextBox;

    @FindBy(xpath = "//input[@id = 'txtPassword']")
    public WebElement passwordTextBox;

    @FindBy(css = "input#btnLogin")
    public WebElement loginBtn;

    @FindBy(id = "divLogo")
    public WebElement syntaxLogo;

    @FindBy(xpath = "//img[@src='/webres_6051af48107ce6.31500353/themes/default/images/login/logo.png']")
    public WebElement SyntaxLogo;

    @FindBy (id = "spanMessage2")
    public WebElement spanMessage;

    @FindBy(id = "logInPanelHeading")
    public WebElement LoglogInPanelHeading;

    /**
     * This method use by enter username and password
     *
     * @param username
     * @param password
     */

    public void loginToHrms(String username, String password){
        login.userNametextBox.sendKeys(username);
        login.passwordTextBox.sendKeys(password);
        login.loginBtn.click();
    }

    public void loginwithvalidcredentialsToHrms(){
        login.userNametextBox.sendKeys(ConfigsReader.getPropValue("username"));
        login.passwordTextBox.sendKeys(ConfigsReader.getPropValue("password"));
        login.loginBtn.click();
    }

    public LoginPageElements(){

        PageFactory.initElements(driver, this);
    }
}
