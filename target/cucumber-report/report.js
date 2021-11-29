$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/.feature");
formatter.feature({
  "name": "Realizar Login",
  "description": "  Como um usuario quando entro no sistema e tento realizar o login",
  "keyword": "Funcionalidade"
});
formatter.scenario({
  "name": "ValidarTodosOsCamposObrigatorios",
  "description": "",
  "keyword": "Cenario"
});
formatter.uri("file:src/test/resources/features/F001_PreencherFormulario.feature");
formatter.feature({
  "name": "Preencher Formulario",
  "description": "  Como um usuario quando entro no sistema faco o preenchimento do formulario",
  "keyword": "Funcionalidade"
});
formatter.scenario({
  "name": "ValidarTodosOsCamposObrigatorios",
  "description": "",
  "keyword": "Cenario",
  "tags": [
    {
      "name": "@F001_CE_001_PreencherEEnviarFormularios"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "preencher o formulario enter Vehicle Data",
  "keyword": "Quando "
});
formatter.match({
  "location": "F001_PreencherFormularioEnterVehicleDataSteps.preencher_o_formulario_enter_Vehicle_Data()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "preencher o formulario enter Insurant Data",
  "keyword": "E "
});
formatter.match({
  "location": "F002_PreencherFormularioEnterInsurantDataSteps.preencher_o_formulario_enter_Insurant_Data()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "preencher o formulario enter Product Data",
  "keyword": "E "
});
formatter.match({
  "location": "F003_PreencherFormularioEnterProductDataSteps.preencher_o_formulario_enter_Product_Data()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "preencher o formulario Select Price Option",
  "keyword": "E "
});
formatter.match({
  "location": "F004_PreencherFormularioSelectPriceOptionSteps.preencher_o_formulario_Select_Price_Option()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "preencher o formulario Send Quote",
  "keyword": "E "
});
formatter.match({
  "location": "F005_PreencherFormularioSendQuoteSteps.preencher_o_formulario_Send_Quote()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "o sistema valida a mensagem de sucesso",
  "keyword": "Entao "
});
formatter.match({
  "location": "F005_PreencherFormularioSendQuoteSteps.o_sistema_valida_a_mensagem_de_sucesso()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png", null);
formatter.after({
  "status": "passed"
});
});