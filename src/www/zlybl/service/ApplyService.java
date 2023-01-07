package www.zlybl.service;

import www.zlybl.model.Apply;

import java.util.List;

public interface ApplyService {
    //根据userid查询借还申请
    List<Apply> MyApply(int userId);

    //用户申请借书
    boolean applyForLoan(Apply apply);

    //管理员查询申请记录
    List<Apply> findApply(Boolean applyType);

    //修改申请状态
    int modApplyStatus(int applyId,int applyStatus);
}
