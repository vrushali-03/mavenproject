package coverFoxPOM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverFoxResultPage {
	
	@FindBy(xpath = "//div[contains(text(),'Insurance Plans')]")  private WebElement text;
	
	@FindBy(className = "plan-card-container")private List<WebElement> banners;
	
	@FindBy(xpath = "//div[text()='Sort Plans']") private WebElement sortPlanFilter;
	
	//constructor
	
	public CoverFoxResultPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//methode
	
	public void  validateBanner()
	{
		String[] result = text.getText().split(" ");
		  int mainResult = Integer.parseInt(result[0]);
		  
		  if(mainResult==banners.size())
		  {
			  System.out.println("Test case pass");
		  }
		  else
		  {
			  System.out.println("Test case failed");
		  }
	}
	
	public int getPlanNumbersFromString()
	{
		        String[] ar = text.getText().split(" ");
		        int result = Integer.parseInt(ar[0]);
		        return result;
	}
	
	public int getNumberOfPlanFromBanners()
	{
		 int bannerSize = banners.size();
		 return bannerSize;
	}

	public boolean sortPlanFilterIsDisplayed()
	{
		        boolean result = sortPlanFilter.isDisplayed();
		        return result;
	}
}
