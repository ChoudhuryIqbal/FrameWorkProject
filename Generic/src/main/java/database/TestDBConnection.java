package database;

import java.util.List;

/**
 * Created by a on 6/6/2016.
 */
public class TestDBConnection {
    DBConnect dbConnect=new DBConnect();
    public static void main(String[] args) throws Exception {
        //dbconnect connect To Database
       DBConnect dbConnect=new DBConnect();
        List<String> newsList=dbConnect.readDataBase();
    }

}
