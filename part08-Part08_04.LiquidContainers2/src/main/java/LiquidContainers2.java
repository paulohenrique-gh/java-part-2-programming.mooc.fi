
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        Container containerOne = new Container();
        Container containerTwo = new Container();

        while (true) {
            System.out.print("> ");

            System.out.println("First: " + containerOne);
            System.out.println("Second: " + containerTwo);

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }

            String[] splitInput = input.split(" ");
            String command = splitInput[0];
            int amount = Integer.valueOf(splitInput[1]);

            if (command.equals("add")) containerOne.add(amount);

            if (command.equals("move")) {
                if (amount > containerOne.contains()) {
                    containerTwo.add(containerOne.contains());
                    containerOne.remove(containerOne.contains());
                } else {
                    containerTwo.add(amount);
                    containerOne.remove(amount);
                }
            }

            if (command.equals("remove")) containerTwo.remove(amount);

        }

    }

}
