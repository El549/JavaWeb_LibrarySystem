package www.zlybl.dao;

import www.zlybl.model.BorrowingHistory;

import java.util.List;

public interface BorrowingHistoryDao {

    //借阅历史
    List<BorrowingHistory> HISTORY_LIST();
    
    //通过用户id查找借阅历史
    List<BorrowingHistory> HistoryListByUserId(int userId);

    //增加借阅历史记录
    int addBorrowingHistory(BorrowingHistory borrowingHistory);

    //增加还书日期
    int modReturnedTime(int book_id);

}
