package login;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by a on 6/4/2016.
 */
public class LoginTest extends CommonAPI {


    @Test
    public void login() throws InterruptedException
    {
        //driver.findElement(By.id("email")).sendKeys("iqbalchoudhury2@gmail.com");
        typeById("email","iqbalchoudhury2@gmail.com");
        Thread.sleep(2000);
        typeById("pass","Srilanka1");
        Thread.sleep(3000);
        clickById("u_0_o");



    }

}
