public class Book implements Packable {
    
    public String author;
    public String bookName;
    public double bookWeight;

    public Book(String author, String bookName, double bookWeight) {
        this.author = author;
        this.bookName = bookName;
        this.bookWeight = bookWeight;
    }

    @Override
    public String toString() {
        return this.author + ": " + this.bookName; 
    }

    @Override
    public double weight() {
        return this.bookWeight;
    }

}
