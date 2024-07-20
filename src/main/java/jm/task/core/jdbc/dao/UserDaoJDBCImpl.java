package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    public void createUsersTable() {
        String sql = "create table users (id integer unique auto_increment primary key, name varchar(45), lastname varchar(45), age tinyint unsigned)";
        try (Statement statement = Util.getConnection().createStatement()){
            statement.execute(sql);
        } catch (SQLException e) {
            System.err.println("Ошибка создания таблицы: " + e.getSQLState());
        }
    }

    public void dropUsersTable() {
        String sql = "drop table users";
        try (Statement statement = Util.getConnection().createStatement()){
            statement.execute(sql);
        } catch (SQLException e) {
            System.err.println("Ошибка удаления таблицы: " + e.getMessage());
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String sql = "insert into users (name, lastname, age) VALUES (?, ?, ?)";
        try {
            try (PreparedStatement preparedStatement = Util.getConnection().prepareStatement(sql)) {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, lastName);
                preparedStatement.setByte(3, age);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
        String sql = "delete from users where id = ?";
        try {
            try (PreparedStatement preparedStatement = Util.getConnection().prepareStatement(sql)) {
                preparedStatement.setLong(1, id);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        ResultSet results;

        String sql = "SELECT * FROM users";
        try (PreparedStatement preparedStatement = Util.getConnection().prepareStatement(sql)) {
            results = preparedStatement.executeQuery();


            while (results.next()) {
                long id = results.getLong(1);
                String name = results.getString(2);
                String lastname = results.getString(3);
                byte age = results.getByte(4);
                User user = new User(name, lastname, age);
                user.setId(id);
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public void cleanUsersTable() {
        String sql = "delete from users";
        try (Statement statement = Util.getConnection().createStatement()){
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
