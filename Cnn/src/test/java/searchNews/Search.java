package searchNews;

import base.CommonAPI;
import org.testng.annotations.Test;
import searchNewsData.SearchData;

import java.io.IOException;

/**
 * Created by a on 6/5/2016.
 */
public class Search extends CommonAPI{
    SearchData searchData=new SearchData();

    @Test
    public void findProducts() throws InterruptedException,IOException {
       /* clickByCss("#twotabsearchtextbox");
        Thread.sleep(1000);
        typeByCss("#twotabsearchtextbox",searchProducts.getData());
        takeEnterKeys("#twotabsearchtextbox");
        Thread.sleep(2000);*/
        String[] data = searchData.getData();
        clickByCss("#search-button");
        Thread.sleep(3000);
        int counter = 0;
        for (String st : data) {
            if (counter == 0) {
                typeByCss("#search-input-field", st);
                takeEnterKeys("#search-input-field");
                clearInputField("#search-input-field");
                Thread.sleep(6000);
                counter++;

            } else {
                typeByCss("#search-input-field", st);
                takeEnterKeys("#search-input-field");
                Thread.sleep(6000);
                clearInputField("#search-input-field");
            }


        }


    }

}
