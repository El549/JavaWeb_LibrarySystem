package www.zlybl.dao.impl;

import www.zlybl.dao.ApplyDao;
import www.zlybl.dao.BaseDao;
import www.zlybl.model.Apply;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApplyDaoImpl extends BaseDao implements ApplyDao {

    @Override
    public List<Apply> MyApply(int userId) {
        List<Apply> applies=new ArrayList<>();
        String sql = "SELECT * FROM apply WHERE user_id=? ORDER BY apply_id DESC ";
        try {
            //创建语句对象
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,userId);
            //执行sql
            rs = pstmt.executeQuery();
            //处理结果
            while (rs.next()) {
                Apply apply=new Apply();
                apply.setApplyId(rs.getInt("apply_id"));
                apply.setUserId(rs.getInt("user_id"));
                apply.setBookId(rs.getInt("book_id"));
                apply.setApplyType(rs.getBoolean("apply_type"));
                apply.setApplyStatus(rs.getInt("apply_status"));
                applies.add(apply);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return applies;
    }

    @Override
    public int addApply(Apply apply) {
        int rows = 0;
        String sql = "INSERT INTO apply(user_id, book_id, apply_type, apply_status) VALUES(?, ?, ? ,?)";
        try {
            //创建语句对象
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,apply.getUserId());
            pstmt.setInt(2, apply.getBookId());
            pstmt.setBoolean(3, apply.isApplyType());
            pstmt.setInt(4, apply.getApplyStatus());
            //执行sql
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public List<Apply> findApply(Boolean applyType) {
        List<Apply> applyList = new ArrayList<>();
        String sql = "SELECT * FROM apply WHERE apply_type = ? ORDER BY apply_id DESC";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setBoolean(1, applyType);
            //执行sql
            rs = pstmt.executeQuery();
            //处理结果
            while (rs.next()){
                Apply apply = new Apply();
                apply.setApplyId(rs.getInt("apply_id"));
                apply.setUserId(rs.getInt("user_id"));
                apply.setBookId(rs.getInt("book_id"));
                apply.setApplyType(rs.getBoolean("apply_type"));
                apply.setApplyStatus(rs.getInt("apply_status"));
                applyList.add(apply);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return applyList;
    }

    @Override
    public int modApplyStatus(int applyId, int applyStatus) {
        int rows = 0;
        String sql = "UPDATE apply SET apply_status=? WHERE apply_id=?";
        try {
            //创建语句对象
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, applyStatus);
            pstmt.setInt(2, applyId);
            //执行sql
            rows = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

}
