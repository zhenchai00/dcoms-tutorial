import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface BookStore extends Remote {
    List<String> getBooks() throws RemoteException;
    String getBookDetails(String title) throws RemoteException;
    boolean addBook(String title, String author, Double price) throws RemoteException;
}
