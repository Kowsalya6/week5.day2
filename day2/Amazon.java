package week5.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


public class Amazon {

	public static void main(String[] args) throws IOException, InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		String price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[2]")).getText();
		System.out.println(price);
		String text2 = driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]")).getText();
		System.out.println(text2);
		WebElement stars = driver.findElement(By.xpath("(//i[@class='a-icon a-icon-star-small a-star-small-4 aok-align-bottom'])[1]"));
		stars.click();
		Actions builder = new Actions(driver);
		builder.moveToElement(stars).perform();
		String text3 = driver.findElement(By.xpath("//a[contains(text(),'63%')]")).getText();
		System.out.println(text3);
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[2]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> lst = new ArrayList<String>(windowHandles);
		driver.switchTo().window(lst.get(1));
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("snap/mobile.png");
		FileUtils.copyFile(source, dest);
		driver.findElement(By.xpath("//input[@title='Add to Shopping Cart']")).click();
		String subtotal = driver.findElement(By.xpath("(//span[@class='a-price-whole']//parent::span)[2]")).getText();
		System.out.println(subtotal);
		if(price.equalsIgnoreCase(subtotal))
		{
			System.out.println("subtotal is correct");
		}
		else
		{
				System.out.println("subtotal is not correct");
		}
	}

}
/*1.Load the uRL 
2.search as oneplus 9 pro 
3.Get the price of the first product
4. Print the number of customer ratings for the first displayed product
5. Mouse Hover on the stars
6. Get the percentage of ratings for the 5 star.
7. Click the first text link of the first image
8. Take a screen shot of the product displayed
9. Click 'Add to Cart' button
10. Get the cart subtotal  and verify if it is correct.*/