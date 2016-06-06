package lookForProduct;

import base.CommonAPI;
import org.testng.annotations.Test;
import reader.SearchProducts;

import java.io.IOException;

/**
 * Created by a on 6/5/2016.
 */
public class Search extends CommonAPI{
    SearchProducts searchProducts=new SearchProducts();

    @Test
    public void findProducts() throws InterruptedException,IOException {
       /* clickByCss("#twotabsearchtextbox");
        Thread.sleep(1000);
        typeByCss("#twotabsearchtextbox",searchProducts.getData());
        takeEnterKeys("#twotabsearchtextbox");
        Thread.sleep(2000);*/
        String[] data = searchProducts.getData();
        clickByCss("#twotabsearchtextbox");
        Thread.sleep(2000);
        int counter = 0;
        for (String st : data) {
            if (counter == 0) {
                typeByCss("#twotabsearchtextbox", st);
                takeEnterKeys("#twotabsearchtextbox");
                clearInputField("#twotabsearchtextbox");
                Thread.sleep(2000);
                counter++;

            } else {
                typeByCss("#twotabsearchtextbox", st);
                takeEnterKeys("#twotabsearchtextbox");
                Thread.sleep(1000);
                clearInputField("#twotabsearchtextbox");
            }


        }


    }

}
