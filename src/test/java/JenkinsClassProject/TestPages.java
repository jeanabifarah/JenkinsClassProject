package JenkinsClassProject;

import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPages {

	@Test
	public void TestCaseWithoutPOM() {
		try{
			System.setProperty("webdriver.chrome.driver", "C:\\Jean\\CeleniumWebdriver\\chrome\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			//Load a local html file.
			driver.get("C://Jean//Misc//Projects//HTMLApp//index.html");
			//Click the Contacts tab
			driver.findElement(By.linkText("Contact")).click();
			//Enter the User ID 
			driver.findElement(By.id("txtUserID")).sendKeys("jabifarah");
			//Enter the Password
			driver.findElement(By.id("txtPwd")).sendKeys("conest");
			//Enter the Email
			driver.findElement(By.id("txtEmail")).sendKeys("jean_farah@yahoo.com");
			//Enter the Address
			driver.findElement(By.id("txtAddress")).sendKeys("386 Pickering street.");
			//Enter the City
			driver.findElement(By.id("txtCity")).sendKeys("Manchester");
			//Select State. Get the drop down as a Select using it's name attribute
			Select state = new Select(driver.findElement(By.id("lstStates")));
			// With Select class we can select an option in drop down using Visible text
			state.selectByVisibleText("AZ");
			//Select your gender
			driver.findElement(By.id("male")).click();
			//click the Add record button.
			driver.findElement(By.id("btnGetResult")).click();
			//click the Clear form button
			driver.findElement(By.id("clrForm")).click();
			// Get the Alert
			Alert alert = driver.switchTo().alert();
			// Get the text displayed on Alert
			String textOnAlert = alert.getText();
			//System.out.println("The text on the alert box is: " + textOnAlert);
			Assert.assertEquals(textOnAlert, "Are you sure you want to clear the form?");
			// 	Click OK button, by calling accept method
			alert.accept();
			//Link Visit W3Schools!
			driver.findElement(By.linkText("Visit W3Schools!")).click();
			//Verify that the new tab is loaded properly.
			//switch using actions class
			Actions action= new Actions(driver);
			action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
			Thread.sleep(15000);
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			// 	change focus to new tab.
			driver.switchTo().window(tabs.get(1));
			//get the title of the tab.
			String pageTitle = driver.getTitle();
			//System.out.println("The title of the page is: " + pageTitle);
			Assert.assertEquals(pageTitle, "W3Schools Online Web Tutorials");
		}
		catch(Exception e){
			System.out.println("Something went wrong." + e);
		}finally {
	      System.out.println("The script is finished.");
		}

	}
}
