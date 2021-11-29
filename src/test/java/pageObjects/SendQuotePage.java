package pageObjects;

import static org.junit.Assert.assertTrue;
import static utils.Utils.aguardarLoading;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Utils;

public class SendQuotePage extends FormBasePage{
	
protected WebDriver driver;

	private String password;

	public SendQuotePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="sendquote")
	private WebElement abaSendQuote;
	
	@FindBy(xpath =  "//*[@id='sendquote']/span")
	private WebElement numberErros;
	
	@FindBy(id="email")
	private WebElement fieldEmail;
	
	@FindBy(id="phone")
	private WebElement fieldPhone;
	
	@FindBy(id="username")
	private WebElement fieldUsername;
	
	@FindBy(id="password")
	private WebElement fieldPassword;
	
	@FindBy(id="confirmpassword")
	private WebElement fieldConfirmPassword;
	
	@FindBy(id="Comments")
	private WebElement fieldComments;
			
	@FindBy(id="prevselectpriceoption")
	private WebElement btnPrev;
	
	@FindBy(id="sendemail")
	private WebElement btnSend;
	
	@FindBy(xpath = "//h2[text()='Sending e-mail success!']")
	private WebElement mensagemSendingEmailSuccess;
	
	@FindBy(xpath = "//div[@class=\"sweet-alert showSweetAlert visible\"]")
	private WebElement sendingEmailSuccess;
		
	@FindBy(className = "confirm")
	private WebElement btnOk;
	
	
	public void fillEmail() {
		escreverNoCampo(fieldEmail, String.valueOf((Utils.fake.internet().emailAddress())));
	}
	
	public void fillPhone() {
		escreverNoCampo(fieldPhone, String.valueOf((Utils.fake.number().numberBetween(100000000, 1000000000))));
	}
	
	public void fillUsername() {
		escreverNoCampo(fieldUsername, String.valueOf((Utils.fake.name().username())));
	}
	
	public void fillPassword() {
		this.password = String.valueOf(Utils.fake.internet().password(10, 15, true));
		escreverNoCampo(fieldPassword, this.password);
	}
	
	public void fillConfirmPassword() {
		escreverNoCampo(fieldConfirmPassword, this.password);
	}
	
	public void fillComments() {
		escreverNoCampo(fieldComments, String.valueOf((Utils.fake.lorem().characters())));
	}
	
	public void clickPrev() {
		clicarBotao(btnPrev);
	}
	
	public void clickSend() {
		clicarBotao(btnSend);
	}
	
	public void fillFormSendQuotePage() {
		Assert.assertTrue(isActive(abaSendQuote));
		fillEmail();
		fillPhone();
		fillUsername();
		fillPassword();
		fillConfirmPassword();
		fillComments();
		
		assertTrue(validaErros(numberErros));
		
		clickSend();
		
	}
	
	public boolean isSendingEmailSuccess() throws InterruptedException {
		aguardarLoading(sendingEmailSuccess);
		return mensagemSendingEmailSuccess.isDisplayed();
	}
	

}
