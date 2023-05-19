
public class Main {

    public static void main(String[] args) {
        // make test programs here
        SimpleDate newDate = new SimpleDate(19,11,1984);
        SimpleDate otherDate = new SimpleDate(24,11,1984);

        System.out.println(newDate.hashCode());
        System.out.println(otherDate.hashCode());

    }
}
