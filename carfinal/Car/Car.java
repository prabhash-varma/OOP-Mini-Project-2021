    package Car;

    
    
    public class Car {

    private String cid;
    private String cname;
    private int cprice;
    private int cmileage;
    private String cavail;

    public Car(String cid,String cname, int cprice, int cmileage,String cavail) {
        this.cid=cid;
        this.cname=cname.toLowerCase();
        this.cprice = cprice;
        this.cmileage = cmileage;
        this.cavail= cavail;
    }


    public Car(String str){
        String values[] = str.split(",");

        this.cid=values[0];
        String name = values[1];
        this.cname=name.toLowerCase();
        this.cprice= Integer.valueOf(values[2]);
        this.cmileage= Integer.valueOf(values[3]);
        this.cavail= values[4];
    }

    
     


    public String getCid() {
        return cid;
    }


    public void setCid(String cid) {
        this.cid = cid;
    }


    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getCprice() {
        return cprice;
    }

    public void setCprice(int cprice) {
        this.cprice = cprice;
    }

    public int getCmileage() {
        return cmileage;
    }

    public void setCmileage(int cmileage) {
        this.cmileage = cmileage;
    }

    public String getCavail() {
        return cavail;
    }


    public void setCavail(String cavail) {
        this.cavail = cavail;
    }



    public void formatted_print()
    {
        System.out.printf("| %10s | %15s | %10d | %10d | %10s     |",this.cid.toUpperCase(),this.cname.toUpperCase(),this.cprice,this.cmileage,this.cavail.toUpperCase());
        System.out.println();
    }

    @Override
    public String toString(){
        String temp= this.cname;
        String name= temp.substring(0,1).toUpperCase()+ temp.substring(1);  //Converting First letter into Uppercase
        String avail= this.cavail;
        String status= avail.substring(0,1).toUpperCase()+ avail.substring(1);

        return " Car[ Id: "+this.cid+ ", Name: "+name+ ", Price: " + this.cprice + ", Mileage: " + this.cmileage + ", Availability: "+status+"]";
    }


    
}
