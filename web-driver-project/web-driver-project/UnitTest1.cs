using Xunit;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

namespace web_driver_project
{
    public abstract class TestGeneral : IDisposable
    {
        public
        WebDriver driver;
        protected TestGeneral()
        {
            driver = new ChromeDriver();
            driver.Navigate().GoToUrl("http://www.calculator.net/");
            driver.Manage().Window.Maximize();
            driver.FindElement(By.XPath("//*[@id=\"homelistwrap\"]/div[3]/div[2]/a")).Click();
            driver.FindElement(By.XPath("//*[@id=\"content\"]/table[2]/tbody/tr/td/div[3]/a")).Click();
        }

        public void Dispose()
        {
            driver.Close();
        }
    }
    public class UnitTest1 : TestGeneral
    {
        [Fact]
        public void TestNegativoNegativo()
        {
            driver.FindElement(By.Id("cpar1")).SendKeys("-10");
            driver.FindElement(By.Id("cpar2")).SendKeys("-10");
            driver.FindElement(By.XPath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).Click();
            IWebElement result = driver.FindElement(By.XPath("//*[@id = 'content']/p[2]/font/b"));
            Assert.Equal("1", result.Text);
        }

        [Fact]
        public void TestNegativoPositivo()
        {
            driver.FindElement(By.Id("cpar1")).SendKeys("-10");
            driver.FindElement(By.Id("cpar2")).SendKeys("10");
            driver.FindElement(By.XPath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).Click();
            IWebElement result = driver.FindElement(By.XPath("//*[@id = 'content']/p[2]/font/b"));
            Assert.Equal("-1", result.Text);
        }

        [Fact]
        public void TestPositivoNegativo()
        {
            driver.FindElement(By.Id("cpar1")).SendKeys("10");
            driver.FindElement(By.Id("cpar2")).SendKeys("-10");
            driver.FindElement(By.XPath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).Click();
            IWebElement result = driver.FindElement(By.XPath("//*[@id = 'content']/p[2]/font/b"));
            Assert.Equal("-1", result.Text);
        }

        [Fact]
        public void TestPositivoPositivo()
        {
            driver.FindElement(By.Id("cpar1")).SendKeys("10");
            driver.FindElement(By.Id("cpar2")).SendKeys("10");
            driver.FindElement(By.XPath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).Click();
            IWebElement result = driver.FindElement(By.XPath("//*[@id = 'content']/p[2]/font/b"));
            Assert.Equal("1", result.Text);
        }

        [Fact]
        public void Test1Parametro()
        {
            driver.FindElement(By.Id("cpar1")).SendKeys("10");
            driver.FindElement(By.Id("cpar2")).SendKeys("");
            driver.FindElement(By.XPath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).Click();
            IWebElement result = driver.FindElement(By.XPath("//*[@id = 'content']/p[2]/font"));
            Assert.Equal("Please provide two numeric values in any fields below.", result.Text);
        }

        [Fact]
        public void Test3Parametros()
        {
            driver.FindElement(By.Id("cpar1")).SendKeys("10 y 20");
            driver.FindElement(By.Id("cpar2")).SendKeys("10");
            driver.FindElement(By.XPath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).Click();
            IWebElement result = driver.FindElement(By.XPath("//*[@id = 'content']/p[2]/font"));
            Assert.Equal("Please provide two numeric values in any fields below.", result.Text);
        }

        [Fact]
        public void TestIntNoint()
        {
            driver.FindElement(By.Id("cpar1")).SendKeys("10");
            driver.FindElement(By.Id("cpar2")).SendKeys("LOL");
            driver.FindElement(By.XPath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).Click();
            IWebElement result = driver.FindElement(By.XPath("//*[@id = 'content']/p[2]/font"));
            Assert.Equal("Please provide two numeric values in any fields below.", result.Text);
        }

        [Fact]
        public void TestNointInt()
        {
            driver.FindElement(By.Id("cpar1")).SendKeys("1.7e");
            driver.FindElement(By.Id("cpar2")).SendKeys("10");
            driver.FindElement(By.XPath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).Click();
            IWebElement result = driver.FindElement(By.XPath("//*[@id = 'content']/p[2]/font"));
            Assert.Equal("Please provide two numeric values in any fields below.", result.Text);
        }

        [Fact]
        public void TestNointNoint()
        {
            driver.FindElement(By.Id("cpar1")).SendKeys("@");
            driver.FindElement(By.Id("cpar2")).SendKeys(".-.");
            driver.FindElement(By.XPath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).Click();
            IWebElement result = driver.FindElement(By.XPath("//*[@id = 'content']/p[2]/font"));
            Assert.Equal("Please provide two numeric values in any fields below.", result.Text);
        }
    }
}