package daopractice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookDAO{
	
public BookDTO findById(int id) {

    BookDTO book = null;

    String sql =
            "SELECT * FROM books WHERE book_id=?";

    try(
        Connection con =
                DBUtil.getConnection();

        PreparedStatement ps =
                con.prepareStatement(sql)
    ){

        ps.setInt(1,id);

        ResultSet rs =
                ps.executeQuery();

        if(rs.next()){

            book = new BookDTO();

            book.setBookId(
                    rs.getInt("book_id"));

            book.setTitle(
                    rs.getString("title"));

            book.setPrice(
                    rs.getInt("price"));
        }

    }catch(Exception e){
        e.printStackTrace();
    }

    return book;
}
}