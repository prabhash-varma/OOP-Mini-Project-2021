package operations;


import Car.*;
import Connection.*;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class PrintData {
    //print ALL cars
    public static List<Car> getAllCars(){

        List<Car> c= new ArrayList<Car>();
        Connection con= DriverConnection.getConnection();
        final String query = "select * from car";

        try(PreparedStatement st = con.prepareStatement(query)){

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



//Print by CAR ID
public static List<Car> getCarByID(String id){
    List<Car>  c = new ArrayList<Car>();
    Connection con = DriverConnection.getConnection();
    final String query = "select * from car where Cid= ?";


    try(PreparedStatement st = con.prepareStatement(query)){
        st.setString(1,id);
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




//get Car by name (partial Strings)
public static List<Car> getCarByCname(String tname){
    
    String name=tname.toLowerCase();
    List<Car> clist= new ArrayList<Car>();
    List<Car> tlist = new ArrayList<Car>();
    Connection con= DriverConnection.getConnection();
    final String query = "select * from car";

    try(PreparedStatement st = con.prepareStatement(query)){

        ResultSet rs = st.executeQuery();
        while(rs.next()){
            Car tempcar = new Car(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5));
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
