package PracticeSoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DemoSoftAssert {
    public static void main(String[] args) throws InterruptedException {

        SoftAssertions soft = new SoftAssertions();
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://it.microtechlimited.com/");

        System.out.println(driver.getTitle());
        //soft.assertTrue(driver.getTitle().equals("MicroTech"));
        soft.assertThat(driver.getTitle().equals("Microtech"));

        String welcomeText = driver.findElement(By.xpath("//h1[text()='Welcome to MicroTech NA.']")).getText();
        soft.assertThat(welcomeText).isEqualTo("Employee Login");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@href='elogin.php']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='mailuid']")).sendKeys("testpilot@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("1234");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='login-submit']")).click();
        soft.assertAll();

    }
}
