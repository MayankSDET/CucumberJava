package stepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

public class orangeloginstepdepfination {

	public static WebDriver driver;


	@Given("^user is already on the login page$")
	public void user_is_already_on_the_login_page(){
		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");


	}

	@When("^tiltle of the login page is verified$")
	public void tiltle_of_the_login_page_is_verified() throws InterruptedException{
		String title = driver.getTitle();
		String expectedTitle= "OrangeHRM";
		Assert.assertEquals("Title does not match!", expectedTitle, title);
		Thread.sleep(5000);

	}

	@Then("^User enters the username and passowrd$")
	public void user_enters_the_username_and_passowrd(){
		WebDriverWait webdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
		webdwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")));

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");

	}

	@Then("^User enters the \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_the_and(String username, String password) {
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@placeholder='Username']"))));
		driver.findElement(By.xpath("(//input[@placeholder='Username'])[1]")).sendKeys(username);
		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys(password);

	}

	@Then("^User clicks on login button$")
	public void user_clicks_on_login_button(){
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Then("^User is on the home page$")
	public void user_is_on_the_home_page() {

		String hometitle = driver.getTitle();
		String homeexpectedTitle= "OrangeHRM";
		Assert.assertEquals("Title does not match!", homeexpectedTitle, hometitle);
		driver.quit();
	}


}
