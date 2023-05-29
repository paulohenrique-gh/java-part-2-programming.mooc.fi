import java.util.ArrayList;

public class Herd implements Movable{

    private ArrayList<Movable> herd;

    public Herd() {
        this.herd = new ArrayList<>();
    }
    
    public void addToHerd(Movable movable) {
        this.herd.add(movable);
    }
   
    @Override
    public void move(int dx, int dy) {
        for (Movable organism : this.herd) {
            organism.move(dx, dy);
        }
    }

    @Override
    public String toString() {
        String organismList = "";
        for (Movable organism : this.herd) {
            organismList += organism.toString() + "\n";
        }
        return organismList;
    }
    
}
