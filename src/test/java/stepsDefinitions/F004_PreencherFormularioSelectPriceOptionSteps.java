package stepsDefinitions;

import io.cucumber.java.pt.Quando;
import pageObjects.SelectPriceOptionPage;
import utils.Utils;

public class F004_PreencherFormularioSelectPriceOptionSteps{
	
	
	
	SelectPriceOptionPage selectPriceOptionPage = new SelectPriceOptionPage(Utils.driver);
	
	@Quando("preencher o formulario Select Price Option")
	public void preencher_o_formulario_Select_Price_Option() {
	   selectPriceOptionPage.fillFormSelectPriceOptionPage();
	}
	
}
