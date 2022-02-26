import org.openqa.selenium.By;
//import necessary Selenium WebDriver classes
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class RegisterTest {
	// declare Selenium WebDriver
	private WebDriver webDriver;

	@Test
	public void checkRegisterForm() {
		// Load website as a new page
		webDriver.navigate().to("http://localhost:8090/PopGamers/GameUserServlet/dashboard");

		// Retrieve link using it's class name and click on it
		webDriver.findElement(By.id("registerUser")).click();

		// assert title of registration form to ensure the right page is accessed
		Assert.assertTrue(webDriver.getTitle().contains("Register to PopGamers!"));

		// enter credentials in elements located by id
		// enter a valid username, change naming everytime ( name is unique key)
		webDriver.findElement(By.id("username")).sendKeys("naming453");

		// enter a valid email address
		webDriver.findElement(By.id("email")).sendKeys("name@abc.com");

		// enter a valid password
		webDriver.findElement(By.id("password")).sendKeys("namepass");

		// submit the form
		webDriver.findElement(By.id("submitRegister")).submit();

		// assert title of dashboard to check that the page led to the right dashboard
		Assert.assertTrue(webDriver.getTitle().contains("GameListing"));

		System.out.println("User successfully registered!");

	}

	@Test
	public void checkHomeButton() {
		// Load website as a new page
		webDriver.navigate().to("http://localhost:8090/PopGamers/GameUserServlet/dashboard");

		// Retrieve link using it's id and click on it
		webDriver.findElement(By.id("returnHome")).click();

		// assert title of home page to ensure the right page is accessed
		Assert.assertTrue(webDriver.getTitle().contains("GameListing"));

		System.out.println("Successfully reached home page!");
	}

	@Test
	public void checkEditDetails() {
		// Load website as a new page
		webDriver.navigate().to("http://localhost:8090/PopGamers/GameUserServlet/dashboard");

		// Retrieve Link using it's id and click on it
		webDriver.findElement(By.id("editUser")).click();

		// assert title of edit form to ensure the right page is accessed
		Assert.assertTrue(webDriver.getTitle().contains("Edit Profiles"));

		// enter credentials in elements located by id
		// enter a valid username
		webDriver.findElement(By.id("editUsername")).clear();
		webDriver.findElement(By.id("editUsername")).sendKeys("nameEdit");

		// enter a valid email address
		webDriver.findElement(By.id("editEmail")).clear();
		webDriver.findElement(By.id("editEmail")).sendKeys("edit@abc.com");

		// enter a valid password
		webDriver.findElement(By.id("editPassword")).clear();
		webDriver.findElement(By.id("editPassword")).sendKeys("editPass");

		// submit the form
		webDriver.findElement(By.id("editSubmit")).click();

		// assert title of dashboard to check that the page led to the right dashboard
		Assert.assertTrue(webDriver.getTitle().contains("User Profiles"));

		System.out.println("User successfully edited!");
	}

	@BeforeTest
	public void beforeTest() {
		// Setting system properties of ChromeDriver
		// to amend directory path base on your local file path
		String chromeDriverDir = "C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", chromeDriverDir);

		// initialize FirefoxDriver at the start of test
		webDriver = new ChromeDriver();
	}

	@AfterTest
	public void afterTest() {
		// Quit the ChromeDriver and close all associated window at the end of test
		webDriver.quit();
	}

}
