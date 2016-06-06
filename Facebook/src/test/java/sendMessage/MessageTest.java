package sendMessage;

import log.Credentials;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by a on 6/6/2016.
 */
public class MessageTest extends Credentials {

    @Test
    public void message() throws InterruptedException,NoSuchElementException {
        sampleLogin();
        clickByXpath("html/body/div[1]/div[1]/div/div[1]/div/div/div/div[2]/div[2]/div[2]/div/a");
      clickByCss("#u_0_h");
        typeByCss(".inputtext.textInput","Choudhury Iqbal");
        Thread.sleep(3000);
        clickByXpath("html/body/div[1]/div[4]/div[1]/div/div/div[1]/div/div[1]/div[2]/div/div/div[2]/div/div/div/ul/li[1]");
       //typeByXpath("html/body/div[1]/div[4]/div[1]/div/div/div[1]/div/div[1]/div[2]/div/div/div/div/div[3]/div[5]/div/div[1]/div/div[2]/div/div/div/div","hello");
        // clickByCss(".inputtext.textInput");
      //  driver.findElement(By.cssSelector(".inputtext.textInput")).submit();
        Thread.sleep(8000);

       // driver.findElement(By.xpath("html/body/div[1]/div[4]/div[1]/div/div/div[1]/div/div[1]/div[2]/div/div/div/div/div[3]/div[5]/div/div[1]/div/div[2]/div/div/div/div")).submit();
        //Thread.sleep(3000);

    }
}
