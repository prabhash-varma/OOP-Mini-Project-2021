package operations;


import Connection.*;
import java.sql.*;


public class DeleteData {
    //delete by car name
    public static void deleteCar(String car_id){
        Connection con = DriverConnection.getConnection();
        final String query="delete from car where Cid= ? ";

        try(PreparedStatement st= con.prepareStatement(query)){
            st.setString(1, car_id);
            int rowsAffected = st.executeUpdate();
            System.out.println(rowsAffected+" row deleted.");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }



    //Delete All rows
    public static void deleteAllCar(){
        Connection con = DriverConnection.getConnection();
        final String query="Truncate table car";

        try(PreparedStatement st= con.prepareStatement(query)){
             st.executeUpdate();
            System.out.println("All rows deleted.");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

}
