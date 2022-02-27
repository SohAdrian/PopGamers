//package devops.popgamers;
//
//import org.testng.annotations.Test;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.AfterTest;
//
//public class NewPopGamersTest {
//  @Test
//  public void f() {
//  }
//  @BeforeTest
//  public void beforeTest() {
//  }
//
//  @AfterTest
//  public void afterTest() {
//  }
//
//}

package devops.popgamers;

import org.openqa.selenium.By;

//import necessary Selenium WebDriver classes
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewPopGamersTest {
	// declare Selenium WebDriver
	private WebDriver webDriver;
	
	@Test
	public void checkAddGame() {
		webDriver.navigate().to("http://localhost:8090/PopGamers/ReviewServlet/GameListing");
		
		webDriver.navigate().to("http://localhost:8090/PopGamers/GamePage.jsp");

		// Get the WebElement corresponding to the gameName
		WebElement gameName = webDriver.findElement(By.name("gameName"));

		// Get the WebElement corresponding to the gamePicture
		WebElement gamePicture = webDriver.findElement(By.name("gamePicture"));

		// Get the WebElement corresponding to the gameDescription
		WebElement gameDescription = webDriver.findElement(By.name("gameDescription"));

		// Get the WebElement corresponding to the genre
		WebElement genre = webDriver.findElement(By.name("genre"));

		// Set a Game info
		gameName.sendKeys("Dead by Daylight");
		gamePicture.sendKeys(
				"https://cdn2.unrealengine.com/egs-deadbydaylight-behaviourinteractive-s1-2560x1440-bb48d8b9e240.jpg?h=480&resize=1&w=854");
		gameDescription.sendKeys("Dead by Daylight is a ");
		genre.sendKeys("Horror/Survival");

		// delete html input values
		gameName.clear();
		gamePicture.clear();
		gameDescription.clear();
		genre.clear();

		WebElement addGameBtn = webDriver.findElement(By.className("btn"));
		addGameBtn.click();

		System.out.println("New Game Added");

		//webDriver.navigate().to("http://localhost:8090/PopGamers/ReviewServlet/GameListing");
		// driver.close();
	}

	
	// Need helo
	@Test
	public void DeleteGame() {

		// navigate the the correct web page
		webDriver.navigate().to("http://localhost:8090/PopGamers/ReviewServlet/GameListing");
		

		//webDriver.findElement(By.xpath("//a[@href='delete?DeadByDeadlight=<c:out value='${game.Valorant}']")).click();
		
		webDriver.findElement(By.xpath("//a[class=\"btn btn-danger\"]")).click();
		
		System.out.println("Deleted Game");

		// driver.close();
	}
	
	
	//Check if add GamePage can go to GameListing with the button
	@Test
	public void checkAddGameTitle() {
		// Load website as a new page
		webDriver.navigate().to("http://localhost:8090/PopGamers/GamePage.jsp");

		// Assert the title to check that we are indeed in the correct website
		Assert.assertEquals(webDriver.getTitle(), "PopGamers");

		System.out.println("title: " + webDriver.getTitle());

		// Retrieve link using Xpath and click on it
		webDriver.findElement(By.className("btn")).click();

		// Assert the new title to check that the title contain Wikipedia and the button
		// had successfully bring us to the new page
		Assert.assertTrue(webDriver.getTitle().contains("GameListing"));
		System.out.println("new title: " + webDriver.getTitle());
	}


	@BeforeTest
	public void beforeTest() {
		// Setting system properties of ChromeDriver
		// to amend directory path base on your local file path
		String chromeDriverDir = "C:\\Program Files\\Google\\Chrome\\chromedriver.exe";

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
