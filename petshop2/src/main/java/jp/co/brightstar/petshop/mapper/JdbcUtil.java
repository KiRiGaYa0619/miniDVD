package jp.co.brightstar.petshop.mapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {

    /**
     * 取得连接的方法
     *
     * @return 一个 conn 连接
     * @throws SQLException
     */
    public static Connection connect() throws SQLException {

        // 使用具体的数据库驱动类
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("MySQL JDBC 驱动未找到");
        }

        // 构建数据库连接 URL
        String url = "jdbc:mysql://localhost:3306/brightstar1213?useSSL=false&characterEncoding=UTF-8";
        Properties p = new Properties();
        p.setProperty("user", "root");
        p.setProperty("password", "caileiku");
        p.setProperty("serverTimezone", "UTC");


        // 获取数据库连接
        return DriverManager.getConnection(url, p);
    }

    public static void close(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
}
