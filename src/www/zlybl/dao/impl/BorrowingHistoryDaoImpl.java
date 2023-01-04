package www.zlybl.dao.impl;

import www.zlybl.dao.BaseDao;
import www.zlybl.dao.BorrowingHistoryDao;
import www.zlybl.model.BorrowingHistory;

import java.util.ArrayList;
import java.util.List;

public class BorrowingHistoryDaoImpl extends BaseDao implements BorrowingHistoryDao {
    @Override
    public List<BorrowingHistory> HISTORY_LIST() {
        List<BorrowingHistory> historyList=new ArrayList<>();
        String sql = "SELECT * FROM borrowing_history";
        try {
            //创建语句对象
            stmt=coon.createStatement();
            //执行sql
            rs = stmt.executeQuery(sql);
            //处理结果
            while (rs.next()) {
                BorrowingHistory history=new BorrowingHistory();
                history.setHistoryId(rs.getInt("history_id"));
                history.setBookId(rs.getInt("book_id"));
                history.setUserId(rs.getInt("user_id"));
                history.setBorrowingTime(rs.getString("borrowed_time"));
                history.setReturnedTime(rs.getString("returned_time"));
                historyList.add(history);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return historyList;
    }

    @Override
    public List<BorrowingHistory> HistoryListByUserId(int userId) {
        List<BorrowingHistory> histories=new ArrayList<>();
        String sql = "SELECT * FROM borrowing_history where user_id=?";
        try {
            //创建语句对象
            pstmt=coon.prepareStatement(sql);
            pstmt.setInt(1,userId);
            //执行sql
            rs = pstmt.executeQuery();
            while (rs.next()) {
                BorrowingHistory history=new BorrowingHistory();
                history.setHistoryId(rs.getInt("history_id"));
                history.setBookId(rs.getInt("book_id"));
                history.setUserId(rs.getInt("user_id"));
                history.setBorrowingTime(rs.getString("borrowed_time"));
                history.setReturnedTime(rs.getString("returned_time"));
                histories.add(history);
            }
        }catch (Exception e){
            System.out.println("查找失败");
            e.printStackTrace();
        }
        return histories;
    }
}
