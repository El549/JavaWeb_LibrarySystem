package www.zlybl.dao.impl;

import www.zlybl.dao.BaseDao;
import www.zlybl.dao.UserDao;
import www.zlybl.model.User;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public List<User> findUserByPage(int start, int num) {
        List<User> userList = new ArrayList<>();

        String sql = "select * from user order by user_id limit ?,?";

        try {
            //创建语句对象
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, start);
            pstmt.setInt(2, num);
            //执行sql
            rs = pstmt.executeQuery();
            //处理结果
            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUserName(rs.getString("user_name"));
                user.setUserPassword(rs.getString("user_password"));
                userList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public User findUserById(int id) {
        User user = null;

        String sql = "select * from user where user_id=?";

        try {
            //创建语句对象
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            //执行sql
            rs = pstmt.executeQuery();
            //处理结果
            while (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUserName(rs.getString("user_name"));
                user.setUserPassword(rs.getString("user_password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

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
    public int count() {
        int count = 0;
        String sql = "select COUNT(*) from user";
        try {
            //创建语句对象
            stmt = conn.createStatement();
            //执行sql
            rs = stmt.executeQuery(sql);
            //处理结果
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int update(User user) {
        int rows = 0;
        String sql = "UPDATE user SET user_name=?,user_password=? WHERE user_id=?";
        try {
            //创建语句对象
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getUserPassword());
            pstmt.setInt(3, user.getUserId());
            //执行sql
            rows = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return rows;
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
    public int updatePassword(int id) {
        int rows = 0;
        String sql = "UPDATE user SET user_password=123456 WHERE user_id=?";
        try {
            //创建语句对象
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            //执行sql
            rows = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int delete(int id) {
        int rows = 0;
        String sql = "DELETE FROM user WHERE user_Id=?";
        try {
            //创建语句对象
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            //执行sql
            rows = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
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
    @Override
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
