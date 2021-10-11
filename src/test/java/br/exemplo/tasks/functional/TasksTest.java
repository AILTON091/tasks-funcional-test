package br.exemplo.tasks.functional;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TasksTest {

	public WebDriver acessoAplicacao() {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://localhost:8001/tasks");	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	
	@Test
	public void deveSalvarTarefaComSucesso() {
		WebDriver driver = acessoAplicacao();
		try {
			//clicar em add Todo 
			driver.findElement(By.id("addTodo")).click();
			
			//escrever descricao 
			driver.findElement(By.id("task")).sendKeys("Teste via selenium");
			
			//escrever data futura
			driver.findElement(By.id("dueDate")).sendKeys("10/10/2030");
			
			//clicar em salvar 
			driver.findElement(By.id("saveButton")).click();
			
			//validar mensagem de sucesso
			String message = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Success!", message);
		
		} finally {
			//fecha o browser
			driver.quit();				
		}		
	}
	
	@Test
	public void deveSalvarTarefaSemDesrcricao() {
		WebDriver driver = acessoAplicacao();
		try {
			//clicar em add Todo 
			driver.findElement(By.id("addTodo")).click();
			
			//escrever data futura
			driver.findElement(By.id("dueDate")).sendKeys("10/10/2030");
			
			//clicar em salvar 
			driver.findElement(By.id("saveButton")).click();
			
			//validar mensagem de sucesso
			String message = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Fill the task description", message);
		
		} finally {
			//fecha o browser
			driver.quit();				
		}		
	}
}
