package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();

        String name = "Bim";
        userService.saveUser(name, "Dim", (byte) 90);
        System.out.printf("User с именем — %s добавлен в базу данных\n", name);

        name = "John";
        userService.saveUser(name, "Doe", (byte) 35);
        System.out.printf("User с именем — %s добавлен в базу данных\n", name);

        name = "Иван";
        userService.saveUser(name, "Иванов", (byte) 49);
        System.out.printf("User с именем — %s добавлен в базу данных\n", name);

        name = "Валерий";
        userService.saveUser(name, "Дмитров", (byte) 66);
        System.out.printf("User с именем — %s добавлен в базу данных\n", name);

        System.out.println(userService.getAllUsers().toString());
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
