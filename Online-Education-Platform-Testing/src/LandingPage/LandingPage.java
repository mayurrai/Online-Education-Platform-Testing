package LandingPage;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

public class LandingPage {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.lpu.in/");
        driver.manage().window().maximize();

        System.out.println("Title of the page: " + driver.getTitle());
        System.out.println("Current URL: " + driver.getCurrentUrl());

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000); 
        actions.sendKeys(Keys.PAGE_UP).perform();

        WebElement aboutDropdown = driver.findElement(By.xpath("//*[@id='header-wrap']/div/div[2]/div[2]/div[2]/nav/ul/li[1]/a/div"));
        Actions hover = new Actions(driver);
        hover.moveToElement(aboutDropdown).perform();

        aboutDropdown.click();

        WebElement option = driver.findElement(By.xpath("//div[text()='Infrastructure']"));
        option.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 3; i++) {
            js.executeScript("window.scrollBy(0, 500);");
            Thread.sleep(5000);  
        }

        WebElement VirtualBackground = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/section/div/div[1]/div[1]/div/a"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(VirtualBackground));

        js.executeScript("arguments[0].scrollIntoView(true);", VirtualBackground);
        
        if (VirtualBackground.isDisplayed() && VirtualBackground.isEnabled()) {
            js.executeScript("arguments[0].click();", VirtualBackground);
        }
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        for (int i = 0; i < 3; i++) {
            js1.executeScript("window.scrollBy(0, 500);");
            Thread.sleep(5000);  
        }


        
        WebElement virtualTourLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[span[@class='st-label' and text()='Virtual Tour']]")));

        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("arguments[0].scrollIntoView(true);", virtualTourLink);

        virtualTourLink.click();
        
        Thread.sleep(30000);

        driver.quit();
        
        System.out.print("Completed: "+ true);
    }
}
