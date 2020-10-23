package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends MenuPage{
	// open the size involve.me
	@FindBy(css=".other-link.login")
	private WebElement OpenLoginUpBtn;
	@FindBy(css="[autocomplete='username']")
	private WebElement usernameField;
	@FindBy(css="[name='password']")
	private WebElement passwordField;
	@FindBy(css=".btn-primary")
	private WebElement loginBtn;
	@FindBy(css=".alert-danger")
	private WebElement errorMessage;
	@FindBy(css="#nav-dropdown>div .flex")
	private WebElement MyLogin;
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	public void OpenLogin() {
		click(OpenLoginUpBtn);
	}
	public void LoginToTheSite(String username, String Password) {
		sleep(1000);
		fillText(usernameField, username);
		fillText(passwordField, Password);
		sleep(1000);
		click(loginBtn);
	}
	public String GetErrorMessage() {
		return getText(errorMessage);
	}
	public String GetMyLogin() {
		return getText(MyLogin);
	}
}
