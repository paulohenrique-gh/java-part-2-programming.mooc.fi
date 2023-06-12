import java.util.ArrayList;

public class HashMap<K, V> {
    
    // class variables: an array of arrayLists that contains key/value pairs, and an int to store current size of array,
    // used later when we need to know if we're going to grow the array
    private ArrayList<Pair<K, V>>[] values;
    private int firstFreeIndex;

    // constructor
    public HashMap() {
        // creates new array with capacity of 32 arraylists initially
        this.values = new ArrayList[32];
        this.firstFreeIndex = 0;
    }

    // return value based on key
    public V get(K key) {
        // calculate hashcode for the received key
        int hashValue = Math.abs(key.hashCode() % this.values.length);
        // if the array at the index corresponding to the hashcode has no arraylist of pairs, return null
        if (this.values[hashValue] == null) {
            return null;
        }

        // retrieve the arraylist stored in the array at the index corresponding to the hashcode
        ArrayList<Pair<K, V>> valuesAtIndex = this.values[hashValue];
        
        // iterate over the arraylist
        for (int i = 0; i < valuesAtIndex.size(); i++) {
            // check each pair in the arraylist and compare its key to the key that was received
            if (valuesAtIndex.get(i).getKey().equals(key)) {
                // if they're equal, return the corresponding value
                return valuesAtIndex.get(i).getValue();
            }
        }
        // otherwise return null
        return null;
    }

    // add new element to the map 
    public void add(K key, V value) {
        // create new arraylist to store key and value, replace value if the key is already in the map
        ArrayList<Pair<K, V>> valuesAtIndex = getListBasedOnKey(key);
        // get index of where the key is stored, if it exists
        int index = getIndexOfKey(valuesAtIndex, key);
        
        // if index is negative, that means the key still doesn't exist in the map
        if (index < 0) {
            // in which case we add a new pair the key and value to the arraylist, and increment the firstfreeindex by one to indicate the new size of the array
            valuesAtIndex.add(new Pair<K,V>(key, value));
            this.firstFreeIndex++;
        } else {
            // otherwise we replace the current value associated with the key with the value passed as argument
            valuesAtIndex.get(index).setValue(value);
        }

        // check if the size is greater the 75% of the initial capacity, if true we double the size
        if (1.0 * this.firstFreeIndex / this.values.length > 0.75) {
            grow();
        }
    }

    // method used by add(), to get a list based on a key
    private ArrayList<Pair<K, V>> getListBasedOnKey(K key) {
        // generate hashcode based on the key
        int hashValue = Math.abs(key.hashCode() % this.values.length);
        // check if corresponding index in the array is null, if so we create a new arraylist in that spot
        if (this.values[hashValue] == null) {
            this.values[hashValue] = new ArrayList<>();
        }

        // we either return an arraylist with some pairs already stored in it or a new arraylist
        return this.values[hashValue];
    }

    // method used by add() to get the index associated with key
    private int getIndexOfKey(ArrayList<Pair<K, V>> myList, K key) {
        // loop through the arraylist of pairs that was passed to the method
        for (int i = 0; i < myList.size(); i++) {
            // if the current key corresponds to the key, return the current index
            if (myList.get(i).getKey().equals(key)) {
                return i;
            }
        }
        // if the key is not in the arraylist, return -1
        return -1;
    }

    // double the capacity of the array when over 75% of inital capacity
    private void grow() {
        // create new empty array with double the capacity of the original one
        ArrayList<Pair<K, V>>[] newValues = new ArrayList[this.values.length * 2];

        // loop through every element in the array and copy it to the new array
        for (int i = 0; i < this.values.length; i++) {
            copy(newValues, i);
        }

        // after everything is copied the original array recieves the reference to the new one with increased capacity
        this.values = newValues;
    }

    // method used by grow() to copy current array to new array with double capacity
    private void copy(ArrayList<Pair<K, V>>[] newArray, int fromIndex) {
         // iterate through the arraylist at the given index of the array
        for (int i = 0; i < this.values[fromIndex].size(); i++) {
            // for each one we create a new pair that recieves the pair that is in the current index of the arraylist
            Pair<K, V> value = this.values[fromIndex].get(i);

            // regenerate hashcode to determine new location in the new array
            int hashValue = Math.abs(value.getKey().hashCode() % newArray.length);
            // if location is null, we assign a new arraylist to it
            if (newArray[hashValue] == null) {
                newArray[hashValue] = new ArrayList<>();
            }

            // add the pair to the arraylist
            newArray[hashValue].add(value);
        }
    }

    // remove pair based on the key and return the value that was associated to the key 
    public V remove(K key) {
        // first we create a new arraylist with pairs that might contain they key we're looking for
        ArrayList<Pair<K, V>> valuesAtIndex = getListBasedOnKey(key);
        // if it's empty we do nothing
        if (valuesAtIndex.size() == 0) {
            return null;
        }
        // we determine the index in the arraylist where the key is stored
        int index = getIndexOfKey(valuesAtIndex, key);
        // if negative, we return null
        if (index < 0) {
            return null;
        }
        // otherwise we store the pair in a variable, remove it from the arraylist and return the value
        Pair<K, V> pair = valuesAtIndex.get(index);
        valuesAtIndex.remove(index);
        return pair.getValue();

    }

}
