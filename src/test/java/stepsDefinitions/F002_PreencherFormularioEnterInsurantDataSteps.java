package stepsDefinitions;

import io.cucumber.java.pt.Quando;
import pageObjects.EnterInsurantDataPage;
import utils.Utils;

public class F002_PreencherFormularioEnterInsurantDataSteps{
	
	
	
	EnterInsurantDataPage enterInsurantDataPage = new EnterInsurantDataPage(Utils.driver);
	

	@Quando("preencher o formulario enter Insurant Data")
	public void preencher_o_formulario_enter_Insurant_Data() {
	   enterInsurantDataPage.fillFormEnterInsurantDataPage();
	}
	
	
}
