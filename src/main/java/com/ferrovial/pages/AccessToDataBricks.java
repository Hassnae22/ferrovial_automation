package com.ferrovial.pages;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccessToDataBricks {

	private WebDriver driver;

	public AccessToDataBricks(WebDriver driver) {
		this.driver = driver;
	}

	public AccessToDataBricks navigateToDailyReport(String date) {

		String url = "https://adb-795588254297800.0.azuredatabricks.net/sql/dashboards/19e3765e-7a7a-4702-8c8a-0e341c273e41?o=795588254297800&p_Time%20Range="
				+ date + "%2000%3A00%3A00--" + date + "%2023%3A59%3A59";
		System.out.println(url);
		try {
			driver.get(url);

		} catch (Exception e) {
			System.out.println("Navigate Error: " + e.getMessage());
		}

		return this;
	}

	public AccessToDataBricks isNavigateSuccess() {
		String elementQuery = "document.querySelector('#app-root > div:nth-child(9) > databricks-dbsql').shadowRoot.querySelector('#application-root > div > div.application-layout-content > div > div > div.databricks-dbsql-1tgvtp5 > div.databricks-dbsql-e4qbzl > div > div.databricks-dbsql-1f5e1yp > h2 > div > div.page-title > h3 > span > span')";

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

			// Execute the script to find the shadow DOM element
			WebElement titleElement = (WebElement) ((JavascriptExecutor) driver)
					.executeScript("return " + elementQuery);

			String checkTitleText = titleElement.getText();
			String expectedTitle = "DAILY REPORT";
			assertTrue(checkTitleText.contains(expectedTitle),
					"Value " + checkTitleText + " does not contain " + expectedTitle);

			System.out.println("Assertion succeeded!");
			System.out.println(checkTitleText);

			System.out.println("Navigate success");

		} catch (AssertionError e) {
			System.out.println("Assertion failed: " + e.getMessage());
			throw e;
		}

		System.out.println("Navigate OOOOOOOOOOOOOOOOOK");

		return this;
	}

	public AccessToDataBricks isButtonEnable() {
		String ulTab1 = "document.querySelector('#app-root > div:nth-child(9) > databricks-dbsql').shadowRoot.querySelector('#dashboard-lazy-widget-7e444055-6d88-4eac-b4b6-59cc868ce5a7 > div > div > div.widget-actions > div > a')";
		String downloadCSVButtonTab1 = "document.querySelector('#app-root > div:nth-child(9) > databricks-dbsql').shadowRoot.querySelector('div:nth-child(3) > div:nth-child(4) > div > div > ul > li:nth-child(1) > a')";

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

			WebElement ulElement = (WebElement) ((JavascriptExecutor) driver).executeScript("return " + ulTab1);
			ulElement.click();

			// now execute the script to find the shadow DOM elemente !!! prob here
//			WebElement buttonElement = (WebElement) ((JavascriptExecutor) driver)
//					.executeScript("return " + downloadCSVButtonTab1);
			WebElement buttonElement = wait.until(ExpectedConditions.elementToBeClickable(
					(By) ((JavascriptExecutor) driver).executeScript("return " + downloadCSVButtonTab1)));
			System.out.println(buttonElement);
			buttonElement.click();
			String ariaDisableAttribute = buttonElement.getAttribute("href");

			System.out.println("aria-disabled");
			System.out.println(ariaDisableAttribute);

		} catch (Exception e) {
			System.out.println("failed: " + e.getMessage());
			throw e;
		}

		return this;
	}

	public AccessToDataBricks downloadConcessionsReport() {
		String url = "https://adb-795588254297800.0.azuredatabricks.net/sql/api/widgets/7e444055-6d88-4eac-b4b6-59cc868ce5a7/results/sqlx:query_execution_session:01eea98d-6701-16ea-8efa-fc08e1eb98bb.csv?o=795588254297800";
		System.out.println(url);
		try {
			driver.get(url);
			System.out.println("Download downloadConcessionsReport");
		} catch (Exception e) {
			System.out.println("Navigate Error: " + e.getMessage());
		}

		return this;
	}

	public AccessToDataBricks downloadDeadQueueLogReport() {
		String url = "https://adb-795588254297800.0.azuredatabricks.net/sql/api/widgets/e3c5a95d-6292-4abf-acbc-52fb6d848ef5/results/sqlx:query_execution_session:01eeab1f-f504-1123-bc43-35b204839bd7.csv?o=795588254297800";
		System.out.println(url);
		try {
			driver.get(url);
			System.out.println("Download downloadDeadQueueLogReport");
		} catch (Exception e) {
			System.out.println("Navigate Error: " + e.getMessage());
		}

		return this;
	}

	public AccessToDataBricks downloadVepReprt() {
		String url = "https://adb-795588254297800.0.azuredatabricks.net/sql/api/widgets/dd74da8f-7e72-4548-a61c-1686ed3ef544/results/sqlx:query_execution_session:01eeab1d-18ab-18d1-a957-e268222e9faf.csv?o=795588254297800";
		System.out.println(url);
		try {
			driver.get(url);
			System.out.println("Download fileeee");
		} catch (Exception e) {
			System.out.println("Navigate Error: " + e.getMessage());
		}

		return this;
	}

	public AccessToDataBricks downloadVmvReport() {
		String url = "https://adb-795588254297800.0.azuredatabricks.net/sql/api/widgets/14f5ed5d-09f1-4111-86c3-4d855d7bd328/results/sqlx:query_execution_session:01eea98d-6702-18e2-91c0-9b4ab61886c4.csv?o=795588254297800";
		System.out.println(url);
		try {
			driver.get(url);
			System.out.println("Download fileeee");
		} catch (Exception e) {
			System.out.println("Navigate Error: " + e.getMessage());
		}

		return this;
	}

	public AccessToDataBricks refreachDailyReportPage() {

		driver.navigate().refresh();
		System.out.println("refresh success !");
		return this;
	}

	public boolean isLoadingIconPresent(String element) {

		try {
			By loadingIconLocator = By.cssSelector(element);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			// Check if the loading icon is present
			wait.until(ExpectedConditions.presenceOfElementLocated(loadingIconLocator));
			System.out.println("The element is located....");

			return true;
		} catch (org.openqa.selenium.TimeoutException e) {
			System.out.println("TimeoutException: The loading icon is not present within the specified timeout.");
			return false;
		}
	}

	public boolean clickOnDownload(String elemnt1, String elemnt2) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

			// Execute the script to find the shadow DOM element
			WebElement choisesElement = (WebElement) ((JavascriptExecutor) driver).executeScript("return " + elemnt1);
			choisesElement.click();
			System.out.println("choisesElement");
			System.out.println(choisesElement);
			WebElement downloadcsv = (WebElement) ((JavascriptExecutor) driver).executeScript("return " + elemnt2);
			downloadcsv.click();

			return true;
		} catch (org.openqa.selenium.TimeoutException e) {
			System.out.println("TimeoutException: The loading icon is not present within the specified timeout.");
			return false;
		}
	}

	public boolean isDownloadButtonEnabled(String elementSelector, String downloadCsvSelector) {
		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

			WebElement choisesElement = (WebElement) ((JavascriptExecutor) driver)
					.executeScript("return " + elementSelector);
			System.out.println("choisesElement");
			System.out.println(choisesElement);
			choisesElement.click();

			String downloadCsvSele = "#app-root > div:nth-child(9) > databricks-dbsql";
			WebElement shadowDomElement = driver.findElement(By.cssSelector(downloadCsvSele));
			WebElement shadowRoot = (WebElement) ((JavascriptExecutor) driver)
					.executeScript("return arguments[0].shadowRoot", shadowDomElement);

			// Now, use the selector within the shadow DOM
			String innerSelector = "div:nth-child(3) > div:nth-child(4) > div > div > ul > li:nth-child(1)";
			WebElement downloadCsvElement = (WebElement) ((JavascriptExecutor) driver)
					.executeScript("return arguments[0].querySelector('" + innerSelector + "')", shadowRoot);

			System.out.println("downloadCsvElement");
			System.out.println(downloadCsvElement);
			System.out.println(downloadCsvElement.getAttribute("aria-disabled"));
			// Now Check if the download button is enabled based on the aria-disabled
			// attribute
			boolean isButtonEnabled = downloadCsvElement.getAttribute("aria-disabled").equals("false");

			if (isButtonEnabled) {
				System.out.println("The download button is enabled.");
			} else {
				System.out.println("The download button is disabled.");
			}

			return isButtonEnabled;
		} catch (org.openqa.selenium.TimeoutException e) {
			System.out.println("TimeoutException: The download button is not present within the specified timeout.");
			return false;
		}
	}

	public void clickOnDownloadCsv(String elementSelector) {
		try {

			WebElement downloadcsv = (WebElement) ((JavascriptExecutor) driver)
					.executeScript("return " + elementSelector);
			downloadcsv.click();
			System.out.println("Download OOOOk");

		} catch (org.openqa.selenium.TimeoutException e) {
			System.out.println("TimeoutException: download");

		}
	}
	
	public void selectShadowAngularComp() {
		
		try {
		WebElement angularComponent = driver.findElement(By.cssSelector("databricks-dbsql"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		System.out.println("angularComponent");
		wait.until(ExpectedConditions.visibilityOf(angularComponent));
		SearchContext shadowRoot = angularComponent.getShadowRoot();
		WebElement dropDownList =  shadowRoot.findElement(By.cssSelector("a.action[data-testid='WidgetDropdownButton']"));
		dropDownList.click();
		}catch(Exception e) {
			System.out.println("Err "+e);
		}
        

	}

}
