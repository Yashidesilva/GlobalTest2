package login.we.globaltradingnetwork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class loginTest1 {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://difc.globaltradingnetwork.com/web/login");
        driver.manage().window().maximize();
        Thread.sleep(10000);
    }

    // Test 1 - empty fileds
    @Test
    public void emptyFields() throws InterruptedException {
        driver.findElement(By.id("LoginButton")).click();
        String msg1 = driver.findElement(By.xpath("//div[@class='login_error_msg']")).getText();
        Thread.sleep(1000);
        System.out.println("Test 1 error Message : " + msg1);
    }

    // Test 2 - input username and password
    @Test
    public void validUser() throws InterruptedException {
        driver.findElement(By.id("form-input-live-u")).sendKeys("TestUserName");
        driver.findElement(By.id("form-input-live-p")).sendKeys("TestPasswprd");
        driver.findElement(By.id("LoginButton")).click();
        Thread.sleep(12000);
        String msg2 = driver.findElement(By.xpath("//div[@class='login_error_msg'][1]")).getText();
        System.out.println("Test 2 error Message : " + msg2);
        Thread.sleep(3000);
    }

    @AfterMethod
    public void afterMethod(){
        driver.close();
    }
}
