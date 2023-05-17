import java.util.Scanner;

public class UserInterface {
    
    private TodoList taskList;
    private Scanner scanner;

    public UserInterface(TodoList taskList, Scanner scanner) {
        this.taskList = taskList;
        this.scanner = scanner;
    }

    public void start() {
        while (true) {
            System.out.print("Command: ");
            String command = this.scanner.nextLine();

            if (command.equals("stop")) break;

            if (command.equals("add")) {
                System.out.print("To add: ");
                String newTask = this.scanner.nextLine();
                this.taskList.add(newTask);
            }
            
            if (command.equals("list")) this.taskList.print();

            if (command.equals("remove")) {
                System.out.print("Which one is removed? ");
                int taskToRemove = Integer.valueOf(this.scanner.nextLine());
                this.taskList.remove(taskToRemove);                
            }
        }
    }
}
