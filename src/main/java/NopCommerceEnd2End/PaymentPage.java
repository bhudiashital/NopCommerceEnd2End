package NopCommerceEnd2End;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Created by bhudi on 24/11/2016.
 */
public class PaymentPage extends DriverManager
{

//    @FindBy(linkText = "Credit Card")
//    private WebElement _CreditCard1;
    @FindBy (id = "paymentmethod_1")
    private WebElement _creditCard;


    @FindBy (xpath = ".//*[@id='payment-method-buttons-container']/input")
    private WebElement _continuepayment;

    @FindBy (id ="CreditCardType")
    private WebElement _cardTypeSelection;
    @FindBy (id ="CardholderName")
    private WebElement _NameOfCardHolder;
    @FindBy (id = "CardNumber")
    private WebElement _CardNumber;
    @FindBy (name= "ExpireMonth")
    private WebElement _ExpireMonth;
    @FindBy( id = "ExpireYear")
    private WebElement _ExpireYear;
    @FindBy (id ="CardCode")
    private WebElement _CcsCod;
    @FindBy (id = "payment-info-buttons-container")
    private WebElement _continuePayment1 ;

    @FindBy (xpath = ".//*[@id='confirm-order-buttons-container']/input")
    private WebElement _conformOrder;





    public  void makePayment()
    {
        Checkout checkout1=new Checkout();
        checkout1.makecheckout();


        Utility.clickOnElements(_creditCard);
        System.out.println(" Visa card select ");
        WebDriverWait wait = new WebDriverWait(driver,12);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(_continuepayment));

        Utility.clickOnElements(_continuepayment);

//        Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='checkout-payment-info-load']/div/div/div[1]/table/tbody/tr[2]" +
//                "/td[1]/label")).getText(), "Cardholder name:");
        System.out.println("TEST PSSS , You r in Payment information page ");


        new Select(_cardTypeSelection).selectByVisibleText("Visa");
        Utility.enterText(_NameOfCardHolder , "Amitabh Bachchan");
        Utility.enterText(_CardNumber, "4942 6394 4607 2876");
        System.out.println("Card name and number entered.");

        new Select(_ExpireMonth).selectByVisibleText("05");
        new Select(_ExpireYear).selectByVisibleText("2017");
        Utility.enterText(_CcsCod, "883");
         new WebDriverWait(driver,12);
//         wait.until(ExpectedConditions.elementToBeClickable(_continuepayment));

        Utility.clickOnElements(_continuePayment1);

//        Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='checkout-confirm-order-load']/div/div/div/div/div[2]/div[2]/div/ul" +
//                "/li[2]/span[1]")).getText(),"Shipping Method: Ground ", "Fail");
        System.out.println("TEST PASS , Payment information match ");
       new WebDriverWait(driver,20);
        WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(_conformOrder));
        Utility.clickOnElements(_conformOrder);


        String actual = driver.findElement(By.xpath("html/body/div[5]/div[3]/div/div/div/div[2]/div/div[1]/strong")).getText();
        String expected = "Your order has been successfully processed!";
        Assert.assertEquals(actual,expected, " Fail");
        System.out.println(" Final Test is pass , Your order has been successfully processed!");



    }



}
