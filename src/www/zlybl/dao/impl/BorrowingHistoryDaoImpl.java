package www.zlybl.dao.impl;

import www.zlybl.dao.BaseDao;
import www.zlybl.dao.BorrowingHistoryDao;
import www.zlybl.model.BorrowingHistory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BorrowingHistoryDaoImpl extends BaseDao implements BorrowingHistoryDao {
    @Override
    public List<BorrowingHistory> HISTORY_LIST() {
        List<BorrowingHistory> historyList=new ArrayList<>();
        String sql = "SELECT * FROM borrowing_history ORDER BY history_id DESC ";
        try {
            //创建语句对象
            stmt=conn.createStatement();
            //执行sql
            rs = stmt.executeQuery(sql);
            //处理结果
            while (rs.next()) {
                BorrowingHistory history=new BorrowingHistory();
                history.setHistoryId(rs.getInt("history_id"));
                history.setBookId(rs.getInt("book_id"));
                history.setUserId(rs.getInt("user_id"));
                history.setBorrowedTime(rs.getDate("borrowed_time"));
                history.setReturnedTime(rs.getDate("returned_time"));
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
        String sql = "SELECT * FROM borrowing_history where user_id=? ORDER BY history_id DESC ";
        try {
            //创建语句对象
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,userId);
            //执行sql
            rs = pstmt.executeQuery();
            while (rs.next()) {
                BorrowingHistory history=new BorrowingHistory();
                history.setHistoryId(rs.getInt("history_id"));
                history.setBookId(rs.getInt("book_id"));
                history.setUserId(rs.getInt("user_id"));
                history.setBorrowedTime(rs.getDate("borrowed_time"));
                history.setReturnedTime(rs.getDate("returned_time"));
                histories.add(history);
            }
        }catch (Exception e){
            System.out.println("查找失败");
            e.printStackTrace();
        }
        return histories;
     }

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
