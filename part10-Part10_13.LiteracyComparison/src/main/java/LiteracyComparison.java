
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LiteracyComparison {
    
    public static void main(String[] args) {

        try {
            Files.lines(Paths.get("literacy.csv"))
                .map(line -> line.split(","))
                .sorted((p1, p2) -> p1[5].compareTo(p2[5]))
                .forEach(line -> System.out.println(line[3].trim() + " (" + line[4].trim() + "), " + line[2].replace("(%)", "").trim() + ", " + line[5].trim()));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
