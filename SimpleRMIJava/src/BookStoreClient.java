import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class BookStoreClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            BookStore bookStore = (BookStore) registry.lookup("bookStore");

            System.out.println("Books available in the bookstore: " + bookStore.getBooks());
            System.out.println("Adding a new book to the bookstore: " + bookStore.addBook("Java", "James Gosling", 45.0));
            System.out.println("Books available in the bookstore: " + bookStore.getBooks());
            System.out.println(bookStore.getBookDetails("Java"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
