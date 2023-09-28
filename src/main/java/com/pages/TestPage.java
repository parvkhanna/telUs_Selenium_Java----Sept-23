package com.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestPage {

	WebDriver driver;
	public WebDriverWait wait;
	JavascriptExecutor js;

	public TestPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//img[@src='/images/cross-icon.svg']")
	private WebElement closePopUp;

	@FindBy(xpath = "//a[normalize-space()='On Demand']")
	private WebElement tabOnDemand;

	@FindBy(xpath = "//span[text()='Movies']")
	private WebElement tabMovies;

	@FindBy(xpath = "//div[contains(text(),'Filter')]")
	private WebElement btnFilter;

	@FindBy(xpath = "//span[normalize-space()='Animated']")
	private WebElement rbAnimated;


	@FindBy(xpath = "//div[contains(@class,'filter-button filter-apply-button filter-button-enabled')]")
	private WebElement btnApply;


	@FindBy(xpath = "//div[@class='description-wrapper']/h2/span")
	private WebElement confirmMsg;


	@FindBy(xpath = "//div[@class='thumbnail-container']/img")
	private List<WebElement> banners;


	

	

	

	public void goToOnDemand() throws InterruptedException 
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		try {
			wait.until(ExpectedConditions.elementToBeClickable(closePopUp)).click();

		} catch (Exception e) {
			
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(tabOnDemand)).click();
		
		wait.until(ExpectedConditions.visibilityOf(tabMovies));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tabMovies);
		tabMovies.click();
		

	}
	
	public String assetsWithRating18Plus()
	{
		
		List<WebElement> assetElements = banners;

		for (WebElement asset : assetElements) {

			WebElement rating = asset.findElement(By.xpath("//p[@class='subtitle' and text()='18+']"));
			if (rating.getText().equals("18+")) {
				rating.click();
				
				break;
			}
		}
		String title = confirmMsg.getText();
		return title;

		
	}
	
	public String checkRating() throws InterruptedException
	{
		btnFilter.isDisplayed();
		btnFilter.click();

		rbAnimated.isEnabled();
		rbAnimated.click();

		btnApply.click();
		String title = assetsWithRating18Plus();
		return title;
	}

}
