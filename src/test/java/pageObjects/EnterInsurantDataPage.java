package pageObjects;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Utils;

public class EnterInsurantDataPage extends FormBasePage{
	
protected WebDriver driver;
	
	String pathImagens = System.getProperty("user.dir") + "\\src\\test\\resources\\Imagens\\";

	public EnterInsurantDataPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="enterinsurantdata")
	private WebElement abaEnterInsurantData;
	
	@FindBy(xpath = "//*[@id='enterinsurantdata']/span")
	private WebElement numberErros;
	
	
	@FindBy(id="firstname")
	private WebElement fieldFirstName;
	
	@FindBy(id="lastname")
	private WebElement fieldLastName;
	
	@FindBy(id="birthdate")
	private WebElement fieldDateOfBirth;
	
	@FindBy(xpath = "//label[input[@id='gendermale']]/span")
	private WebElement radioGenderMale;
	
	@FindBy(xpath = "//label[input[@id='genderfemale']]/span")
	private WebElement radioGenderFemale;
	
	@FindBy(id="streetaddress")
	private WebElement fieldStreetAddress;
	
	@FindBy(id="country")
	private WebElement selectCountry;
	
	@FindBy(id="zipcode")
	private WebElement fieldZipCode;
	
	@FindBy(id="city")
	private WebElement fieldCity;
	
	@FindBy(id="occupation")
	private WebElement selectOccupation;
	
	@FindBy(xpath = "//label[input[@id='speeding']]/span")
	private WebElement speedingHobbies;
	
	@FindBy(xpath = "//*[@name='Hobbies']")
	private List<WebElement> hobbbies;
	
	@FindBy(xpath="//label[input[@id='bungeejumping']]/span")
	private WebElement bungeeJumpingHobbies;
	
	@FindBy(xpath="//label[input[@id='cliffdiving']]/span")
	private WebElement cliffDivingHobbies;
	
	@FindBy(xpath="//label[input[@id='skydiving']]/span")
	private WebElement skydivingHobbies;
	
	@FindBy(xpath="//label[input[@id='other']]/span")
	private WebElement otherHobbies;
	
	@FindBy(id="website")
	private WebElement fieldWebSite;
	
	@FindBy(id="picture")
	private WebElement picture;
	
	@FindBy(id="open")
	private WebElement openPicture;
	
	@FindBy(id="preventervehicledata")
	private WebElement btnPrev;
	
	@FindBy(id="nextenterproductdata")
	private WebElement btnNext;
	
	
	public void fillFirstname() {
		escreverNoCampo(fieldFirstName, Utils.fake.name().firstName());
	}
	
	public void fillLastName() {
		escreverNoCampo(fieldLastName, Utils.fake.name().lastName());
	}
	
	public void fillDateOfBirth() {
		escreverNoCampo(fieldDateOfBirth, Utils.dateBirth());
	}
	
	public void radioGender() {
		Integer optionGender = Utils.fake.number().numberBetween(1, 2);
		if (optionGender == 1) {
			radioGenderMale.click();
		} else {
			radioGenderFemale.click();
		}
			
	}
	
	public void fillStreetaddress() {
		escreverNoCampo(fieldStreetAddress, Utils.fake.address().streetAddress());
	}
	
	public void selectCountry() {
		selecionarOptionAleatorio(selectCountry);
	}
	
	public void fillZipCode() {
		String zipCode = Utils.fake.address().zipCode().replaceAll("-", "");
		if(zipCode.length() > 8) {
			zipCode = zipCode.substring(0, 7);
		} else if(zipCode.length() < 4) {
			while(zipCode.length() < 4) {
				zipCode.concat(String.valueOf(Utils.fake.number().numberBetween(0, 9)));
			}
		}
		escreverNoCampo(fieldZipCode, zipCode);
	}
	
	public void fillCity() {
		escreverNoCampo(fieldCity, Utils.fake.address().city());
	}
	
	public void selectOccupation() {
		selecionarOptionAleatorio(selectOccupation);
	}
	
	
	public void selectHobbies() {
		List<WebElement> hobbies = Arrays.asList(speedingHobbies, bungeeJumpingHobbies, cliffDivingHobbies, skydivingHobbies, otherHobbies);
		Integer qtdHobbies = Utils.fake.number().numberBetween(1, hobbies.size());
		if(qtdHobbies == hobbies.size()) {
			hobbies.stream().forEach(product -> product.click());		
		} else {
			
			// Caso não seja para selecionar todos os hobbies, 
			// Gera uma lista aleatoria dos hobbies a serem selecionados
			List<Integer> list = new ArrayList<Integer>();
			while (list.size() != qtdHobbies) {
				Integer valueOption = Utils.fake.number().numberBetween(1, hobbies.size()); 
				if(!list.contains(valueOption)) {
					list.add(valueOption);	
				}
			}
			list.stream().forEach(option -> hobbies.get(option-1).click());
		}
		
	}
	
	public void fillWebSite() {
		escreverNoCampo(fieldWebSite, Utils.fake.internet().url());
	}
	
	private void selectPicture() {
		String path = new File(pathImagens + "images.jpg").getAbsolutePath();
		clicarBotao(openPicture);
		executeUpload(path);
	}
	
	private void executeUpload(String path) {

		StringSelection ss = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		Robot robot;
		try {
			robot = new Robot();
			robot.delay(250);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(90);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
	}
	
	public void clickNext() {
		clicarBotao(btnNext);
	}
	
	public void clickPrev() {
		clicarBotao(btnPrev);
	}
	
	public void fillFormEnterInsurantDataPage() {
		assertTrue(isActive(abaEnterInsurantData));
		fillFirstname();
		fillLastName();
		fillDateOfBirth();
		radioGender();
		fillStreetaddress();
		selectCountry();
		fillZipCode();
		fillCity();
		selectOccupation();
		selectHobbies();
		fillWebSite();
		selectPicture();
		assertTrue(validaErros(numberErros));
		
		clickNext();
	}

	

	
	
	
}
