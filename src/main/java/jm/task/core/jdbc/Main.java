package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {

    public static void main(String[] args) {


        UserServiceImpl userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Tom", "Felton", (byte) 30);
        userService.saveUser("John", "Smith", (byte) 21);
        userService.saveUser("Emily", "InParis", (byte) 55);
        userService.saveUser("Sam", "Ford", (byte) 1);


        userService.getAllUsers();

        userService.cleanUsersTable();

        userService.dropUsersTable();

    }
}
