package com.harshitJava.SeleniumAutomationStepByStep;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
/**
 * Hello world!

 *
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.*;

public class App 
{
	  WebDriver driver=null;
	  int length=0;
	  Logger log = LogManager.getLogger("Project Started");
	  @Test
		public void setAndLaunch() throws InterruptedException {
			
			driver = new FirefoxDriver();
			log.info("Browser Opened");
			driver.get("https://www.makemytrip.com/railways/");
			String title = driver.getTitle();
			System.out.println("Title of the page is: " + title);
			String url = driver.getCurrentUrl();
			System.out.println("URL of the page is: " + url);
			log.info("Home Page visited");

		}

		@Test(dependsOnMethods = "setAndLaunch")
		public void selectLocation() throws InterruptedException {

			// click on element using xpath
			driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div/div[1]/label/span")).click();
			// click on element using id
			
			Thread.sleep(1000);
			

		}

		@Test(dependsOnMethods = "selectLocation")
		public void selectFrom() throws InterruptedException {
			// click on element using xpath
			driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div/div[1]/label/span")).click();
			// click on element using id

			Thread.sleep(1000);
			driver.findElement(
					By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div/div[1]/div[1]/div/div/div/input"))
					.sendKeys("Delhi");
			// wait until element is not visible
			Thread.sleep(2000);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			// find the length of all the elements find using selector
			int length = driver.findElements(By.cssSelector("ul.react-autosuggest__suggestions-list > li")).size();
			System.out.println("Length of the list is: " + length);

			// define a loop to iterate through the list
			for (int i = 0; i < length; i++) {
				// find the element using index
				String element = driver.findElements(By.cssSelector(
						"ul.react-autosuggest__suggestions-list > li > div > div > p.searchedResult.font14.darkText > span"))
						.get(i).getText();
				System.out.println("Element is: " + element);
				// check if the element is equal to the search term
				if (element.equals("Delhi")) {
					// click on the element
					driver.findElements(By.cssSelector(
							"ul.react-autosuggest__suggestions-list > li > div > div > p.searchedResult.font14.darkText > span"))
							.get(i).click();
					break;
				}
			}
			log.info("From location selected");

		}

		@Test(dependsOnMethods = "selectFrom")
		public void selectDestination() throws InterruptedException {
			// Selecting Destination
			// click on element using xpath
			driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div/div[2]/label/span")).click();
			// click on element using id

			Thread.sleep(1000);
			driver.findElement(
					By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div/div/div/input"))
					.sendKeys("Lucknow");
			// wait until element is not visible
			Thread.sleep(2000);

			// find the length of all the elements find using selector
			int length = driver.findElements(By.cssSelector("ul.react-autosuggest__suggestions-list > li")).size();
			System.out.println("Length of the list is: " + length);

			// define a loop to iterate through the list
			for (int i = 0; i < length; i++) {
				// find the element using index
				String element = driver.findElements(By.cssSelector(
						"ul.react-autosuggest__suggestions-list > li > div > div > p.searchedResult.font14.darkText > span"))
						.get(i).getText();
				System.out.println("Element is: " + element);
				// check if the element is equal to the search term
				if (element.equals("Lucknow")) {
					// click on the element
					driver.findElements(By.cssSelector(
							"ul.react-autosuggest__suggestions-list > li > div > div > p.searchedResult.font14.darkText > span"))
							.get(i).click();
					break;
				}
			}
			log.info("Destination location selected");
		}

		@Test(dependsOnMethods = "selectDestination")
		public void selectDate() throws InterruptedException {
			// Selecting Date
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div/div[3]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[1]/div[3]/label/input"))
					.click();
			int k = 0;
			while (k != 3) {
				driver.findElement(By.xpath(
						"/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div[3]/div[1]/div/div/div/div[2]/div/div[1]/span[2]"))
						.click();
				k++;
			}
			driver.findElement(By.xpath(
					"/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[3]/div[4]/div[2]"))
					.click();

			log.info("Given Date Selected");
		}

		@Test(dependsOnMethods = "selectDate")
		public void selectClass() throws InterruptedException {
			// Selecting Class
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div/div[4]")).click();
			int length = driver.findElements(By.cssSelector("ul.travelForPopup > li")).size();
			System.out.println("Length of the list is: " + length);
			for (int i = 0; i < length; i++) {
				String element = driver.findElements(By.cssSelector("ul.travelForPopup > li")).get(i).getText();
				System.out.println("Element is: " + element);
				if (element.equals("Third AC")) {
					driver.findElements(By.cssSelector("ul.travelForPopup > li")).get(i).click();
					break;
				}
			}
			log.info("Class Selected");
		}

		@Test(dependsOnMethods = "selectClass")
		public void search() throws InterruptedException {
			// Clicking Search button
			Thread.sleep(2000);
			driver.findElement(By.xpath("// *[@id='root']/div/div[2]/div/div/div/div[2]/p/a")).click();
			log.info("Closing Browswer");
			driver.close();

		}

}