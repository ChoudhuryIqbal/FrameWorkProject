package login;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * Created by a on 6/5/2016.
 */
public class LoginTest extends CommonAPI
{
    @Test
    public void login() throws InterruptedException
    {
        clickByCss("#login");
        typeById("username","username_Should_be_here");
        typeById("password","password_shoudl_be_here");
        Thread.sleep(2000);

        clickByCss(".wrapper-btn-login>span>button");
        Thread.sleep(3000);

    }

}
