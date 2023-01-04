package www.zlybl.service;

import www.zlybl.model.Book;

import java.util.List;

public interface BookService {
//    全查图书
    List<Book> QueryBookList(int page,int pageSize);

    //书籍多条件查询
    List<Book>  BookListByConditions(Book book);

//    根据id查找书籍
    Book findBookById(int id);
    //    添加图书
    boolean AddBook(Book book);

    //    修改图书
    boolean ModBook(Book book);

    //  删除图书
    boolean DelBook(int BookId);
//    书数量
    int count();
}
