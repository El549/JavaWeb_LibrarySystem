package www.zlybl.dao;

import www.zlybl.model.Apply;

import java.util.List;

public interface ApplyDao {
    //根据userid查询借还申请
    List<Apply> MyApply(int userId);

    //添加一条申请借书记录
    int addApply(Apply apply);

    //管理全查借书申请记录
    List<Apply> findApply(Boolean applyType);

    //修改申请状态
    int modApplyStatus(int applyId,int applyStatus);
}