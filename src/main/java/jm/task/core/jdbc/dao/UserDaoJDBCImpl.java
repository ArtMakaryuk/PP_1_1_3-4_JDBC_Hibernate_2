package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private static final Connection connection = Util.getConnection();

    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
//        Statement statement = null;
        String sql_create = "CREATE TABLE IF NOT EXISTS users " +
                "(" +
                "id INT NOT NULL AUTO_INCREMENT, " +
                "name VARCHAR(45) NOT NULL, " +
                "lastName VARCHAR(45) NOT NULL," +
                "age INT(3) NOT NULL, " +
                "PRIMARY KEY (`id`)" +
                ")";
//        try {
//            statement = connection.createStatement();
//            statement.executeUpdate(sql_create);
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        try (Statement statement = connection.createStatement()){
            statement.executeUpdate(sql_create);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
//        Statement statement = null;
        String sql_drop = "DROP TABLE IF EXISTS users";
//        try {
//            statement = connection.createStatement();
//            statement.executeUpdate(sql_drop);
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql_drop);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
//        PreparedStatement preparedStatement = null;
        String sql_save = "INSERT INTO users (name, lastName, age) values(?, ?, ?)";
//        try {
//            preparedStatement = connection.prepareStatement(sql_save);
//            preparedStatement.setString(1, name);
//            preparedStatement.setString(2, lastName);
//            preparedStatement.setByte(3, age);
//            preparedStatement.executeUpdate();
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql_save)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
//        Statement statement = null;
        String sql_remove = "DELETE FROM users WHERE id='" + id + "'";
//        try {
//            statement = connection.createStatement();
//            statement.executeUpdate(sql_remove);
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql_remove);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (ResultSet rs = connection.createStatement().executeQuery("select * from users")) {
            while (rs.next()) {
                String name = rs.getString("name");
                String lastName = rs.getString("lastName");
                byte age = rs.getByte("age");
                User user = new User(name, lastName, age);
                user.setId(rs.getLong("id"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void cleanUsersTable() {
//        Statement statement = null;
        String sql_clean = "TRUNCATE TABLE users";
//        try {
//            statement = connection.createStatement();
//            statement.executeUpdate(sql_clean);
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql_clean);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
