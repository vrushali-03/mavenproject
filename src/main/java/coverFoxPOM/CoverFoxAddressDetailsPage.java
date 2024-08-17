package coverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxAddressDetailsPage {
	
	@FindBy(className = "mp-input-text")  private WebElement  pinCodeField;
	
	@FindBy(id = "want-expert") private WebElement mobileNumber;
	
	@FindBy(className = "next-btn") private WebElement next_btn;
	
	//constructor
	
	public CoverFoxAddressDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	  //methode
	
	public void enterPinCode(String pinCode)
	{
		Reporter.log("entering pin code" , true);
		pinCodeField.sendKeys(pinCode);
	}
	
	 public void enterMobile(String mobileNo)
	 {
		 Reporter.log("entering mobile number",true);
		 mobileNumber.sendKeys(mobileNo);
	 }
	 
	 public void clickOnNextButton()
	 {
		 Reporter.log("Clicking on next button",true);
		 next_btn.click();
	 }
}
