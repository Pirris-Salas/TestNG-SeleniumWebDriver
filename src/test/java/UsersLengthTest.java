import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class UsersLengthTest {

    WebDriver webDriver = null;
    UserDataClass data = null;

   @BeforeMethod
   public void start(){
       data = new UserDataClass(
               "Luis Salas",
               "UsuarioUniversidadCreativa.12345",
               "UsuarioUniversidadCreativa.12",
               "UsuarioUniversidadCreativa.12",
               "",
               "Creativa1234"
               );
       System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
       webDriver = new ChromeDriver();
       webDriver.get("http://oscaraw.com/qa/registro.php");
       webDriver.manage().window().maximize();
   }

    @Test(testName = "Caso de Prueba 1")
    public void largestUserTest(){
        WebElement name = webDriver.findElement(By.name("nombre"));
        WebElement user = webDriver.findElement(By.name("usuario"));
        WebElement password = webDriver.findElement(By.name("password"));

        name.sendKeys(data.getGenericName());
        user.sendKeys(data.getLargestUserName());
        password.sendKeys(data.getGenericPassword());

        password.submit();

        WebElement confirmationElement = webDriver.findElement(By.id("confir"));
        String confirmationText = confirmationElement.getText();

        assertNotEquals(confirmationText, "Usuario registrado");

    }

    @Test(testName = "Caso de Prueba 2")
    public void valid29LengthUserName(){
        WebElement name = webDriver.findElement(By.name("nombre"));
        WebElement user = webDriver.findElement(By.name("usuario"));
        WebElement password = webDriver.findElement(By.name("password"));

        name.sendKeys(data.getGenericName());
        user.sendKeys(data.getValid29LengthUserName());
        password.sendKeys(data.getGenericPassword());

        password.submit();

        WebElement confirmationElement = webDriver.findElement(By.id("confir"));
        String confirmationText = confirmationElement.getText();

        assertEquals(confirmationText, "Usuario registrado");
    }

    @Test(testName = "Caso de Prueba 3")
    public void valid30LengthUserName(){
        WebElement name = webDriver.findElement(By.name("nombre"));
        WebElement user = webDriver.findElement(By.name("usuario"));
        WebElement password = webDriver.findElement(By.name("password"));

        name.sendKeys(data.getGenericName());
        user.sendKeys(data.getValid30LengthUserName());
        password.sendKeys(data.getGenericPassword());

        password.submit();

        WebElement confirmationElement = webDriver.findElement(By.id("confir"));
        String confirmationText = confirmationElement.getText();

        assertEquals(confirmationText, "Usuario registrado");
    }

    @Test(testName = "Caso de Prueba 4")
    public void emptyUserName(){
        WebElement name = webDriver.findElement(By.name("nombre"));
        WebElement user = webDriver.findElement(By.name("usuario"));
        WebElement password = webDriver.findElement(By.name("password"));

        name.sendKeys(data.getGenericName());
        user.sendKeys(data.getEmptyUserName());
        password.sendKeys(data.getGenericPassword());

        password.submit();

        WebElement confirmationElement = webDriver.findElement(By.id("confir"));
        String confirmationText = confirmationElement.getText();

        assertNotEquals(confirmationText, "Usuario registrado");
    }

    @AfterMethod
    public void end(){
       webDriver.quit();
    }
}
