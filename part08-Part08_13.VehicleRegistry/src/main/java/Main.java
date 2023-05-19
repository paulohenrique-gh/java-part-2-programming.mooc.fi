
import java.util.ArrayList;
import java.util.HashMap;


public class Main {

    public static void main(String[] args) {
     
        VehicleRegistry vehicleRegistry = new VehicleRegistry();

        LicensePlate lp1 = new LicensePlate("TG", "OPK-122");
        LicensePlate lp2 = new LicensePlate("HD", "LDK-869");
        LicensePlate lp3 = new LicensePlate("OD", "PDL-990");

        vehicleRegistry.add(lp1, "Jack");
        vehicleRegistry.add(lp2, "Mona");
        vehicleRegistry.add(lp3, "Jack");

        vehicleRegistry.printLicensePlates();
        System.out.println("-");
        vehicleRegistry.printOwners();
        
    }
}
