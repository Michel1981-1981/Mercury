package ReservarTicket;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ReservaTicket {
	
	private WebDriver driver;
	@BeforeEach
	public void setUp() throws Exception {
		System.setProperty("Webdriver.chrome.driver", "C:\\Automação\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 
	}

	@AfterEach
	void tearDown() throws Exception {
		 driver.quit();
	}

	public void UserName(WebDriver driver) throws InterruptedException {	
		
		driver.findElement(By.name("userName")).sendKeys("mercury");
		Thread.sleep(1000);
		
		driver.findElement(By.name("password")).sendKeys("mercury");
		Thread.sleep(1000);		
		
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);
	}
	
	public void FlightDetails (WebDriver driver) throws InterruptedException {	
		
		Select dropdown = new Select(driver.findElement(By.name("fromPort")));
		dropdown.selectByVisibleText("London");
		Thread.sleep(1000);
		
		Select dropdown1 = new Select(driver.findElement(By.name("toPort")));
		dropdown1.selectByVisibleText("Zurich");
		Thread.sleep(1000);
		
		Select dropdown2 = new Select(driver.findElement(By.name("toMonth")));
		dropdown2.selectByVisibleText("December");
		Thread.sleep(1000);
		
		Select dropdown3 = new Select(driver.findElement(By.name("toDay")));
		dropdown3.selectByVisibleText("20");
		Thread.sleep(1000);
		
	}
	
	public void Preferences (WebDriver driver) throws InterruptedException {	
		
		driver.findElement(By.xpath("//font/font/input[2]")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.name("findFlights")).click();
		Thread.sleep(1000);
	}
	
	public void Depart (WebDriver driver) throws InterruptedException {
		
		driver.findElement(By.name("reserveFlights")).click();
		Thread.sleep(1000);
	}
	
	
	public void BookAFlight (WebDriver driver) throws InterruptedException {
		
		driver.findElement(By.name("passFirst0")).sendKeys("Michel");
		Thread.sleep(1000);
		
		driver.findElement(By.name("passLast0")).sendKeys("Eduardo");
		Thread.sleep(1000);
		
		driver.findElement(By.name("creditnumber")).sendKeys("5468723489");
		Thread.sleep(1000);
		
		driver.findElement(By.name("buyFlights")).click();
		Thread.sleep(1000);
	}


	@Test
	public void test() throws InterruptedException {
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		assertTrue("Titulo da página difere do esperado", driver.getTitle().contentEquals("ProtoCommerce"));
				 
		Thread.sleep(3000);

		UserName(driver);
		Thread.sleep(2000);

		FlightDetails(driver);
		Thread.sleep(2000);
		
		Preferences(driver);
		Thread.sleep(2000);
		
		Depart(driver);
		Thread.sleep(2000);
		
		BookAFlight(driver);
		Thread.sleep(2000);
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	private void assertTrue(String string, boolean contentEquals) {
		// TODO Auto-generated method stub
		
	}
}
