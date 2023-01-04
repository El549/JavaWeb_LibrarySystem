package www.zlybl.service.impl;

import www.zlybl.dao.ManagerDao;
import www.zlybl.dao.impl.ManagerDaoImpl;
import www.zlybl.model.Manager;
import www.zlybl.service.ManagerService;

public class ManagerServiceImpl implements ManagerService {
    ManagerDao managerDao=new ManagerDaoImpl();

    @Override
    public Manager managerLogin(String managerName, String managerPassword) {
        return managerDao.findManagerByNameAndPwd(managerName,managerPassword);
    }
}
