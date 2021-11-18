

public class Car {

    private String cid;
    private String cname;
    private int cprice;
    private int cmileage;


    public Car(String cid,String cname, int cprice, int cmileage) {
        this.cid=cid;
        this.cname = cname;
        this.cprice = cprice;
        this.cmileage = cmileage;
    }


    public Car(String str){
        String[] values = str.split(",");
        this.cid=values[0];
        this.cname=values[1];
        this.cprice= Integer.valueOf(values[2]);
        this.cmileage= Integer.valueOf(values[3]);
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


    @Override
    public String toString(){
        return " Car[ Car id: "+this.cid+ ", Car name: " + this.cname + ", Car Price: " + this.cprice + ", Car Mileage: " + this.cmileage + "]";
    }
}
