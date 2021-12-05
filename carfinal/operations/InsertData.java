package operations;

import Car.*;
import Connection.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
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
            final String query="insert into car(Cid,Cname,Cprice,Cmileage,Cavail) values(?,?,?,?,?)";

            try(PreparedStatement st= con.prepareStatement(query)){
                st.setString(1, c.getCid());
                st.setString(2, c.getCname());
                st.setInt(3, c.getCprice());
                st.setInt(4, c.getCmileage());
                st.setString(5, c.getCavail());
    
                int rowsAffected = st.executeUpdate();

                if(rowsAffected!=0){
                    System.out.println("----------------------------------");
                    System.out.println("|  Data successfully inserted!!  |");
                    System.out.println("----------------------------------");
                }
                else{
                    System.out.println("--------------------------------------------");
                    System.out.println("| Error: Car Data not inserted!! Try Again |");
                    System.out.println("--------------------------------------------");
                }

                try {
                    PrintWriter file =new PrintWriter(new BufferedWriter(new FileWriter("C:\\Uses\\Priya\\Desktop\\carfinal\\csv\\cars.csv",true)));
                    file.println(" ");
                    file.print(c.getCid());
                    file.print(",");
                    file.print(c.getCname());
                    file.print(",");
                    file.print(c.getCprice());
                    file.print(",");
                    file.print(c.getCmileage());
                    file.print(",");
                    file.print(c.getCavail());
                    file.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }

               
        else{ 
            Car temp = new Car(list.get(0).getCid(),list.get(0).getCname(),list.get(0).getCprice(),list.get(0).getCmileage(),list.get(0).getCavail());
    
            
            if((temp.getCid().equals(c.getCid()))  && (temp.getCname().equals(c.getCname())) && (temp.getCprice()==c.getCprice()) && (temp.getCmileage()== c.getCmileage()&& (temp.getCavail().equals(c.getCavail())) )){
                System.out.println("----------------------------------------------");
                System.out.println("|  We already have this car in our database  |");
                System.out.println("----------------------------------------------");
               
            }
            
           
           
            

        }
    }
}