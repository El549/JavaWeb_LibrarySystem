package www.zlybl.dao;

import www.zlybl.model.Book;

import java.util.List;

public interface BookDao {
    //用户书籍全查
    List<Book> findAllBooksByPage(int start, int num);

    //用户图书按条件查询
    List<Book> findBooksByConditions(Book targetBook);

    //修改图书借阅状态
    int modBookStatus(int bookId,boolean bookStatus);

    //查询用户未还图书
    List<Book> findBooksByUserId(int userId);

    int count();
}
