package validating;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        if (name == null || name.isEmpty() || name.length() > 40 ||
            age > 120 || age < 0) {
                throw new IllegalArgumentException(
                    "Please provide a name between 1 and 40 characters long, and an age between 0 and 120");
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
