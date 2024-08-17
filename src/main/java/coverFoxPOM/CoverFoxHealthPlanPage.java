package coverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxHealthPlanPage {
	
	@FindBy(className = "next-btn") private WebElement next_btn;
	
	//consructor
	
	public CoverFoxHealthPlanPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// methode
	
	public void ClickOnNextButton()
	{
		Reporter.log("clicking on next button",true);
		next_btn.click();
	}

}

