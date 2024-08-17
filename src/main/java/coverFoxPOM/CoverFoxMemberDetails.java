package coverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class CoverFoxMemberDetails {
	
	@FindBy(id = "Age-You") private WebElement ageDropDown;
	
	@FindBy(className = "next-btn") private WebElement next_btn;
	
	//consructor
	
	public CoverFoxMemberDetails(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	// methode
	
	public void handleDropDown(String value) 
	{
		Reporter.log("handling age drop down",true);
		Select s=new Select(ageDropDown);
		s.selectByValue(value+"y");
	}
	
	public void clickOnNextButton()
	{
		Reporter.log("clicking on next button",true);
		next_btn.click();
	}
	

}
