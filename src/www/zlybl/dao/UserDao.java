package www.zlybl.dao;

import www.zlybl.model.User;

import java.util.List;

public interface UserDao {

    List<User> findUserByPage(int start, int num);

    User findUserById(int id);

    int count();

    int update(User user);

    int updatePassword(int id);

    int delete(int id);

    //根据id查用户
    User queryUserById(int id);
    
    //添加用户
    int userRegister(User user);
    
    //根据用户名和密码查用户：用于用户登录
    User findByIdAndPwd(int userId,String userPassword);

    //获得最后一个Id
    int userGetLastId();

}
