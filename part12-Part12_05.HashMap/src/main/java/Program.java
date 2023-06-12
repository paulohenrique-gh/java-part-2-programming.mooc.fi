

public class Program {

    public static void main(String[] args) {
  
        HashMap<String, Integer> map = new HashMap<>();

        map.add("one", 1);
        map.add("two", 2);
        map.add("three", 3);
        map.add("four", 4);

        System.out.println(map);

        map.get("two");

        System.out.println(map.remove("four"));



        

    }

}
