package pageObjects;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Utils;

public class EnterVehicleDataPage extends FormBasePage{
	
	protected WebDriver driver;
	
	public EnterVehicleDataPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="entervehicledata")
	private WebElement abaEnterVehicleData;
	
	@FindBy(xpath = "//*[@id='entervehicledata']/span")
	private WebElement numberErros;
	
	@FindBy(id="make")
	private WebElement selectMake;
	
	@FindBy(id="model")
	private WebElement selectModel;
	
	@FindBy(id="cylindercapacity")
	private WebElement fieldCylinderCapacity;
	
	@FindBy(id="engineperformance")
	private WebElement fieldEnginePerformance;
	
	@FindBy(id="dateofmanufacture")
	private WebElement fieldDateOfManufacture;
	
	@FindBy(id="numberofseats")
	private WebElement selectNumberOfSeats;
	
	@FindBy(xpath = "//label[input[@id='righthanddriveyes']]/span")
	private WebElement selectRigthHandDriverYes;
	
	@FindBy(xpath = "//label[input[@id='righthanddriveno']]/span")
	private WebElement selectRigthHandDriverNo;
	
	@FindBy(id="numberofseatsmotorcycle")
	private WebElement selectNumberOfSeatsMotorcycle;
	
	@FindBy(id="fuel")
	private WebElement selectFuelType;
	
	@FindBy(id="payload")
	private WebElement fieldPayloadKg;
	
	@FindBy(id="totalweight")
	private WebElement fieldTotalWeightKg;
	
	@FindBy(id="listprice")
	private WebElement fieldListPrice;
	
	@FindBy(id="licenseplatenumber")
	private WebElement fieldLicensePlateNumber;
	
	@FindBy(id="annualmileage")
	private WebElement fieldAnnualMileageMi;
	
	@FindBy(id="nextenterinsurantdata")
	private WebElement btnNext;
	
		
	public void selectMake() {
		selecionarOptionAleatorio(selectMake);
	}
	
	public void selectMakeInvalid() {
		selecionarOptionInvalid(selectMake);
	}
	
	public void selectModel() {
		selecionarOptionAleatorio(selectModel);
	}
	
	public void selectModelInvalid() {
		selecionarOptionInvalid(selectModel);

	}
	
	public void fillCylinderCapacity() {
		escreverNoCampo(fieldCylinderCapacity, String.valueOf(Utils.fake.number().randomDigitNotZero()));
	}
	
	public void fillCylinderCapacityError() {
		escreverNoCampo(fieldCylinderCapacity, "Error");
	}
	
	public void fillEnginePerformance() {
		escreverNoCampo(fieldEnginePerformance, String.valueOf(Utils.fake.number().randomDigitNotZero()));
	}
	
	public void fillDateOfManufacture() {
		escreverNoCampo(fieldDateOfManufacture, Utils.dateManufacture());
	}
	
	public void selectNumberOfSeats() {
    selecionarOptionAleatorio(selectNumberOfSeats);
	}
	
	public void selectRightHandDrive() {
		Integer optionRightHandDrive = Utils.fake.number().numberBetween(1, 2);
		if (optionRightHandDrive == 1) {
			selectRigthHandDriverYes.click();;
		} else {
			selectRigthHandDriverNo.click();
		}
			
	}
	
	public void selectNumberOfSeatsMotorcycle() {
	selecionarOptionAleatorio(selectNumberOfSeatsMotorcycle);
	}
	
	public void selectFuelType() {
		selecionarOptionAleatorio(selectFuelType);
	}
	
	public void fillPayloadKg() {
		escreverNoCampo(fieldPayloadKg, String.valueOf((Utils.fake.number().randomDouble(10, 1L, 10L))));
	}
	
	public void fillTotalWeightKg() {
		escreverNoCampo(fieldTotalWeightKg, String.valueOf((Utils.fake.number().numberBetween(100, 50000))));
	}
	
	public void fillListPrice() {
		escreverNoCampo(fieldListPrice, String.valueOf((Utils.fake.number().numberBetween(500, 100000))));
	}
	
	public void fillLicensePlateNumber() {
		escreverNoCampo(fieldLicensePlateNumber, String.valueOf((Utils.fake.number().randomDigitNotZero())));
	}
	
	public void fillAnnualMileageMi() {
		escreverNoCampo(fieldAnnualMileageMi, String.valueOf((Utils.fake.number().numberBetween(100, 100000))));
	}
	
	public void clickNext() {
		clicarBotao(btnNext);
	}
	
	public void fillFormEnterVehicleDataPage() {
		Assert.assertTrue(isActive(abaEnterVehicleData));
		selectMake();
		selectModel();
		fillCylinderCapacity();
		fillEnginePerformance();
		fillDateOfManufacture();
		selectNumberOfSeats();
		selectRightHandDrive();
		selectNumberOfSeatsMotorcycle();
		selectFuelType();
		fillPayloadKg();
		fillTotalWeightKg();
		fillListPrice();
		fillLicensePlateNumber();
		fillAnnualMileageMi();
		
		assertTrue(validaErros(numberErros));
		
		clickNext();
		
	}
	
}
