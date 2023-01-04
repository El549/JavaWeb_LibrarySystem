package www.zlybl.service;

import www.zlybl.model.User;

import java.util.List;

public interface UserService {
    //用户登录
    User userLogin(int userId, String userPassword);


    boolean userRegister(User user);
    int userGetLastId();
}