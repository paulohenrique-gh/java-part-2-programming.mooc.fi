public class Hideout<T> {
    
    private T thingToHide;

    public Hideout() {

    }

    public void putIntoHideout(T toHide) {
        this.thingToHide = toHide;
    }

    public T takeFromHideout() {
        T thing = this.thingToHide;
        this.thingToHide = null;
        return thing;
    }

    public boolean isInHideout() {
        if (this.thingToHide != null) {
            return true;
        }

        return false;
    }

}
