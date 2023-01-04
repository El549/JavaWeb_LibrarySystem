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
}
