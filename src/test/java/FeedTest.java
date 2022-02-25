import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class FeedTest {
	private WebDriver webDriver;
	
	@Test
	public void checkHomeButton() {
		// Load website as a new page
		webDriver.navigate().to("http://localhost:8080/PopGamers/FeedServlet/dashboard");

		// Retrieve link using its id and click on it
		webDriver.findElement(By.id("returnHome")).click();

		// assert title of home page to ensure the right page is accessed
		Assert.assertTrue(webDriver.getTitle().contains("GameListing"));

		System.out.println("Successfully reached home page!");
	}
  @BeforeTest
  public void beforeTest() {
	// Setting system properties of ChromeDriver
			// to amend directory path base on your local file path
			String chromeDriverDir = "C:\\Program Files (x86)\\Google\\Chrome\\chromedriver_win32\\chromedriver.exe";

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
