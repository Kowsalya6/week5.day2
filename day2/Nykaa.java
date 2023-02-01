package week5.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.nykaa.com/");
		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(brands).perform();
		WebElement l = driver.findElement(By.xpath("//a[text()='L']"));
		builder.moveToElement(l).perform();
		driver.findElement(By.xpath("(//a[contains(text(),'Oreal Paris')])[1] ")).click(); 
		String title = driver.getTitle();
		if(title.contains("Oreal Paris products online"))
				{
			System.out.println("The title contains L'Oreal Paris");
				}
		else
				{
			System.out.println("The title doesnot contains L'Oreal Paris");
				}
		driver.findElement(By.xpath("//span[@class='sort-name']")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		driver.findElement(By.xpath("//span[text()='Category'] ")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("(//span[text()='Hair Care'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		String text = driver.findElement(By.xpath("//span[text()='Shampoo']")).getText();
		if(text.contains("Shampoo"))//span[text()='Color Protection']
		{
			System.out.println("Filter is applied with Shampoo");
		}
		else
		{
			System.out.println("Filter is not applied with Shampoo");
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(), 'Colour Protect Shampoo')]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> lst = new ArrayList<String>(windowHandles);
		driver.switchTo().window(lst.get(1));
		driver.findElement(By.xpath("(//span[text()='180ml'])[1]")).click();
		String mrp = driver.findElement(By.xpath("(//span[text()='₹189'])[1]")).getText();
		System.out.println(mrp);
		driver.findElement(By.xpath("(//span[text()='Add to Bag'])[1]")).click();
		driver.findElement(By.xpath("//span[@class='cart-count']")).click();
		driver.switchTo().frame(0);
		String grandtotal = driver.findElement(By.xpath("(//span[contains(text(),'259')])[1]")).getText();
		String grandtotal1 = grandtotal.replaceAll("[^0-9]", "");
		System.out.println(grandtotal1);
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		//String windowHandle2 = driver.getWindowHandle();
		String windowHandle = driver.getWindowHandle();
		driver.switchTo().window(windowHandle);
		driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("kpudur");
		driver.findElement(By.xpath("//textarea[@placeholder='Road Name/ Area /Colony']")).sendKeys("Housing board, Idappadi");
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Kowsi");
		driver.findElement(By.xpath("//input[@placeholder='Phone']")).sendKeys("8825976636");
		driver.findElement(By.xpath("//input[@placeholder='Email ID']")).sendKeys("Kowsiselva6@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Pincode']")).sendKeys("637101");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Ship to this address']")).click();
		String finalgrandtotal = driver.findElement(By.xpath("//button[contains(text(),'259')]")).getText();
		String finalgrandtotal1 = finalgrandtotal.replaceAll("[^0-9]", "");
		System.out.println(finalgrandtotal1);
		if(grandtotal1.equals(finalgrandtotal1))
		{
			System.out.println("The grand total is same, Successfull");
		}
		else 
		
			{
				System.out.println("The grand total isnt same, unSuccessfull");
			}
		driver.close();
		

	}

}
