package NopCommerceEnd2End;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by bhudi on 30/11/2016.
 */


public class ReferAFriend extends DriverManager
{

    @FindBy(linkText = "Electronics")
    private WebElement _electronics;

    @FindBy(linkText = "Camera & photo" )
    private WebElement _camera;

    @FindBy(xpath = "html/body/div[5]/div[3]/div[2]/div[2]/div/div[2]/div[3]/div/div[1]/div/div[2]/div[3]/div[2]/input[1]")
    private WebElement _product1;
    @FindBy (xpath = ".//*[@id='product-details-form']/div/div[1]/div[2]/div[4]/div[2]/input")
    private WebElement _refFriend;

    @FindBy(id = "FriendEmail")
    private WebElement _FriendEmail;

    @FindBy(id ="PersonalMessage")
    private WebElement _PersonalMessage;
    @FindBy(xpath = "html/body/div[5]/div[3]/div/div/div/div[2]/form/div[2]/input")
    private WebElement _SendMail;

    @FindBy (className ="result")
    private WebElement _ActulAssert;

    public  void referANewFriend()
    {
        Register register=new Register();
        register.regForm();


        Utility.clickOnElements(_electronics);
        Utility.clickOnElements(_camera);
        Utility.clickOnElements(_product1);
        Utility.clickOnElements(_refFriend);
        Utility.enterText(_FriendEmail,"myoffer123@gmail.com");
        Utility.enterText(_PersonalMessage, "Please try this product. Excellent Item. ");
        Utility.clickOnElements(_SendMail);
        System.out.println("Mail have been successfuly send to youe Friend");


        Assert.assertEquals(_ActulAssert.getText(),"Your message has been sent.", "Fail");
        System.out.println("Your message has been sent.");
    }

}

