package pageObjects;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Utils;

public class SelectPriceOptionPage extends FormBasePage{
	
protected WebDriver driver;
	
	public SelectPriceOptionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="selectpriceoption")
	private WebElement abaSelectPriceOption;
	
	@FindBy(xpath =  "//*[@id='selectpriceoption']/span")
	private WebElement numberErros;
	
	@FindBy(xpath = "//label[input[@id='selectsilver']]/span")
	private WebElement radioSilverSelectOption;
	
	@FindBy(xpath = "//label[input[@id='selectgold']]/span")
	private WebElement radioGoldSelectOption;
	
	@FindBy(xpath = "//label[input[@id='selectplatinum']]/span")
	private WebElement radioPlatinumSelectOption;
	
	@FindBy(xpath = "//label[input[@id='selectultimate']]/span")
	private WebElement radioUltimateSelectOption;
	
	@FindBy(id="viewquote")
	private WebElement viewQuote;
	
	@FindBy(id="downloadquote")
	private WebElement downloadQuote;
			
	@FindBy(id="preventerproductdata")
	private WebElement btnPrev;
	
	@FindBy(id="nextsendquote")
	private WebElement btnNext;
	
	public void radioPriceOption() {
		
		Integer optionPrice = Utils.fake.number().randomDigitNotZero();
		
		switch (optionPrice) {
		case 1:
			radioSilverSelectOption.click();
			break;
		case 2:
			radioGoldSelectOption.click();
			break;
		case 3:
			radioPlatinumSelectOption.click();
			break;
		case 4:
			radioUltimateSelectOption.click();
			break;
		default:
			radioSilverSelectOption.click();
			break;
		
		}
			
	}
	
	public void clickViewQuote() {
		clicarBotao(viewQuote);
	}
	
	public void clickDownloadQuote() {
		clicarBotao(downloadQuote);
	}
	
	public void clickNext() {
		clicarBotao(btnNext);
	}
	
	public void clickPrev() {
		clicarBotao(btnPrev);
	}
	
	public void fillFormSelectPriceOptionPage() {
		assertTrue(isActive(abaSelectPriceOption));
		
		radioPriceOption();
		
		assertTrue(validaErros(numberErros));
		
		clickNext();
	}
	
}
