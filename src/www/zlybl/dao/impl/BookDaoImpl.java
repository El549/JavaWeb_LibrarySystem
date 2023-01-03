package www.zlybl.dao.impl;

import www.zlybl.dao.BaseDao;
import www.zlybl.dao.BookDao;
import www.zlybl.model.Book;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public List<Book> findAllBooksByPage(int start, int num) {
        List<Book> bookList = new ArrayList<>();
        String sql = "SELECT * FROM book ORDER BY book_id LIMIT ?,?";
        //创建语句对象
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, start);
            pstmt.setInt(2, num);
            //执行sql
            rs = pstmt.executeQuery();
            //处理结果
            while (rs.next()){
                Book book = new Book();
                book.setBookId(rs.getInt("book_id"));
                book.setBookCover(rs.getString("book_cover"));
                book.setBookName(rs.getString("book_name"));
                book.setAuthor(rs.getString("author"));
                book.setPress(rs.getString("press"));
                book.setBookClass(rs.getString("book_class"));
                book.setBookStatus(rs.getBoolean("book_status"));
                bookList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    @Override
    public List<Book> findBooksByConditions(Book targetBook) {
        List<Book> bookList = new ArrayList<>();
        String sql = "SELECT * FROM book WHERE (book_name like CONCAT('%',?,'%') OR ?='')" +
                                        "AND (author like CONCAT('%',?,'%') OR ?='')" +
                                        "AND (press like CONCAT('%',?,'%') OR ?='')" +
                                        "AND (book_class like CONCAT('%',?,'%') OR ?='')" +
                                        "AND (book_status like CONCAT('%',?,'%') OR ?='')" +
                                        "ORDER BY book_id";
        System.out.println(sql);
        //创建语句对象
        try {
            pstmt = conn.prepareStatement(sql);
            System.out.println(targetBook);
            pstmt.setString(1, targetBook.getBookName());
            pstmt.setString(2, targetBook.getBookName());

            pstmt.setString(3, targetBook.getAuthor());
            pstmt.setString(4, targetBook.getAuthor());

            pstmt.setString(5, targetBook.getPress());
            pstmt.setString(6, targetBook.getPress());

            pstmt.setString(7, targetBook.getBookClass());
            pstmt.setString(8, targetBook.getBookClass());

            pstmt.setBoolean(9, targetBook.isBookStatus());
            pstmt.setBoolean(10, targetBook.isBookStatus());

            //执行sql
            rs = pstmt.executeQuery();

            //处理结果
            while (rs.next()){
                Book book = new Book();
                book.setBookId(rs.getInt("book_id"));
                book.setBookCover(rs.getString("book_cover"));
                book.setBookName(rs.getString("book_name"));
                book.setAuthor(rs.getString("author"));
                book.setPress(rs.getString("press"));
                book.setBookClass(rs.getString("book_class"));
                book.setBookStatus(rs.getBoolean("book_status"));
                bookList.add(book);
                System.out.println(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    @Override
    public int modBookStatus(int bookId, boolean bookStatus) {
        int rows = 0;
        String sql = "UPDATE book SET book_Status=? WHERE book_id=?";
        try {
            //创建语句对象
            pstmt = conn.prepareStatement(sql);
            pstmt.setBoolean(1, bookStatus);
            pstmt.setInt(2, bookId);
            //执行sql
            rows = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public List<Book> findBooksByUserId(int userId) {
        List<Book> bookList = new ArrayList<>();
        String sql = "SELECT * FROM book WHERE book_id IN (SELECT book_id FROM borrowing_history WHERE (user_id = ? AND returned_time is null)) ORDER BY book_id";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            //执行sql
            rs = pstmt.executeQuery();
            //处理结果
            while (rs.next()){
                Book book = new Book();
                book.setBookId(rs.getInt("book_id"));
                book.setBookCover(rs.getString("book_cover"));
                book.setBookName(rs.getString("book_name"));
                book.setAuthor(rs.getString("author"));
                book.setPress(rs.getString("press"));
                book.setBookClass(rs.getString("book_class"));
                book.setBookStatus(rs.getBoolean("book_status"));
                bookList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    @Override
    public int count() {
        int count = 0;
        String sql = "SELECT COUNT(*) FROM book";
        try {
            //创建语句对象
            stmt = conn.createStatement();
            //执行sql
            rs = stmt.executeQuery(sql);
            //处理结果
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
}
