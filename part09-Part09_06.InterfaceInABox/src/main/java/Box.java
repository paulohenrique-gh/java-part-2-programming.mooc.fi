import java.util.ArrayList;

public class Box implements Packable{

    private ArrayList<Packable> items;
    private double maxCapacity;

    public Box(double maxCapacity) {
        this.items = new ArrayList<>();
        this.maxCapacity = maxCapacity;
    }

    public void add(Packable item) {
        if (item.weight() <= this.maxCapacity - this.weight()) {
            this.items.add(item);
        }
    }

    @Override
    public double weight() {
        double currentWeight = 0;

        for (Packable item : items) {
            currentWeight += item.weight();
        }

        return currentWeight;
    }
    
    @Override
    public String toString() {
        return "Box: " + this.items.size() + " items, total weight " + this.weight() + " kg";
    }
}
