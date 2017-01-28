import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class testPelen {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://torak28.github.io";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testPelen() throws Exception {
    driver.get(baseUrl + "/test");
    driver.findElement(By.id("input1")).clear();
    driver.findElement(By.id("input1")).sendKeys("1");
    driver.findElement(By.id("button1")).click();
    driver.findElement(By.id("input2")).clear();
    driver.findElement(By.id("input2")).sendKeys("2");
    driver.findElement(By.id("button2")).click();
    driver.findElement(By.id("input3")).clear();
    driver.findElement(By.id("input3")).sendKeys("3");
    driver.findElement(By.id("button3")).click();
    driver.findElement(By.id("input4")).clear();
    driver.findElement(By.id("input4")).sendKeys("4");
    driver.findElement(By.id("button4")).click();
    driver.findElement(By.id("input5")).clear();
    driver.findElement(By.id("input5")).sendKeys("5");
    driver.findElement(By.id("button5")).click();
    driver.findElement(By.cssSelector("button")).click();
    driver.findElement(By.id("input5")).clear();
    driver.findElement(By.id("input5")).sendKeys("");
    driver.findElement(By.id("input4")).clear();
    driver.findElement(By.id("input4")).sendKeys("");
    driver.findElement(By.id("input3")).clear();
    driver.findElement(By.id("input3")).sendKeys("");
    driver.findElement(By.id("input2")).clear();
    driver.findElement(By.id("input2")).sendKeys("");
    driver.findElement(By.id("input1")).clear();
    driver.findElement(By.id("input1")).sendKeys("6");
    driver.findElement(By.id("input2")).clear();
    driver.findElement(By.id("input2")).sendKeys("7");
    driver.findElement(By.id("input3")).clear();
    driver.findElement(By.id("input3")).sendKeys("8");
    driver.findElement(By.id("input4")).clear();
    driver.findElement(By.id("input4")).sendKeys("9");
    driver.findElement(By.id("input5")).clear();
    driver.findElement(By.id("input5")).sendKeys("10");
    driver.findElement(By.xpath("(//button[@id='buttonInit'])[2]")).click();
    driver.findElement(By.cssSelector("button")).click();
    driver.findElement(By.id("buttonInit")).click();
    driver.findElement(By.cssSelector("button")).click();
    driver.findElement(By.id("input1")).clear();
    driver.findElement(By.id("input1")).sendKeys("");
    driver.findElement(By.id("input2")).clear();
    driver.findElement(By.id("input2")).sendKeys("");
    driver.findElement(By.id("input3")).clear();
    driver.findElement(By.id("input3")).sendKeys("");
    driver.findElement(By.id("input4")).clear();
    driver.findElement(By.id("input4")).sendKeys("");
    driver.findElement(By.id("input5")).clear();
    driver.findElement(By.id("input5")).sendKeys("");
    driver.findElement(By.id("input1")).clear();
    driver.findElement(By.id("input1")).sendKeys("Jarek");
    driver.findElement(By.id("button1")).click();
    driver.findElement(By.cssSelector("button")).click();
    driver.findElement(By.id("input1")).clear();
    driver.findElement(By.id("input1")).sendKeys("2");
    driver.findElement(By.id("button1")).click();
    driver.findElement(By.cssSelector("button")).click();
    String tekst = driver.findElement(By.xpath("//*[@id=\"tekst\"]/b")).getText();
    String tabelka = driver.findElement(By.xpath("//*[@id=\"tabelka\"]")).getText();
	  //Sprawdzenie tekstu
    assertEquals(tekst, "Taki tam przykładowy tekst");
	  //Sprawdzenie tabeli stworzonej z inputow
    assertEquals(tabelka, "1,2,3,4,5,6,7,8,9,10,2");
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
