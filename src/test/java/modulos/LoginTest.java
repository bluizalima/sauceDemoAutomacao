package modulos;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.LoginPage;

import java.time.Duration;

@DisplayName("Login com usuário bloqueado, e validar a mensagem de bloqueio exibida")
public class LoginTest {

    private WebDriver navegador;

    @BeforeEach
    public void beforeEach() {

       //Abrir o Navegador
        System.setProperty("webdriver.chrome.driver","C:\\drivers\\chromedriver98\\chromedriver.exe");
        this.navegador = new ChromeDriver();

        //maximizar a tela
        this.navegador.manage().window().maximize();

        //tempo de espera padrão
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Navegar para a pagina da Sauce
        this.navegador.get("https://www.saucedemo.com");
    }

    @Test
    public void testLoginComUsuarioBloqueado(){
        String validaMensagemBloqueio = new LoginPage(navegador)
                .preencherUsuario("locked_out_user")
                .preencherSenha("secret_sauce")
                .submeterLoginComProblema()
                .capturarMensagemComErro();
        Assertions.assertEquals("Epic sadface: Sorry, this user has been locked out.", validaMensagemBloqueio);
    }

    @Test
    public void testLoginUsuarioComProblema(){
        //Fazer Login com usuario com problema
        new LoginPage(navegador)
                .preencherUsuario("problem_user")
                .preencherSenha("secret_sauce")
                .submeterLogin();

        // Validar usuario com problema verificando se existem dois produtos iguais
        String validaProduto1 = navegador.findElement(By.cssSelector("#item_0_img_link > img")).getText();
        String validaProduto2 = navegador.findElement(By.cssSelector("#item_0_img_link > img")).getText();
        Assertions.assertEquals(validaProduto1,validaProduto2);
    }

    @AfterEach
    public void afterEach(){
        //fecha o navegador
        navegador.quit();
    }

}
