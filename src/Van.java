/**
 * Created by hp on 1/4/2017.
 */
public class Van extends Vehicle{
    private int cargoVolume;
    public static int vanCount;

    public Van(String regNum, String brand, DateTime entrytime,int cargoVolume) {
        super(regNum, brand, entrytime);
        this.cargoVolume=cargoVolume;
        vanCount++;
    }

    public int getCargoVolume() {
        return cargoVolume;
    }

    public void setCargoVolume(int cargoVolume) {
        this.cargoVolume = cargoVolume;
    }

    @Override
    public String getVehicleType() {
        return "Van";
    }

    @Override
    public int compareTo(Vehicle o) {
        return 0;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("vahicle cargo volume :"+this.getCargoVolume());
    }

    @Override
    public String toString() {
        return "Van{" +
                "cargoVolume=" + cargoVolume +
                '}';
    }
}
