package www.zlybl.dao;

import www.zlybl.model.Manager;


public interface ManagerDao {
    Manager findManagerByIdAndPwd(int managerId, String managerPassword);
}
