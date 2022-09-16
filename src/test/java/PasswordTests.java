import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class PasswordTests {
    WebDriver webDriver = null;
    PasswordDataClass data = null;

    @BeforeMethod
    public void start(){
        data = new PasswordDataClass(
                "Luis Salas",
                "UsuarioUniversidadCreativa.12",
                "1234",
                "Crea12",
                "CREA12",
                "crea12",
                "Creativ",
                "1234567"
        );
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("http://oscaraw.com/qa/registro.php");
        webDriver.manage().window().maximize();
    }

    @Test(testName = "Caso de Prueba 5")
    public void passwordInvalidLength(){
        WebElement name = webDriver.findElement(By.name("nombre"));
        WebElement user = webDriver.findElement(By.name("usuario"));
        WebElement password = webDriver.findElement(By.name("password"));

        name.sendKeys(data.getGenericName());
        user.sendKeys(data.getGenericUserName());
        password.sendKeys(data.getShortPassword());

        password.submit();

        WebElement confirmationElement = webDriver.findElement(By.id("confir"));
        String confirmationText = confirmationElement.getText();

        assertNotEquals(confirmationText, "Usuario registrado");
    }

    @Test(testName = "Caso de Prueba 6")
    public void validPassword(){
        WebElement name = webDriver.findElement(By.name("nombre"));
        WebElement user = webDriver.findElement(By.name("usuario"));
        WebElement password = webDriver.findElement(By.name("password"));

        name.sendKeys(data.getGenericName());
        user.sendKeys(data.getGenericUserName());
        password.sendKeys(data.getValidPassword());

        password.submit();

        WebElement confirmationElement = webDriver.findElement(By.id("confir"));
        String confirmationText = confirmationElement.getText();

        assertEquals(confirmationText, "Usuario registrado");
    }

    @Test(testName = "Caso de Prueba 7")
    public void upperCaseNumbersPassword(){
        WebElement name = webDriver.findElement(By.name("nombre"));
        WebElement user = webDriver.findElement(By.name("usuario"));
        WebElement password = webDriver.findElement(By.name("password"));

        name.sendKeys(data.getGenericName());
        user.sendKeys(data.getGenericUserName());
        password.sendKeys(data.getUpercaseNumbersPassword());

        password.submit();

        WebElement confirmationElement = webDriver.findElement(By.id("confir"));
        String confirmationText = confirmationElement.getText();

        assertNotEquals(confirmationText, "Usuario registrado");
    }

    @Test(testName = "Caso de Prueba 8")
    public void lowerCaseNumbersPassword(){
        WebElement name = webDriver.findElement(By.name("nombre"));
        WebElement user = webDriver.findElement(By.name("usuario"));
        WebElement password = webDriver.findElement(By.name("password"));

        name.sendKeys(data.getGenericName());
        user.sendKeys(data.getGenericUserName());
        password.sendKeys(data.getLowercaseNumbersPassword());

        password.submit();

        WebElement confirmationElement = webDriver.findElement(By.id("confir"));
        String confirmationText = confirmationElement.getText();

        assertNotEquals(confirmationText, "Usuario registrado");
    }

    @Test(testName = "Caso de Prueba 9")
    public void lettersOnlyPassword(){
        WebElement name = webDriver.findElement(By.name("nombre"));
        WebElement user = webDriver.findElement(By.name("usuario"));
        WebElement password = webDriver.findElement(By.name("password"));

        name.sendKeys(data.getGenericName());
        user.sendKeys(data.getGenericUserName());
        password.sendKeys(data.getLettersOnlyPassword());

        password.submit();

        WebElement confirmationElement = webDriver.findElement(By.id("confir"));
        String confirmationText = confirmationElement.getText();

        assertNotEquals(confirmationText, "Usuario registrado");
    }

    @Test(testName = "Caso de Prueba 10")
    public void numbersOnlyPassword(){
        WebElement name = webDriver.findElement(By.name("nombre"));
        WebElement user = webDriver.findElement(By.name("usuario"));
        WebElement password = webDriver.findElement(By.name("password"));

        name.sendKeys(data.getGenericName());
        user.sendKeys(data.getGenericUserName());
        password.sendKeys(data.getNumbersOnlyPassword());

        password.submit();

        WebElement confirmationElement = webDriver.findElement(By.id("confir"));
        String confirmationText = confirmationElement.getText();

        assertNotEquals(confirmationText, "Usuario registrado");
    }


    @AfterMethod
    public void fin(){
       webDriver.quit();
    }
}
