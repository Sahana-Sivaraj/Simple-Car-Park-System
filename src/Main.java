import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by hp on 1/8/2017.
 */
public class Main {
    void runSystemMenu(){
      //
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        try
        {
            char Response = 'Y';
            String Stop = "";
            while (Response == 'Y' || Response=='y') {
                new WestminsterCarParkManager().runMenu();

                System.out.println("Do You Want Continue !");

                Stop = br.readLine();
                Response = Stop.charAt(0);
            }
        }
        catch(Exception ex){}
    }
    public static void main(String args[]) throws Exception{
      new Main().runSystemMenu();
    }
}
