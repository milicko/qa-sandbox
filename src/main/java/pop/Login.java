package pop;

import org.openqa.selenium.By;
import pop.mainView.DashboardView;
import util.Base;

public class Login extends Base {

    private By INPUT_USERNAME = By.xpath("//input[@name='email']");

    private By INPUT_PASSWORD = By.xpath("//input[@name='password']");

    private By BUTTON_SUBMIT = By.xpath("//button[@data-testid='submit_btn']");


    public Login setUserName(String userName) {
        writeText(INPUT_USERNAME, userName);

        return this;
    }

    public Login setPassword(String userName) {
        writeText(INPUT_PASSWORD, userName);
        return this;
    }

    public DashboardView submit() {
        click(BUTTON_SUBMIT);
        return new DashboardView();
    }

}
