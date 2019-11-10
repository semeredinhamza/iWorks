import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Kim_Tests {

	private static String title;
	private static int titleLength;
	private static String pageSource;
	private static int pageSourceLength;
	private static String actualUrl;

	// get getters and setters for the pageSourceLength

	public static int getPageSourceLength() {
		return pageSourceLength;
	}

	public static void setPageSourceLength(int pageSourceLength) {
		Kim_Tests.pageSourceLength = pageSourceLength;
	}

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\ws\\Selenium\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.get("https://www.google.com");

		driver.findElement(By.name("q")).sendKeys("https://iWorks.appspot.com");
		driver.findElement(By.name("btnK")).submit();

		// Navigate to Kimonge website login page

		driver.get("http://iWorks.appspot.com");

		// login using invalid id and password

		driver.findElement(By.id("emailInput")).sendKeys("keziaoketch@gmail.com");
		driver.findElement(By.id("passInput")).sendKeys("S2298j986@");
		driver.findElement(By.className("Login")).click();

		// login using valid id and password

		driver.findElement(By.id("emailInput")).sendKeys("jjmacoyala@gmail.com");
		driver.findElement(By.id("passInput")).sendKeys("S2298j986@");
		driver.findElement(By.className("Login")).click();
		

		// get page information

		title = driver.getTitle();
		titleLength = driver.getTitle().length();

		System.out.println("Title of the page is : " + title);
		System.out.println("Length of the title is : " + titleLength);

		pageSource = driver.getPageSource();

		setPageSourceLength(pageSource.length());

		System.out.println("Total length of the Page Source is : " + pageSourceLength);

		actualUrl = driver.getCurrentUrl();

		if (actualUrl.equals("http://iWorks.appspot.com")) {
			System.out.println("Verification Successful - The correct Url is opened.");
		} else {
			System.out.println("Verification Failed - An incorrect Url is opened.");
		}

	}

}
