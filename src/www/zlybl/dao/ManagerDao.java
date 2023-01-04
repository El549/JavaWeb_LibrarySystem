package www.zlybl.dao;

import www.zlybl.model.Manager;


public interface ManagerDao {
    Manager findManagerByNameAndPwd(String managerName, String managerPassword);
}
