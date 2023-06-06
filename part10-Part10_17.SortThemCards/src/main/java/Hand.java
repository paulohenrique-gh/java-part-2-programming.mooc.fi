import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Hand implements Comparable<Hand>{
    
    private ArrayList<Card> hand;

    public Hand() {
        this.hand = new ArrayList<>();
    }

    public void add(Card card) {
        this.hand.add(card);
    }

    public void print() {
        this.hand.stream()
            .forEach(c -> System.out.println(c));
    }

    public void sort() {
        Comparator<Card> comparator = Comparator
                        .comparing(Card::getValue)
                        .thenComparing(Card::getSuit);
                       
        Collections.sort(hand, comparator);
                    
    }

    public void sortBySuit() {
        BySuitInValueOrder bySuitInValueOrder = new BySuitInValueOrder();
        Collections.sort(this.hand, bySuitInValueOrder);
    }

    public ArrayList<Card> getHand() {
        return this.hand;
    }

    @Override
    public int compareTo(Hand o) {
        int currentHandValue = this.hand.stream()
                .map(hand -> hand.getValue())
                .reduce(0, (subtotal, value) -> subtotal + value);

        int comparedHandValue = o.getHand().stream()
                .map(hand -> hand.getValue())
                .reduce(0, (subtotal, value) -> subtotal + value);

        return currentHandValue - comparedHandValue;
    }

}
