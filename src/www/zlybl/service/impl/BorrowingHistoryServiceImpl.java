package www.zlybl.service.impl;

import www.zlybl.dao.BorrowingHistoryDao;
import www.zlybl.dao.impl.BorrowingHistoryDaoImpl;
import www.zlybl.model.BorrowingHistory;
import www.zlybl.service.BorrowingHistoryService;

import java.util.Date;

import java.util.List;

public class BorrowingHistoryServiceImpl implements BorrowingHistoryService {
    BorrowingHistoryDao borrowingHistoryDao =new BorrowingHistoryDaoImpl();
    @Override
    public List<BorrowingHistory> HistoryList() {
        return borrowingHistoryDao.HISTORY_LIST();
    }

    @Override
    public List<BorrowingHistory> HistoryListByUserId(int userId) {
        return borrowingHistoryDao.HistoryListByUserId(userId);

    @Override
    public int addBorrowingHistory(int bookId,int userId) {
        BorrowingHistory borrowingHistory = new BorrowingHistory();
        borrowingHistory.setBookId(bookId);
        borrowingHistory.setUserId(userId);
        Date nowDate = new Date();
        borrowingHistory.setBorrowedTime(nowDate);
        return borrowingHistoryDao.addBorrowingHistory(borrowingHistory);
    }

    @Override
    public int modReturnedTime(int book_id) {
        return borrowingHistoryDao.modReturnedTime(book_id);
    }
}
