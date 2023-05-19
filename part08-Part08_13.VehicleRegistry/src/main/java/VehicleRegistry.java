import java.util.ArrayList;
import java.util.HashMap;

public class VehicleRegistry {
    private HashMap<LicensePlate, String> vehicleRegistry;

    public VehicleRegistry() {
        this.vehicleRegistry = new HashMap<>();
    }

    public boolean add(LicensePlate licensePlate, String owner) {
        if (!this.vehicleRegistry.containsKey(licensePlate)) {
            this.vehicleRegistry.put(licensePlate, owner);
            return true;
        }

        return false;
    }

    public String get(LicensePlate licensePlate) {
        if (this.vehicleRegistry.containsKey(licensePlate)) {
            return this.vehicleRegistry.get(licensePlate);
        }

        return null;
    }

    public boolean remove(LicensePlate licensePlate) {
        if (this.vehicleRegistry.containsKey(licensePlate)) {
            this.vehicleRegistry.remove(licensePlate);
            return true;
        }

        return false;
    }

    public void printLicensePlates() {
        for (LicensePlate lp : this.vehicleRegistry.keySet()) {
            System.out.println(lp);
        }
    }

    public void printOwners() {
        ArrayList<String> printedOwners = new ArrayList<>();
        for (String owners : this.vehicleRegistry.values()) {
            if (!(printedOwners.contains(owners))) {
                System.out.println(owners);
                printedOwners.add(owners);
            }
        }
    }
}
