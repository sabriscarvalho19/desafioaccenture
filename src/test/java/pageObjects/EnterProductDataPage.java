package pageObjects;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Utils;

public class EnterProductDataPage extends FormBasePage{
	
protected WebDriver driver;

	public EnterProductDataPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
		
	@FindBy(id="enterproductdata")
	private WebElement abaEnterProductData;
	
	@FindBy(xpath =  "//*[@id='enterproductdata']/span")
	private WebElement numberErros;
	
	@FindBy(id="startdate")
	private WebElement fieldStartDate;
	
	@FindBy(id="insurancesum")
	private WebElement selectInsuranceSum;
	
	@FindBy(id="meritrating")
	private WebElement selectMeritRating;
	
	@FindBy(id="damageinsurance")
	private WebElement selectDamageInsurance;
	
	@FindBy(xpath = "//label[input[@id='EuroProtection']]/span")
	private WebElement euroProtectionOptionalProducts;
	
	@FindBy(xpath = "//label[input[@id='LegalDefenseInsurance']]/span")
	private WebElement legalDefenseInsurance;
	
	@FindBy(id="courtesycar")
	private WebElement selectCourtesyCar;
		
	@FindBy(id="preventerinsurancedata")
	private WebElement btnPrev;
	
	@FindBy(id="nextselectpriceoption")
	private WebElement btnNext;
	

	public void fillStartDate() {
		escreverNoCampo(fieldStartDate, Utils.startDate());
	}
	
	public void selectInsuranceSum() {
		selecionarOptionAleatorio(selectInsuranceSum);
	}
	
	public void selectMeritRating() {
		selecionarOptionAleatorio(selectMeritRating);
	}
	
	public void selectDamageInsurance() {
		selecionarOptionAleatorio(selectDamageInsurance);
	}
	
	public void selectOptionalProducts() {
		
		List<WebElement> optionalProducts = Arrays.asList(euroProtectionOptionalProducts, legalDefenseInsurance);

		//Gera uma quantidade de produtos para serem selecionados
		Integer qtdProducts = Utils.fake.number().numberBetween(1, optionalProducts.size());

		if(qtdProducts == optionalProducts.size()) {
			optionalProducts.stream().forEach(product -> product.click());		
		} else {
			// Caso não seja para selecionar todos os produtos, 
			// Gera uma lista aleatoria dos produtos a serem selecionados 
			List<Integer> list = new ArrayList<Integer>();
			
			while (list.size() != qtdProducts) {
				Integer valueOption = Utils.fake.number().numberBetween(1, optionalProducts.size()); 
				if(!list.contains(valueOption)) {
					list.add(valueOption);	
				}
			}
			
			list.stream().forEach(option -> optionalProducts.get(option-1).click());
		}
		
			
	}
	
	public void selectCourtesyCar() {
		selecionarOptionAleatorio(selectCourtesyCar);
	}
	
	public void clickNext() {
		clicarBotao(btnNext);
	}
	
	public void clickPrev() {
		clicarBotao(btnPrev);
	}
	
	public void fillFormEnterProductDataPage() {
		
		//Verifica se a aba está ativa
		assertTrue(isActive(abaEnterProductData));
		
		fillStartDate();
		selectInsuranceSum();
		selectMeritRating();
		selectDamageInsurance();
		selectOptionalProducts();
		selectCourtesyCar();
		assertTrue(validaErros(numberErros));
		
		clickNext();
	}

}
