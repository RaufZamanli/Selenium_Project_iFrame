package TestingProje3;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Main extends BaseDriver {

    @Test
    void Scenario1() {
        driver.get("https://shopdemo.e-junkie.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));

        WebElement ebookAddToCart = driver.findElement(By.xpath("(//button[@class='view_product'])[2]"));
        ebookAddToCart.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']")));
        WebElement iframe5 = driver.findElement(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(iframe5);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='Apply-Button Show-Promo-Code-Button']")));
        WebElement addPromoCode = driver.findElement(By.xpath("//button[@class='Apply-Button Show-Promo-Code-Button']"));
        addPromoCode.click();

        WebElement promoCodeText = driver.findElement(By.xpath("//input[@class='Promo-Code-Value']"));
        promoCodeText.sendKeys("1214");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='Promo-Apply']")));
        WebElement promoApply = driver.findElement(By.xpath("//button[@class='Promo-Apply']"));
        promoApply.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Invalid promo code']")));
        WebElement invalidPromoCode = driver.findElement(By.xpath("//span[text()='Invalid promo code']"));
        Assert.assertTrue(invalidPromoCode.getText().equals("Invalid promo code"));


    }

    @Test
    public void Scenerio2(){
        driver.get("https://shopdemo.e-junkie.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));

        WebElement ebookAddToCart = driver.findElement(By.xpath("(//button[@class='view_product'])[2]"));
        ebookAddToCart.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']")));
        WebElement iframe5 = driver.findElement(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(iframe5);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='Payment-Button CC']")));
        WebElement payUsingCard = driver.findElement(By.xpath("//button[@class='Payment-Button CC']"));
        payUsingCard.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='Pay-Button']")));
        WebElement payBtn = driver.findElement(By.xpath("//button[@class='Pay-Button']"));
        payBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Invalid Billing Name']")));
        WebElement invalidMsj = driver.findElement(By.xpath("//span[text()='Invalid Billing Name']"));
        Assert.assertTrue(invalidMsj.getText().contains("Invalid Billing Name"));
    }


    @Test
    public void Scenario3()
    {

        driver.get("https://shopdemo.e-junkie.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));

        WebElement ebookAddToCart = driver.findElement(By.xpath("(//button[@class='view_product'])[2]"));
        ebookAddToCart.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']")));
        WebElement iframe5 = driver.findElement(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(iframe5);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='Payment-Button CC']")));
        WebElement payUsingCard = driver.findElement(By.xpath("//button[@class='Payment-Button CC']"));
        payUsingCard.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@title='Secure card payment input frame']")));
        WebElement iframe6 = driver.findElement(By.xpath("//iframe[@title='Secure card payment input frame']"));
        driver.switchTo().frame(iframe6);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='cardnumber']")));
        WebElement cardNum = driver.findElement(By.xpath("//input[@name='cardnumber'] "));
        cardNum.sendKeys("1111 1111 1111 1111");
        driver.switchTo().parentFrame();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Your card number is invalid.']")));
        WebElement invalidcardMess = driver.findElement(By.xpath("//span[text()='Your card number is invalid.']"));

        Assert.assertTrue(invalidcardMess.isDisplayed());

        driver.switchTo().defaultContent();

    }

    @Test
    public void Scenario4() {

        driver.get("https://shopdemo.e-junkie.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

        WebElement ebookAddToCart = driver.findElement(By.xpath("(//button[@class='view_product'])[2]"));
        ebookAddToCart.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']")));
        WebElement iframe5 = driver.findElement(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(iframe5);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='Payment-Button CC']")));
        WebElement payUsingCard = driver.findElement(By.xpath("//button[@class='Payment-Button CC']"));
        payUsingCard.click();

        WebElement email = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        email.sendKeys("selenium@gmail.com");

        WebElement congEmail = driver.findElement(By.xpath("//input[@placeholder='Confirm Email']"));
        congEmail.sendKeys("selenium@gmail.com");

        WebElement name = driver.findElement(By.xpath("//input[@placeholder='Name On Card']"));
        name.sendKeys("Memmed");

        WebElement phone = driver.findElement(By.xpath("(//input[@autocomplete='phone'])[1]"));
        phone.sendKeys("+99412141214");

        WebElement company = driver.findElement(By.xpath("(//input[@autocomplete='company'])[1]"));
        company.sendKeys("MR");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@title='Secure card payment input frame']")));
        WebElement iframe6 = driver.findElement(By.xpath("//iframe[@title='Secure card payment input frame']"));
        driver.switchTo().frame(iframe6);

        WebElement cardNumber = driver.findElement(By.xpath("//input[@name='cardnumber']"));
        cardNumber.sendKeys("4242 4242 4242 4242");

        WebElement expdate = driver.findElement(By.xpath("//input[@name='exp-date']"));
        expdate.sendKeys("12/23");

        WebElement cvc = driver.findElement(By.xpath("//input[@name='cvc']"));
        cvc.sendKeys("000");

        driver.switchTo().parentFrame();
        WebElement payBtn = driver.findElement(By.xpath("//button[text()='Pay 0.50 USD']"));
        payBtn.click();
        driver.switchTo().defaultContent();
        WebElement orderConfirm = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//span[text()=' your order is confirmed. Thank you!']")));
        Assert.assertTrue(orderConfirm.isDisplayed());

        driver.switchTo().defaultContent();

    }

    @Test
    public void Scenario5()
    {
        driver.get("https://shopdemo.e-junkie.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement contactUs = driver.findElement(By.xpath("//a[@class='contact']"));
        contactUs.click();

        WebElement name = driver.findElement(By.id("sender_name"));
        name.sendKeys("Rauf");

        WebElement email = driver.findElement(By.id("sender_email"));
        email.sendKeys("rzamanli@gmail.com");

        WebElement subject = driver.findElement(By.id("sender_subject"));
        subject.sendKeys("Test Automation");

        WebElement message = driver.findElement(By.id("sender_message"));
        message.sendKeys("No pain No gain");

        WebElement iframe = driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']"));
        driver.switchTo().frame(iframe);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='recaptcha-checkbox-border']")));
        WebElement recaptcha = driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']"));
        recaptcha.click();

        driver.switchTo().defaultContent();

        WebElement submit = driver.findElement(By.id("send_message_button"));
        submit.click();

        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }
}