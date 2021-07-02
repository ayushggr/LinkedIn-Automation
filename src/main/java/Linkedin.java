import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Linkedin {
    public static void main(String[] args) {

        String url = "https://www.linkedin.com/login";
        Document document;
        {

                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                WebDriver driver = new ChromeDriver();
                driver.get(url);
                driver.manage().window().maximize();
                driver.findElement(By.xpath("/html//input[@id='username']")).sendKeys("ayushggr11@gmail.com");
                driver.findElement(By.xpath("/html//input[@id='password']")).sendKeys("8R5P!!HvFkQN");
                driver.findElement(By.xpath("//div[@id='organic-div']/form[@action='/checkpoint/lg/login-submit']//button[@class='btn__primary--large from__button--floating']")).click();
                driver.get("https://www.linkedin.com/mynetwork/");
                WebElement ayush;
                WebDriverWait wait = new WebDriverWait(driver, 20);
                ayush = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[8]/aside/div[1]/header/section[2]/button[2]")));
                driver.findElement(By.xpath("/html/body/div[8]/aside/div[1]/header/section[2]/button[2]")).click();
                ayush = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[8]/div[3]/div/div/div/div/div/div/div[2]/section/section/ul/li[4]/div/section/div[2]/footer/button/span")));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                List<WebElement> elements = driver.findElements(By.cssSelector("span"));
                try {
                    for (WebElement element : elements) {
                        if (element.getText().equals("Connect")) {
                            js.executeScript("arguments[0].click();", element);
                        }
                    }
                } finally {
                    driver.quit();
                }
        }
    }
}
