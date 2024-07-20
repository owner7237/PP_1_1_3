package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();
        Util.CreateConnection();
        //userService.saveUser("Bim", "Dim", (byte) 90);
        //userService.removeUserById(5);
        //userService.removeUserById(6);
        System.out.println(userService.getAllUsers().toString());
        Util.closeConnection();

    }
}
