/**
 * Created by hp on 1/4/2017.
 */
public class Car extends Vehicle{
   private int noOfDoors;
   private String color;
   public static int carCount;

    public Car(String regNum) {
        super(regNum);
    }

    public int getNoOfDoors() {
        return noOfDoors;
    }

    public void setNoOfDoors(int noOfDoors) {
        this.noOfDoors = noOfDoors;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Car(String regNum, String brand, DateTime entrytime, int noOfDoors, String color) {
        super(regNum, brand, entrytime);
        this.noOfDoors = noOfDoors;
        this.color = color;
        carCount++;
    }
   @Override
    public String getVehicleType() {
        return "Car".toLowerCase();
    }

    @Override
    public int compareTo(Vehicle o) {
        return 0;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("vehicle color is"+this.getColor());
        System.out.println("noOd doors are "+this.getNoOfDoors());
    }

    @Override
    public String toString() {
        return "Car{" +
                "noOfDoors=" + noOfDoors +
                ", color='" + color + '\'' +
                '}';
    }
}
