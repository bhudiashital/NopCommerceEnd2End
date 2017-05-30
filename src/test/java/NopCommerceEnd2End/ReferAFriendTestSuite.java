package NopCommerceEnd2End;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by bhudi on 30/11/2016.
 */
public class ReferAFriendTestSuite extends DriverManager
{   @BeforeTest
    public static void open()
    {
        openBrowser();
    }

    @Test

    public static void referAFriend()
    {
        ReferAFriend refer = new ReferAFriend();
        refer.referANewFriend();
    }


    @AfterTest
    public static void close()
    {
    closeBrowser();
    }



}
