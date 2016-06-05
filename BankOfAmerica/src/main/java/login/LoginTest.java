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
        typeById("onlineId1","123nafees");
        typeById("passcode1","Choudhury2");
        Thread.sleep(2000);
        clickById("hp-sign-in-btn");
        Thread.sleep(10000);



    }
}
