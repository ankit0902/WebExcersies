package WebTest1;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.xpath;

public class WebExercises1 {

    static protected WebDriver driver;
    String expected = "My registration Succesfully";

//-----------------------------------------------------------------------------------------------------------------------//
    //Method 1 : Wait until Clickable

    public WebElement waitForElementToBeClickable(WebDriver driver, WebElement webElement, int seconds){

        WebDriverWait wait = new WebDriverWait(driver,seconds);
        WebElement element  = wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return element;
    }
//--------------------------------------------------------------------------------------------------------------------//

    //Method 2 : Wait until Visible
    public WebElement waitForElementToBeVisible(WebDriver driver, WebElement webElement, int seconds){

        WebDriverWait wait = new WebDriverWait(driver,seconds);
        WebElement element  = wait.until(ExpectedConditions.visibilityOf(webElement));
        return element;
    }
     //Method 4 : Get Text from element

    public String getTextFromElement(By by)
    {
        return driver.findElement(by).getText();
    }
 //--------------------------------------------------------------------------------------------------------------

    //Method 5 : Click on Element

    public void clickOnElement(By by){

        driver.findElement(by).click();
    }
//-------------------------------------------------------------------------------------------------------------------
    //Method 6 : Enter Text(Send Key)
    public void enterText(By by,String text){

        driver.findElement(by).sendKeys(text);
    }

//-------------------------------------------------------------------------------------------------------------------

    //Method 7 : Select from drop down by value

    public void selectFromDropDownByValue(By by, String value){

        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
   }
//------------------------------------------------------------------------------------------------------------------------

     //Method 8 : Select from drop down by index

     public void selectFromDropDownByIndex(By by, int index){

       Select select = new Select(driver.findElement(by));
       select.selectByIndex(index);
    }
 //-----------------------------------------------------------------------------------------------------------------
    //Method 9 : Select from drop down by visible text

    public void selectFromDropDownByVisibleText(By by, int visText){

       Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(String.valueOf(visText));

    }
    //---------------------------------------------------------------------------------------------------------------
    //Method 10 : Create Time Stamp

        public String timestamp() {

        DateFormat dateFormat = new SimpleDateFormat("ddMMyyHHss");
          Date date = new Date();
           return (dateFormat.format(date));
    }
     //-----------------------------------------------------------------------------------------------------------
    //Method 11 : Create Before Test
    @Test
    @BeforeTest
        public void beforeTest() {
    // create instance of the chrome driver
    System.setProperty("webdriver.chrome.driver", "src\\test\\java\\BrowserDrivers\\chromedriver.exe");
    //object created from chrome driver
    driver = new ChromeDriver();
    //maximize window
    driver.manage().window().maximize();
    // add implicitly wait
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

//--------------------------------------------------------------------------------------------------------------------
    //Method 12 : Create After Test
    @AfterTest

    public void afterTest(){
        driver.close(); }

    @Test

     public void userShouldAbleToRegisterSuccessfully() {

        driver.get("https://demo.nopcommerce.com/");
        //THIS METHOD WILL SEARCH BOX TO BE VISIBLE
        waitForElementToBeVisible(driver,driver.findElement(By.id("small-searchterms")),30).sendKeys(("Computer"));
        //THIS METHOD WILL WAIT UNTIL ELEMENT TO BE CLICKABLE
        waitForElementToBeClickable(driver,driver.findElement(By.xpath("//input[@class=\"button-1 search-box-button\"]")),30);
        //CLICK ON ELEMENT METHOD USED TO CLICK ON REGISTER BUTTON
        clickOnElement(By.linkText("Register"));
        WebDriverWait wait = new WebDriverWait(driver,40);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("register-button")));
        ////FIND ELEMENT AND ENTER VALID FIRST NAME
        enterText(By.id("FirstName"),"Raju");
        //FIND ELEMENT AND ENTER VALID LAST NAME
        enterText(By.id("LastName"),"Pandya");
        //FIND ELEMENT AND SELECT DATE FROM DATE OF BIRTH
        selectFromDropDownByIndex(By.name("DateOfBirthDay"),9);
        //FIND ELEMENT AND SELECT MONTH FROM DATE OF BIRTH
        selectFromDropDownByIndex(By.name("DateOfBirthMonth"),5);
        //FIND ELEMENT AND SELECT YEAR FROM DATE OF BRITH
        selectFromDropDownByVisibleText(By.name("DateOfBirthYear"),2001);
        //FIND ELEMENT AND ENTER EMAIL ADDRESS
        enterText(By.id("Email"),"rajupandya2+"+timestamp() + "@test.com");
        //FIND ELEMENT AND ENTER COMPANY NAME
        enterText(By.id("Company"),"Raj&Company");
        //Find Element AND ENTER VALID PASSWORD
        enterText(By.name("Password"),"Priyan22");
        //FIND ELEMENT AND ENTER CONFIRM PASSWORD
        enterText((By.id("ConfirmPassword")),"Priyan22");
        //FIND ELEMENT AND CLICK ON REGISTER BUTTON
        driver.findElement((By.name("register-button"))).click();
        //FIND ACTUAL RESULT IS MATCHING WITH EXPECTED RESULT
        String actual = driver.findElement(By.className("result")).getText();
        Assert.assertEquals(expected,actual);
    }
    @Test

    public void userShouldAbleToRegisteredSuccesfully(){

        driver.get("https://www.sky.com/");
       //CLICK ON ELEMENT METHOD USED TO CLICK ON SIGN IN  BUTTON
        clickOnElement(By.linkText("Sign in"));
        //CLICK ON ELEMENT METHOD USED TO CLICK ON SIGN UP BUTTON
        clickOnElement(By.linkText("Sign up"));
        //FIND ELEMENT AND SELECT TITLE
        selectFromDropDownByValue(By.id("title"),"Mr");
        //FIND ELEMENT AND ENTER VALID FIRST NAME
        enterText(By.id("firstname"),"Ankit");
        //FIND ELEMENT AND ENTER VALID LAST NAME
        enterText(By.id("lastname"),"Dhanorkar");
        //FIND ELEMENT AND ENTER VALID EMAIL
        enterText(By.id("email"),"ankitdhanorkar205"+ timestamp()+ "@gmail.com");
        //FIND ELEMENT AND ENTER CONFIRM EMAIL
        enterText(By.id("confirmEmail"),"ankitdhanorkar206@gmail.com");
        //FIND ELEMENT AND ENTER VALID PASSWORD
        enterText(By.id("password"),"Priyan23");
        //FIND ELEMENT AND ENTER CONFIRM PASSWORD
        enterText(By.id("confirmPassword"),"Priyan23");
        driver.findElement(By.xpath("//div[@class=\"defaultBubble termsAndConditionsError visible\"]")).click();
        //FIND ACTUAL RESULT IS MATCHING WITH EXPECTED RESULT
        String actual = driver.findElement(By.id("submitButton")).getText();
        Assert.assertEquals("Test Case Fail", expected,actual);
    }
    @Test

    public void userShouldAbleToRegisteredSuccessfully(){

        driver.get("https://www.mockplus.com/");
        //CLICK ON ELEMENT METHOD USED TO CLICK ON SIGN IN  BUTTON
        clickOnElement(By.className("user-btn"));
        //FIND ELEMENT AND ENTER VALID EMAIL ADDRESS
        enterText(By.id("email"),"ankitdhanorkar0902"+ timestamp() +"@ gmail.com");
        //FIND ELEMENT AND ENTER VALID PASSWORD
        enterText(By.xpath("//input[@id=\"password\"]"),"Tajmahal123");
        //FIND ELEMENT AND ENTER  CONFIRMATION PASSWORD
        enterText(By.xpath("//input[@id=\"cofPassword\"]"),"Tajmahal123");
        //FIND ELEMENT AND CLICK ON TERMS AND CONDITION
        clickOnElement(By.id("agree"));
        //FIND ELEMENT AND CLICK ON REGISTER
        clickOnElement(By.id("register"));
        //FIND ACTUAL RESULT IS MATCHING WITH EXPECTED RESULT
        String actual = driver.findElement(By.className("title-content")).getText();
        Assert.assertEquals("Test Case Fail",expected,actual);
    }
    @Test
            public void useshouldbeableToRegisterSuccessfully() {
                driver.get("https://groceries.asda.com/");
                //CLICK ON ELEMENT METHOD USED TO CLICK ON REGISTER BUTTON
                driver.findElement(By.className("menu-user__register")).click();
                //FIND ELEMENT AND ENTER THE VALID EMAIL ADDRESS
                enterText(xpath("//input[@type='email']"),"ankitdhanorkar207"+timestamp()+"@gmail.com");
                //FIND ELEMENT AND ENTER CORRECT PASSWORD
                enterText(xpath("//input[@type='password']"),"Priyan22");
                //FIND ELEMENT AND ENTER VALID POSTCODE
                enterText(xpath("//input[@type='text']"),"HA0 2LA");
                //FIND ELEMENT AND CLICK ON REGISTER BUTTON
                clickOnElement(xpath("//label[@class='regCheckTnC check-box']//span[@class='checkmark']"));
                //FIND ACTUAL RESULT IS MATCHING WITH EXPECTED RESULT
                String actual= driver.findElement(xpath("//button[@class=\"primary full\"]")).getText();
                Assert.assertEquals("Test Case Fail:",expected,actual);
                }
      @Test

             public void userShouldBeRegisteredSuccessfully(){
            driver.get("https://www.ocado.com/");
            //THIS METHOD WILL SEARCH BOX TO BE VISIBLE
             waitForElementToBeVisible(driver,driver.findElement(By.id("findText")),30).sendKeys(("Milk"));
            //THIS METHOD WILL WAIT UNTIL ELEMENT TO BE CLICKABLE
             waitForElementToBeClickable(driver,driver.findElement(By.id("findButton")),30);
            //Find ELEMENT AND CLICK ON REGISTER BUTTON
            clickOnElement(By.linkText("Register"));
            //FIND ELEMENT AND SELECT TITAL
            driver.findElement(By.id("title")).sendKeys("Mr");
            //FIND ELEMENT AND ENTER FIRST NAME
            enterText(By.id("firstName"),"Ankit");
            //FIND ELEMENT AND ENTER LAST NAME
            enterText(By.id("lastName"),"Dhanorkar");
            //FIND ELEMENT AND ENTER EMAIL ADDRESS
            enterText(By.id("login"),"ankitdhanorkar209"+timestamp()+"@gmail.com");
            //FIND ELEMENT AND ENTER VALID PASSWORD
            enterText(By.id("password"),"Priyu22");
            //FIND ELEMENT AND ENTER POSTCODE
            enterText(By.id("postcode"),"Tw14 8lp");
            //FIND ELEMENT AND CLICK ON REGISTER BUTTON
            clickOnElement(By.id("registration-submit-button"));
            //FIND EXPECTED RESULT MATCHING ACTUAL RESULT
           String actual = driver.findElement(By.className("prp-heading prp-heading--small")).getText();
           Assert.assertEquals("Test Case Fail :",expected,actual);
            }

      @Test

        public void userShouldBeResgisteredSuccessfully(){
        driver.get("https://www.matalan.co.uk/");
        //FIND ELEMENT AND CLICK ON MY ACCOUNT
        clickOnElement(By.linkText("My Account"));
        //FIND ELEMENT AND ENTER VALID EMAIL ADDRESS
        enterText(By.id("account_form_email"),"ap_dhanorkar2002"+timestamp()+"@yahoo.co.uk");
        //FIND ELEMENT AND CLICK ON NEW ACCOUNT
        clickOnElement(xpath("//*[@id=\"new_account_form\"]/button"));
        //FIND ELEMENT AND ENTER FIRST NAME
        enterText(By.id("account_form_meta_attributes[first_name][value]"),"Ankit");
        //FIND ELEMENT AND ENTER LAST NAME
        enterText(xpath("//*[@id=\"account_form_meta_attributes[last_name][value]\"]"),"Dhanorkar");
        //FIND ELEMENT AND ENTER VALID EMAIL ADDRESS
        enterText(By.id("account_form_email_confirmation"),"ap_dhanorkar2000@yahoo.co.uk");
        //FIND ELEMENT AND ENTER VALID PASSWORD
        enterText(By.id("account_form_password"),"Priyu222");
        //FIND ELEMENT AND ENTER CONFIRM PASSWORD
        enterText(By.id("account_form_password_confirmation"),"Priyu22");
        //FIND ACTUAL RESULT IS MATCHING WITH EXPECTED RESULT
        String actual = driver.findElement(By.className("title--page-title")).getText();
        Assert.assertEquals("Test Case Fail :",expected,actual);
    }
}


