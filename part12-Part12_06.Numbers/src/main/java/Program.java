
import java.util.Random;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many random numbers should be printed?");
        int thisManyTimes = scanner.nextInt();

        Random rng = new Random();

        for (int i = 0; i < thisManyTimes; i++) {
            System.out.println(rng.nextInt(11));
        }
    }

}
