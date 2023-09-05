package demo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGTodo{
    public String username = "pokalakarurakesh369";
    public String accesskey = "pt2J85LAiV1Vzi39rlwx57yUm0RaqMhSvk4NXRE6jbcYMZLHex";
    public static RemoteWebDriver driver = null;
    public String gridURL = "@hub.lambdatest.com/wd/hub";
    boolean status = false;
    @BeforeClass
    public void setUp() throws Exception {
       DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("version", "70.0");
        capabilities.setCapability("platform", "win10"); // If this cap isn't specified, it will just get the any available one
        capabilities.setCapability("build", "LambdaTestSampleApp");
        capabilities.setCapability("name", "LambdaTestJavaSample");
        try {
            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
        } catch (MalformedURLException e) {
            System.out.println("Invalid grid URL");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
  
    @Test
    public void scenarioOne() throws Exception {
      driver.get("https://www.lambdatest.com/selenium-playground/");
      driver.findElement(By.linkText("Simple Form Demo")).click();
      String url=driver.getCurrentUrl();
      Assert.assertTrue(url.contains("simple-form-demo"),"Both the urls are not same");
      driver.findElement(By.id("user-message")).click();
      driver.findElement(By.id("user-message")).clear();
      String text="Test";
      driver.findElement(By.id("user-message")).sendKeys(text);
      driver.findElement(By.id("showInput")).click();
      String returnText=driver.findElement(By.id("message")).getText();
      Assert.assertEquals(text, returnText,"Both the text are not same");
    }
    @Test
    public void  scenarioTwo() throws Exception {
      driver.get("https://www.lambdatest.com/selenium-playground/");
      driver.findElement(By.linkText("Drag & Drop Sliders")).click();
      driver.findElement(By.xpath("//input[@value='15']")).clear();
      String value="95";
      driver.findElement(By.xpath("//input[@value='15']")).sendKeys(value);
      driver.findElement(By.xpath("//input[@value='15']")).click();
      String valueInsliderBox=driver.findElement(By.xpath("//output[@id='rangeSuccess']")).getText();
      Assert.assertEquals(value, valueInsliderBox,"Both the sliderBox are not same");  
    }
    @Test
    public void scenarioThree() throws Exception {
      driver.get("https://www.lambdatest.com/selenium-playground/");
      driver.findElement(By.linkText("Input Form Submit")).click();
      driver.findElement(By.xpath("//form[@id='seleniumform']/div[6]/button")).click();
      driver.findElement(By.id("name")).click();
      driver.findElement(By.id("name")).clear();
      driver.findElement(By.id("name")).sendKeys("Test");
      driver.findElement(By.id("inputEmail4")).click();
      driver.findElement(By.id("inputEmail4")).clear();
      driver.findElement(By.id("inputEmail4")).sendKeys("abcd@yopmail.com");
      driver.findElement(By.id("inputPassword4")).click();
      driver.findElement(By.id("inputPassword4")).clear();
      driver.findElement(By.id("inputPassword4")).sendKeys("abcd1234");
      driver.findElement(By.id("company")).click();
      driver.findElement(By.id("company")).clear();
      driver.findElement(By.id("company")).sendKeys("Auto");
      driver.findElement(By.id("websitename")).click();
      driver.findElement(By.id("websitename")).clear();
      driver.findElement(By.id("websitename")).sendKeys("https://abc.com");
      driver.findElement(By.name("country")).click();
      new Select(driver.findElement(By.name("country"))).selectByVisibleText("Austria");
      driver.findElement(By.id("inputCity")).click();
      driver.findElement(By.id("inputCity")).clear();
      driver.findElement(By.id("inputCity")).sendKeys("Philadelphia");
      driver.findElement(By.id("seleniumform")).click();
      driver.findElement(By.id("inputAddress1")).click();
      driver.findElement(By.id("inputAddress1")).clear();
      driver.findElement(By.id("inputAddress1")).sendKeys("710 Wakefield Street");
      driver.findElement(By.id("inputAddress2")).click();
      driver.findElement(By.id("inputAddress2")).clear();
      driver.findElement(By.id("inputAddress2")).sendKeys("710 Wakefield Street");
      driver.findElement(By.id("inputState")).click();
      driver.findElement(By.id("inputState")).clear();
      driver.findElement(By.id("inputState")).sendKeys("Pennsylvania");
      driver.findElement(By.id("inputZip")).click();
      driver.findElement(By.id("inputZip")).clear();
      driver.findElement(By.id("inputZip")).sendKeys("19107");
      driver.findElement(By.xpath("//form[@id='seleniumform']/div[6]/button")).click();
      String returnMessage=driver.findElement(By.xpath("//p[@class='success-msg hidden']")).getText();
      Assert.assertEquals("Thanks for contacting us, we will get back to you shortly.",
    		  returnMessage,"Both the messages are not same");
    }
    @AfterClass
    public void tearDown() throws Exception {
       if (driver != null) {
            ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
            driver.quit();
        }
    }
}
