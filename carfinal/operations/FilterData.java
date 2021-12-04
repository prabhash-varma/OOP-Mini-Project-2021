package operations;
import Car.*;
import Connection.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

abstract class Pricerange
{
    abstract public List<Car> filter_price(int beg, int end);
    abstract public List<Car> filter_mileage(int beg,int end);
}

public class FilterData extends Pricerange
{
    @Override
    public List<Car> filter_price(int num1, int num2) {
        List<Car> c= new ArrayList<Car>();
            Connection con= DriverConnection.getConnection();
            final String query = "select * from car where Cprice > ? and Cprice < ?";
            try(PreparedStatement st = con.prepareStatement(query)){
                st.setInt(1,num1);
                st.setInt(2,num2);
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
    @Override
    public List<Car> filter_mileage(int num1, int num2) {
        List<Car> c= new ArrayList<Car>();
            Connection con= DriverConnection.getConnection();
            final String query = "select * from car where Cmileage > ? and Cmileage < ?";
            try(PreparedStatement st = con.prepareStatement(query)){
                st.setInt(1,num1);
                st.setInt(2,num2);
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
