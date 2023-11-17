/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package webdriverdemo;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Eduardo
 */
public class WebDriverDemoTest {
    
    WebDriver driver;
    
    public WebDriverDemoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        //Set up web driver (chrome, firefox,...)
	//System.setProperty("webdriver.gecko.driver",
        //       "C:\\...\\Selenium\\Selenium WebDriver\\Java\\Libs\\geckodriver-v0.23.0-win32\\geckodriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        //Launch website
        driver.navigate().to("http://www.calculator.net/");

        //Maximize the browser
        driver.manage().window().maximize();

        // Click on Math Calculators
        driver.findElement(By.xpath("//*[@id=\"homelistwrap\"]/div[3]/div[2]/a")).click();

        // Click on Percent Calculators
        driver.findElement(By.xpath("//*[@id=\"content\"]/table[2]/tbody/tr/td/div[3]/a")).click();
    }
    
    @After
    public void tearDown() {
        //Close the Browser.
        driver.close();
    }

    @Test
    public void testNegativoNegativo() {
        driver.findElement(By.id("cpar1")).sendKeys("-10");
        driver.findElement(By.id("cpar2")).sendKeys("-10");
        driver.findElement(By.xpath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).click();
        String result = driver.findElement(By.xpath(".//*[@id = 'content']/p[2]/font/b")).getText();
        assertEquals("1", result);
    }

    @Test
    public void testNegativoPositivo() {
        driver.findElement(By.id("cpar1")).sendKeys("-10");
        driver.findElement(By.id("cpar2")).sendKeys("10");
        driver.findElement(By.xpath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).click();
        String result = driver.findElement(By.xpath(".//*[@id = 'content']/p[2]/font/b")).getText();
        assertEquals("-1", result);
    }
    
    @Test
    public void testPositivoNegativo() {
        driver.findElement(By.id("cpar1")).sendKeys("10");
        driver.findElement(By.id("cpar2")).sendKeys("-10");
        driver.findElement(By.xpath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).click();
        String result = driver.findElement(By.xpath(".//*[@id = 'content']/p[2]/font/b")).getText();
        assertEquals("-1", result);
    }
    
    @Test
    public void testPositivoPositivo() {
        driver.findElement(By.id("cpar1")).sendKeys("10");
        driver.findElement(By.id("cpar2")).sendKeys("10");
        driver.findElement(By.xpath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).click();
        String result = driver.findElement(By.xpath(".//*[@id = 'content']/p[2]/font/b")).getText();
        assertEquals("-1", result);
    }
    
    @Test
    public void test1Parametro() {
        driver.findElement(By.id("cpar1")).sendKeys("10");
        driver.findElement(By.id("cpar2")).sendKeys("");
        driver.findElement(By.xpath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).click();
        String result = driver.findElement(By.xpath(".//*[@id = 'content']/p[2]/font/b")).getText();
        assertEquals("", result);
    }
    
    @Test
    public void test3Parametros() {
        driver.findElement(By.id("cpar1")).sendKeys("10 20");
        driver.findElement(By.id("cpar2")).sendKeys("10");
        driver.findElement(By.xpath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).click();
        String result = driver.findElement(By.xpath(".//*[@id = 'content']/p[2]/font/b")).getText();
        assertEquals("", result);
    }
    
    @Test
    public void testIntNoint() {
        driver.findElement(By.id("cpar1")).sendKeys("10");
        driver.findElement(By.id("cpar2")).sendKeys("LOL");
        driver.findElement(By.xpath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).click();
        String result = driver.findElement(By.xpath(".//*[@id = 'content']/p[2]/font/b")).getText();
        assertEquals("", result);
    }
    
    @Test
    public void testNointInt() {
        driver.findElement(By.id("cpar1")).sendKeys("1.7e");
        driver.findElement(By.id("cpar2")).sendKeys("10");
        driver.findElement(By.xpath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).click();
        String result = driver.findElement(By.xpath(".//*[@id = 'content']/p[2]/font/b")).getText();
        assertEquals("", result);
    }
    
    @Test
    public void testNointNoint() {
        driver.findElement(By.id("cpar1")).sendKeys("@");
        driver.findElement(By.id("cpar2")).sendKeys(".-.");
        driver.findElement(By.xpath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).click();
        String result = driver.findElement(By.xpath(".//*[@id = 'content']/p[2]/font/b")).getText();
        assertEquals("", result);
    }
}
