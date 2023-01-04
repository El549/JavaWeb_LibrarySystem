package www.zlybl.service.impl;

import www.zlybl.dao.UserDao;
import www.zlybl.dao.impl.UserDaoImpl;
import www.zlybl.model.User;
import www.zlybl.service.UserService;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    @Override
    public User userLogin(int userId, String userPassword) {
        return userDao.findByIdAndPwd(userId, userPassword);
    }

    @Override
    public boolean userRegister(User user) {
        return userDao.userRegister(user) == 1;
    }

    @Override
    public int userGetLastId() {
        return userDao.userGetLastId();
    }
}
