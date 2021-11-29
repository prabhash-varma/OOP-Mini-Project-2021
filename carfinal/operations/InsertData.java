package operations;

import Car.*;
import Connection.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class InsertData{

// Insert new item from cmd line
    public static void insertCar(Car c){
        Connection con = DriverConnection.getConnection();

        List<Car> list= new ArrayList<Car>();
        list = PrintData.getCarByID(c.getCid());

        if(list.isEmpty()){
            final String query="insert into car(Cid,Cname,Cprice,Cmileage) values(?,?,?,?)";

            try(PreparedStatement st= con.prepareStatement(query)){
                st.setString(1, c.getCid());
                st.setString(2, c.getCname());
                st.setInt(3, c.getCprice());
                st.setInt(4, c.getCmileage());
    
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
            Car temp = new Car(list.get(0).getCid(),list.get(0).getCname(),list.get(0).getCprice(),list.get(0).getCmileage());
    
            
            if((temp.getCid().equals(c.getCid()))  && (temp.getCname().equals(c.getCname())) && (temp.getCprice()==c.getCprice()) && (temp.getCmileage()== c.getCmileage() )){
                System.out.println("Car with Id:"+c.getCid()+" already exists in the Database.");
               
            }
            
           
           
            

        }
    }
}