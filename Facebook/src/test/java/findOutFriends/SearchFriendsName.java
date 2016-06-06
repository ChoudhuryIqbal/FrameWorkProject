package findOutFriends;

import log.Credentials;
import login.LoginTest;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by a on 6/6/2016.
 */
public class SearchFriendsName  extends Credentials{
    @Test
    public void enterName()throws InterruptedException,IOException {
        sampleLogin();
        clickById("findFriendsNav");
        typeByCss("._586i","Faisal Shovon");

        // typeByXpath("html/body/div[1]/div[1]/div/div[1]/div/div/div/div[1]/div[2]/div/form/div/div/div/div/div[3]","Faisal Shovon");
        //  clickByXpath("html/body/div[1]/div[1]/div/div[1]/div/div/div/div[1]/div[2]/div/form/div/div/div/div/div[3]");
        Thread.sleep(8000);

    }
}
