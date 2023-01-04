package www.zlybl.dao;

import www.zlybl.model.BorrowingHistory;

public interface BorrowingHistoryDao {
    //增加借阅历史记录
    int addBorrowingHistory(BorrowingHistory borrowingHistory);

    //增加还书日期
    int modReturnedTime(int book_id);
}
