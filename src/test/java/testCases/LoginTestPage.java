package testCases;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import page.DatabasePage;
import page.LoginPage;

public class LoginTestPage extends TestBase {
	LoginPage loginPageObj;
	SoftAssert softAssert = new SoftAssert();
	
	@BeforeMethod 
	public void setUp() {
		initializeDriver();
		loginPageObj = PageFactory.initElements(driver, LoginPage.class);
	}
	
	@Test(priority=1)
	public void LoginTest() throws InterruptedException, ClassNotFoundException, SQLException, IOException {
		loginPageObj.enterUserName("demo@techfios.com");
		Thread.sleep(2000);
		loginPageObj.enterPassword("abc123");
		Thread.sleep(2000);
		loginPageObj.clickOnSignInButton();
		Thread.sleep(3000);
		
		takeScreenshotAtEndOfTest(driver);
	}
	@Test(priority=2)
	public void loginPageTitleTest() throws ClassNotFoundException, SQLException, InterruptedException {
		loginPageObj.enterUserName("demo@techfios.com");
		Thread.sleep(2000);
		loginPageObj.enterPassword("abc123");
		Thread.sleep(2000); 
		loginPageObj.clickOnSignInButton();
		String expectedTitle = "Dashboard- iBilling";
		String actualTitle = loginPageObj.getPageTitle();
		Assert.assertEquals(expectedTitle , actualTitle);
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
