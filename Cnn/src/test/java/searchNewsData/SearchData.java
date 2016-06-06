package searchNewsData;

import util.DataReader;

import java.io.IOException;

/**
 * Created by a on 6/5/2016.
 */
public class SearchData {
    DataReader dataReader=new DataReader();

    public String[] getData() throws IOException {
        String path=System.getProperty("user.dir")+"/data/file1.xls";
        String[] news=dataReader.fileReader(path);
        return news;



    }






}