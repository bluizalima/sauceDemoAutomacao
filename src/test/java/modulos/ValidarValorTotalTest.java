package modulos;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.LoginPage;

import java.time.Duration;

@DisplayName("Adicionar todos os produtos ao carrinho e validar o valor total da compra a ser pago.")

public class ValidarValorTotalTest {

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
    public void testAdicionarProdutoValidarOTotaldaCompra(){
        String valorTotal = new LoginPage(navegador)
                .preencherUsuario("standard_user")
                .preencherSenha("secret_sauce")
                .submeterLogin()
                .adicionarProdutos()
                .acessarCarrinho()
                .acessarCheckoutInformation()
                .preencherNome("Bruna")
                .preencherSobrenome("Lima")
                .preencherCep("13186130")
                .acessarCheckoutOverview()
                .validarValorTotal();
        Assertions.assertEquals("Total: $140.34", valorTotal);
    }

    @AfterEach
    public void afterEach(){
        //fecha o navegador
        navegador.quit();
    }

}
