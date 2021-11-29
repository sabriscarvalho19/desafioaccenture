package utils;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

import io.cucumber.core.api.Scenario;

public class Utils {
	public static WebDriver driver = new FirefoxDriver();
	public static Faker fake = new Faker();
	public static void acessarSistema() {
		
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://sampleapp.tricentis.com/101/app.php");
	}
	
	public static <T>T Na(Class<T> classe){
		return PageFactory.initElements(driver, classe);
	}
	
	public static void capturarScreenshot(Scenario scenario) {
		final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.embed(screenshot, "image/png");
	}
	
	public static void aguardarLoading(WebElement elemento) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(elemento));
	}
	
	public static String dateManufacture() {
		LocalDate date = LocalDate.now();
		return date.getMonthValue() + "/" + date.getDayOfMonth() + "/" +date.getYear();
	}
	
	public static String dateBirth() {
		LocalDate date = LocalDate.now();
		Date dateInicial = Date.valueOf(date.minusYears(70));
		Date dateFinal = Date.valueOf(date.minusYears(18));
		LocalDate dateBirth = LocalDate.from(fake.date().between(dateInicial, dateFinal).toInstant().atZone(ZoneId.systemDefault()));
		return dateBirth.getMonthValue() +"/"+ dateBirth.getDayOfMonth()+"/"+dateBirth.getYear();
		
	}
	
	public static String startDate() {	
		LocalDate startDate = LocalDate.from(LocalDate.now().plusYears(fake.number().randomDigitNotZero()));
		return startDate.getMonthValue() +"/"+ startDate.getDayOfMonth()+"/"+startDate.getYear();	
	}

}
