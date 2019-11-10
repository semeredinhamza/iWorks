import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDowns {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\ws\\Selenium\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		// login

		driver.get("http://iWorks.appspot.com");
		
		
		

		driver.findElement(By.id("emailInput")).sendKeys("keziaoketch@gmail.com");
		driver.findElement(By.id("passInput")).sendKeys("S2298j986@");
		driver.findElement(By.className("Login")).click();
		
		driver.findElement(By.linkText("Create Your Account")).click();
		
		/*Select dropStaff = new Select(driver.findElement(By.className("dropdown-menu")));
		
		dropStaff.selectByIndex(0);*/
				

	}

}
