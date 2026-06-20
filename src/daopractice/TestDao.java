package daopractice;

public class TestDao {

	
public static void main(String[] args) {

    BookDAO dao = new BookDAO();

    BookDTO book =
            dao.findById(1);

    System.out.println(
            book.getTitle());

    System.out.println(
            book.getPrice());
}
}