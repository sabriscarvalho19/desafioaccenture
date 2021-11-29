package stepsDefinitions;

import static utils.Utils.driver;

import static utils.Utils.acessarSistema;
import static utils.Utils.capturarScreenshot;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	@Before()
	public void setUp() {
		acessarSistema();
	}
	
	@After()
	public void down(Scenario scenario) {
		capturarScreenshot(scenario);
		driver.quit();
	}
}
