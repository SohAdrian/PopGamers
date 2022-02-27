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
		webDriver.navigate().to("http://localhost:8090/PopGamers/FeedServlet/dashboard");

		// Retrieve link using its id and click on it
		webDriver.findElement(By.id("returnHome")).click();

		// assert title of home page to ensure the right page is accessed
		Assert.assertTrue(webDriver.getTitle().contains("GameListing"));

		System.out.println("Successfully reached home page!");
	}
	
	@Test
	public void checkThreadForm() {
		// Load website as a new page
		webDriver.navigate().to("http://localhost:8090/PopGamers/FeedServlet/dashboard");

		// Retrieve link using its id and click on it
		webDriver.findElement(By.id("createThread")).click();

		// assert currentUrl of Thread form to ensure the right page is accessed
		Assert.assertTrue(webDriver.getCurrentUrl().contains("http://localhost:8090/PopGamers/createThread.jsp"));

		// enter form values in elements located by id
		// enter a title
		webDriver.findElement(By.id("title")).sendKeys("title123");

		// enter a user
		webDriver.findElement(By.id("user")).sendKeys("JonDo");

		// enter content
		webDriver.findElement(By.id("content")).sendKeys("Lorem Ipsum");

		// submit the form
		webDriver.findElement(By.id("threadSubmit")).submit();

		// assert title of dashboard to check that the page led to the right dashboard
		Assert.assertTrue(webDriver.getCurrentUrl().contains("http://localhost:8090/PopGamers/CreateThreadServlet"));

		System.out.println("Thread created!");

	}
	
	@Test
	public void checkEditDetails() {
		// Load website as a new page
		webDriver.navigate().to("http://localhost:8090/PopGamers/FeedServlet/dashboard");

		// Retrieve Link using its id and click on it
		webDriver.findElement(By.id("editForm")).click();

		// assert title of edit form to ensure the right page is accessed
		//Assert.assertTrue(webDriver.getTitle().contains("Edit Thread"));

		// enter in elements located by id
		// edit title
		webDriver.findElement(By.id("editTitle")).clear();
		webDriver.findElement(By.id("editTitle")).sendKeys("editTitle");

		// edit content
		webDriver.findElement(By.id("editContent")).clear();
		webDriver.findElement(By.id("editContent")).sendKeys("sleep");

		// edit user
		webDriver.findElement(By.id("editUser")).clear();
		webDriver.findElement(By.id("editUser")).sendKeys("MaryLee");

		// submit the form
		webDriver.findElement(By.id("saveChanges")).click();

		// assert title of dashboard to check that the page led to the right dashboard
		Assert.assertTrue(webDriver.getTitle().contains("All Feeds"));

		System.out.println("Thread successfully edited!");
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
