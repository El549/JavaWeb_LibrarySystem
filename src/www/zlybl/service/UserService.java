package www.zlybl.service;

import www.zlybl.model.User;

import java.util.List;

public interface UserService {

    //分页全查
    List<User> findUserByPage(int page, int pageSize);

    //根据Id查询
    User findUserById(String sid);

    int count();

    boolean modUser(User user);

    boolean resetPassword(String sid);

    boolean delUser(String sid);
    
    //用户登录
    User userLogin(int userId, String userPassword);

    boolean userRegister(User user);
    
    int userGetLastId();
}
