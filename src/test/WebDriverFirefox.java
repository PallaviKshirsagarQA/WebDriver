package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverFirefox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver","geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.simplilearn.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		WebDriverWait wait = new WebDriverWait(driver,50);
		
		
		WebElement LoginLink = driver.findElement(By.className("Login"));
		
		
		LoginLink.click();
		
		WebElement UserName = driver.findElement(By.name("user_login"));
		WebElement Password = driver.findElement(By.id("password"));
		WebElement LoginBtn = driver.findElement(By.name("btn_login"));
		WebElement RememberMe= driver.findElement(By.className("rememberMe"));
		
		UserName.sendKeys("xyz@abc.com");
		Password.sendKeys("Abc@12345");
		RememberMe.click();
		LoginBtn.click();
		
		WebElement ErrorMsg = driver.findElement(By.id("msg_box")); 
		
		String ActualMsg = ErrorMsg.getText();
		String ExpMsg = "The email or password you have entered is invalid.";
		
		if(ActualMsg.equals(ExpMsg)) {
			System.out.println("TC Passed");
		}else {
			System.out.println("TC Failed");
		}
		
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		System.out.println("Total Links are " + links.size());
		
		for(WebElement elm : links) {
			
			System.out.println(elm.getAttribute("href"));
		}
		
		//driver.close();
		


	}

}
