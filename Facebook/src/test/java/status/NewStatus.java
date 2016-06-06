package status;

import log.Credentials;
import org.testng.annotations.Test;

/**
 * Created by a on 6/6/2016.
 */
public class NewStatus extends Credentials{

    @Test
    public void Update() throws InterruptedException{
        sampleLogin();
       // clickByCss("._2s25");
        Thread.sleep(2000);
        typeByCss(".uiTextareaAutogrow._3en1","hello");
       // typeByCss("._1mwp._395._1mwq._4c_p._5bu_._5yk1","hello");
        Thread.sleep(1000);
      //  clickByCss("._1mf7._4jy0._4jy3._4jy1._51sy.selected._42ft");
    }






}
