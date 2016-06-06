package log;

import base.CommonAPI;

/**
 * Created by a on 6/6/2016.
 */
public class Credentials extends CommonAPI {

    public void sampleLogin() throws InterruptedException {
        typeById("email", "iqbalchoudhury2@gmail.com");
        Thread.sleep(2000);
        typeById("pass", "Srilanka1");
        Thread.sleep(3000);
        clickById("u_0_o");


    }
}
