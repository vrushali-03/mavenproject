package coverFoxTest;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import coverFoxBase.Base;
import coverFoxPOM.CoverFoxAddressDetailsPage;
import coverFoxPOM.CoverFoxHealthPlanPage;
import coverFoxPOM.CoverFoxHomePage;
import coverFoxPOM.CoverFoxMemberDetails;
import coverFoxPOM.CoverFoxResultPage;



public class CoverFoxTC extends Base{
	
	CoverFoxHomePage homePage;
	CoverFoxHealthPlanPage healthPlanPage;
	CoverFoxAddressDetailsPage addressDetailsPage;
	CoverFoxMemberDetails memberDetailsPage;
	CoverFoxResultPage resultPage;
	String filePath;
	public static Logger logger;
	
	@BeforeTest
	public void launchBrowser()
	{
		
		logger=logger.getLogger("CoverFoxInsurence");
		PropertyConfigurator.configure("Log4j.properties");
		logger.info("opening browser");
		openBrowser();
		homePage=new CoverFoxHomePage(driver);
		healthPlanPage=new CoverFoxHealthPlanPage(driver);
		addressDetailsPage=new CoverFoxAddressDetailsPage(driver);
		memberDetailsPage=new CoverFoxMemberDetails(driver);
		resultPage=new CoverFoxResultPage(driver);
		filePath="C:\\Users\\tussh\\eclipse-workspace\\Project_Selenium\\excelTest.xlsx";
		
   }
	@BeforeClass
	public void preConditions() throws InterruptedException, EncryptedDocumentException, IOException
	{
		logger.info("clicking on gender button");
		homePage.clickOnFemaleButton();
		Thread.sleep(1000);
		logger.info("clicking on next button");
		healthPlanPage.ClickOnNextButton();
		Thread.sleep(1000);
		logger.warn("enter age between 15 to 80");
		memberDetailsPage.handleDropDown(coverFoxUtility.Utility.readDataFromExcel(filePath, "Sheet4", 0, 0));
		logger.info("clicking on next button");
		memberDetailsPage.clickOnNextButton();
		Thread.sleep(1000);
		logger.warn("enter valid pin code");
		addressDetailsPage.enterPinCode(coverFoxUtility.Utility.readDataFromExcel(filePath, "Sheet4", 0, 1));
		logger.warn("enter valid mobile number");
		logger.info("entering mobile number");
		addressDetailsPage.enterMobile(coverFoxUtility.Utility.readDataFromExcel(filePath, "Sheet4", 0, 2));
		logger.info("clicking on next button");
		addressDetailsPage.clickOnNextButton();
	}
	  @Test
	  public void validateBanners() throws InterruptedException {
		  Thread.sleep(4000);
		  Assert.fail();
		  logger.info("validating banner");
		  int stringPlanNumber = resultPage.getPlanNumbersFromString();
		  int totalNoOfPlanOnBanner = resultPage.getNumberOfPlanFromBanners();
		  
		  
	      Assert.assertEquals(stringPlanNumber, totalNoOfPlanOnBanner,"plan on banners are not equal,TC failed");
	  }
	  
	  
	  @Test
	  public void validatePresenceOfSortButton() throws InterruptedException, IOException
	  {
		    Thread.sleep(4000);
		   Assert.fail();
		    logger.info("validating presence of sort button");
		    Assert.assertTrue(resultPage.sortPlanFilterIsDisplayed(), "sortButton is not displayed,TC failed");
		   //Utility.takeScreenShot(driver,"validatePresenceOfSortButton" );
	  }
	  @AfterClass
	  public void closeBrowser() throws InterruptedException
	  {
		  logger.info("closing browser");
		  browserClose();
	  }
	

}
