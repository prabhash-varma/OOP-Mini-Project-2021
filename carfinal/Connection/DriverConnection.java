package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DriverConnection {
    private static final String user= "root";
    private static final String password = "devivarma@123";
    private static final String url = "jdbc:mysql://localhost:3306/oops";

    public static Connection getConnection(){

        Connection con=null;

        try {

            Properties connectionProperties = new Properties();
            connectionProperties.put("user",user);
            connectionProperties.put("password",password);
            con = DriverManager.getConnection(url,connectionProperties);
           

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }

}