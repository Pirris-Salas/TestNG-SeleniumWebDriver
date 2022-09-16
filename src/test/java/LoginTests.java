import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTests {
    WebDriver webDriver = null;
    LoginDataClass data = null;
    @BeforeMethod
    public void start(){
        data = new LoginDataClass(
                "prueba3",
                "prueba3",
                "TEST",
                "TEST"
        );
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("http://oscaraw.com/qa/index.php?");
        webDriver.manage().window().maximize();
    }

    @Test(testName = "Caso de Prueba 11")
    public void validLogin(){
        WebElement user = webDriver.findElement(By.name("user"));
        WebElement password = webDriver.findElement(By.name("pass"));

        user.sendKeys(data.getValidUser());
        password.sendKeys(data.getValidPassword());

        password.submit();

        String currentPage = webDriver.getCurrentUrl();

        assertEquals(currentPage, "http://oscaraw.com/qa/productos.php");

    }

    @Test(testName = "Caso de Prueba 12")
    public void wrongUser(){
        WebElement user = webDriver.findElement(By.name("user"));
        WebElement password = webDriver.findElement(By.name("pass"));

        user.sendKeys(data.getWrongUser());
        password.sendKeys(data.getValidPassword());

        password.submit();

        WebElement error = webDriver.findElement(By.id("error"));
        String errorMessage = error.getText();

        assertEquals(errorMessage, "Usuario o contreña invalido.");

    }

    @Test(testName = "Caso de Prueba 13")
    public void wrongPassword(){
        WebElement user = webDriver.findElement(By.name("user"));
        WebElement password = webDriver.findElement(By.name("pass"));

        user.sendKeys(data.getValidUser());
        password.sendKeys(data.getWrongPassword());

        password.submit();

        WebElement error = webDriver.findElement(By.id("error"));
        String errorMessage = error.getText();

        assertEquals(errorMessage, "Usuario o contreña invalido.");

    }

    @AfterMethod
    public void fin(){
        webDriver.quit();
    }
}
