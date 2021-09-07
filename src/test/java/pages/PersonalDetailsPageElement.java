package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.PageInitializer;

public class PersonalDetailsPageElement extends PageInitializer {

    @FindBy(id = "profile-pic")
    public WebElement profile_header;

    @FindBy(xpath = "//a[text()='Contact Details']")
    public WebElement contact_details;

    @FindBy(xpath = "//a[text()='Emergency Contacts']")
    public WebElement emergeny_contacts;

    @FindBy(xpath = "//a[text()='Dependents']")
    public WebElement dependents;

    @FindBy(xpath = "//a[text()='Immigration']")
    public WebElement immigration;

    @FindBy(partialLinkText = "Memberships")
    public WebElement memberships;

    @FindBy(xpath = "//input[@id='btnSave' and @value='Edit']")
    public WebElement buttun_edit1;

    @FindBy(xpath = "//input[@id='btnSave' and @value='Save']")
    public WebElement buttun_Save1;

    public PersonalDetailsPageElement(){
        PageFactory.initElements(driver, this);
    }
}
