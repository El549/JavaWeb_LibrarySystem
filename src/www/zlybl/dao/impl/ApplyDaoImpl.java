package www.zlybl.dao.impl;

import www.zlybl.dao.ApplyDao;
import www.zlybl.dao.BaseDao;
import www.zlybl.model.Apply;

import java.util.ArrayList;
import java.util.List;

public class ApplyDaoImpl extends BaseDao implements ApplyDao {

    @Override
    public List<Apply> MyApply(int userId) {
        List<Apply> applies=new ArrayList<>();
        String sql = "SELECT * FROM apply WHERE user_id=?";
        try {
            //创建语句对象
            pstmt=coon.prepareStatement(sql);
            pstmt.setInt(1,userId);
            //执行sql
            rs = pstmt.executeQuery();
            //处理结果
            while (rs.next()) {
                Apply apply=new Apply();
                apply.setApplyId(rs.getInt("apply_id"));
                apply.setUserId(rs.getInt("user_id"));
                apply.setBookId(rs.getInt("book_id"));
                apply.setApplyType(rs.getString("apply_type"));
                apply.setApplyStatus(rs.getString("apply_status"));
                applies.add(apply);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return applies;
    }
}
