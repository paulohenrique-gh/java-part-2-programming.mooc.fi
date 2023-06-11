import java.util.ArrayList;
import java.util.List;

public class Pipe<T> {
    
    private List<T> thingsInPipe;

    public Pipe() {
        this.thingsInPipe = new ArrayList<>();
    }

    public void putIntoPipe(T value) {
        this.thingsInPipe.add(value);
    }

    public T takeFromPipe() {
        if (this.thingsInPipe.isEmpty()) return null;
        return this.thingsInPipe.remove(0);
    }

    public boolean isInPipe() {
        return !this.thingsInPipe.isEmpty();
    }

}
