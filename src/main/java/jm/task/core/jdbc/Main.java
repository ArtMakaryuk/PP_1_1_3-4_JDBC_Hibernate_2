package jm.task.core.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    private static final  String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {

        //ДА ЕБАНЫЙ СТЫД СЫЫЫЫЫР
        Connection connection;
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("Соединение установлено");
            }
            connection.close();
            if (connection.isClosed()) {
                System.out.println("Соединение закрыто");
            }
        } catch (SQLException e) {
            System.out.println("Не удалось соединиться");
        }
    }
}
