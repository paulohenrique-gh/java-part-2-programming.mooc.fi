import java.util.ArrayList;

public class TodoList {
    
    private ArrayList<String> tasks;

    //constructor
    public TodoList() {
        this.tasks = new ArrayList<>();
    }

    //add new task to the list
    public void add(String task) {
        this.tasks.add(task);
    }

    //print all tasks currently on the list
    public void print() {
        for (String task : this.tasks) {
            int index = this.tasks.indexOf(task) + 1;
            System.out.println(index + ": " + task);
        }
    }

    //remove tasks according to number passed. from the user's perspective the number is the index + 1
    public void remove(int taskNumber) {
        this.tasks.remove(this.tasks.get(taskNumber - 1));
    }
}
