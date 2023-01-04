package www.zlybl.service;

import www.zlybl.model.Manager;

public interface ManagerService {
    Manager managerLogin(int managerId, String managerPassword);
}
