import java.io.IOException;

/**
 * Created by hp on 1/8/2017.
 */
public interface CarParkManager {
     void displayTotalChargers();
     void displayPercentage();
     void displaySpecificDay();
     void displaylongestDurationVehicle();
     void displayLastParkedVehicle();
     void viewAllVehicles();
     void addVehicle() throws IOException;
     void deleteVehicle();
     void runMenu() throws IOException;
}
