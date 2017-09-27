package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBusca {
	
	static WebDriver driver;
	private WebDriverWait wait;

	public PageBusca(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inserirItem(String itemBusca){
		driver.findElement(By.id("searchtext")).sendKeys(itemBusca);
	}
	public void clicarBusca(){
		//wait.until(ExpectedConditions.elementIfVisible("searchbutton"));
		driver.findElement(By.xpath(".//*[@id='searchbutton']")).click();
				//("searchbutton")).submit();
	}
	//inserir dados para busca
	public void realizarBusca(String itemBusca){
		inserirItem(itemBusca);
		clicarBusca();
	}

	public void paginarBusca(){
		By pagina = By.className("item number active");
		if (pagina.equals(2)){
		driver.findElement(pagina).click();
		}
	}
	
}
