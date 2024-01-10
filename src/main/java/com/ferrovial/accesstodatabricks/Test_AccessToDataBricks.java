package com.ferrovial.accesstodatabricks;

import com.ferrovial.interfaceUI.WebDriverSingleton;
import com.ferrovial.pages.AccessToDataBricks;

public class Test_AccessToDataBricks {

	public static AccessToDataBricks accessToDataBricks;
	public String date;

	public Test_AccessToDataBricks() {

		this.accessToDataBricks = new AccessToDataBricks(WebDriverSingleton.getDriver());
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void doAccessToDataBricks() throws InterruptedException {

		String ulElementOfTab1 = "document.querySelector('#app-root > div:nth-child(9) > databricks-dbsql').shadowRoot.querySelector('#dashboard-lazy-widget-7e444055-6d88-4eac-b4b6-59cc868ce5a7 > div > div > div.widget-actions > div > a')";
		String downloadCSVButtonTab1 = "document.querySelector('#app-root > div:nth-child(9) > databricks-dbsql').shadowRoot.querySelector('div:nth-child(3) > div:nth-child(4) > div > div > ul > li:nth-child(1) > a')";
		String ulElementOfTab2 = "";
		String downloadCSVButtonTab2 = "";

		// navigate to Daily Report page
		accessToDataBricks.navigateToDailyReport(date);
		// wait 20 se
		Thread.sleep(20000);
		accessToDataBricks.isNavigateSuccess();
		accessToDataBricks.selectShadowAngularComp();
//			accessToDataBricks.clickOnDownload(ulElementOfTab2, downloadCSVButtonTab1);
//			accessToDataBricks.isButtonEnable();
//         System.out.println(accessToDataBricks.isDownloadButtonEnabled(ulElementOfTab1 , downloadCSVButtonTab1));
//			if (accessToDataBricks.isDownloadButtonEnabled(ulElementOfTab1 , downloadCSVButtonTab1)) {
//				accessToDataBricks.clickOnDownloadCsv(downloadCSVButtonTab1);
//				System.out.println("Tab1");
//			} else {
//			    // If not enabled
//			    System.out.println("Download button for table 1 is not enabled. Waiting or handling as needed.");
//			}

	}
}
