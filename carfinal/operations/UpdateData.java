package operations;

import Car.*;
import Connection.*;
import java.sql.*;

public class UpdateData {
    //Create
    public static void updateCar(Car c){
        Connection con = DriverConnection.getConnection();
        final String query= "update car set Cname=?, Cprice=?, Cmileage=? where Cid=?";
        try(PreparedStatement st= con.prepareStatement(query)){

            st.setString(1,c.getCname());
            st.setInt(2,c.getCprice());
            st.setInt(3,c.getCmileage());
            st.setString(4,c.getCid());
           
            int rowsAffected =st.executeUpdate();
            System.out.println(rowsAffected+" row updated.");
        }
        catch(SQLException e){
            e.printStackTrace();
        }

    }
}
