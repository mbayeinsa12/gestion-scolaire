package sn.isep.dbe.util;

import java.sql.*;

public class ConnexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/gestion_scolaire";
    private static final String USER = "alndiaye";
    private static final String PASSWORD = "alndiaye";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
