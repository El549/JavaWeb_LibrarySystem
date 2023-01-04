package www.zlybl.dao;

import www.zlybl.model.Book;

import java.util.List;

public interface BookDao {
    //  全查书籍
    List<Book> BookListM(int start,int num);

    //书籍条件查询
    List<Book>  BookListByConditionsM(Book book);
//    根据id查找书籍
    Book findBookById(int id);
//    添加图书
    int AddBook(Book book);

//    修改图书
    int ModBook(Book book);

//  删除图书
    int DelBook(int bookId);
//    书数量
    int count();

}
