package operations;

import Car.*;
import Connection.*;
import java.sql.*;


public class InsertData{

// Insert new item from cmd line
    public static void insertCar(Car c){
        Connection con = DriverConnection.getConnection();
        final String query="insert into car(Cid,Cname,Cprice,Cmileage) values(?,?,?,?)";

        try(PreparedStatement st= con.prepareStatement(query)){
            st.setString(1, c.getCid());
            st.setString(2, c.getCname());
            st.setInt(3, c.getCprice());
            st.setInt(4, c.getCmileage());

            int rowsAffected = st.executeUpdate();
            System.out.println(rowsAffected+"  row created.");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

}