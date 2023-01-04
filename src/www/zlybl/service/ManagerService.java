package www.zlybl.service;

import www.zlybl.model.Manager;

public interface ManagerService {
    Manager managerLogin(String managerName, String managerPassword);
}
