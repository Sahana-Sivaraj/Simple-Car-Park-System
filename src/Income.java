/**
 * Created by hp on 1/8/2017.
 */
public class Income {
    private double price;
    private int parkedHours;
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public int getParkedHours() {
        return parkedHours;
    }

    public double calFinalPrice(int hoursParked){
        double totalCost=0.0;
        this.setParkedHours(hoursParked);
        double currentCost = this.finalPrice(this.getParkedHours()); //most recent customer
        totalCost+=currentCost;
        return totalCost;
    }
    public double finalPrice(int numHours){
        double garageCost = 0;

        if(numHours<=3)
            garageCost = 3;

        else if(numHours>3 && numHours<=19)
            garageCost = 3.0 + 1*(numHours - 3);

        else if (numHours >19)
            garageCost = 30;

        return garageCost;

    }
    public void setParkedHours(int parkedHours) {

        this.parkedHours = parkedHours;
    }
}
