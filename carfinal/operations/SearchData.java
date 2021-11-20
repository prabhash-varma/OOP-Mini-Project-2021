package operations;

import Car.*;
import Connection.*;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SearchData {
    //Search by price
    public static List<Car> search_price_gt(int num) {
        List<Car> c= new ArrayList<Car>();
            Connection con= DriverConnection.getConnection();
            final String query = "select * from car where Cprice > ?";
            try(PreparedStatement st = con.prepareStatement(query)){
                st.setInt(1,num);
                ResultSet rs = st.executeQuery();
                while(rs.next()){
                    Car tempcar = new Car(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
                    c.add(tempcar);
                }
    
            }
    
            catch(SQLException e){
                e.printStackTrace();
            }

            return c;
    }


    public static List<Car> search_price_less(int num) {
        List<Car> c= new ArrayList<Car>();
            Connection con= DriverConnection.getConnection();
            final String query = "select * from car where Cprice < ?";
            try(PreparedStatement st = con.prepareStatement(query)){
                st.setInt(1,num);
                ResultSet rs = st.executeQuery();
                while(rs.next()){
                    Car tempcar = new Car(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
                    c.add(tempcar);
                }
    
            }
    
            catch(SQLException e){
                e.printStackTrace();
            }

            return c;
    }




    //search by mileage
    public static List<Car> search_mileage_gt(int num) {
        List<Car> c= new ArrayList<Car>();
            Connection con= DriverConnection.getConnection();
            final String query = "select * from car where Cmileage > ?";
            try(PreparedStatement st = con.prepareStatement(query)){
                st.setInt(1,num);
                ResultSet rs = st.executeQuery();
                while(rs.next()){
                    Car tempcar = new Car(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
                    c.add(tempcar);
                }
    
            }
    
            catch(SQLException e){
                e.printStackTrace();
            }

            return c;
    }


    public static List<Car> search_mileage_less(int num) {
        List<Car> c= new ArrayList<Car>();
            Connection con= DriverConnection.getConnection();
            final String query = "select * from car where Cmileage < ?";
            try(PreparedStatement st = con.prepareStatement(query)){
                st.setInt(1,num);
                ResultSet rs = st.executeQuery();
                while(rs.next()){
                    Car tempcar = new Car(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
                    c.add(tempcar);
                }
    
            }
    
            catch(SQLException e){
                e.printStackTrace();
            }

            return c;
    }

}