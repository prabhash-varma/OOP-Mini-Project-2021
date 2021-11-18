import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDAO {

    //  Create/Upload from CSV file
    public static void createCar(Car c){
        Connection con = DriverConnection.getConnection();
        final String query="insert into car(Cname,Cprice,Cmileage) values(?,?,?)";

        try(PreparedStatement st= con.prepareStatement(query)){
            st.setString(1, c.getCname());
            st.setInt(2, c.getCprice());
            st.setInt(3, c.getCmileage());

            int rowsAffected = st.executeUpdate();
            System.out.println(rowsAffected+"  rows created.");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }




    // Insert new item from cmd line
    public static void insertCar(Car c){
        Connection con = DriverConnection.getConnection();
        final String query="insert into car(Cname,Cprice,Cmileage) values(?,?,?)";

        try(PreparedStatement st= con.prepareStatement(query)){
            st.setString(1, c.getCname());
            st.setInt(2, c.getCprice());
            st.setInt(3, c.getCmileage());

            int rowsAffected = st.executeUpdate();
            System.out.println(rowsAffected+"  rows created.");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }





    //delete by car name
    public static void deleteCar(String car_name){
        Connection con = DriverConnection.getConnection();
        final String query="delete from car where Cname= ? ";

        try(PreparedStatement st= con.prepareStatement(query)){
            st.setString(1, car_name);
            int rowsAffected = st.executeUpdate();
            System.out.println(rowsAffected+" rows deleted.");
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
            int rows= st.executeUpdate();
            System.out.println("All rows deleted.");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }





    //Create
    public static void updateCar(Car c){
        Connection con = DriverConnection.getConnection();
        final String query= "update car set Cprice=?, Cmileage=? where Cname=?";

        
        try(PreparedStatement st= con.prepareStatement(query)){
            st.setInt(1,c.getCprice());
            st.setInt(2,c.getCmileage());
            st.setString(3,c.getCname());
           
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
                    Car tempcar = new Car(rs.getString(1),rs.getInt(2),rs.getInt(3));
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
                    Car tempcar = new Car(rs.getString(1),rs.getInt(2),rs.getInt(3));
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
                    Car tempcar = new Car(rs.getString(1),rs.getInt(2),rs.getInt(3));
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
                    Car tempcar = new Car(rs.getString(1),rs.getInt(2),rs.getInt(3));
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
                    Car tempcar = new Car(rs.getString(1),rs.getInt(2),rs.getInt(3));
                    c.add(tempcar);
                }
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        return c;
    }



    //Read
    public static List<Car> getCarByName(String name){
        List<Car>  c = new ArrayList<Car>();
        Connection con = DriverConnection.getConnection();
        final String query = "select * from car where Cname= ?";

        try(PreparedStatement st = con.prepareStatement(query)){
            st.setString(1,name);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Car tempcar = new Car(rs.getString(1),rs.getInt(2),rs.getInt(3));
                c.add(tempcar);
            }

        }

        catch(SQLException e){
            e.printStackTrace();
        }

        return c;
    }
}