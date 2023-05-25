/**
 * Набор инструментов для работы с базой данных
 */

package org.sf.finalproject.tools;

import org.springframework.beans.factory.annotation.Value;

import java.sql.*;

public class dbTools {

    public static void test_db_connection(String name_db_sql, String usr_bd_sql, String pass_bd_sql) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost/" + name_db_sql, usr_bd_sql, pass_bd_sql); // Пробуем подключиться к БД
            System.out.println("База данных существует");        // если БД существует, то сообщаем об этом
        } catch (SQLException e) {
            if (e.getSQLState().equals("3D000")) {                                                      // Если базы нет, то создаем базу данных
                System.out.println("База данных отсутствует\nПопытка создать базу данных.");
                connection = DriverManager.getConnection("jdbc:postgresql://localhost/", usr_bd_sql, pass_bd_sql);
                statement = connection.createStatement();
                statement.executeUpdate("CREATE DATABASE " + name_db_sql + ";");                         // Команда создания БД
                System.out.println("База данных создана");
            } else {
                System.out.println("Trouble" + e.getSQLState());
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
        }
    }
}
