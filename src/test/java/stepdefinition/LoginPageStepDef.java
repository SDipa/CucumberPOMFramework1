package stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.factory.Driverfactory;
import com.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStepDef {

	public static String title;
	private LoginPage loginPage = new LoginPage(Driverfactory.getDriver());

	@Given("user is on login page")
	public void user_is_on_login_page() {
		Driverfactory.getDriver().get("http://automationpractice.com/");

	}

	@When("user gets the title of page")
	public void user_gets_the_title_of_page() {
		title = loginPage.getTitle();
		System.out.println("login title is: " + title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		Assert.assertTrue(title.equalsIgnoreCase(expectedTitle));
	}

	@Then("forgot password link should be displayed")
	public void forgot_password_link_should_be_displayed() {
		Assert.assertTrue(loginPage.forgotPasswordLink());
	}

	@When("user enters the username {string}")
	public void user_enters_the_username(String username) {
		loginPage.loginUsername(username);
	}

	@When("user enters the password {string}")
	public void user_enters_the_password(String password) {
		loginPage.loginPwd(password);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		loginPage.loginbutton();
	}


	

}
