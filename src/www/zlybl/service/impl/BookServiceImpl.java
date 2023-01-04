package www.zlybl.service.impl;

import www.zlybl.dao.BookDao;
import www.zlybl.dao.impl.BookDaoImpl;
import www.zlybl.model.Book;
import www.zlybl.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    BookDao bookDao = new BookDaoImpl();

    @Override
    public List<Book> findAllBooksByPage(int page, int pageSize) {
        return bookDao.findAllBooksByPage((page - 1) * pageSize, pageSize);
    }

    @Override
    public List<Book> findBooksByConditions(Book targetBook) {
        return bookDao.findBooksByConditions(targetBook);
    }

    @Override
    public int modBookStatus(int bookId, boolean bookStatus) {
        return bookDao.modBookStatus(bookId,bookStatus);
    }

    @Override
    public List<Book> findBooksByUserId(int userId) {
        return bookDao.findBooksByUserId(userId);
    }

    @Override
    public int count() {
        return bookDao.count();
    }
}
