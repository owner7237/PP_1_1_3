package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDaoJDBCImpl UserJDBC;
    public UserServiceImpl() {
         UserJDBC = new UserDaoJDBCImpl();
         Util.CreateConnection();
    }
    public void createUsersTable() {
        UserJDBC.createUsersTable();
    }

    public void dropUsersTable() {
        UserJDBC.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        UserJDBC.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        UserJDBC.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return UserJDBC.getAllUsers();
    }

    public void cleanUsersTable() {
        UserJDBC.cleanUsersTable();
    }
}
