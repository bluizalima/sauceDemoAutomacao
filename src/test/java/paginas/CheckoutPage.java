package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private WebDriver navegador;

    public CheckoutPage (WebDriver navegador){
        this.navegador = navegador;

    }
    public CheckoutInformationPage acessarCheckoutInformation() {
        navegador.findElement(By.id("checkout")).click();
        return new CheckoutInformationPage(navegador);
    }
}
