
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LimitedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();

        while (true) {
            int input = Integer.valueOf(scanner.nextLine());

            if (input < 0) {
                break;
            }

            list.add(input);
        }

        list.stream()
            .filter(n -> n >= 1 && n <= 5)
            .forEach(System.out::println);

    }
}
