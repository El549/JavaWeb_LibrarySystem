package www.zlybl.service;

import www.zlybl.model.BorrowingHistory;

import java.util.List;

public interface BorrowingHistoryService {
    //全查借阅历史
    List<BorrowingHistory> HistoryList();
    
    //通过用户id查找历史
    List<BorrowingHistory> HistoryListByUserId(int userId);

    //增加借阅历史记录
    int addBorrowingHistory(int bookId,int userId);

    //增加还书日期
    int modReturnedTime(int book_id);

}
