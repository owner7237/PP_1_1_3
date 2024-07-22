package jm.task.core.jdbc.service;


import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;


import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDaoJDBCImpl userJDBC;
    public UserServiceImpl() {
         userJDBC = new UserDaoJDBCImpl();
    }
    public void createUsersTable() {
        userJDBC.createUsersTable();
    }

    public void dropUsersTable() {
        userJDBC.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userJDBC.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        userJDBC.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return userJDBC.getAllUsers();
    }

    public void cleanUsersTable() {
        userJDBC.cleanUsersTable();
    }
}
