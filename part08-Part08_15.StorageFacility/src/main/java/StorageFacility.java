import java.util.ArrayList;
import java.util.HashMap;

public class StorageFacility {
    
    private HashMap<String, ArrayList<String>> storage;

    //constructor with no parameters
    public StorageFacility() {
        //creates new hashmap upon object instantiation
        this.storage = new HashMap<>();
    }

    //add new unit and item passed to new unit
    public void add(String StorageUnit, String item) {
        //if the unit passed is not in the hashmap, add the new unit with an empty array for now
        //if the unit is already in the hashmap, jump to the next line
        this.storage.putIfAbsent(StorageUnit, new ArrayList<>());
        //add the item to the unit
        this.storage.get(StorageUnit).add(item);

    }

    //get list with all current items in the unit
    public ArrayList<String> contents(String StorageUnit) {
        return this.storage.getOrDefault(StorageUnit, new ArrayList<>());
    }

    //remove item from unit
    public void remove(String storageUnit, String item) {
        //check every item in the array in storage unit
        for (int i = 0; i < this.storage.get(storageUnit).size(); i++) {
            //if current item equals the same as the one passed as argument,
            //remove it and continue 
            if (this.storage.get(storageUnit).get(i).equals(item)) {
                this.storage.get(storageUnit).remove(item);
                continue;
            }
        }

        //if the unit becomes empty after removing the item, remove the unit from the
        if (this.storage.get(storageUnit).isEmpty()) {
            this.storage.remove(storageUnit);
        }
    }

    //get list with all current units
    public ArrayList<String> storageUnits() {
        ArrayList<String> units = new ArrayList<>();
        for (String unit : this.storage.keySet()) {
            units.add(unit);
        }
        return units;
    }
}
