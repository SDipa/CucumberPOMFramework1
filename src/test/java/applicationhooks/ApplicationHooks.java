package applicationhooks;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.factory.Driverfactory;
import com.utility.ConfigPropertiesReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	// private- because its specific to Hokks class only
	private Driverfactory driverfactory;
	private WebDriver driver;
	private ConfigPropertiesReader configReader;
	Properties prop;

	@Before(order = 1)
	public void getPoperty() {
		configReader = new ConfigPropertiesReader();
		prop = configReader.init_properties();

	}

	@Before(order = 2)
	public void launchBrowser() {
		String browser_name = prop.getProperty("browser");

		driverfactory = new Driverfactory();
		driver = driverfactory.init_driver(browser_name);
	}

	// order at After will execute in reverse
	@After(order = 1)
	public void quitBrowser() {
		driver.quit();
	}
	@After(order = 2)
	public void fetFailedScreenShot(Scenario sc) {
		if(sc.isFailed()) {
			//take screenhsot
			
			String screenshotname=sc.getName().replaceAll("", "_");//replace space from scenario name			
			byte[] src=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES); //bytes if we want to use jenkins or any other CICD
			sc.attach(src, "img/png", screenshotname);
		}
	}

}
