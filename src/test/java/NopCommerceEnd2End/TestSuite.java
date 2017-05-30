package NopCommerceEnd2End;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by bhudi on 22/11/2016.
 */
public class TestSuite extends DriverManager
{
    PaymentPage pm=new PaymentPage();
    @BeforeTest
    public static void open()
    {
    openBrowser();
    }
    @AfterMethod
    public static void close()
    {
        closeBrowser();
    }
    @Test
    public void register()
    {
        Register register1=new Register();
        register1.regForm();
        driver.findElement(By.xpath("")).sendKeys(register1.username1);
    }
    @Test
    public void shopping()
    {
        Shopping shopping1=new Shopping();
        shopping1.shopping();
    }
    @Test
    public void verifyUserCanReferAFrieind(){
        register();
        shopping();
    }
    @Test
    public void checkout()
    {
        Checkout checkout=new Checkout();
        checkout.makecheckout();
    }
    @Test
    public void payment()
    {
        PaymentPage paymentPage=new PaymentPage();
        paymentPage.makePayment();
    }

}
