public class OneItemBox extends Box {

    private Item item;
    private boolean hasItem;

    public OneItemBox() {
        this.hasItem = false;
    }

    @Override
    public void add(Item item) {
        if (!this.hasItem) this.item = item;
        this.hasItem = true; 
    }

    @Override
    public boolean isInBox(Item item) {
        if (this.item == null) {
            return false;
        }
        return this.item.equals(item);
    }
}
