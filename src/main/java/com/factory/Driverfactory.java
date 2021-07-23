package com.factory;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*3-->class is used for driver initialization
This class provides thread-local variables. These variables differ fromtheir normal counterparts in
that each thread that accesses one (via its get or set method) has its own, independently initializedcopy
of the variable. ThreadLocal instances are typically privatestatic fields in classes that wish to associate
state with a thread (e.g.,a user ID or Transaction ID). */

public class Driverfactory {

	public static WebDriver driver;
	Properties prop;

	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();

	/*
	 * ThreadLocal class is used to run in parallel if required Used to initialize
	 * the driver with Threadlocal driver on the basis of given browser
	 * 
	 * @parameter- browser retrun- this will return tldriver
	 * 
	 */

	public WebDriver init_driver(String browser) {

		prop = new Properties();
		System.out.println("Browser is: " + browser);

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			// will create the local driver for the thread and local driver have instance of
			// webdriver
			tldriver.set(new ChromeDriver());
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			// will create the local driver for the thread and local driver have instance of
			// webdriver
			tldriver.set(new FirefoxDriver());
		}

		else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			// will create the local driver for the thread and local driver have instance of
			// webdriver
			tldriver.set(new EdgeDriver());

		}

		else {
			System.out.println("Please enter the valid browser value.Options are chrome, firefox or edge");
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return getDriver();
	}

	/*
	 * Used to get the driver thread with local synchronized the method to prevent
	 * multiple thread to access the driver at same time
	 */

	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}

}
