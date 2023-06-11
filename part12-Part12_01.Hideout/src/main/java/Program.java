
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // you may try out your class here
        Hideout<Integer> den = new Hideout<>();
        System.out.println(den.isInHideout()); //false
        den.putIntoHideout(1);
        System.out.println(den.isInHideout()); //true
        System.out.println(den.isInHideout()); //true
        System.out.println(den.takeFromHideout()); //1
        System.out.println(den.isInHideout()); //false

    }
}
