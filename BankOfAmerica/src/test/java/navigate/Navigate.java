package navigate;

import org.testng.annotations.Test;
import test_login.Login;

/**
 * Created by a on 6/6/2016.
 */
public class Navigate extends Login {


    @Test
    public void testNavigate() throws InterruptedException{
        login();
        clickByCss(".fsdnav-top-menu-item.fsdnav-selected");
        Thread.sleep(2000);
        clickByCss(".fsdnav-top-menu-item.boa-fn");
        Thread.sleep(2000);

    }
}
