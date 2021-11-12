

public class Car {

    private String cname;
    private int cprice;
    private int cmileage;


    public Car(String cname, int cprice, int cmileage) {
        this.cname = cname;
        this.cprice = cprice;
        this.cmileage = cmileage;
    }


    public Car(String str){
        String[] values = str.split(",");
        this.cname=values[0];
        this.cprice= Integer.parseInt(values[1]);
        this.cmileage= Integer.parseInt(values[2]);
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


    @Override
    public String toString(){
        return " Car[ Car name: " + this.cname + ", Car Price: " + this.cprice + ", Car Mileage: " + this.cmileage + "]";
    }
}
