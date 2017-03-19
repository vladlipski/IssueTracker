package by.issue_tracker.db;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbutils.DbUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DbWorker {

    private static final BasicDataSource dataSource = new BasicDataSource();

    public DbWorker() {
        InputStream inputStream = null;
        try {
            inputStream =  getClass().getClassLoader().getResourceAsStream("dbConnection.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            dataSource.setUrl(properties.getProperty("jdbc.url"));
            dataSource.setDriverClassName(properties.getProperty("jdbc.driver"));
            dataSource.setUsername(properties.getProperty("jdbc.username"));
            dataSource.setPassword(properties.getProperty("jdbc.password"));
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
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
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
