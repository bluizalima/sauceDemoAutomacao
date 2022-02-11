package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {

    private WebDriver navegador;

    public CheckoutOverviewPage (WebDriver navegador){
        this.navegador = navegador;
    }

    public CheckoutOverviewPage finalizarCompra(){
        navegador.findElement(By.id("finish")).click();
        return this;
    }

    public String validarValorTotal(){
        return navegador.findElement(By.cssSelector("#checkout_summary_container > div > div.summary_info > div.summary_total_label")).getText();
    }

    public String validarFinalizacaoCompra(){
        return navegador.findElement(By.cssSelector("#checkout_complete_container > h2")).getText();
    }


}
