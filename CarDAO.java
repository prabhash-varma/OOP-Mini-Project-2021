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
        final String query="Truncate table car ";

        try(PreparedStatement st= con.prepareStatement(query)){
            System.out.println(" ALL rows deleted.");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }





    //Create
    public static void updateCar(String carname,int carprice,int carmileage){
        Connection con = DriverConnection.getConnection();
        final String query= "update car set Cprice=?, Cmileage=? where Cname=?";
        try(PreparedStatement st= con.prepareStatement(query)){
            st.setString(1,carname);
            st.setInt(2,carprice);
            st.setInt(3,carmileage);

            int rowsAffected = st.executeUpdate();
            System.out.println(rowsAffected+"  rows updated.");
        }
        catch(SQLException e){
            e.printStackTrace();
        }

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