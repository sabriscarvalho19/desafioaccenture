package stepsDefinitions;

import io.cucumber.java.pt.Quando;
import pageObjects.EnterProductDataPage;
import utils.Utils;

public class F003_PreencherFormularioEnterProductDataSteps{
	
	
	
	EnterProductDataPage enterProductDataPage = new EnterProductDataPage(Utils.driver);
	

	@Quando("preencher o formulario enter Product Data")
	public void preencher_o_formulario_enter_Product_Data() {
	    enterProductDataPage.fillFormEnterProductDataPage();
	}

	
}
