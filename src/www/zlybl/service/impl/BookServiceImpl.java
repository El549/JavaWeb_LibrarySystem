package www.zlybl.service.impl;

import www.zlybl.dao.BookDao;
import www.zlybl.dao.impl.BookDaoImpl;
import www.zlybl.model.Book;
import www.zlybl.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    BookDao bookDao =new BookDaoImpl();

    //    全查图书
    @Override
    public List<Book> QueryBookList(int page,int pageSize) {
        return bookDao.BookListM((page-1)*pageSize,pageSize);
    }

    @Override
    public List<Book> BookListByConditions(Book book) {
        return bookDao.BookListByConditionsM(book);
    }

    @Override
    public Book findBookById(int id) {
        return bookDao.findBookById(id);
    }

    @Override
    public boolean AddBook(Book book) {
        return bookDao.AddBook(book)==1?true:false;
    }

    @Override
    public boolean ModBook(Book book) {
        return bookDao.ModBook(book)==1?true:false;
    }

    @Override
    public boolean DelBook(int BookId) {
        return bookDao.DelBook(BookId)==1?true:false;
    }

    @Override
    public int count() {
        return bookDao.count();
    }
}
