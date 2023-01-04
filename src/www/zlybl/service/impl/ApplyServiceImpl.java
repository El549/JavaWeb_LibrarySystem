package www.zlybl.service.impl;

import www.zlybl.dao.ApplyDao;
import www.zlybl.dao.impl.ApplyDaoImpl;
import www.zlybl.model.Apply;
import www.zlybl.service.ApplyService;

import java.util.List;

public class ApplyServiceImpl implements ApplyService {
    ApplyDao applyDao = new ApplyDaoImpl();
    @Override
    public boolean applyForLoan(Apply apply) {
        return applyDao.addApply(apply) == 1 ? true : false;
    }

    @Override
    public List<Apply> findApply(Boolean applyType) {
        return applyDao.findApply(applyType);
    }

    @Override
    public int modApplyStatus(int applyId, int applyStatus) {
        return applyDao.modApplyStatus(applyId, applyStatus);
    }
}
