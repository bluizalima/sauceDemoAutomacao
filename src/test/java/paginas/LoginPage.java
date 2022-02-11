package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.log.Log;

public class LoginPage {
    private WebDriver navegador;

    public LoginPage(WebDriver navegador){
        this.navegador = navegador;
    }

    public LoginPage preencherUsuario(String usuario){
        navegador.findElement(By.id("user-name")).sendKeys(usuario);
        return this;
    }

    public LoginPage preencherSenha(String senha){
        navegador.findElement(By.id("password")).sendKeys(senha);
        return this;
    }

    public LoginPage clicarBotaoLogin(String botaoLogin){
        navegador.findElement(By.id("login-button")).click();
        return this;
    }

    public LoginPage submeterLoginComProblema(){
        navegador.findElement(By.id("login-button")).click();
        return this;
    }


    public ListaProdutosPage submeterLogin(){
        navegador.findElement(By.id("login-button")).click();
        return new ListaProdutosPage(navegador);
    }

    public String capturarMensagemComErro(){
        return navegador.findElement(By.cssSelector("#login_button_container > div > form > div.error-message-container.error")).getText();
    }

}
