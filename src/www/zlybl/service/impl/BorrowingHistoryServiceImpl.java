package www.zlybl.service.impl;

import www.zlybl.dao.BorrowingHistoryDao;
import www.zlybl.dao.impl.BorrowingHistoryDaoImpl;
import www.zlybl.model.BorrowingHistory;
import www.zlybl.service.BorrowingHistoryService;

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
    }
}
