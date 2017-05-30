package NopCommerceEnd2End;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by bhudi on 22/11/2016.
 */
public class Shopping extends DriverManager

{


    @FindBy(xpath = "html/body/div[5]/div[2]/ul[1]/li[2]/a")
    private WebElement _electronics;

    @FindBy(xpath = "html/body/div[5]/div[3]/div[2]/div[2]/div/div[2]/div[4]/div/div[1]/div/div[2]/div[3]/div[2]/input[1]")
    private WebElement _beatsPill;

    @FindBy(xpath = "html/body/div[5]/div[3]/div[2]/div[2]/div/div[2]/div[4]/div/div[2]/div/div[2]/div[3]/div[2]/input[1]")
    private WebElement _htcM8;

    @FindBy(xpath = "html/body/div[5]/div[3]/div[2]/div[2]/div/div[2]/div[4]/div/div[3]/div/div[2]/div[3]/div[2]/input[1]")
    private WebElement _htcMini;

    @FindBy(className = "content")
    private WebElement _textForAssert;         //  location for asserting display msg

    @FindBy(linkText = "shopping cart")
    private WebElement _shoppingcartBartext;

    @FindBy(xpath = ".//*[@id='shopping-cart-form']/div[2]/div[1]/input[2]")
    private WebElement _continueShopping;

    @FindBy(xpath = ".//*[@id='checkout']")
    private WebElement _checkout;

    @FindBy(xpath = ".//*[@id='termsofservice']")
    private WebElement _termsOfUse;





  public void shopping()
  {
      Register register1=new Register();
      register1.regForm();

      Utility.clickOnElements(_electronics);

      driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

//  First Product
      Utility.clickOnElements(_beatsPill);

      Assert.assertEquals(_textForAssert.getText(),"The product has been added to your shopping cart");
      System.out.println("TEST PASSED. FIRST Product has been added to your shopping cart. ");

      Utility.clickOnElements(_shoppingcartBartext);
      Utility.clickOnElements(_continueShopping);


//  Second Product
      Utility.clickOnElements(_electronics);
      Utility.clickOnElements(_htcM8);
      Assert.assertEquals(_textForAssert.getText(),"The product has been added to your shopping cart");
      System.out.println("TEST PASSED. SECOND Product has been added to your shopping cart. ");
      Utility.clickOnElements(_shoppingcartBartext);
      Utility.clickOnElements(_continueShopping);

//  Third Product
      Utility.clickOnElements(_htcMini);
      Assert.assertEquals(_textForAssert.getText(),"The product has been added to your shopping cart");
      System.out.println("TEST PASSED. THIRD Product has been added to your shopping cart. ");
      Utility.clickOnElements(_shoppingcartBartext);
      Utility.clickOnElements(_termsOfUse);
      Utility.clickOnElements(_checkout);  // Proceed to checkout.


      System.out.println("Congratulations.... You are now on Checkout page.");



  }


}
