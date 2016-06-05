package login;

import base.CommonAPI;
import org.testng.annotations.Test;

/**
 * Created by a on 6/5/2016.
 */
public class LoginTest extends CommonAPI {
    @Test
    public void login() throws InterruptedException
    {
        clickByXpath("html/body/div[1]/header/div/div[2]/div[2]/div/a[1]/span[1]");
       //clickByCss("#multi-item-multi-row-item ");
        typeById("ap_email","iqbalchoudhury2@gmail.com");
        Thread.sleep(2000);
        typeById("ap_password","bangladesh1");
        Thread.sleep(3000);
        clickById("signInSubmit");



    }
}
