package NopCommerceEnd2End;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by bhudi on 22/11/2016.
 */
public class Register extends DriverManager
{
public  String username1="";

    @FindBy(xpath = "html/body/div[5]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")
    private WebElement _registerButton;

    @FindBy(id = "gender-female")
    private WebElement _gender;

    @FindBy(id="FirstName")
    private WebElement _firstName;

    @FindBy(id="LastName")
    private WebElement _lastName;

    @FindBy(name = "DateOfBirthDay")
    private WebElement _birthday;

    @FindBy(name="DateOfBirthMonth")
    private WebElement _birthmonth;

    @FindBy(name="DateOfBirthYear")
    private WebElement _birthyear;

    @FindBy(id="Email")
    private WebElement _email;

    @FindBy(id="Password")
    private WebElement _password;

    @FindBy(id="ConfirmPassword")
    private WebElement _confirmPassword;

    @FindBy(id = "register-button")
    private WebElement _registerUser;

    public String randomDate()
    {
        SimpleDateFormat forMat=new SimpleDateFormat("ddMMyySSmm");
        return forMat.format(new Date());
    }

    public void regForm()
    {   Utility.clickOnElements(_registerButton);

        Utility.clickOnElements(_registerButton);
        Utility.enterText(_firstName,"Shital");
        Utility.enterText(_lastName,"Bhudia");

        username1 = "random123"+randomDate()+"@gmail.com";

        Utility.enterText(_email,username1);
        Utility.enterText(_password,"123456");
        Utility.enterText(_confirmPassword, "123456");
        Utility.clickOnElements(_registerUser);

        System.out.println("User Registration Completed.");




    }



}
