import java.util.Date;

/**
 * Created by hp on 1/4/2017.
 */
public abstract class Vehicle implements Comparable<Vehicle> {
    private String regNum;
    private String brand;
    private DateTime entrytime;
    private DateTime leaveTime;
    private Date date;

    public Date getDate() {
        return date;
    }

    public Vehicle(String regNum) {
        this.regNum = regNum;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public DateTime getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(DateTime leaveTime) {
        this.leaveTime = leaveTime;
    }

    public Vehicle(String regNum, String brand, DateTime entrytime) {
        this.regNum = regNum;
        this.brand = brand;
        this.entrytime = entrytime;
    }

    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public DateTime getEntrytime() {
        return entrytime;
    }

    public void setEntrytime(DateTime entrytime) {
        this.entrytime = entrytime;
    }
    public abstract String getVehicleType();
    public void printDetails(){
        System.out.println("Vehicle details".toUpperCase());
        System.out.println("...............................");
        System.out.println("vehicle plate id".toUpperCase()+":  "+this.getRegNum());
        System.out.println("vehicle type ".toUpperCase()+":  "+this.getVehicleType());
        System.out.println("vehicle entry time".toUpperCase()+": "+this.getEntrytime());
        System.out.println("vehicle brand".toUpperCase()+": "+this.getBrand());
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "regNum='" + regNum + '\'' +
                ", brand='" + brand + '\'' +
                ", entrytime=" + entrytime +
                ", leaveTime=" + leaveTime +
                ", date=" + date +
                '}';
    }
}
