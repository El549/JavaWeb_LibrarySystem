package www.zlybl.service;

import www.zlybl.model.Book;

import java.util.List;

public interface BookService {
    //全查图书
    List<Book> QueryBookList(int page,int pageSize);

    //书籍多条件查询
    List<Book>  BookListByConditions(Book book);

    //根据id查找书籍
    Book findBookById(int id);
    
    //添加图书
    boolean AddBook(Book book);

    //修改图书
    boolean ModBook(Book book);

    //删除图书
    boolean DelBook(int BookId);

    //用户书籍全查
    List<Book> findAllBooksByPage(int page, int pageSize);

    //用户书籍按条件查询
    List<Book> findBooksByConditions(Book targetBook);

    //修改图书借阅状态
    int modBookStatus(int bookId,boolean bookStatus);

    //查询用户未还图书
    List<Book> findBooksByUserId(int userId);

    //书数量
    int count();
}
