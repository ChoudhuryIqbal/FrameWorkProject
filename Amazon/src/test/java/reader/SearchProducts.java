package reader;

import util.DataReader;

import java.io.IOException;

/**
 * Created by a on 6/5/2016.
 */
public class SearchProducts {
    DataReader dataReader=new DataReader();

    public String[] getData() throws IOException{
        String path=System.getProperty("user.dir")+"/data/searchProduct.xls";
        String[] news=dataReader.fileReader(path);
        return news;



    }






}
