package Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import PageObject.LoginPage;


public class TestUserAndPassword extends BaseTest{

	@Test(description = "Test the login failed scenario - check that login failed, and you get the right message")
	public void tc01_OpenLogin() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.OpenLogin();
		loginPage.LoginToTheSite("phaim7485a@gmail.com", "Praim35");
		String actual=loginPage.GetErrorMessage();
		String expected="These credentials do not match our records.";
		Assert.assertEquals(actual, expected);
	}

	@Test(dataProvider ="getData", description="use incorect login information")
	public void tc02_OpenLogin2(String username, String password) throws InterruptedException{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.LoginToTheSite(username, password);
		String actual=loginPage.GetErrorMessage();
		String expected="These credentials do not match our records.";
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][]getData(){
		Object[][]myData= {
				{"pppp@gmail.com","111111"},
				{"papa@walla.co.il","123456"},
				{"prielha1234@gmail.com","1985"},
				{"prielhaim7485@gmail.com","PrielHam1985"},
		};
		return myData;
	}
}