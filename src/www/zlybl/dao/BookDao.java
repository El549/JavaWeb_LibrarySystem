package www.zlybl.dao;

import www.zlybl.model.Book;

import java.util.List;

public interface BookDao {
    //全查书籍
    List<Book> BookListM(int start,int num);

    //书籍条件查询
    List<Book>  BookListByConditionsM(Book book);
    
    //根据id查找书籍
    Book findBookById(int id);
    
    //添加图书
    int AddBook(Book book);

    //修改图书
    int ModBook(Book book);

    //删除图书
    int DelBook(int bookId);
   
    //书数量
    int count();

    //用户书籍全查
    List<Book> findAllBooksByPage(int start, int num);

    //用户图书按条件查询
    List<Book> findBooksByConditions(Book targetBook);

    //修改图书借阅状态
    int modBookStatus(int bookId,boolean bookStatus);

    //查询用户未还图书
    List<Book> findBooksByUserId(int userId);

}
