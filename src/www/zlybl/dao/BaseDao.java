package www.zlybl.dao;

import java.sql.*;

public class BaseDao {
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/db_javaWeb_library?serverTimezone=GMT";
    String jdbcUser = "root";
    String jdbcPwd = "12345678";
    protected Connection conn = null;
    protected Statement stmt = null;
    protected PreparedStatement pstmt = null;
    protected ResultSet rs = null;
    public BaseDao() {
        connect();
    }
    protected void connect() {
        try {
            //加载驱动
            Class.forName(driver).newInstance();
            //链接数据库
            conn = DriverManager.getConnection(url, jdbcUser, jdbcPwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void close() {
        //关闭数据库
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (pstmt != null && !pstmt.isClosed()) {
                pstmt.close();
            }
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
