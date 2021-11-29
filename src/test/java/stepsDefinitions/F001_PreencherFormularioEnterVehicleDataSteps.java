package stepsDefinitions;

import io.cucumber.java.pt.Quando;
import pageObjects.EnterVehicleDataPage;
import utils.Utils;

public class F001_PreencherFormularioEnterVehicleDataSteps{
	
	
	
	EnterVehicleDataPage enterVehicleDataPage = new EnterVehicleDataPage(Utils.driver);
	
	@Quando("preencher o formulario enter Vehicle Data")
	public void preencher_o_formulario_enter_Vehicle_Data() {
	    enterVehicleDataPage.fillFormEnterVehicleDataPage();
	}
	
	
}
