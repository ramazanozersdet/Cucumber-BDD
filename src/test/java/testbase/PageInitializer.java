package testbase;
import pages.AddEmployeePageElements;
import pages.DashboardPageElements;
import pages.LoginPageElements;
import pages.PersonalDetailsPageElement;

public class PageInitializer extends  BaseClass{

    public static LoginPageElements login;
    protected static DashboardPageElements dash;
    protected static AddEmployeePageElements addEmp;
    protected static PersonalDetailsPageElement personal;

    public static void initializePageObjects(){

        login=new LoginPageElements();
        dash=new DashboardPageElements();
        addEmp=new AddEmployeePageElements();
        personal = new PersonalDetailsPageElement();

    }
}
