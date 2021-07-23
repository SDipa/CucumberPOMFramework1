package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/*here we will mainitain
locators-private
class construtor
page methods-public
*/
public class LoginPage {
	
	private WebDriver driver;
	
	//1.provate locators
	private By email_Id=By.id("email");
	private By password=By.id("passwd");
	private By signIn_Button=By.id("SubmitLogin");
	private By forgotPasswrodLink=By.linkText("Forgot your password?");
	
	//2.public constructor
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//3.page actions- public
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public Boolean forgotPasswordLink() {
		return driver.findElement(forgotPasswrodLink).isDisplayed();
	}

	public void loginUsername(String username) {
		driver.findElement(email_Id).sendKeys(username);
	}
	
	public void loginPwd(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void loginbutton() {
		driver.findElement(signIn_Button).click();
	}
	
}
