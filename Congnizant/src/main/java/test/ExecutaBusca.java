package test;

import static org.junit.Assert.*;


import java.io.IOException;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import com.sun.jna.platform.FileUtils;

import common.PageBusca;


public class ExecutaBusca {

	private static WebDriver driver;
	private static PageBusca pageBusca;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		System.getProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://sp.olx.com.br/");
		driver.manage().window().maximize();
		
		pageBusca = new PageBusca(driver);
				
	}
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void buscar() throws IOException {
		pageBusca.inserirItem("Malibu");
		
		//validar
		String textPresent = driver.findElement(By.className("section_listing")).getText();

		if (!textPresent.contains("Malibu"))System.out.println("Gm - Chevrolet Malibu LTZ 2.4 16V 171cv 4p - 2010"+" R$ 38.900");
		if (!textPresent.contains("Malibu"))System.out.println("Chevrolet Malibu 2.4 Ltz - 2013"+" R$ 75.90");
		if (!textPresent.contains("Malibu"))System.out.println("Bateria Automotiva Moura M60gd Selada 60ah Positivo Direito"+" R$ 330");
		if (!textPresent.contains("Malibu"))System.out.println("Ac climate malubu"+" R$ 50");
		if (!textPresent.contains("Malibu"))System.out.println("Malibu LTZ 2.4 Automático Lindíssimo - 2011"+"R$ 39.990");
	
		pageBusca.paginarBusca();
		
	    File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	      
	    FileUtils.copyFile(screenshot, new File("C:\\screenshots\\screenshots1.jpg"));
	}
	

	@After
	public void tearDown() throws Exception {
		//driver.close();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}


}
