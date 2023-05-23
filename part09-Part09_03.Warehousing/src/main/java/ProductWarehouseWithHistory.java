public class ProductWarehouseWithHistory extends ProductWarehouse {

    private ChangeHistory history;

    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        super.addToWarehouse(initialBalance);
        this.history = new ChangeHistory();
        this.history.add(initialBalance);
    }

    public String history() {
        return this.history.toString();
    }

    public void addToWarehouse(double amount) {
        super.addToWarehouse(amount);
        this.history.add(getBalance());
    }
    
    public double takeFromWarehouse(double amount) {
        double returnValue = super.takeFromWarehouse(amount);
        this.history.add(getBalance());
        return returnValue;
    }

    public void printAnalysis() {
        System.out.println(
            "Product: " + getName() + "\n" +
            "History: " + history() + "\n" +
            "Largest amount of product: " + this.history.maxValue() + "\n" +
            "Smallest amount of product: " + this.history.minValue() + "\n" +
            "Average: " + this.history.average()
        );
    }
}
