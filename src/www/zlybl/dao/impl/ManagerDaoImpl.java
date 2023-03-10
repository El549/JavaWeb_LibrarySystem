package www.zlybl.dao.impl;

import www.zlybl.dao.BaseDao;
import www.zlybl.dao.ManagerDao;
import www.zlybl.model.Manager;

import java.sql.SQLException;

public class ManagerDaoImpl extends BaseDao implements ManagerDao {

    @Override
    public Manager findManagerByIdAndPwd(int managerId, String managerPassword) {
        Manager manager = null;
        String sql = "SELECT * FROM manager WHERE manager_id=? AND manager_password=?";
        System.out.println(managerId+managerPassword);
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, managerId);
            pstmt.setString(2, managerPassword);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                manager = new Manager();
                manager.setManagerId(rs.getInt("manager_id"));
                manager.setManagerName(rs.getString("manager_name"));
                manager.setManagerPassword(rs.getString("manager_password"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return manager;
    }
}
