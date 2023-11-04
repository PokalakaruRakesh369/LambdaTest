package Test1;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGTask1 {
	private WebDriverWait wait;
private SoftAssert softAssert;
private boolean acceptNextAlert = true;

public String username = "rakeshpokalakaru";
public String accesskey = "PTuoAijNaikCcJvqols8wqCZpyHKus0G6cfIT3SpMdpRJTyeVy";
public static RemoteWebDriver driver=null;
public String gridURL = "@hub.lambdatest.com/wd/hub";
boolean status = false;
@BeforeClass
public void setUp() throws Exception {
   DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("browserName", " Chrome");
    capabilities.setCapability("version", " 88.0");
    capabilities.setCapability("platform", "  Windows 10"); // If this cap isn't specified, it will just get the any available one
    capabilities.setCapability("build", "MySampleTest1");
    capabilities.setCapability("name", "MySampleTestOne");
    try {
    	driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
    } catch (MalformedURLException e) {
        System.out.println("Invalid grid URL");
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}
@Test
public void testScenario1() throws InterruptedException {
	 driver.get("https://www.lambdatest.com/selenium-playground/");
     String pageTitle = driver.getTitle();
     Thread.sleep(3000);
     Assert.assertEquals("Selenium Grid Online | Run Selenium Test On Cloud", pageTitle);
 }
@Test
public void testScenario2() throws InterruptedException {
    WebElement checkbox_demo_link = driver.findElement(By.xpath("//a[text()='Checkbox Demo']"));
    checkbox_demo_link.click();
    WebElement single_checkbox = driver.findElement(By.xpath("//label[text()='Click on check box']"));
    single_checkbox.click();
    Thread.sleep(3000);
	if( single_checkbox.isSelected()) {
		
		System.out.println("Checkbox is selected.");
	}
		else {
		System.out.println("Checkbox is not selected.");
	
		}
	
	WebElement single_checkbox1 = driver.findElement(By.xpath("//label[text()='Click on check box']"));
    single_checkbox1.click();
    
    
    if(!single_checkbox1.isSelected()){
		System.out.println("Checkbox is unselected.");

       }
    	else {
    		System.out.println("Checkbox is still selected.");

    	}
}
@Test
public void testScenario3() throws InterruptedException {
    driver.get("https://www.lambdatest.com/selenium-playground/");
    driver.findElement(By.linkText("Javascript Alerts")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
    Assert.assertEquals(closeAlertAndGetItsText(), "I am an alert box!");
    driver.quit();
  }
private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
/*@AfterMethod
public void tearDown() {
driver.quit();
}*/
}

