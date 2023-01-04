package www.zlybl.dao.impl;

import www.zlybl.dao.BaseDao;
import www.zlybl.dao.BookDao;
import www.zlybl.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {
    //全查图书
    @Override
    public List<Book> BookListM(int start,int num) {
        List<Book> bookList=new ArrayList<>();
        String sql = "SELECT * FROM book ORDER BY book_id LIMIT ?,?";
        try {
            //创建语句对象
            pstmt=coon.prepareStatement(sql);
            pstmt.setInt(1,start);
            pstmt.setInt(2,num);
            //执行sql
            rs = pstmt.executeQuery();
            //处理结果
            while (rs.next()) {
                Book book=new Book();
                book.setBookId(rs.getInt("book_id"));
                book.setBookCover(rs.getString("book_cover"));
                book.setBookName(rs.getString("book_name"));
                book.setAuthor(rs.getString("author"));
                book.setPress(rs.getString("press"));
                book.setBookClass(rs.getString("book_class"));
                book.setBookStatus(rs.getBoolean("book_status"));
                bookList.add(book);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return bookList;
    }

//    书籍条件查询 todo
    @Override
    public List<Book> BookListByConditionsM(Book book) {
        List<Book> bookList=new ArrayList<>();
        String sql = "SELECT * FROM book WHERE (book_name LIKE CONCAT('%',?,'%') OR book_name='')" +
                "AND (author LIKE CONCAT('%',?,'%') OR author='')"+
                "AND (press LIKE CONCAT('%',?,'%') OR press='')"+
                "AND (book_class LIKE CONCAT('%',?,'%') OR book_class='')";
        try {
            //创建语句对象
            pstmt=coon.prepareStatement(sql);
            pstmt.setString(1,book.getBookName());
            pstmt.setString(2,book.getAuthor());
            pstmt.setString(3,book.getPress());
            pstmt.setString(4,book.getBookClass());
            //执行sql
            rs = pstmt.executeQuery();
            //处理结果
            while (rs.next()) {
                Book books=new Book();
                books.setBookId(rs.getInt("book_id"));
                books.setBookCover(rs.getString("book_cover"));
                books.setBookName(rs.getString("book_name"));
                books.setAuthor(rs.getString("author"));
                books.setPress(rs.getString("press"));
                books.setBookClass(rs.getString("book_class"));
                books.setBookStatus(rs.getBoolean("book_status"));
                bookList.add(books);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return bookList;
    }
//    通过id查找书籍
    @Override
    public Book findBookById(int id) {
        Book book=null;
        String sql = "SELECT * FROM book where book_id=?";
        try {
            //创建语句对象
            pstmt=coon.prepareStatement(sql);
            pstmt.setInt(1,id);
            //执行sql
            rs = pstmt.executeQuery();
            while (rs.next()) {
                book=new Book();
                book.setBookId(rs.getInt("book_id"));
                book.setBookCover(rs.getString("book_cover"));
                book.setBookName(rs.getString("book_name"));
                book.setAuthor(rs.getString("author"));
                book.setPress(rs.getString("press"));
                book.setBookClass(rs.getString("book_class"));
                book.setBookStatus(rs.getBoolean("book_status"));
            }
        }catch (Exception e){
            System.out.println("查找失败");
            e.printStackTrace();
        }
        return book;
    }

    //    添加图书
    @Override
    public int AddBook(Book book) {
        int rows=0;
        String sql = "insert into book(book_cover,book_name,author,press,book_class,book_status)" +
                "values(?,?,?,?,?,?)";
        try {
            //创建语句对象
            pstmt=coon.prepareStatement(sql);
            pstmt.setString(1,book.getBookCover());
            pstmt.setString(2,book.getBookName());
            pstmt.setString(3,book.getAuthor());
            pstmt.setString(4,book.getPress());
            pstmt.setString(5,book.getBookClass());
            pstmt.setInt(6,1);
            //执行sql
            rows = pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rows;
    }
//    修改书籍信息
    @Override
    public int ModBook(Book book) {
        int rows=0;
        String sql = "UPDATE book SET book_cover=?,book_name=?,author=?,press=?,book_class=?,book_status=?" +
                " WHERE book_id=?";
        try {
            //创建语句对象
            pstmt=coon.prepareStatement(sql);
            pstmt.setString(1,book.getBookCover());
            pstmt.setString(2,book.getBookName());
            pstmt.setString(3,book.getAuthor());
            pstmt.setString(4,book.getPress());
            pstmt.setString(5,book.getBookClass());
            pstmt.setBoolean(6,book.isBookStatus());
            pstmt.setInt(7,book.getBookId());
            //执行sql
            rows = pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rows;
    }
//    删除书籍
    @Override
    public int DelBook(int bookId) {
        int rows=0;
        String sql = "DELETE FROM book WHERE book_id=?";
        try {
            //创建语句对象
            pstmt=coon.prepareStatement(sql);
            pstmt.setInt(1,bookId);
            //执行sql
            rows = pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int count() {
        int count=0;
        String sql="SELECT COUNT(*) FROM book";
        try {
            //创建语句对象
            stmt=coon.createStatement();
            //执行sql
            rs = stmt.executeQuery(sql);
            //          处理结果
            while (rs.next()) {
                count=rs.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }
}
