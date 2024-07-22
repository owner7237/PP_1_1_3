package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    private final static String URL = "jdbc:mysql://localhost:3306/katadb";
    private final static String USERNAME = "user";
    private final static String PASSWORD = "pass";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

