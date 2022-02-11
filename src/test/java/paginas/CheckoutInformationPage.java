package paginas;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInformationPage {

    private WebDriver navegador;

    public CheckoutInformationPage (WebDriver navegador){
        this.navegador = navegador;
    }

    public CheckoutInformationPage preencherNome (String nome){
        navegador.findElement(By.id("first-name")).sendKeys(nome);
        return this;
    }

    public CheckoutInformationPage preencherSobrenome (String sobrenome){
        navegador.findElement(By.id("last-name")).sendKeys(sobrenome);
        return this;
    }

    public CheckoutInformationPage preencherCep (String cep){
        navegador.findElement(By.id("postal-code")).sendKeys(cep);
        return this;
    }

    public CheckoutOverviewPage acessarCheckoutOverview() {
        navegador.findElement(By.id("continue")).click();
        return new CheckoutOverviewPage(navegador);
    }
}



