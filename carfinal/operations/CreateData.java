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
}
