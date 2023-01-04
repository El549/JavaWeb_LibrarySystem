package www.zlybl.service.impl;

import www.zlybl.dao.UserDao;
import www.zlybl.dao.impl.UserDaoImpl;
import www.zlybl.model.User;
import www.zlybl.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public List<User> findUserByPage(int page, int pageSize) {
        return userDao.findUserByPage((page-1)*pageSize,pageSize);
    }

    @Override
    public User findUserById(String sid) {
        if (sid==null||sid.equals("")){
            return null;
        }
        int id=Integer.parseInt(sid);
        return userDao.findUserById(id);
    }

    @Override
    public int count() {
        return userDao.count();
    }

    @Override
    public boolean modUser(User user) {
        return userDao.update(user)==1?true:false;
    }

    @Override
    public boolean resetPassword(String sid) {
        if (sid==null||sid.equals("")){
            return false;
        }
        int id=Integer.parseInt(sid);
        return userDao.updatePassword(id)==1?true:false;
    }

    @Override
    public boolean delUser(String sid) {
        if (sid==null||sid.equals("")){
            return false;
        }
        int id=Integer.parseInt(sid);
        return userDao.delete(id)==1?true:false;
    }

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
