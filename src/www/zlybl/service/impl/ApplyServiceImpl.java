package www.zlybl.service.impl;


import www.zlybl.dao.ApplyDao;
import www.zlybl.dao.impl.ApplyDaoImpl;
import www.zlybl.model.Apply;
import www.zlybl.service.ApplyService;

import java.util.List;

public class ApplyServiceImpl implements ApplyService {
    ApplyDao applyDao=new ApplyDaoImpl();
    @Override
    public List<Apply> MyApply(int userId) {
        return applyDao.MyApply(userId);
    }
}
