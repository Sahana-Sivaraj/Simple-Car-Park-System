/**
 * Created by hp on 1/4/2017.
 */
public class Moterbike extends Vehicle{
    private String engineCpacity;
    public static int motorbikeCount;
    public Moterbike(String regNum, String brand, DateTime entrytime,String engineCpacity) {
        super(regNum, brand, entrytime);
        this.engineCpacity=engineCpacity;
        motorbikeCount++;
    }

    public String getEngineCpacity() {
        return engineCpacity;
    }

    public void setEngineCpacity(String engineCpacity) {
        this.engineCpacity = engineCpacity;
    }

    @Override
    public String getVehicleType() {
        return "MoterBike".toLowerCase();
    }

    @Override
    public int compareTo(Vehicle o) {
        return 0;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("vehicle engine capasity "+this.getEngineCpacity());
    }

    @Override
    public String toString() {
        return "Moterbike{" +
                "engineCpacity='" + engineCpacity + '\'' +
                '}';
    }
}
