package NopCommerceEnd2End;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by bhudi on 22/11/2016.
 */
public class Utility extends DriverManager
{
    public static void clickOnElements(WebElement element)
    {element.click();}


    public static void enterText(WebElement element, String text)
    {
        element.sendKeys(text);
    }

    public static void Wait(WebElement element,String text)
    {
        WebDriverWait wait=new WebDriverWait(driver,10);

//        WebElement wait=wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }


    public String randomDate()
    {
        SimpleDateFormat forMat=new SimpleDateFormat("ddMMyySSmm");
        return forMat.format(new Date());
    }
}
