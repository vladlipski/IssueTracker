package by.issue_tracker.db;

import org.apache.commons.dbutils.DbUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbWorker {

    private Connection connection;
    private String url;
    private String driver;
    private String username;
    private String password;

    public DbWorker() {
        InputStream inputStream = null;
        try {
            inputStream =  getClass().getClassLoader().getResourceAsStream("dbConnection.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            url = properties.getProperty("jdbc.url");
            driver = properties.getProperty("jdbc.driver");
            username = properties.getProperty("jdbc.username");
            password = properties.getProperty("jdbc.password");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Connection getConnection() {
        DbUtils.loadDriver(driver);
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            System.out.println("Failed to create the database connection.");
        }
        return connection;
    }

    public void closeConnection(Connection connection) {
        DbUtils.closeQuietly(connection);
    }

//    public Connection getConnection() {
//        DbUtils.loadDriver(driver);
//        try {
//            conn = DriverManager.getConnection(url, usr, pwd);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        QueryRunner query = new QueryRunner();
//        try {
//            user = (User) query.query(conn, "select * from user where id=1", new BeanHandler(User.class));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        System.out.println(user.getName());
//        //DbUtils.closeQuietly(conn);
//        return conn;
//    }
}
