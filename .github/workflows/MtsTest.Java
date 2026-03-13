# This workflow will build a Java project with Maven, and cache/restore any dependencies to improve the workflow execution time
# For more information see: https://docs.github.com/en/actions/automating-builds-and-tests/building-and-testing-java-with-maven

# This workflow uses actions that are not certified by GitHub.
# They are provided by a third-party and are governed by
# separate terms of service, privacy policy, and support
# documentation.

name: Java CI with Maven

on:
  push:
    branches: [ "main" ]
  pull_request:
    branches: [ "main" ]

jobs:
  build:

    runs-on: ubuntu-latest

    steps:
    - uses: actions/checkout@v4
    - name: Set up JDK 17
      uses: actions/setup-java@v4
      with:
        java-version: '17'
        distribution: 'temurin'
        cache: maven
    - name: Build with Maven
      run: mvn -B package --file pom.xml

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


      public class MtsTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // ожидание открытия
        driver.manage().window().maximize(); // открыть окно на весь экран
        driver.get("https://www.mts.by/");
        WebElement cookie = driver.findElement(By.xpath("//button[@class='btn btn_gray cookie__cancel']"));
        wait.until(ExpectedConditions.elementToBeClickable(cookie));
        cookie.click();
    }

    @Test       // Проверить название указанного блока
    public void verifyBlockName() {
        WebElement blockTitle = driver.findElement(By.xpath("//div[@class='pay__wrapper']/h2"));
        String expectedName = "Онлайн пополнение\nбез комиссии";
        assertEquals(expectedName, blockTitle.getText());
    }

    @Test       // Проверить наличие логотипов платежных систем
    public void verifyPaymentSystemsLogos() {
        WebElement paymentLogos = driver.findElement(By.xpath("//div[@class='pay__partners']"));
        assertTrue(paymentLogos.isDisplayed());
    }

    @Test       // Проверить работу ссылки «Подробнее о сервисе»
    public void verifyServiceLink() {
        WebElement serviceLink = driver.findElement(By.xpath("//div[@class='pay__wrapper']/a"));
        serviceLink.click();
        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        wait.until(ExpectedConditions.urlContains("poryadok-oplaty-i-bezopasnost-internet-platezhey"));
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    @Test       // Заполнить поля и проверить работу кнопки «Продолжить» (проверяем только вариант «Услуги связи», номер для теста 297777777)
    public void verifyContinue() throws InterruptedException {
        WebElement phoneNumber = driver.findElement(By.xpath("//*[@id=\"connection-phone\"]"));
        //phoneNumber.click();
        phoneNumber.sendKeys("297777777");
        WebElement amount = driver.findElement(By.xpath("//*[@id=\"connection-sum\"]"));
        //amount.click();
        amount.sendKeys("12");
        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        continueButton.click();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("bepaid-iframe")));
        WebElement continueForm = driver.findElement(By.xpath("//div[@class='app-wrapper__content']"));
        wait.until(ExpectedConditions.elementToBeClickable(continueForm));
        assertTrue(continueForm.isDisplayed());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Закрываем веб-драйвер после выполнения теста
        }
    }

}

    # Optional: Uploads the full dependency graph to GitHub to improve the quality of Dependabot alerts this repository can receive
    - name: Update dependency graph
      uses: advanced-security/maven-dependency-submission-action@571e99aab1055c2e71a1e2309b9691de18d6b7d6
