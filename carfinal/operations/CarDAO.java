
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
        list = PrintData.getCarByID(c.getCid());

        if(list.isEmpty()){
            final String query="insert into car(Cid,Cname,Cprice,Cmileage,Cavail) values(?,?,?,?,?)";

            try(PreparedStatement st= con.prepareStatement(query)){
                st.setString(1, c.getCid());
                st.setString(2, c.getCname());
                st.setInt(3, c.getCprice());
                st.setInt(4, c.getCmileage());
                st.setString(5, c.getCavail());
    
    
                int rowsAffected = st.executeUpdate();
                System.out.println(rowsAffected+" row created.");
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }

               
        else{ 
            Car temp = new Car(list.get(0).getCid(),list.get(0).getCname(),list.get(0).getCprice(),list.get(0).getCmileage(),list.get(0).getCavail());
    
            
            if((temp.getCid().equals(c.getCid()))  && (temp.getCname().equals(c.getCname())) && (temp.getCprice()==c.getCprice()) && (temp.getCmileage()== c.getCmileage() ) && (temp.getCavail().equals(c.getCavail()) )){
                System.out.println("1 row Unaffected");
               
            }
            
           
            else{

                final String query= "update car set Cname=?, Cprice=?, Cmileage=?, Cavail=? where Cid=?";
                try(PreparedStatement st= con.prepareStatement(query)){
                    st.setString(1,c.getCname());
                    st.setInt(2,c.getCprice());
                    st.setInt(3,c.getCmileage());
                    st.setString(4,c.getCavail());
                    st.setString(5,c.getCid());
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

    List<Car> list= new ArrayList<Car>();
    list = PrintData.getCarByID(c.getCid());

    if(list.isEmpty()){
        final String query="insert into car(Cid,Cname,Cprice,Cmileage,Cavail) values(?,?,?,?,?)";

        try(PreparedStatement st= con.prepareStatement(query)){
            st.setString(1, c.getCid());
            st.setString(2, c.getCname());
            st.setInt(3, c.getCprice());
            st.setInt(4, c.getCmileage());
            st.setString(5, c.getCavail());

            int rowsAffected = st.executeUpdate();

            if(rowsAffected!=0){
                System.out.println("Car with Id:"+c.getCid()+" has been inserted.");
            }
            else{
                System.out.println("Error: Car Data not inserted!! Try Again");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

           
    else{ 
        Car temp = new Car(list.get(0).getCid(),list.get(0).getCname(),list.get(0).getCprice(),list.get(0).getCmileage(),list.get(0).getCavail());

        
        if((temp.getCid().equals(c.getCid()))  && (temp.getCname().equals(c.getCname())) && (temp.getCprice()==c.getCprice()) && (temp.getCmileage()== c.getCmileage()&& (temp.getCavail().equals(c.getCavail())) )){
            System.out.println("Car with Id:"+c.getCid()+" already exists in the Database.");
           
        }
        
       
       
        

    }
}





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





    //Update
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
                System.out.println("Error: Car NOT Found!!");
            }
            else{
            System.out.println("Car with Id:"+c.getCid()+" has been updated.");
            }
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
                    Car tempcar = new Car(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5));
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
                    Car tempcar = new Car(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5));
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
                    Car tempcar = new Car(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5));
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
                    Car tempcar = new Car(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5));
                    c.add(tempcar);
                }
    
            }
    
            catch(SQLException e){
                e.printStackTrace();
            }

            return c;
    }




    

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





//Exact data
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
