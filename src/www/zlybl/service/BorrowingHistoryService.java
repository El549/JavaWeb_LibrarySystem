package www.zlybl.service;

import www.zlybl.model.BorrowingHistory;

public interface BorrowingHistoryService {
    //增加借阅历史记录
    int addBorrowingHistory(int bookId,int userId);

    //增加还书日期
    int modReturnedTime(int book_id);
}
