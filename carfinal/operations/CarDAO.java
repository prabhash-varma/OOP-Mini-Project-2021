
package operations;

import Car.*;
import Connection.*;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;



abstract class CarDAO {

    //  Create/Upload from CSV file
    public static void createCar(Car c){
        Connection con = DriverConnection.getConnection();

        List<Car> list= new ArrayList<Car>();
        list = getCarByID(c.getCid());

    
       

        if(list.isEmpty()){
            final String query="insert into car(Cid,Cname,Cprice,Cmileage) values(?,?,?,?)";

            try(PreparedStatement st= con.prepareStatement(query)){
                st.setString(1, c.getCid());
                st.setString(2, c.getCname());
                st.setInt(3, c.getCprice());
                st.setInt(4, c.getCmileage());
    
                int rowsAffected = st.executeUpdate();
                System.out.println(rowsAffected+" row created.");
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }

               
        else{ 
            Car temp = new Car(list.get(0).getCid(),list.get(0).getCname(),list.get(0).getCprice(),list.get(0).getCmileage());
    
            
            if((temp.getCid().equals(c.getCid()))  && (temp.getCname().equals(c.getCname())) && (temp.getCprice()==c.getCprice()) && (temp.getCmileage()== c.getCmileage() )){
                System.out.println("1 row Unaffected");
            }

            else{
                final String query= "update car set Cname=?, Cprice=?, Cmileage=? where Cid=?";
                try(PreparedStatement st= con.prepareStatement(query)){
                    st.setString(1,c.getCname());
                    st.setInt(2,c.getCprice());
                    st.setInt(3,c.getCmileage());
                    st.setString(4,c.getCid());
                    int rowsAffected = st.executeUpdate();
                    System.out.println(rowsAffected+" row updated.");
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
            }

        }
    }
                
        
    

        
 
    





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




    

    //Read - ALL
    public static List<Car> getAllCars(){

            List<Car> c= new ArrayList<Car>();
            Connection con= DriverConnection.getConnection();
            final String query = "select * from car";

            try(PreparedStatement st = con.prepareStatement(query)){

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



    //Read
    public static List<Car> getCarByID(String id){
        List<Car>  c = new ArrayList<Car>();
        Connection con = DriverConnection.getConnection();
        final String query = "select * from car where Cid= ?";


        try(PreparedStatement st = con.prepareStatement(query)){
            st.setString(1,id);
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
    public static List<Car> getCarByCname(String tname){
        tname.toLowerCase();
        String name= tname.substring(0,1).toUpperCase() + tname.substring(1);
        List<Car> clist= new ArrayList<Car>();
        List<Car> tlist = new ArrayList<Car>();
        Connection con= DriverConnection.getConnection();
        final String query = "select * from car";

        try(PreparedStatement st = con.prepareStatement(query)){

            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Car tempcar = new Car(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
                clist.add(tempcar);
            }


          for (int index = 0; index < clist.size() ; index++) {
              if(clist.get(index).getCname().contains(name)){
                  tlist.add(clist.get(index));
              }
          }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    return tlist;
    }
}
