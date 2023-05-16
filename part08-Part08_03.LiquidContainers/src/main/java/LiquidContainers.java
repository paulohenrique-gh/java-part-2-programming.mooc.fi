
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int firstContainer = 0;
        int secondContainer = 0;

        while (true) {
            System.out.print("> ");

            System.out.println("First: " + firstContainer + "/100");
            System.out.println("Second: " + secondContainer + "/100");

            String input = scan.nextLine();

            if (input.equals("quit")) break;

            String[] splitString = input.split(" ");
            String command = splitString[0];
            int amount = Integer.valueOf(splitString[1]);

            if (amount < 0) continue;

            //adding
            if (command.equals("add")) {
                firstContainer += amount;
                if (firstContainer > 100) firstContainer = 100;
                continue;
            }

            //moving
            if (command.equals("move")) {
                if (firstContainer == 0) {
                    continue;
                }

                if (firstContainer < amount) {
                    secondContainer = amount - (amount - firstContainer);
                    firstContainer = 0;
                } else {
                    secondContainer += amount;
                    firstContainer -= amount;
                }

                if (firstContainer < 0) firstContainer = 0;
                if (secondContainer > 100) secondContainer = 100;
                continue;
            }

            //removing
            if (command .equals("remove")) {
                secondContainer -= amount;

                if (secondContainer < 0) secondContainer = 0; 
            }


        }
    }

}
