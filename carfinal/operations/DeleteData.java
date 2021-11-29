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

            if(rowsAffected==0){
                System.out.println("Error: No car with Id:"+car_id+" !! ");
            }
            else{
            System.out.println("Car with ID:"+car_id+" has been deleted.");
            }
        }
        catch(SQLException e){
            System.out.println("Error!! Try Again");
        }
    }



    //Delete All rows
    public static void deleteAllCar(){
        Connection con = DriverConnection.getConnection();
        final String query="Truncate table car";

        try(PreparedStatement st= con.prepareStatement(query)){
            int rowsAffected = st.executeUpdate();

            if(rowsAffected==0){
                System.out.println("All Cars have been deleted.");
            }
            else{
            System.out.println("All Cars have been deleted.");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

}
