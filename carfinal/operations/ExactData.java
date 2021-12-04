package operations;

import Car.*;
import Connection.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class ExactData {
    public static List<Car> show_for_price(int price){
        List<Car>  c = new ArrayList<Car>();
        Connection con = DriverConnection.getConnection();
        final String query = "select * from car where Cprice= ?";
    
    
        try(PreparedStatement st = con.prepareStatement(query)){
            st.setInt(1,price);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Car tempcar = new Car(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5));
                c.add(tempcar);
            }
    
        }
    
        catch(SQLException e){
            e.printStackTrace();
        }
    
        return c;
    }



    public static List<Car> show_for_mileage(int mileage){
        List<Car>  c = new ArrayList<Car>();
        Connection con = DriverConnection.getConnection();
        final String query = "select * from car where Cmileage= ?";
    
    
        try(PreparedStatement st = con.prepareStatement(query)){
            st.setInt(1,mileage);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Car tempcar = new Car(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5));
                c.add(tempcar);
            }
    
        }
    
        catch(SQLException e){
            e.printStackTrace();
        }
    
        return c;
    }
}
