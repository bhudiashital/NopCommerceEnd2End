package NopCommerceEnd2End;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static NopCommerceEnd2End.Utility.enterText;

/**
 * Created by bhudi on 24/11/2016.
 */
public class Checkout extends DriverManager
{
    @FindBy(id = "BillingNewAddress_CountryId")
    private WebElement _countrySelection;

    @FindBy (id ="BillingNewAddress_City")
    private WebElement _cityname;

    @FindBy(id ="BillingNewAddress_Address1")
    private WebElement  _houseNoFirstLineOfAddress;

    @FindBy (id ="BillingNewAddress_ZipPostalCode")
    private WebElement _postcode;
    @FindBy (id ="BillingNewAddress_PhoneNumber")
    private WebElement  _phoneNumber;
    @FindBy (xpath =".//*[@id='billing-buttons-container']/input" )
    private WebElement _continueButton;
    @FindBy (xpath = ".//*[@id='shipping-method-buttons-container']/input")
    private WebElement _continuetoNextpage;



    public  void makecheckout()
    {
        Shopping shopping1=new Shopping();
        shopping1.shopping();

        new Select(_countrySelection).selectByVisibleText("United Kingdom");

        enterText( _cityname, "London");
        enterText( _houseNoFirstLineOfAddress,"111, Chaplin Road");
        enterText( _postcode, "HA04SS");
        enterText( _phoneNumber, "01234567898");
        Utility.clickOnElements(_continueButton);

        Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='checkout-shipping-method-load']/div/div/ul/li[1]" +
                "/div[1]/label") ).getText(),"Ground ($10.00)" , " Fail");
        System.out.println( " TEST PASS ,Shipping Method Selected");

        Utility.clickOnElements(_continuetoNextpage);

        Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='checkout-payment-method-load']/div/div/ul/" +
                "li[2]/div/div[2]/label")).getText(),"Credit Card", "Fail you r not in card selection page ");
        System.out.println(" TEST PASS. Proceed to payments Page. ");


    }


}
