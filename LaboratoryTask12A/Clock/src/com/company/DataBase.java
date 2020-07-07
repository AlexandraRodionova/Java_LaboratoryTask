package com.company;

import java.sql.*;
import java.util.Properties;

public class DataBase {
    Connection connection;
    Statement statement;
    DataBase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/Clock";
        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password", "sascha11");
        properties.put("autoReconnect", "true");
        properties.put("characterEncoding", "UTF-8");
        properties.put("useUnicode", "true");
        properties.put("serverTimezone", "Europe/Moscow");
        try {
            connection = DriverManager.getConnection(url, properties);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
