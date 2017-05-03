import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by hp on 1/8/2017.
 */
public class WestminsterCarParkManager implements CarParkManager {
    private static final int maxCapacity = 20;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    private Vehicle vehicle;
    List<Vehicle> vehicleList;
    private List<Vehicle> deleteVehicleList;

    public WestminsterCarParkManager() {
        this.vehicleList = new LinkedList<Vehicle>();
        this.deleteVehicleList = new LinkedList<>();
    }

    public int numOfAvailableSpots() {
        return this.maxCapacity - this.vehicleList.size();
    }

    // Method to find number of occupied spaces in the carpark
    public int numOfOccupiedSpots() {
        return this.vehicleList.size();
    }

    @Override
    public void displayTotalChargers() {
      Income income=new Income();
      LinkedList<Vehicle> list= (LinkedList<Vehicle>) this.deleteVehicleList;
      for(Vehicle veh:list){
          long diff=DateTime.differenceHours(veh.getLeaveTime().date1,veh.getEntrytime().date1);
          double price= income.calFinalPrice((int) diff);
          veh.printDetails();
          System.out.print("\t"+price);

      }

    }

    @Override
    public void displayPercentage() {
           int carCount=0;
           int vanCount=0;
          int motorbikeCount=0;
//        System.out.println("Car percentage" + ((Car.carCount / maxCapacity) * 100));
//        System.out.println("MotorBike percentage" + ((Moterbike.motorbikeCount / maxCapacity) * 100));
//        System.out.println("Van percentage" + ((Van.vanCount / maxCapacity) * 100));

        LinkedList<Vehicle> vehicles= (LinkedList<Vehicle>) this.vehicleList;
        Iterator<Vehicle> iterator=vehicles.iterator();
        while(iterator.hasNext()){
            if(iterator.next().getVehicleType().equalsIgnoreCase("car")){
                carCount++;
            }
            if(iterator.next().getVehicleType().equalsIgnoreCase("van")){
                vanCount++;
            }
            if(iterator.next().getVehicleType().equalsIgnoreCase("motorbike")){
                motorbikeCount++;
            }

        }
        System.out.println("Car percentage" + (carCount / WestminsterCarParkManager.maxCapacity) * 100);
        System.out.println("MotorBike percentage" + (motorbikeCount / WestminsterCarParkManager.maxCapacity) * 100);
        System.out.println("Van percentage" + (vanCount / WestminsterCarParkManager.maxCapacity) * 100);
    }

    @Override
    public void displaySpecificDay() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the date and year to see vehicle details");
        int day = sc.nextInt();
        int year = sc.nextInt();
        LinkedList<Vehicle> vehicleLinkedList= (LinkedList<Vehicle>) this.vehicleList;
        for (Vehicle veh : vehicleLinkedList) {
            int calculateDay = veh.getEntrytime().calculateDay(veh.getEntrytime().date1);
            int calculateYear = veh.getEntrytime().calculateYear(veh.getEntrytime().date1);
            if (calculateDay == day && calculateYear == year)
            {
                veh.printDetails();
            } else {
                System.out.println("no vehicles found on that days");
            }

        }
    }

    @Override
    public void displaylongestDurationVehicle() {
        LinkedList<Vehicle> vehicles = (LinkedList<Vehicle>) this.deleteVehicleList;
        ListIterator<Vehicle> list = vehicles.listIterator(0);
        ArrayList<Long> difference = new ArrayList<>();
        while (list.hasNext()) {
            long diff = DateTime.differenceHours(list.next().getLeaveTime().date1, list.next().getEntrytime().date1);
            difference.add(diff);
            long max = Collections.max(difference);
            if (diff == max) {
                if(list.next().getVehicleType().equalsIgnoreCase("car")) ((Car) list.next()).printDetails();
               else if(list.next().getVehicleType().equalsIgnoreCase("motorbike")){
                    ((Moterbike) list.next()).printDetails();}
               else if(list.next().getVehicleType().equalsIgnoreCase("van")){
                    ((Van) list.next()).printDetails();
                }
                   }
                }

      }
    @Override
    public void displayLastParkedVehicle() {
        LinkedList<Vehicle> vehicles= (LinkedList<Vehicle>) this.vehicleList;
        Collections.sort(vehicles, Comparator.comparing(o -> o.getEntrytime().date1));
        System.out.println("Last parked vehicle is :");
        ((LinkedList<Vehicle>) (this.vehicleList)).getLast().printDetails();
    }

    @Override
    public void viewAllVehicles() {
        List<Vehicle> vehicles = this.vehicleList;
        Collections.sort(vehicles, Comparator.comparing(o -> o.getEntrytime().date1));
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleType().toLowerCase().equalsIgnoreCase("Car")) {
                Car car = (Car) vehicle;
                car.printDetails();
            }
           else if (vehicle.getVehicleType().toLowerCase().equalsIgnoreCase("Van")) {
                Van van = (Van) vehicle;
                van.printDetails();
            }
           else if (vehicle.getVehicleType().toLowerCase().equalsIgnoreCase("motorbike")) {
                Moterbike bike = (Moterbike) vehicle;
                bike.printDetails();
            }
        }
    }

    public void recordVehicleDetails() {
        Vehicle vechicle;
        Scanner sc = new Scanner(System.in);
        System.out.println("Vehicle Registration Number:");
        String id = sc.next();
        System.out.println("Brand:");
        String brand = sc.next();
        System.out.println("entry date and entry time(yyyy:mm:dd:hh:mm:ss):");
        String date = sc.next();
        DateTime time = new DateTime(date);
        System.out.println("Vehicle type :" + "\n" + "Car(C or c)" + "\n" + "Van (V or v)" + "\n" + "Moterbike(M or m)");
        char type = sc.next().charAt(0);
        switch (type) {
            case 'c':
            case 'C':
                System.out.println("car color:");
                String color = sc.next();
                System.out.println("car noOfDoors:");
                int door = sc.nextInt();
                Car car = new Car(id, brand, time, door, color);
                this.vehicleList.add(car);
                break;
            case 'V':
            case 'v':
                System.out.println("van cargoVolume:");
                int volume = sc.nextInt();
                Van van = new Van(id, brand, time, volume);
                this.vehicleList.add(van);
                this.vehicleList.add(van);
                break;
            case 'M':
            case 'm':
                System.out.println("car engineCapacity:");
                String capacity = sc.next();
                Moterbike motor= new Moterbike(id, brand, time, capacity);
                this.vehicleList.add(motor);
                break;
            default:
                break;
        }

    }

    @Override
    public void addVehicle() throws IOException {
        InputStreamReader in=new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(in);
        char response = 'y';
        while (response == 'y' || response == 'Y') {
            if (this.numOfAvailableSpots() > 0) {
                System.out.println("Available slots are :" + this.numOfAvailableSpots());
                this.recordVehicleDetails();
            } else {
                System.out.println("No slots available");
            }
            System.out.println("Do you want to add vehicle ");

            response = bufferedReader.readLine().charAt(0);
            //i++;
            if(response !='Y'|| response!='y')
            {
                this.runMenu();
            }
        }
    }
    @Override
    public void deleteVehicle() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vehicle Registration Number:");
        String id = sc.next();
        System.out.println("Vehicle leave time:");
        String date = sc.next();
        DateTime leavedate = new DateTime(date);
        int index = 0;
        for (int i = 0; i < this.vehicleList.size(); i++) {
            if (this.vehicleList.get(i).getRegNum() == id) {
                index = i;
            }
        }
        Vehicle vec = this.vehicleList.get(index);
        vec.setLeaveTime(leavedate);
        this.deleteVehicleList.add(vec);
        this.vehicleList.remove(index);
        vec.printDetails();

    }

    @Override
    public void runMenu() throws IOException {
        System.out.println("....................................................");
        System.out.println("......Welcome to DSK Hospital CarParking Centre.....");
        System.out.println("....................................................");
        System.out.println(".............................................................................");
        System.out.println("*                    1 : Add vehicle                                        *");
        System.out.println("*                    2 : Delete vehicle                                     *");
        System.out.println("*                    3 : Currently Parked Vehicles' List                    *");
        System.out.println("*                    4 : Vehicle type Percentage Report                     *");
        System.out.println("*                    5 : vehicle list for a particular day                  *");
        System.out.println("*                    6 : Car park income statement                          *");
        System.out.println("*                    7 : Long duration parked Vehicles                      *");
        System.out.println("*                    8 : Last Parked Vehicle                                *");
        System.out.println(".............................................................................");
        System.out.println("Enter Option     :");

        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        switch (option) {

            case 1:
                this.addVehicle();
                break;
            case 2:
                this.deleteVehicle();
                break;
            case 3:
                this.viewAllVehicles();
                break;
            case 4:
                this.displayPercentage();
                break;
            case 5:
                this.displaySpecificDay();
                break;
            case 6:
                this.displayTotalChargers();
                break;
            case 7:
                this.displaylongestDurationVehicle();
                break;
            case 8:
                this.displayLastParkedVehicle();
            default:
                System.exit(0);
                break;
        }
    }
}
