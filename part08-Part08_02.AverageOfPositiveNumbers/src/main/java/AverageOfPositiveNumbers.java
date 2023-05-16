
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int positiveNumbersTotal = 0;
        int positiveNumbersCount = 0;

        while (true) {
            int input = Integer.valueOf(scanner.nextLine());

            if (input == 0) {
                break;
            }

            if (input > 0) {
                positiveNumbersTotal += input;
                positiveNumbersCount++;
            }
        }

        double average = 0.0;

        if (positiveNumbersCount != 0) {
            average = (double) positiveNumbersTotal / positiveNumbersCount;
        }

        if (average == 0.0) {
            System.out.println("Cannot calculate the average");
        } else {
            System.out.println(average);
        }

    }
}
