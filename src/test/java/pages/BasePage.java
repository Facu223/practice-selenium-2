package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.Assert;

public class BasePage {
	protected static WebDriver driver;
	private static WebDriverWait wait;
	private static Actions action;
	
	static {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		driver = new ChromeDriver(chromeOptions);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public BasePage(WebDriver driver) {
		BasePage.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public static void navigateTo(String url) {
		driver.get(url);
	}
	
	private WebElement Find(String locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}
	
	public void clickElement(String locator) {
		Find(locator).click();
	}
	
	public void write(String locator, String textToWrite) {
		Find(locator).clear();
		Find(locator).sendKeys(textToWrite);
	}
	
	public void selectFromDropdownByValue(String locator, String valueToSelect) {
		Select dropdown = new Select(Find(locator));
		dropdown.selectByValue(valueToSelect);
	}
	
	public void selectFromDropdownByIndex(String locator, int valueToSelect) {
		Select dropdown = new Select(Find(locator));
		dropdown.selectByIndex(valueToSelect);
	}
	
	public void hoverOverElement(String locator) {
		action.moveToElement(Find(locator));
	}
	
	public void doubleClick(String locator) {
		action.doubleClick(Find(locator));
	}
	
	public void rightClick(String locator) {
		action.contextClick(Find(locator));
	}
	
	public void switchToiFrame(String iFrameIndex) {
		driver.switchTo().frame(iFrameIndex);
	}
	
	public void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}
	
	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}
	
	public String textFromElement(String locator) {
		return Find(locator).getText();
	}
	
	public boolean elementIsDisplayed(String locator) {
		return Find(locator).isDisplayed();
	}
	
	public boolean isSelected(String locator) {
		return Find(locator).isSelected();
	}
	
	
	
	
	public static void closeBrowser() {
		driver.quit();
	}
}