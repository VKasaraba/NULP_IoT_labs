package ua.lviv.iot.kasaraba.persistent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManager {
    private static final String url = "jdbc:mysql://localhost:3306/kasaraba_db?serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "root";
    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwable) {
                System.out.println("Can't close connection, Exception is:" + throwable.getMessage());
                System.out.println("State:" + throwable.getMessage());
                System.out.println("Vendor Error:" + throwable.getMessage());
            }
        }
    }
}
