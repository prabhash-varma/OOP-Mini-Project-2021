package operations;

import Car.*;
import Connection.*;
import java.sql.*;

public class UpdateData {
    //Update CAR DATA using CAR ID
    public static void updateCar(Car c){
        Connection con = DriverConnection.getConnection();
        final String query= "update car set Cname=?, Cprice=?, Cmileage=?, Cavail=? where Cid=?";
        try(PreparedStatement st= con.prepareStatement(query)){

            st.setString(1,c.getCname());
            st.setInt(2,c.getCprice());
            st.setInt(3,c.getCmileage());
            st.setString(4,c.getCavail());
            st.setString(5,c.getCid());
           
            int rowsAffected =st.executeUpdate();

            if(rowsAffected==0){

                System.out.println("----------------------------");
                System.out.println("|  Error: Car NOT Found!!  |");
                System.out.println("----------------------------");
            }
            else{
            System.out.println("---------------------------------");
            System.out.println("|  Data successfully updated!!  |");
            System.out.println("---------------------------------");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }

    }



    //Update CAR STATUS using CAR ID
    public static void updateCarStatus(String id,String avail) {
        Connection con = DriverConnection.getConnection();
        final String query= "update car set Cavail=? where Cid=?";
        try(PreparedStatement st= con.prepareStatement(query)){
            st.setString(1,avail);
            st.setString(2,id);
            
           
            int rowsAffected =st.executeUpdate();

            if(rowsAffected==0){
                System.out.println("----------------------------");
                System.out.println("|  Error: Car NOT Found!!  |");
                System.out.println("----------------------------");
            }
            else{
                System.out.println("---------------------------------");
                System.out.println("|  Data successfully updated!!  |");
                System.out.println("---------------------------------");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}