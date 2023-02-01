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

public class Myntra {

	public static void main(String[] args) throws IOException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.myntra.com/");
		WebElement mens = driver.findElement(By.xpath("(//a[@class='desktop-main'])[1]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(mens).perform();
		driver.findElement(By.xpath("(//a[text()='Jackets'])[1]")).click();
		String text = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		String totalcount = text.replaceAll("[^0-9]", "");
		System.out.println(totalcount);
		String count1 = driver.findElement(By.xpath("(//span[@class='categories-num'])[1]")).getText();
		String count2 = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText();
		String count3 = count1.replaceAll("[^0-9]", "");	
		String count4 = count2.replaceAll("[^0-9]", "");
		System.out.println(count3);
		System.out.println(count4);
		if(totalcount==(count3+count4))
		{
			System.out.println("sum of categories count are matched with totalcount");
		}
		else
		{
			System.out.println("sum of categories count are not matched with totalcount");
		}
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search brand']")).sendKeys("Duke");
		driver.findElement(By.xpath("//input[@value='Duke']//parent::label")).click();
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
		List<WebElement> duke = driver.findElements(By.xpath("//h3[@class='product-brand']"));
		for (int i = 0; i <duke.size(); i++) {
		System.out.println(duke.get(i).getText());
		}
		WebElement sort = driver.findElement(By.xpath("//div[@class='sort-sortBy']"));
		Actions action = new Actions(driver);
		action.moveToElement(sort).perform();
		driver.findElement(By.xpath("(//label[@class='sort-label '])[4]")).click();
		String price = driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]")).getText();
		System.out.println(price);
		driver.findElement(By.xpath("(//img[@class='img-responsive'])[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> lst = new ArrayList<String>(windowHandles);
		driver.switchTo().window(lst.get(1));
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("snap/dukemyntra.png");
		FileUtils.copyFile(source, dest);
		driver.findElement(By.xpath("//span[text()='WISHLIST']")).click();
		driver.close();
		driver.switchTo().window(lst.get(0));
		driver.close();
	}

}

/*Myntra
1) Open https://www.myntra.com/
2) Mouse hover on MeN 
3) Click Jackets 
4) Find the total count of item 
5) Validate the sum of categories count matches
6) Check jackets
7) Click + More option under BRAND
8) Type Duke and click checkbox
9) Close the pop-up x
10) Confirm all the Coats are of brand Duke
    Hint : use List 
11) Sort by Better Discount
12) Find the price of first displayed item
Click on the first product
13) Take a screen shot
14) Click on WishList Now
15) Close Browser
*/
