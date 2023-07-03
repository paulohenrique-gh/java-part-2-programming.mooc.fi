package application;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private TodoDao database;

    public UserInterface(Scanner scanner, TodoDao database) {
        this.scanner = scanner;
        this.database = database;
    }

    public void start() throws SQLException {
        while (true) {
            System.out.println("");
            System.out.println("Enter command:");
            System.out.println("1) list");
            System.out.println("2) add");
            System.out.println("3) mark as done");
            System.out.println("4) remove");
            System.out.println("x) quit");

            System.out.print("> ");
            String command = this.scanner.nextLine();
            if (command.equals("x")) {
                break;
            }

            // implement the functionality here
            if (command.equals("1")) {
                try {
                    this.list();
                } catch (Exception e) {
                    e.getMessage();
                }
            }

            if (command.equals("2")) {
                try {
                    this.add();
                } catch (Exception e) {
                    e.getMessage();
                }
            }

            if (command.equals("3")) {
                try {
                    this.markAsDone();
                } catch (Exception e) {
                    e.getMessage();
                }
            }

            if (command.equals("4")) {
                try {
                    this.remove();
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        }

        System.out.println("Thank you!");
    }

    public void list() throws Exception {
        System.out.println("Listing the database contents");

        List<Todo> list = this.database.list();

        for (Todo todo : list) {
            System.out.println(todo);
        }
    }

    public void add() throws Exception {
        System.out.println("Adding a new todo");
        System.out.println("Enter name");
        String name = this.scanner.nextLine();
        System.out.println("Enter description");
        String description = scanner.nextLine();
        boolean isCompleted = false;

        Todo todo = new Todo(name, description, isCompleted);
        this.database.add(todo);
    }

    public void markAsDone() throws Exception {
        System.out.println();
        System.out.println("Which todo should be marked as done (give the id)?");
        int completedTask = Integer.valueOf(this.scanner.nextLine());

        this.database.markAsDone(completedTask);
    }

    public void remove() throws Exception {
        System.out.println();
        System.out.println("Which todo should be removed (give the id)?");
        int taskToRemove = Integer.valueOf(this.scanner.nextLine());

        this.database.remove(taskToRemove);
    }
}
