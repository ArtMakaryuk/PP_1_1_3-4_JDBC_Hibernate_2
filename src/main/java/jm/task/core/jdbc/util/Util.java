package jm.task.core.jdbc.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    // реализуйте настройку соеденения с БД
    public static Connection getConnection() {
        Connection connection = null;
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/database.properties")) {
            properties.load(fis);
            String url = properties.getProperty("db.url");
            String login = properties.getProperty("db.username");
            String password = properties.getProperty("db.password");
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, login, password);
                if (connection != null) {
                    System.out.println("Connection successful");
                }
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                System.out.println("Connection's not established");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File not found");
        }
        return connection;
    }
}
