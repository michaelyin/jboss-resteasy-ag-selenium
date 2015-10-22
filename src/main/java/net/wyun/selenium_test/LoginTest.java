package net.wyun.selenium_test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class LoginTest 
{
    public static void main( String[] args ) throws InterruptedException
    {
    	// Create a new instance of the Firefox driver
    			System.setProperty("webdriver.chrome.driver", "/opt/webdriver/chromedriver");
    			WebDriver driver = new ChromeDriver();
    			// Wait For Page To Load
    			// Put a Implicit wait, this means that any search for elements on the
    			// page
    			// could take the time the implicit wait is set for before throwing
    			// exception
    			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    			// Navigate to URL
    			driver.get("http://localhost:8080/resteasy-test-0.1.0/");
    			// Maximize the window.
    			driver.manage().window().maximize();
    			// Enter UserName
    			String userName = "ag"; //
    			String passWord = "ag";
    			driver.findElement(By.xpath("//input[@name='j_username']")).sendKeys(userName);
    			// Enter Password
    			driver.findElement(By.xpath("//input[@name='j_password']")).sendKeys(passWord);
    			// Wait For Page To Load
    			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    			// Click on 'Sign In' button
    			driver.findElement(By.xpath("//input[@value='login']")).click();
    			
    			
    			WebElement body = driver.findElement(By.xpath("//body"));
    			
    			String html = body.getAttribute("innerHTML");
    			//FileHelper.save(html, "orderSummary.html");
    			
    			if("hello\n".equals(html)){
    				System.out.println("Login Successful!");
    				driver.get("http://localhost:8080/resteasy-test-0.1.0/rest/ag/employee/99");
    				body = driver.findElement(By.xpath("//pre"));
    				System.out.println("Get employee with id 99:");
    				System.out.println(body.getAttribute("innerHTML"));
    			}else{
    				System.out.println("Login Failure!!!");
    			}
    			
    			System.out.println(html);
    			
    			
    			TimeUnit.SECONDS.sleep(10);
    			
    		//	driver.findElement(By.xpath("//div[@id='topNavLeft']/a")).click();
    			
    			System.out.println("close browser now.");
    			driver.close();
    }
}
