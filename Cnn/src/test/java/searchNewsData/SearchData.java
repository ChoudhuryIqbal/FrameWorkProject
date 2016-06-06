package searchNewsData;

import database.DBConnect;
import util.DataReader;

import java.io.IOException;
import java.util.List;

/**
 * Created by a on 6/5/2016.
 */
public class SearchData {
    DataReader dataReader=new DataReader();
    DBConnect dbConnect=new DBConnect();

    public String[] getData() throws IOException {
        String path=System.getProperty("user.dir")+"/data/file1.xls";
        String[] news=dataReader.fileReader(path);
        return news;



    }
    public List<String> getDataFromDB() throws IOException,Exception{
        List<String> newsList=dbConnect.readDataBase();
        return newsList;
    }

    public String[] getActionFromExcelFile() throws IOException{
        String path=System.getProperty("user.dir")+"/data/file1.xls";
        String [] news=dataReader.fileReader(path);
        return news;
    }
    /*
public List<String> getNewsDataFromDB(String tableName,String columnName)throws Exception{
    List<String >  newsList=dbConnect.readDataBase(tableName,columnName);
    return newsList;
}

    public List<String> getActionStepsDataFromDB(String tableName,String columnName) throws Exception{
        List<String> actionList=dbConnect.readDataBase(tableName,columnName);
        return actionList;
    }



*/
}