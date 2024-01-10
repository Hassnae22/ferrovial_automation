package com.ferrovial.pages;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;





public class Login {
	
    private WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
    }
    
	public Login clickOnSignInWithAzureAD() throws Exception {
		
		By clickOnSignInWithAzureAD = By.xpath("//a[@class='aad-btn btn btn-primary btn-large']");
		
		new WebDriverWait(driver, Duration.ofSeconds(20))
        .until(ExpectedConditions.elementToBeClickable(clickOnSignInWithAzureAD));

        driver.findElement(clickOnSignInWithAzureAD).click();
        
		return this;
}
	public Login setEmailAddress(String email) throws Exception {
		
		By emailAddress = By.xpath("//input[@id='i0116']");
		By ClickOnNext = By.xpath("//input[@id='idSIButton9']");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement emailAddressElement = wait.until(ExpectedConditions.presenceOfElementLocated(emailAddress));

		emailAddressElement.clear();
		emailAddressElement.sendKeys(email);
		 
	   	 driver.findElement(ClickOnNext).click();
			
		return this;
	}
	
 public Login ClickOnSignIn() throws Exception {
		
				return this;
	}

	public Login clickOnText() throws Exception {
    
		By clickOnText = By.xpath("//div[@role='listitem']//div[1]/div");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement clickOnTextElement = wait.until(ExpectedConditions.presenceOfElementLocated(clickOnText));
		clickOnTextElement.click();
		return this;
	}

	

	

	public Login setPassword(String password) throws Exception {
		
		By setpassword = By.xpath("//input[@id='i0118']");
		By ClickOnSignIn = By.xpath("//input[@id='idSIButton9']");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement passwordElement = wait.until(ExpectedConditions.presenceOfElementLocated(setpassword));

		passwordElement.clear();
		passwordElement.sendKeys(password);
		 Thread.sleep(5000);
	   	 driver.findElement(ClickOnSignIn).click();
			
		return this;
	}


	public Login isLoginSuccess() throws Exception {
		
		By title = By.xpath("//div[@class='css-1os4nfd']");

	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        WebElement titleElement = wait.until(ExpectedConditions.presenceOfElementLocated(title));

	        String checkTitleText = titleElement.getText();
	        String expectedTitle = "Microsoft Azure";
	        assertTrue(checkTitleText.contains(expectedTitle),
	                "Value " + checkTitleText + " does not contain " + expectedTitle);

	        System.out.println("Assertion succeeded!");
	        System.out.println(checkTitleText);
	    } catch (AssertionError e) {
	        // Assertion failed
	        System.out.println("Assertion failed: " + e.getMessage());
	       
	        throw e;   }

	    System.out.println("OOOOOOOOOOOOOOOOOK");

	    return this;}
 

}
