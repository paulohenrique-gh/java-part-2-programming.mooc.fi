
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Book> books = new ArrayList<>();

        while (true) {
            System.out.print("Input the name of the book, empty stops: ");
            String name = scanner.nextLine();

            if (name.isEmpty()) {
                break;
            }

            System.out.print("Input the age recommendation: ");
            int ageRecommendation = Integer.valueOf(scanner.nextLine());

            System.out.println();
            Book book = new Book(name, ageRecommendation);
            books.add(book);
           
        }

        System.out.println("\n" + books.stream().count() + " books in total.\n");

        Comparator<Book> comparator = Comparator
            .comparing(Book::getAgeRecommendation)
            .thenComparing(Book::getName);

        Collections.sort(books, comparator);

        for (Book b : books) {
            System.out.println(b);
        }
    }
}
