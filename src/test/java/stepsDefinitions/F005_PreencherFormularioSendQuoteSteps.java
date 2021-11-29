package stepsDefinitions;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pageObjects.SendQuotePage;
import utils.Utils;

public class F005_PreencherFormularioSendQuoteSteps{
	
	
	
	SendQuotePage sendQuotePage = new SendQuotePage(Utils.driver);
	
	@Quando("preencher o formulario Send Quote")
	public void preencher_o_formulario_Send_Quote() {
	  sendQuotePage.fillFormSendQuotePage();
	}
	
	@Entao("o sistema valida a mensagem de sucesso")
	public void o_sistema_valida_a_mensagem_de_sucesso() throws InterruptedException {
	    assertTrue(sendQuotePage.isSendingEmailSuccess());
	}
	
}
