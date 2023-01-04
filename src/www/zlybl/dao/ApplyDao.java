package www.zlybl.dao;

import www.zlybl.model.Apply;

import java.util.List;

public interface ApplyDao {
//    根据userid查询借还申请
    List<Apply> MyApply(int userId);


}

