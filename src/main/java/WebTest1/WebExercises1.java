package WebTest1;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.xpath;

public class WebExercises1 {

    static protected WebDriver driver;

    @Test
    public void userShouldAbleToRegisterSuccessfully() {

        System.setProperty("webdriver.chrome.driver", "src\\test\\java\\BrowserDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.linkText("Register")).click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("register-button")));
        driver.findElement(By.id("FirstName")).sendKeys("Raj");
        driver.findElement(By.name("LastName")).sendKeys("Patel");
        driver.findElement(By.id("Email")).sendKeys("rajpatel23@gmail.com");
        driver.findElement(By.id("Company")).sendKeys("Raj&Company");
        driver.findElement(By.name("Password")).sendKeys("Priyan22");
        driver.findElement((By.id("ConfirmPassword"))).sendKeys("Priyan22");
        driver.findElement((By.name("register-button"))).click();


    }

    @Test

    public void userShouldAbleToRegisteredSuccesfully(){

        System.setProperty("webdriver.chrome.driver", "src\\test\\java\\BrowserDrivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.sky.com/");
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.linkText("Sign up")).click();
        driver.findElement(By.id("title")).sendKeys("Mr");
        driver.findElement(By.id("firstname")).sendKeys("Ankit");
        driver.findElement(By.id("lastname")).sendKeys("Dhanorkar");
        driver.findElement(By.id("email")).sendKeys("ankitdhanorkar201@gmail.com");
        driver.findElement(By.id("confirmEmail")).sendKeys("ankitdhanorkar201@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Priyan23");
        driver.findElement(By.id("confirmPassword")).sendKeys("Priyan23");
    }
    @Test

    public void userShouldAbleToRegisteredSuccessfully(){

        System.setProperty("webdriver.chrome.driver", "src\\test\\java\\BrowserDrivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.mockplus.com/");
        driver.findElement(By.className("user-btn")).click();
        driver.findElement(By.id("email")).sendKeys("ankitdhanorkar201@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Tajmahal123");
        driver.findElement(By.id("cofPassword")).sendKeys("Tajmahal123");}



        @Test


            public void useshouldbeableToRegisterSuccessfully() {

                System.setProperty("webdriver.chrome.driver", "src\\test\\java\\BrowserDrivers\\chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                driver.get("https://groceries.asda.com/");
                driver.findElement(By.className("menu-user__register")).click();
                //wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
                WebDriverWait wait = new WebDriverWait(driver,50);
                driver.findElement(xpath("//input[@type='email']")).sendKeys("ankitdhanorkar201@gmail.com");
                driver.findElement(xpath("//input[@type='password']")).sendKeys("Priyan22");
                driver.findElement(xpath("//input[@type='text']")).sendKeys("HA0 2LA");
                driver.findElement(xpath("//label[@class='regCheckTnC check-box']//span[@class='checkmark']")).click();
                driver.findElement(xpath("//button[@class=\"primary full\"]"));
            }


        @Test

        public void userShouldBeRegisteredSuccessfully(){


            System.setProperty("webdriver.chrome.driver", "src\\test\\java\\BrowserDrivers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get("https://www.ocado.com/");
            driver.findElement(By.linkText("Register")).click();
            WebDriverWait wait = new WebDriverWait(driver,50);
            driver.findElement(By.id("title")).sendKeys("Mr");
            driver.findElement(By.id("firstName")).sendKeys("Ankit");
            driver.findElement(By.id("lastName")).sendKeys("Dhanorkar");
            driver.findElement(By.id("login")).sendKeys("ankitdhanorkar201@gmail.com");
            driver.findElement(By.id("password")).sendKeys("Priyu22");
            driver.findElement(By.id("postcode")).sendKeys("Tw14 8lp");
            driver.findElement(By.id("registration-submit-button")).click();

        }

    @Test

    public void userShouldBeResgisteredSuccessfully(){

        System.setProperty("webdriver.chrome.driver", "src\\test\\java\\BrowserDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.matalan.co.uk/");
        driver.findElement(By.linkText("My Account")).click();
        WebDriverWait wait = new WebDriverWait(driver, 40);
       // wait.until(ExpectedConditions.elementToBeClickable(By.id("")));
        driver.findElement(By.id("account_form_email")).sendKeys("ap_dhanorkar2000@yahoo.co.uk");
        driver.findElement(xpath("//*[@id=\"new_account_form\"]/button")).click();
        driver.findElement(By.id("account_form_meta_attributes[first_name][value]")).sendKeys("Ankit");
        driver.findElement(xpath("//*[@id=\"account_form_meta_attributes[last_name][value]\"]")).sendKeys("Dhanorkar");
        //driver.findElement(By.id("account_form_email")).sendKeys("ap_dhanorkar2000@yahoo.co.uk");
        driver.findElement(By.id("account_form_email_confirmation")).sendKeys("ap_dhanorkar2000@yahoo.co.uk");
        driver.findElement(By.id("account_form_password")).sendKeys("Priyu222");
        driver.findElement(By.id("account_form_password_confirmation")).sendKeys("Priyu22");

    }

}


