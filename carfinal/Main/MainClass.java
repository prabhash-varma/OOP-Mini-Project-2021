

package Main;

import Car.*;
import operations.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;



public class MainClass {

    public static void main(String[] args) throws Exception {

    
    // 1) Create/Update via CSV--------------------------------------------------------------------------
   if(args[0].equals("-enter")){
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Priya\\Desktop\\carfinal\\csv\\cars.csv"));
        String sline;
        while((sline= reader.readLine())!=null){

        
            if(sline.split(",").length==5){
            CreateData.createCar( new Car(sline));
            }
            else{
                System.out.println("--------------------------------------------------------------");
                System.out.println("|  Warning: Only "+sline.split(",").length+" inputs entered !! Enter all input fields  |");
                System.out.println("--------------------------------------------------------------");
            }
        }
        reader.close();

    }      





    // 2) Insert new Data into CSV file & Database from Cmd line------------------------------------------
    else if(args[0].equals("-insert")){
        try {

            String id = args[1];
            String name = args[2];
            int price= Integer.valueOf(args[3]);
            int mil = Integer.valueOf(args[4]); 
            String avail = args[5];
            Car c1 = new Car(id,name,price,mil,avail);

            InsertData.insertCar(c1);


            
            
        } catch (Exception e) {
            System.out.println("-----------------------------------------------------");
            System.out.println("|  Command NOT Found!! Enter '-h' for all Commands  |");
            System.out.println("-----------------------------------------------------");
        }
          
    }






    // 3) delete car data from DataBase using car id----------------------------------------------------
    else if(args[0].equals("-delete")){

        try {

            String car_id= args[1];
            DeleteData.deleteCar(car_id);
            
        } catch (Exception e) {
            System.out.println("-----------------------------------------------------");
            System.out.println("|  Command NOT Found!! Enter '-h' for all Commands  |");
            System.out.println("-----------------------------------------------------");
        }

    }





    // 4) Delete All cars from Database------------------------------------------------------------------- 
    else if(args[0].equals("-deleteAll")){
        try {
            DeleteData.deleteAllCar();
        } catch (Exception e) {
            System.out.println("-----------------------------------------------------");
            System.out.println("|  Command NOT Found!! Enter '-h' for all Commands  |");
            System.out.println("-----------------------------------------------------");
        }
    }





    // 5) update car data in the Database using carid -----------------------------------------------------
    else if(args[0].equals("-update")){
        try {
            String id= args[1];
            String name = args[2];
            int price= Integer.valueOf(args[3]);
            int mil = Integer.valueOf(args[4]); 
            String avail = args[5];
            Car c = new Car(id,name,price,mil,avail);
            UpdateData.updateCar(c);
            
        } catch (Exception e) {
            System.out.println("-----------------------------------------------------");
            System.out.println("|  Command NOT Found!! Enter '-h' for all Commands  |");
            System.out.println("-----------------------------------------------------");
        }
              
    }






    // 6) update car availability in the Database using carid -----------------------------------------------------
    else if(args[0].equals("-updateStatus")){
      try{  
            if(args[2].toLowerCase().equals("yes") || args[2].toLowerCase().equals("no")){
        
                 String id= args[1];
                String avail = args[2];
                UpdateData.updateCarStatus(id,avail);
            
            } 
    
            else{
                 System.out.println("-----------------------------------------------");
                 System.out.println("|  Error: Enter 'Yes/No' only for the status  |");
                 System.out.println("-----------------------------------------------");
             }
        }
        catch (Exception e) {
            System.out.println("-----------------------------------------------------");
            System.out.println("|  Command NOT Found!! Enter '-h' for all Commands  |");
            System.out.println("-----------------------------------------------------");
        }
              
    }





    // 7) Print all the cars in the Database-------------------------------------------------------------
    else if(args[0].equals("-printAll")){

        try{
            List<Car> list2 = PrintData.getAllCars();
            if(list2.isEmpty()){
                System.out.println("------------------------------");
                System.out.println("|  Sorry! we're out of Cars  |");
                System.out.println("------------------------------");
            }
            else{
                 //list2.forEach(System.out::println);
                 System.out.println("---------------------------------------------------------------------------");
                 System.out.printf("| %10s | %15s | %10s | %10s |%15s |", "CAR ID", "CAR NAME", "PRICE", "MILEAGE","AVAILABILITY");
                 System.out.println();
                 System.out.println("---------------------------------------------------------------------------");
                 for(int i=0;i<list2.size();i++)
                 {
                    list2.get(i).formatted_print();
                 }
                 System.out.println("---------------------------------------------------------------------------");
            }
        }
        catch (Exception e) {
            System.out.println("-----------------------------------------------------");
            System.out.println("|  Command NOT Found!! Enter '-h' for all Commands  |");
            System.out.println("-----------------------------------------------------");
        }
    }





    // 8) Print Cars using car id & car name(can use Partial Strings)------------------------------------- 
    else if(args[0].equals("-print")){

    try{
        if(args[1].equals("-id")){
                try{
                         List<Car> list2 = PrintData.getCarByID(args[2]);

                    if(list2.isEmpty()){
                             System.out.println("--------------------------------------");
                             System.out.println("|  Sorry! We couldn't find anything  |");
                             System.out.println("--------------------------------------");
                    }
                    else{
                            //list2.forEach(System.out::println);
                            System.out.println("---------------------------------------------------------------------------");
                            System.out.printf("| %10s | %15s | %10s | %10s |%15s |", "CAR ID", "CAR NAME", "PRICE", "MILEAGE","AVAILABILITY");
                            System.out.println();
                            System.out.println("---------------------------------------------------------------------------");
                            for(int i=0;i<list2.size();i++)
                            {
                                list2.get(i).formatted_print();
                            }
                            System.out.println("---------------------------------------------------------------------------");
                    }
            
                }
                catch(Exception e){
                    System.out.println("-----------------------------------------------------");
                    System.out.println("|  Command NOT Found!! Enter '-h' for all Commands  |");
                    System.out.println("-----------------------------------------------------");
                }
        }

        else if(args[1].equals("-name")){

            
            try{
            List<Car> list2 = PrintData.getCarByCname(args[2]);
    
                if(list2.isEmpty()){
                    System.out.println("--------------------------------------");
                    System.out.println("|  Sorry! We couldn't find anything  |");
                    System.out.println("--------------------------------------");
                }
                else{
                     //list2.forEach(System.out::println);
                    System.out.println("---------------------------------------------------------------------------");
                    System.out.printf("| %10s | %15s | %10s | %10s |%15s |", "CAR ID", "CAR NAME", "PRICE", "MILEAGE","AVAILABILITY");
                    System.out.println();
                    System.out.println("---------------------------------------------------------------------------");
                    for(int i=0;i<list2.size();i++)
                    {
                        list2.get(i).formatted_print();
                    }
                    System.out.println("---------------------------------------------------------------------------");
                }
                
            }
            catch(Exception e){
                System.out.println("-----------------------------------------------------");
                System.out.println("|  Command NOT Found!! Enter '-h' for all Commands  |");
                System.out.println("-----------------------------------------------------");
            }
            
        }

        else{
            System.out.println("-----------------------------------------------------");
            System.out.println("|  Command NOT Found!! Enter '-h' for all Commands  |");
            System.out.println("-----------------------------------------------------");
        }

    }catch(Exception e){
            System.out.println("-----------------------------------------------------");
            System.out.println("|  Command NOT Found!! Enter '-h' for all Commands  |");
            System.out.println("-----------------------------------------------------");
    }
        
}

     
    


    // 9) get cars using price & mileage (Exact values)----------------------------------------------------
    else if(args[0].equals("-get")){
        try{
            if(args[1].equals("-price"))
            {
                int price = Integer.valueOf(args[2]);
                List<Car> list2=  ExactData.show_for_price(price);
                if(list2.isEmpty())
                {
                    System.out.println("--------------------------------------");
                    System.out.println("|  Sorry! We couldn't find anything  |");
                    System.out.println("--------------------------------------");
                }
                else
                {
                    System.out.println("---------------------------------------------------------------------------");
                    System.out.printf("| %10s | %15s | %10s | %10s |%15s |", "CAR ID", "CAR NAME", "PRICE", "MILEAGE","AVAILABILITY");
                    System.out.println();
                    System.out.println("---------------------------------------------------------------------------");
                    for(int i=0;i<list2.size();i++)
                    {
                        list2.get(i).formatted_print();
                    }
                    System.out.println("---------------------------------------------------------------------------");
                }
            }
            else if(args[1].equals("-mileage"))
            {
                int mileage = Integer.valueOf(args[2]);
                List<Car> list2=  ExactData.show_for_mileage(mileage);
                if(list2.isEmpty())
                {
                    System.out.println("--------------------------------------");
                    System.out.println("|  Sorry! We couldn't find anything  |");
                    System.out.println("--------------------------------------");
                }
                else
                {
                    System.out.println("---------------------------------------------------------------------------");
                    System.out.printf("| %10s | %15s | %10s | %10s |%15s |", "CAR ID", "CAR NAME", "PRICE", "MILEAGE","AVAILABILITY");
                    System.out.println();
                    System.out.println("---------------------------------------------------------------------------");
                    for(int i=0;i<list2.size();i++)
                    {
                        list2.get(i).formatted_print();
                    }
                    System.out.println("---------------------------------------------------------------------------");
                }
            }
            else{
                System.out.println("-----------------------------------------------------");
                System.out.println("|  Command NOT Found!! Enter '-h' for all Commands  |");
                System.out.println("-----------------------------------------------------");
            }
            }
            catch(Exception e)
            {
                System.out.println("-----------------------------------------------------");
                System.out.println("|  Command NOT Found!! Enter '-h' for all Commands  |");
                System.out.println("-----------------------------------------------------");
            }
    }





    // 10) Search cars using price & mileage (greater & less)---------------------------------------------
    else if(args[0].equals("-search")){


        try {

            if(args[1].equals("-price")){
                if(args[2].equals("-gt")){
    
                    int temp= Integer.valueOf(args[3]);
                    List<Car> list2=  SearchData.search_price_gt(temp);
                    if(list2.isEmpty()){
                        System.out.println("--------------------------------------");
                        System.out.println("|  Sorry! We couldn't find anything  |");
                        System.out.println("--------------------------------------");
                    }
                    else{
                        System.out.println("---------------------------------------------------------------------------");
                        System.out.printf("| %10s | %15s | %10s | %10s |%15s |", "CAR ID", "CAR NAME", "PRICE", "MILEAGE","AVAILABILITY");
                        System.out.println();
                        System.out.println("---------------------------------------------------------------------------");
                        for(int i=0;i<list2.size();i++)
                        {
                            list2.get(i).formatted_print();
                        }
                        System.out.println("---------------------------------------------------------------------------");
                    }
                }
                else if(args[2].equals("-less")){
                    
                    int temp= Integer.valueOf(args[3]);
                    List<Car> list2=  SearchData.search_price_less(temp);
                    if(list2.isEmpty()){
                        System.out.println("--------------------------------------");
                        System.out.println("|  Sorry! We couldn't find anything  |");
                        System.out.println("--------------------------------------");
                    }
                    else{
                        System.out.println("---------------------------------------------------------------------------");
                        System.out.printf("| %10s | %15s | %10s | %10s |%15s |", "CAR ID", "CAR NAME", "PRICE", "MILEAGE","AVAILABILITY");
                        System.out.println();
                        System.out.println("---------------------------------------------------------------------------");
                        for(int i=0;i<list2.size();i++)
                        {
                            list2.get(i).formatted_print();
                        }
                        System.out.println("---------------------------------------------------------------------------");
                    }
                }
                else{
                    System.out.println("-----------------------------------------------------");
                    System.out.println("|  Command NOT Found!! Enter '-h' for all Commands  |");
                    System.out.println("-----------------------------------------------------");
                }
            }
    
            else if(args[1].equals("-mileage")){
                if(args[2].equals("-gt")){
                    int temp= Integer.valueOf(args[3]);
                    List<Car> list2=  SearchData.search_mileage_gt(temp);
                    if(list2.isEmpty()){
                        System.out.println("--------------------------------------");
                        System.out.println("|  Sorry! We couldn't find anything  |");
                        System.out.println("--------------------------------------");
                    }
                    else{
                        System.out.println("---------------------------------------------------------------------------");
                        System.out.printf("| %10s | %15s | %10s | %10s |%15s |", "CAR ID", "CAR NAME", "PRICE", "MILEAGE","AVAILABILITY");
                        System.out.println();
                        System.out.println("---------------------------------------------------------------------------");
                        for(int i=0;i<list2.size();i++)
                        {
                            list2.get(i).formatted_print();
                        }
                        System.out.println("---------------------------------------------------------------------------");
                    }
                }
                else if(args[2].equals("-less")){
                    int temp= Integer.valueOf(args[3]);
                    List<Car> list2=  SearchData.search_mileage_less(temp);
                    if(list2.isEmpty()){
                        System.out.println("--------------------------------------");
                        System.out.println("|  Sorry! We couldn't find anything  |");
                        System.out.println("--------------------------------------");
                    }
                    else{
                        System.out.println("---------------------------------------------------------------------------");
                        System.out.printf("| %10s | %15s | %10s | %10s |%15s |", "CAR ID", "CAR NAME", "PRICE", "MILEAGE","AVAILABILITY");
                        System.out.println();
                        System.out.println("---------------------------------------------------------------------------");
                        for(int i=0;i<list2.size();i++)
                        {
                            list2.get(i).formatted_print();
                        }
                        System.out.println("---------------------------------------------------------------------------");
                    }
                }
                else{
                    System.out.println("-----------------------------------------------------");
                    System.out.println("|  Command NOT Found!! Enter '-h' for all Commands  |");
                    System.out.println("-----------------------------------------------------");
                }
            }

            else{
                System.out.println("-----------------------------------------------------");
                System.out.println("|  Command NOT Found!! Enter '-h' for all Commands  |");
                System.out.println("-----------------------------------------------------");
            }
            
        } catch (Exception e) {
            System.out.println("-----------------------------------------------------");
            System.out.println("|  Command NOT Found!! Enter '-h' for all Commands  |");
            System.out.println("-----------------------------------------------------");
        }
          
    }

    




   // 11) Filter using car price & car mileage---------------------------------------------------------------
    else if(args[0].equals("-filter"))
    {
        try{
        if(args[1].equals("-price"))
        {
            int beg= Integer.valueOf(args[2]);
            int end= Integer.valueOf(args[3]);
            FilterData f1 = new FilterData();
            List<Car> list2=  f1.filter_price(beg,end);
            if(list2.isEmpty())
            {
                System.out.println("--------------------------------------");
                System.out.println("|  Sorry! We couldn't find anything  |");
                System.out.println("--------------------------------------");
            }
            else
            {
                System.out.println("---------------------------------------------------------------------------");
                System.out.printf("| %10s | %15s | %10s | %10s |%15s |", "CAR ID", "CAR NAME", "PRICE", "MILEAGE","AVAILABILITY");
                System.out.println();
                System.out.println("---------------------------------------------------------------------------");
                for(int i=0;i<list2.size();i++)
                {
                    list2.get(i).formatted_print();
                }
                System.out.println("---------------------------------------------------------------------------");
            }
        }
        else if(args[1].equals("-mileage"))
        {
            int beg= Integer.valueOf(args[2]);
            int end= Integer.valueOf(args[3]);
            FilterData f2 = new FilterData();
            List<Car> list2=  f2.filter_mileage(beg,end);
            if(list2.isEmpty())
            {
                System.out.println("--------------------------------------");
                System.out.println("|  Sorry! We couldn't find anything  |");
                System.out.println("--------------------------------------");
            }
            else
            {
                System.out.println("---------------------------------------------------------------------------");
                System.out.printf("| %10s | %15s | %10s | %10s |%15s |", "CAR ID", "CAR NAME", "PRICE", "MILEAGE","AVAILABILITY");
                System.out.println();
                System.out.println("---------------------------------------------------------------------------");
                for(int i=0;i<list2.size();i++)
                {
                    list2.get(i).formatted_print();
                }
                System.out.println("---------------------------------------------------------------------------");
            }
        }
        else 
        {
            System.out.println("-----------------------------------------------------");
            System.out.println("|  Command NOT Found!! Enter '-h' for all Commands  |");
            System.out.println("-----------------------------------------------------");
        }
        }
        catch(Exception e)
        {
            System.out.println("-----------------------------------------------------");
            System.out.println("|  Command NOT Found!! Enter '-h' for all Commands  |");
            System.out.println("-----------------------------------------------------");
        }
    }




    

    //12) Check availability of the car using id--------------------------------------------------------
    else if(args[0].equals("-check")){

        try{
        if(args[1]!=null){
        

            String id = args[1];
            List<Car> list2 = PrintData.getCarByID(id);
            if(list2.isEmpty()){
                System.out.println("--------------------------------------");
                System.out.println("|  Sorry! We couldn't find anything  |");
                System.out.println("--------------------------------------");
            }
            else{
                 for(Car i: list2){
                     System.out.println("---------------------------------------------------------------------------");
                     System.out.println("|                  Availability of Car with ID:"+i.getCid()+" : "+i.getCavail().substring(0,1).toUpperCase()+ i.getCavail().substring(1)+ "                 |");
                     System.out.println("---------------------------------------------------------------------------");
                     if(i.getCavail().equals("yes"))
                     {
                        System.out.println("---------------------------------------------------------------------------");
                        System.out.printf("| %10s | %15s | %10s | %10s |%15s |", "CAR ID", "CAR NAME", "PRICE", "MILEAGE","AVAILABILITY");
                        System.out.println();
                        System.out.println("---------------------------------------------------------------------------");
                        i.formatted_print();
                        System.out.println("---------------------------------------------------------------------------");
                     }
                 }
            }
    
        
        }
        
        else{

            System.out.println("--------------------------------------");
            System.out.println("|  Sorry! We couldn't find anything  |");
            System.out.println("--------------------------------------");
        }
    }  
        catch (Exception e) {
            System.out.println("-----------------------------------------------------");
            System.out.println("|  Command NOT Found!! Enter '-h' for all Commands  |");
            System.out.println("-----------------------------------------------------");
        }
    }
    



    else if(args[0].equals("-h")){
        System.out.println("---------------------------Commands for Car Rental System---------------------------");
        System.out.println(" Create/Update via CSV      : -enter");
        System.out.println(" Insert via Cmd             : -insert car_id car_name car_price car_mileage status(yes/no)");
        System.out.println(" Delete(All)                : -deleteAll  ");
        System.out.println(" Delete(by car_id)          : -delete car_id ");
        System.out.println(" Update(by car_id)          : -update car_id car_name car_price car_mileage status(yes/no)");
        System.out.println(" Update Car Availability    : -updateStatus car_id status(yes/no)");
        System.out.println(" Print All cars             : -printAll");
        System.out.println(" Print by CarId             : -print -id car_id");
        System.out.println(" Print by CarName           : -print -name car_name");
        System.out.println(" Search(for exact price)    : -get -price car_price");
        System.out.println(" Search(for exact mileage)  : -get -mileage car_mileage");
        System.out.println(" Search(by price (gt))      : -search -price -gt car_price");
        System.out.println(" Search(by price (less))    : -search -price -less car_price");
        System.out.println(" Search(by mileage (gt))    : -search -mileage -gt car_mileage");
        System.out.println(" Search(by mileage (less))  : -search -mileage -less car_mileage");
        System.out.println(" Filter(in price range)     : -filter -price beg end");
        System.out.println(" Filter(in mileage range)   : -filter -mileage beg end");
        System.out.println(" Check Car Availability     : -check car_id");
        System.out.println(" For Help                   : -h ");
    

    }

    else{
        System.out.println("-----------------------------------------------------");
        System.out.println("|  Command NOT Found!! Enter '-h' for all Commands  |");
        System.out.println("-----------------------------------------------------");
    }


    
    
}

}