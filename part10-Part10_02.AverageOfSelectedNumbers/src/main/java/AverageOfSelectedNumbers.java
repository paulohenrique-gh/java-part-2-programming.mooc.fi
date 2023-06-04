
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("Input numbers, type \"end\" to stop.");

        while(true) {
            String input = scanner.nextLine();

            if (input.equals("end")) {
                break;
            }

            int number = Integer.valueOf(input);

            numbers.add(number);            
        }

        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
        char nOrP = scanner.next().charAt(0);

        if (nOrP == 'n') {
            double negativeAverage = numbers.stream()
                .mapToInt(n -> Integer.valueOf(n))
                .filter(n -> n < 0)
                .average()
                .getAsDouble();

            System.out.println("Average of the negative numbers: " + negativeAverage);

        } else if (nOrP == 'p') {
            double positiveAverage = numbers.stream()
                .mapToInt(n -> Integer.valueOf(n))
                .filter(n -> n >= 0)
                .average()
                .getAsDouble();

            System.out.println("Average of the negative numbers: " + positiveAverage);
        }

    }
}
