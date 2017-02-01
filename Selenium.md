# SystemLiniiLotniczych

Przygotowali
 * Jarosław Ciołek-Żelechowski, **218386**
 * Dominik Cecotka, **218339**
 
# Idea

Seleniu można potraktować jako swego rodzaju automatyzacje działania z możliwości sprawdzania czy działanie to przebiega po Nszej myśli. W dużej mierze opiera się to na nagrywaniu ruchów jakie wykonujemy i sprawdzaniu czy po ich odtworzeniu otrzymamy dokładnie taki sam wynik.
# Budowa Strony Pod Test

W celu przeprowadzenia testów aplikacji Internetowej postanowiliśmy takową napisać. Całość miała być dość prosta, kozystać z JavaScriptu i paru znaczników htmla. Całość prezentuje się następująco:
```html    
    <div id="tekst">
      <b>Taki tam przykładowy tekst</b>
    </div>
    <div id="tabela">
      <button onclick="myFunction()">Klik</button>
      <div>
        Tabelka:<p id="tabelka"> </p>
      </div>
    </div>
    <div id="input1Col" class="col-lg-6">
      <input type="text" style="color: #080808" id="input1"><button type="button" class="btn btn-success" id="button1" onclick="input1 = setInput1(); if(!isNaN(input1)){greet1();}"><b>Klik!</b></button>
    </div>
    <div id="input2Col" class="col-lg-6">
      <input type="text" style="color: #080808" id="input2"><button type="button" class="btn btn-success" id="button2" onclick="input2 = setInput2(); if(!isNaN(input2)){greet2();}"><b>Klik!</b></button>
    </div>
    <div id="input3Col" class="col-lg-6">
      <input type="text" style="color: #080808" id="input3"><button type="button" class="btn btn-success" id="button3" onclick="input3 = setInput3(); if(!isNaN(input3)){greet3();}"><b>Klik!</b></button>
    </div>
    <div id="input4Col" class="col-lg-6">
      <input type="text" style="color: #080808" id="input4"><button type="button" class="btn btn-success" id="button4" onclick="input4 = setInput4(); if(!isNaN(input4)){greet4();}"><b>Klik!</b></button>
    </div>
    <div id="input5Col" class="col-lg-6">
      <input type="text" style="color: #080808" id="input5"><button type="button" class="btn btn-success" id="button5" onclick="input5 = setInput5(); if(!isNaN(input5)){greet5();}"><b>Klik!</b></button>
    </div>
    <div id="buttonInitCol" class="col-lg-12">
        <button type="button" class="btn btn-success" id="buttonInit" onclick="setup()"><b>Reset!</b></button><button type="button" class="btn btn-success" id="buttonInit" onclick="input1 = setInput1(); if(!isNaN(input1)){greet1();}input2 = setInput2(); if(!isNaN(input2)){greet2();}input3 = setInput3(); if(!isNaN(input3)){greet3();}input4 = setInput4(); if(!isNaN(input4)){greet4();}input5 = setInput5(); if(!isNaN(input5)){greet5();}"><b>WszystkieKlik!</b></button>
    </div>
```

![alt text](http://i.imgur.com/TOX2z8u.png, "nic")

Idea całości polega na tym że w puste pola można wpisać liczby, które następnie po kliknięciu w przycisk o dźwięcznej nazwie "Klik!" zostaną wyrysowane w jaiś tam sposób na poniższym canvasie, a oprócz tego zostaną dodane do tablicy liczb, którą to można wyświetlić przyciskiem "klik" na samej górze. Dodatkowo na samej górze znajduję się tesktowy atrybut html-a.

Sam JavaScript prezentuje się następująco:
```javascript
var input1, input2, input3, input4, input5;
var input = [];
var button1, button2, button3, button4, button5;
var greeting;

function setInput1(){
  return parseInt(document.getElementById("input1").value);
}
function setInput2(){
  return parseInt(document.getElementById("input2").value);
}
function setInput3(){
  return parseInt(document.getElementById("input3").value);
}
function setInput4(){
  return parseInt(document.getElementById("input4").value);
}
function setInput5(){
  return parseInt(document.getElementById("input5").value);
}

function setup() {
  background(51);
  createCanvas(710, 400);
}

function greet1() {
  var name = input1;
  input.push(name);
  for (var i=0; i<200; i++) {
    push();
    fill(random(255), 255, 255);
    translate(random(width), random(height));
    rotate(random(2*PI));
    text(name, 0, 0);
    pop();
  }
}
function greet2() {
  var name = input2;
  input.push(name);
  for (var i=0; i<200; i++) {
    push();
    fill(0, 0, random(255));
    translate(random(width), random(height));
    rotate(random(2*PI));
    text(name, 0, 0);
    pop();
  }
}
function greet3() {
  var name = input3;
  input.push(name);
  for (var i=0; i<200; i++) {
    push();
    fill(0, random(255), 0);
    translate(random(width), random(height));
    rotate(random(2*PI));
    text(name, 0, 0);
    pop();
  }
}
function greet4() {
  var name = input4;
  input.push(name);
  for (var i=0; i<200; i++) {
    push();
    fill(random(255), 0, 0);
    translate(random(width), random(height));
    rotate(random(2*PI));
    text(name, 0, 0);
    pop();
  }
}
function greet5() {
  var name = input5;
  input.push(name);
  for (var i=0; i<200; i++) {
    push();
    fill(random(200), 255, 120);
    translate(random(width), random(height));
    rotate(random(2*PI));
    text(name, 0, 0);
    pop();
  }
}
function myFunction() {
  input.toString();
  document.getElementById("tabelka").innerHTML = input;
}
```

Cały kod jak widać można podzielić na cztery sekcje:
* Settry
* setup()
* greet()
* myFunction()

###Settery
Ustwaia wartości zmiennych wewnętrznych zgodnie z tym co zostanie wpisane w wolne pola

###Setup()
Można powiedzieć że jest to funkcja MyInit() z OpenGL-a, w sensie że jako instrukcja wykinuje się ona na początku  tylko raz. Co do samej funkcjonalności to jest to tylko i wyłącznie stworzenie canvas i zamalowanie go tłem.

###greet()
Funkcja ta spełnia dwa zadania. Po pierwsze zawartość pustego pola dodaje do tablicy *input*, a po drugie wyrysowuje zawartośc w losowy sposób na canvasie

###myFunction()
To najzwyczajniesze sparsowanie tablicy *input* na String i wyświetlenie jej na stronie.

# Test Aplikacji Internetowej
Sam test skałda się z nagrania całości. I tak sprawdzam czy do danych pustych pól można wpisać poszczególne cyfry, następnie sprawdzam odpowiadające pustym polą przyciski "Klik". Gdy to mam za sobą to czyszczę zawartość pustych pól, zapełniam je znowu, ale tym razem całość doaje przyciskiem "WszystkieKlik". Gdy to mam za soba ponownie czyszczę całość i do pierwszego pustego wpisuje niepoprawne dane, czyli moje imię i klikam "Klik". Zaraz po tym wpisuję w tym samym polu "2" i ponownie dodaje przez klinknięcie.

![alt text](http://i.imgur.com/dUXePsK.png, "nic")

Zaraz po tym na podstawie nagrania wygenerowaliśmy kod Javy i dodaliśmy go do projektu:
```java
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
```

Jak widać do całości w atrybucie @Test dodaliśmy jeszcze dwa spawdzenia. Pierwsze dość trywialne i sprawdzające czy tekstowy atrybut html-a istnieje i jest taki jak zakładamy, oraz czy tabela złożona z wpisywanych cyfr istnieje i czy jest taka jak zakładana

```java
  //Sprawdzenie tekstu
  assertEquals(tekst, "Taki tam przykładowy tekst");
  //Sprawdzenie tabeli stworzonej z inputow
  assertEquals(tabelka, "1,2,3,4,5,6,7,8,9,10,2");
```

![alt text](http://i.imgur.com/oBodR9g.png, "nic")

# Test Bazy Danych

Oprócz testów aplikacji internetowej uznaliśmy że warto by było wykazać się umiejętnością testowania Bazy Danych. Nie pokuśilismy się już o dopisanie do Naszej strony testowej połączenia z Bazą Danych. Strona stooi na github-pages i niestety ustanowienie takie funkcjonalności jest dużo trudniejsze niż się wyadaje. W takim razie uznaliśmy że skorzystamy z mojej Bazy Danych przygotowanej na zaliczenie projektu.
```java
public class testPSQL{
	String dbUrl, user, password, query;
	String id, pass, mail,port;
	@Before
	public void Funkc() throws ClassNotFoundException, SQLException{
		dbUrl = "jdbc:postgresql://127.0.0.1:5432/Projekt";
		user = "postgres";
		password = "admin1";
		query = "SELECT * FROM public.uzytkownik";

		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection(dbUrl,user,password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()){
			id = rs.getString(1);
			pass = rs.getString(2);
			mail = rs.getString(3);
			port = rs.getString(4);
			//System.out.println(id + " "+ pass + " "+mail+" "+" "+port);
		}
	}
	@Test
	public void testBaza() throws Exception{
		assertEquals(1, Integer.parseInt(id));
		assertEquals("admin123", pass);
		assertEquals("jan@kowalski.pl", mail);
		assertEquals(1, Integer.parseInt(port));
	}
}
```

I tak jak widać na początku łączymy się z Postgresem, wysyłamy zapytnie, pobieramy jego wynik i w atrybucie @Test sprawdzamy czy to co baza Nam zwraca jest zgodne z tym co zakładamy. Test bardzo prosty i naiwny ale pokazujący ideę i wykonujący przegląd programistycznych umiejętności potrzebnych do łaczenia i testowania Bazy

![alt text](http://i.imgur.com/Uup2jCf.png, "nic")
