import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class BookStoreServer {
    public static void main(String[] args) {
        try {
            BookStoreImpl bookStore = new BookStoreImpl();

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("bookStore", bookStore);
            System.out.println("BookStore Server is running ...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
