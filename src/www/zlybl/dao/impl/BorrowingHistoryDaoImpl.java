package www.zlybl.dao.impl;

import www.zlybl.dao.BaseDao;
import www.zlybl.dao.BorrowingHistoryDao;
import www.zlybl.model.BorrowingHistory;

import java.util.Date;
import java.sql.SQLException;

public class BorrowingHistoryDaoImpl extends BaseDao implements BorrowingHistoryDao {
    @Override
    public int addBorrowingHistory(BorrowingHistory borrowingHistory) {
        int rows = 0;
        String sql = "INSERT INTO borrowing_history(book_id, user_id, borrowed_time, returned_time) VALUES(?, ?, ? ,null)";
        try {
            //创建语句对象
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,borrowingHistory.getBookId());
            pstmt.setInt(2, borrowingHistory.getUserId());
            pstmt.setDate(3, new java.sql.Date(borrowingHistory.getBorrowedTime().getTime()));
            //执行sql
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int modReturnedTime(int book_id) {
        int rows = 0;
        String sql = "UPDATE borrowing_history SET returned_time=? WHERE (book_id=? AND returned_time is null)";
        try {
            //创建语句对象
            pstmt = conn.prepareStatement(sql);
            Date nowDate = new Date();
            pstmt.setDate(1, new java.sql.Date(nowDate.getTime()));
            pstmt.setInt(2, book_id);
            //执行sql
            rows = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }
}
