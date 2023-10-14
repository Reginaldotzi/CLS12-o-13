package edu.umg.datos;

import java.sql.*;

public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/p2b";
    private static final String JDBC_USER ="root";
    private static final String JDBC_PASS = "regi34";

    //metodo para obtener la conexion
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
    }


    //metodo para cerrar el resultset
    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    //metodo para cerrar el statement
    public static void close(PreparedStatement stmt){
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    //metodo para cerrar la conexion
    public static void close(Connection conn){
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
} //end class