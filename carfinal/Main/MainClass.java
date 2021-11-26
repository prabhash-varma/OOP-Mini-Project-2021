package Main;

import Car.*;
import operations.*;

import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.PrintWriter;
//import java.lang.ref.Cleaner;
//import java.util.Arrays;
import java.util.List;



public class MainClass {

    public static void main(String[] args) throws Exception {

    
    
   if(args[0].equals("enter")){
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Priya\\Desktop\\carfinal\\csv\\cars.csv"));
        String sline;
        while((sline= reader.readLine())!=null){
            CreateData.createCar(new Car(sline));
          
        }
        reader.close();

    }      
    
    else if(args[0].equals("-insert")){
        try {

            String id = args[1];
            String name = args[2];
            int price= Integer.valueOf(args[3]);
            int mil = Integer.valueOf(args[4]); 
            Car c1 = new Car(id,name,price,mil);

            InsertData.insertCar(c1);
            
        } catch (Exception e) {
            System.out.println("Command NOT Found!! Enter '-h' for all Commands");
        }
           


            /*
            PrintWriter file =new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\Priya\\Desktop\\test\\cars.csv",true)));

            file.print(id);
            file.print(",");
            file.print(name);
            file.print(",");
            file.print(price);
            file.print(",");
            file.print(mil);
            file.println(" ");
            file.close();
            */
    }

    else if(args[0].equals("-delete")){

        try {

            String car_id= args[1];
            DeleteData.deleteCar(car_id);
            
        } catch (Exception e) {
            System.out.println("Command NOT Found!! Enter '-h' for all Commands");
        }
            

    }

    else if(args[0].equals("-deleteAll")){
        try {
            DeleteData.deleteAllCar();
        } catch (Exception e) {
            System.out.println("Command NOT Found!! Enter '-h' for all Commands");
        }
    }

    else if(args[0].equals("-update")){
        try {
            String id= args[1];
            String name = args[2];
            int price= Integer.valueOf(args[3]);
            int mil = Integer.valueOf(args[4]); 
           
            Car c = new Car(id,name,price,mil);
            UpdateData.updateCar(c);
            
        } catch (Exception e) {
            System.out.println("Command NOT Found!! Enter '-h' for all Commands");
        }
            
        
    }


    else if(args[0].equals("-printAll")){

        try{
            List<Car> list2 = PrintData.getAllCars();
            if(list2.isEmpty()){
                System.out.println("List is Empty!!");
            }
            else{
                 list2.forEach(System.out::println);
            }
        }
        catch (Exception e) {
            System.out.println("Command NOT Found!! Enter '-h' for all Commands");
        }
    }

    else if(args[0].equals("-print")){

        try{
        if(args[1].equals("-id")){
                try{
                         List<Car> list2 = PrintData.getCarByID(args[2]);

                    if(list2.isEmpty()){
                             System.out.println("Warning: Entered WRONG Car ID!!");
                    }
                    else{
                            list2.forEach(System.out::println);
                    }
            
                }
                catch(Exception e){
                            System.out.println("Command NOT FOUND");
                }
        }

        else if(args[1].equals("-name")){

            
            try{
            List<Car> list2 = PrintData.getCarByCname(args[2]);
    
                if(list2.isEmpty()){
                    System.out.println("Warning: Entered WRONG Car name!!");
                }
                else{
                     list2.forEach(System.out::println);
                }
                
            }
            catch(Exception e){
                System.out.println("Command NOT FOUND!! Enter '-h' for all Commands");
            }
            
        }

    }catch(Exception e){
        System.out.println("Command NOT FOUND!! Enter '-h' for all Commands");
    }


        
    }

     
    

    else if(args[0].equals("-search")){


        try {

            if(args[1].equals("-price")){
                if(args[2].equals("-gt")){
    
                    int temp= Integer.valueOf(args[3]);
                    List<Car> list=  SearchData.search_price_gt(temp);
                    list.forEach(System.out::println);
                }
                else if(args[2].equals("-less")){
                    
                    int temp= Integer.valueOf(args[3]);
                    List<Car> list=  SearchData.search_price_less(temp);
                    list.forEach(System.out::println);
                }
            }
    
            else if(args[1].equals("-mileage")){
                if(args[2].equals("-gt")){
                    int temp= Integer.valueOf(args[3]);
                    List<Car> list=  SearchData.search_mileage_gt(temp);
                    list.forEach(System.out::println);
                }
                else if(args[2].equals("-less")){
                    int temp= Integer.valueOf(args[3]);
                    List<Car> list=  SearchData.search_mileage_less(temp);
                    list.forEach(System.out::println);
                }
            }

            else{
                System.out.println("Command NOT FOUND!! Enter '-h' for all Commands");
            }
            
        } catch (Exception e) {
            System.out.println("Command NOT FOUND!! Enter '-h' for all Commands");
        }
        

        
    }

    else if(args[0].equals("-get")){
        try{
            if(args[1].equals("-price"))
            {
                int price = Integer.valueOf(args[2]);
                List<Car> list=  ExactData.show_for_price(price);
                list.forEach(System.out::println);
                if(list.isEmpty())
                {
                    System.out.println("No cars exist with the price tag "+price+" Rs");
                }
            }
            else if(args[1].equals("-mileage"))
            {
                int mileage = Integer.valueOf(args[2]);
                List<Car> list=  ExactData.show_for_mileage(mileage);
                list.forEach(System.out::println);
                if(list.isEmpty())
                {
                    System.out.println("No cars with "+mileage+" mileage");
                }
            }
            }
            catch(Exception e)
            {
                System.out.println("Command NOT Found!! Enter '-h' for all Commands");
            }
    }





    else if(args[0].equals("-filter"))
    {
        try{
        if(args[1].equals("-price"))
        {
            int beg= Integer.valueOf(args[2]);
            int end= Integer.valueOf(args[3]);
            FilterData f1 = new FilterData();
            List<Car> list=  f1.filter_price(beg,end);
            list.forEach(System.out::println);
            if(list.isEmpty())
            {
                System.out.println("No cars in the price range "+beg+"-"+end);
            }
        }
        else if(args[1].equals("-mileage"))
        {
            int beg= Integer.valueOf(args[2]);
            int end= Integer.valueOf(args[3]);
            FilterData f2 = new FilterData();
            List<Car> list=  f2.filter_mileage(beg,end);
            list.forEach(System.out::println);
            if(list.isEmpty())
            {
                System.out.println("No cars in the mileage range "+beg+"-"+end);
            }
        }
        else 
        {
            System.out.println("Command NOT FOUND!! Enter '-h' for all Commands");
        }
        }
        catch(Exception e)
        {
            System.out.println("Command NOT FOUND!! Enter '-h' for all Commands");
        }
    }

    



    else if(args[0].equals("-h")){
        System.out.println("--------------------Commands for Mini Project---------------------");
        System.out.println(" Insert                     : -insert car_id car_name car_price car_mileage");
        System.out.println(" Delete(All)                : -deleteAll  ");
        System.out.println(" Delete(by car_id)          : -delete car_id ");
        System.out.println(" Update(by car_id)          : -update car_id car_name car_price car_mileage ");
        System.out.println(" Print All cars             : -printAll");
        System.out.println(" Print by CarId             : -print -id car_id");
        System.out.println(" Print by CarName           : -print -name car_name");
        System.out.println(" Search(for exact price)    : -get -price car_price");
        System.out.println(" Search(for exact mileage)  : -get -mileage car_mileage");
        System.out.println(" Search(by price)           : -search -price -gt car_price");
        System.out.println(" Search(by price)           : -search -price -less car_price");
        System.out.println(" Search(by mileage)         : -search -mileage -gt car_mileage");
        System.out.println(" Search(by mileage)         : -search -mileage -less car_mileage");
        System.out.println(" Filter(in price range)     : -filter -price beg end");
        System.out.println(" Filter(in mileage range)   : -filter -mileage beg end");
        System.out.println(" For Help                   : -h ");
    
    }

    else{
       System.out.printf("\n Command NOT Found!! Enter '-h' for all Commands\n");
    }


    
    
}

}
