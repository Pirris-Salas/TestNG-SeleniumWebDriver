import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class ProductTests {

    WebDriver webDriver = null;
    ProductDataClass data = null;

    @BeforeMethod
    public void start(){
        data = new ProductDataClass(
                "Tornillo",
                "Tornillo de 1 pulgada",
                "",
                "",
                "Ferretería",
                "EPA",
                "Dewal"
        );

        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("http://oscaraw.com/qa/productos.php");
        webDriver.manage().window().maximize();
    }

    @Test(testName = "Caso de Prueba 14")
    public void emptyProductName(){
        WebElement link = webDriver.findElement(By.linkText("Agregar producto"));
        link.click();


        WebElement name = webDriver.findElement(By.name("nombre"));
        WebElement description = webDriver.findElement(By.name("descripcion"));
        WebElement category = webDriver.findElement(By.name("categoria"));
        WebElement provider = webDriver.findElement(By.name("proveedor"));
        WebElement brand = webDriver.findElement(By.name("marca"));

        name.sendKeys(data.getEmptyProductName());
        description.sendKeys(data.getProductDescription());
        category.sendKeys(data.getCategory());
        provider.sendKeys(data.getProvider());
        brand.sendKeys(data.getBrand());

        brand.submit();

        WebElement confirmationMessage = webDriver.findElement(By.id("confir"));
        String message = confirmationMessage.getText();

        assertNotEquals(message, "Producto registrado");
    }

    @Test(testName = "Caso de Prueba 15")
    public void emptyProductDecription(){
        WebElement link = webDriver.findElement(By.linkText("Agregar producto"));
        link.click();


        WebElement name = webDriver.findElement(By.name("nombre"));
        WebElement description = webDriver.findElement(By.name("descripcion"));
        WebElement category = webDriver.findElement(By.name("categoria"));
        WebElement provider = webDriver.findElement(By.name("proveedor"));
        WebElement brand = webDriver.findElement(By.name("marca"));

        name.sendKeys(data.getProvider());
        description.sendKeys(data.getEmptyProductDescription());
        category.sendKeys(data.getCategory());
        provider.sendKeys(data.getProvider());
        brand.sendKeys(data.getBrand());

        brand.submit();

        WebElement confirmationMessage = webDriver.findElement(By.id("confir"));
        String message = confirmationMessage.getText();

        assertNotEquals(message, "Producto registrado");
    }

    @Test(testName = "Caso de Prueba 16")
    public void validNewProduct(){
        WebElement link = webDriver.findElement(By.linkText("Agregar producto"));
        link.click();


        WebElement name = webDriver.findElement(By.name("nombre"));
        WebElement description = webDriver.findElement(By.name("descripcion"));
        WebElement category = webDriver.findElement(By.name("categoria"));
        WebElement provider = webDriver.findElement(By.name("proveedor"));
        WebElement brand = webDriver.findElement(By.name("marca"));

        name.sendKeys(data.getProductName());
        description.sendKeys(data.getProductDescription());
        category.sendKeys(data.getCategory());
        provider.sendKeys(data.getProvider());
        brand.sendKeys(data.getBrand());

        brand.submit();

        WebElement confirmationMessage = webDriver.findElement(By.id("confir"));
        String message = confirmationMessage.getText();

        assertEquals(message, "Producto registrado");
    }

    @AfterMethod
    public void end(){
        webDriver.quit();
    }
}
