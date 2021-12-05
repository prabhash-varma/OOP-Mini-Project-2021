package operations;


import Connection.*;
import java.sql.*;



public class DeleteData {

    //Delete by car ID
    public static void deleteCar(String car_id){
        Connection con = DriverConnection.getConnection();
        final String query="delete from car where Cid= ? ";

        try(PreparedStatement st= con.prepareStatement(query)){
            st.setString(1, car_id);
            int rowsAffected = st.executeUpdate();

            if(rowsAffected==0){
                System.out.println("--------------------------------------");
                System.out.println("|  Sorry! We couldn't find anything  |");
                System.out.println("--------------------------------------");
            }
            else{
                System.out.println("---------------------------------");
                System.out.println("|  Data successfully deleted!!  |");
                System.out.println("---------------------------------");
            }
        }
        catch(SQLException e){
            System.out.println("---------------------");
            System.out.println("| Error!! Try Again |");
            System.out.println("---------------------");
        }
    }



    //Delete All rows
    public static void deleteAllCar(){
        Connection con = DriverConnection.getConnection();
        final String query="Truncate table car";

        try(PreparedStatement st= con.prepareStatement(query)){
             st.executeUpdate();

            
                System.out.println("------------------------------");
                System.out.println("| All Cars have been deleted |.");
                System.out.println("------------------------------");
            
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

}