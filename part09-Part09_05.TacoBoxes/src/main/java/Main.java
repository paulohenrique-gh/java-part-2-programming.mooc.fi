
public class Main {

    public static void main(String[] args) {
        // Test your code here!
        TripleTacoBox tripleTacoBox = new TripleTacoBox();

        System.out.println(tripleTacoBox.tacosRemaining()); //3
        tripleTacoBox.eat();
        System.out.println(tripleTacoBox.tacosRemaining()); //2
        tripleTacoBox.eat();
        tripleTacoBox.eat();
        System.out.println(tripleTacoBox.tacosRemaining()); //0
        tripleTacoBox.eat();
        System.out.println(tripleTacoBox.tacosRemaining()); //0

        System.out.println();

        CustomTacoBox customTacoBox = new CustomTacoBox(8);

        System.out.println(customTacoBox.tacosRemaining()); //8
        customTacoBox.eat();
        customTacoBox.eat();
        customTacoBox.eat();
        customTacoBox.eat();
        customTacoBox.eat();
        System.out.println(customTacoBox.tacosRemaining()); //3
        customTacoBox.eat();
        customTacoBox.eat();
        customTacoBox.eat();
        customTacoBox.eat();
        System.out.println(customTacoBox.tacosRemaining()); //0

    }
}
