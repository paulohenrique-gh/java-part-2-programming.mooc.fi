public class List<T> {
    
    private T[] values;
    private int firstFreeIndex; // always contains the current length of the array

    public List() {
        this.values = (T[]) new Object[10];
        this.firstFreeIndex = 0;
    }

    public void add(T value) {
        if (this.firstFreeIndex == this.values.length) {
            grow();
        }

        this.values[this.firstFreeIndex] = value;
        this.firstFreeIndex++;
    }

    public void grow() {
        int newSize = this.values.length + this.values.length / 2;
        T[] newArray = (T[]) new Object[newSize];
        for (int i = 0; i < this.values.length; i++) {
            newArray[i] = this.values[i];
        }
        this.values = newArray;
    }

    public boolean contains(T value) {
        return indexOfValue(value) >= 0;
    }

    public void remove(T value) {
        int fromIndex = indexOfValue(value);
        if (fromIndex < 0) return;
        moveToLeft(fromIndex);
        this.firstFreeIndex--;
    }

    public int indexOfValue(T value) {
        for (int i = 0; i < this.firstFreeIndex; i++) {
            if (this.values[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    private void moveToLeft(int fromIndex) {
        for (int i = fromIndex; i < this.firstFreeIndex; i++) {
            this.values[i] = this.values[i + 1];
        }
    }

    public T value(int index) {
        if (index < 0 || index > this.firstFreeIndex) {
            throw new ArrayIndexOutOfBoundsException("Out of bounds");
        }
        return this.values[index];
    }

    public int size() {
        return this.firstFreeIndex;
    }
}
