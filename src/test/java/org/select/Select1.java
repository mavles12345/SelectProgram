package org.select;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Select1 {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"F:\\\\Eclipse-workspace\\\\org.sample\\\\driver\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();

		Thread.sleep(4000);

		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("jack");

		driver.findElement(By.name("lastname")).sendKeys("M");
		driver.findElement(By.name("reg_email__")).sendKeys("jackmavles@gmail.com");
		driver.findElement(By.name("reg_passwd__")).sendKeys("jackmavles");

		WebElement days = driver.findElement(By.id("day"));

		Select s = new Select(days);

		List<WebElement> options = s.getOptions();

		for (WebElement x : options) {

			String each = x.getText();

			System.out.println(each);

		}

		s.selectByIndex(10);
		boolean multiple = s.isMultiple();
		System.out.println(multiple);

		try {

			s.deselectByIndex(10);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		WebElement month = driver.findElement(By.id("month"));

		Select m = new Select(month);

		List<WebElement> allmonth = m.getOptions();

		for (WebElement y : allmonth) {

			String each = y.getAttribute("value");

			System.out.println(each);

		}

		m.selectByVisibleText("Dec");

		WebElement year = driver.findElement(By.id("year"));

		Select y = new Select(year);

		List<WebElement> allyear = y.getOptions();

		for (int i = 0; i < allyear.size(); i++) {

			System.out.println(allyear.get(i).getAttribute("value"));

		}

		y.selectByVisibleText("2020");

		driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();

		List<WebElement> allRadio = driver.findElements(By.xpath("//input[@type='radio']"));

		int size = allRadio.size();
		System.out.println(size);

		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		File des = new File("F:\\Eclipse-workspace\\SelectProgram\\Screenshot\\screen.png");
		FileUtils.copyFile(src, des);

	}
}
