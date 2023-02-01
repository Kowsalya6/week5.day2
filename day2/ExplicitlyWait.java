package week5.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitlyWait {

	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.leafground.com/waits.xhtml");
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[1]")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='I am here']"))));
		driver.findElement(By.xpath("(//span[text()='Click'])[2]")).click();
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait3.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//span[text()='I am about to hide']"))));
		driver.findElement(By.xpath("//span[text()='Click First Button']")).click();
		WebElement clickable = driver.findElement(By.xpath("//span[text()='Click Second']"));
		wait.until(ExpectedConditions.elementToBeClickable(clickable));
		driver.findElement(By.xpath("(//span[text()='Click'])[3]")).click();
		WebElement findElement = driver.findElement(By.xpath("//span[text()='Did you notice?']"));
        String text1 = driver.findElement(By.xpath("//span[text()='Did you notice?']")).getText();
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait2.until(ExpectedConditions.textToBePresentInElement(findElement, text1));
		System.out.println(text1);
		
	}

}

