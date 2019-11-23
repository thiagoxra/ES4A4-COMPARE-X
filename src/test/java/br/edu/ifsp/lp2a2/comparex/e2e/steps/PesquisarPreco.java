package br.edu.ifsp.lp2a2.comparex.e2e.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PesquisarPreco {
    private WebDriver driver;
    @Given("Estou na página inicial da minha aplicação")
    public void pagina_inicial(){
        this.driver = new PhantomJSDriver();
        this.driver.get("http://localhost:8080/");
        String actual = this.driver.getTitle();
        String expected = "comparex";
        assertTrue(actual.toLowerCase().contains(expected));
    }
    @When("Eu digito dentro do campo {string} o texto {string}")
    public void digitar_algo(String where , String text){
        WebElement input = this.driver.findElement(By.cssSelector("input[name="+where +"]"));
        input.sendKeys(text);
        String actual = input.getAttribute("value");
        assertEquals(text, actual);
    }
    @And("clico no botão {string}")
    public void click_botao(String where){
        WebElement button = this.driver.findElement(By.id(where));
        button.click();
    }
    @Then("Devo ser redirecionado para a página {string}")
    public void redirect(String to){
        String actual = this.driver.getTitle();
        String expected = "Resultado da busca";
        assertTrue("mensagem válida", actual.contains(expected) );;
        this.driver.close();
    }


}
