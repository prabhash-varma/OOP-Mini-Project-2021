package operations;

import Car.*;
import Connection.*;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CreateData {


    public static void createCar(Car c){
        Connection con = DriverConnection.getConnection();

        List<Car> list= new ArrayList<Car>();
        list = PrintData.getCarByID(c.getCid());

        //If list is Empty, it creates a new row
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

        //If CAR ID already exists in the table and all the inputs are same then Row will be unaffected    
        else{ 
            Car temp = new Car(list.get(0).getCid(),list.get(0).getCname(),list.get(0).getCprice(),list.get(0).getCmileage(),list.get(0).getCavail());
    
            
            if((temp.getCid().equals(c.getCid()))  && (temp.getCname().equals(c.getCname())) && (temp.getCprice()==c.getCprice()) && (temp.getCmileage()== c.getCmileage() ) && (temp.getCavail().equals(c.getCavail()) )){
                System.out.println("1 row Unaffected");
               
            }
            
           

         //IF CAR ID exists in the table and other inputs are different then the row will be updated   
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
}
