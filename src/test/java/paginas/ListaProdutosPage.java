package paginas;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListaProdutosPage {

    private WebDriver navegador;

    public ListaProdutosPage(WebDriver navegador){
        this.navegador = navegador;

    }

    public ListaProdutosPage adicionarProdutos (){
        navegador.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        navegador.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        navegador.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        navegador.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
        navegador.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        navegador.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();

        return this;
    }

    public ListaProdutosPage adicionarProdutosEspecificos(){
        navegador.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        navegador.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        navegador.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
        return this;
    }
    public CheckoutPage acessarCarrinho(){
        navegador.findElement(By.id("shopping_cart_container")).click();
        return new CheckoutPage(navegador);
    }


}
