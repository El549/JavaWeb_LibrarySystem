package www.zlybl.service;

import www.zlybl.model.Apply;

import java.util.List;

public interface ApplyService {
    //    根据userid查询借还申请
    List<Apply> MyApply(int userId);
}
