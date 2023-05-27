import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Warehouse {
    
    private Map<String, Integer> products;
    private Map<String, Integer> stockBalance;

    public Warehouse() {
        this.products = new HashMap<>();
        this.stockBalance = new HashMap<>();
    }

    public void addProduct(String product, int price, int stock) {
        this.products.put(product, price);
        this.stockBalance.put(product, stock);
    }

    public int price(String product) {
            return this.products.getOrDefault(product, -99);
    }

    public int stock(String product) {
            return this.stockBalance.getOrDefault(product, 0);
    }

    public boolean take(String product) {
        if (this.stockBalance.containsKey(product) &&
            this.stockBalance.get(product) > 0) {
            this.stockBalance.put(product, this.stockBalance.get(product) - 1);
            if (this.stockBalance.get(product) < 0) {
                this.stockBalance.put(product, 0);
            }
            return true;
        }
        
        return false;
    }

    public Set<String> products() {
        Set<String> productKeys = this.products.keySet();
        return productKeys;
    }
}
