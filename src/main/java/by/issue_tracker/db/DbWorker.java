package by.issue_tracker.db;

import by.issue_tracker.models.User;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbWorker {
    private Connection conn = null;
    private String url = "jdbc:mysql://localhost:3306/issue_tracker?useUnicode=true&" +
            "useSSL=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String driver = "com.mysql.jdbc.Driver";
    private String usr = "root";
    private String pwd = "root";
    private User user;

    public Connection getConnection() {
        DbUtils.loadDriver(driver);
        try {
            conn = DriverManager.getConnection(url, usr, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        QueryRunner query = new QueryRunner();
        try {
            user = (User) query.query(conn, "select * from user where id=1", new BeanHandler(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(user.getName());
        //DbUtils.closeQuietly(conn);
        return conn;
    }
}
