import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<String, Item> purchase;

    public ShoppingCart() {
        this.purchase = new HashMap<>();
    }

    public void add(String product, int price) {
        if (this.purchase.containsKey(product)) {
            this.purchase.get(product).increaseQuantity();
        } else {
            this.purchase.put(product, new Item(product, 1, price));
        }
    }

    public int price() {
        int totalPrice = 0;
        for (Item item : this.purchase.values()) {
            totalPrice += item.price();
        }

        return totalPrice;
    }

    public void print() {
        for (Item item: this.purchase.values()) {
            System.out.println(item);
        }
    }
}
