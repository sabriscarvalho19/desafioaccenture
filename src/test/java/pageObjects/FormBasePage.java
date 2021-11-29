package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.Utils;

public class FormBasePage {
	
	public boolean isActive(WebElement aba) {
		return aba.isDisplayed();
	}
	
	public boolean validaErros(WebElement aba) {
		if (aba.isDisplayed()) {
			Integer erros = Integer.valueOf(aba.getText());
			return erros == 0;
		} else {
			return Boolean.FALSE;
					
		}
	}
	
	protected void selecionarOptionAleatorio(WebElement campo) {
		Select select = new Select(campo);
		select.selectByIndex(Utils.fake.number().numberBetween(1, select.getOptions().size() - 1));
	}
	
	protected void selecionarOptionInvalid(WebElement campo) {
		Select select = new Select(campo);
		select.selectByIndex(0);
	}
	
	protected void escreverNoCampo(WebElement campo, String texto) {
		campo.clear();
		campo.sendKeys(texto);
	}	

	protected void clicarRadio(WebElement option) {
		clicarBotao(option);
	}
	protected void clicarBotao(WebElement campo){
		campo.click();
	}
	
	
}
