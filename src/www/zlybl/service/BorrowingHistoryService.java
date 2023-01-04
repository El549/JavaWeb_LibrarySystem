package www.zlybl.service;

import www.zlybl.model.BorrowingHistory;

import java.util.List;

public interface BorrowingHistoryService {
    //    全查借阅历史
    List<BorrowingHistory> HistoryList();
//    通过用户id查找历史
    List<BorrowingHistory> HistoryListByUserId(int userId);


}
