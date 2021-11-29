#language: pt
#encoding: UTF8 

Funcionalidade: Preencher Formulario
  Como um usuario quando entro no sistema faco o preenchimento do formulario

@F001_CE_001_PreencherEEnviarFormularios
  Cenario: ValidarTodosOsCamposObrigatorios
	    Quando preencher o formulario enter Vehicle Data
	    E preencher o formulario enter Insurant Data
	 		E preencher o formulario enter Product Data
	 		E preencher o formulario Select Price Option
	 		E preencher o formulario Send Quote
 		  Entao o sistema valida a mensagem de sucesso
    

    