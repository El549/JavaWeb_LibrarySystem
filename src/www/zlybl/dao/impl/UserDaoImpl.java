package www.zlybl.dao.impl;

import www.zlybl.dao.BaseDao;
import www.zlybl.dao.UserDao;
import www.zlybl.model.User;

import java.sql.SQLException;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserById(int id) {
        User user = null;
        String sql = "SELECT *FROM user WHERE user_id=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setUserId(id);
                user.setUserName(rs.getString("name"));
                user.setUserPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public int userRegister(User user) {
        System.out.println(user);
        int rows = 0;
        String sql = "INSERT INTO user (user_name,user_password) VALUES (?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getUserPassword());
            rows = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows;
    }

    @Override
    public User findByIdAndPwd(int userId, String userPassword) {
        User user = null;
        String sql = "SELECT * FROM user WHERE user_id=? AND user_password=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            pstmt.setString(2, userPassword);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setUserId(userId);
                user.setUserName(rs.getString("user_name"));
                user.setUserPassword(userPassword);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return user;
    }

    public int userGetLastId() {
        int lastId = 0;
        User user;
        String sql = "SELECT * from user order by user_id desc limit 1";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt("user_id"));
                lastId = user.getUserId();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lastId;
    }
}
