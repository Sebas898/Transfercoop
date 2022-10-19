package Modelo;

import java.sql.*;

public class Conexion {
	private static String URL = "jdbc:mysql://localhost/transfer_prueba";
	private static String USERNAME = "root";
	private static String PASSWORD = "sebas123";
	
	public static Connection getConection() {
		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);

		}

		catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("ERROR ALCONECTAR");
			e.printStackTrace();
		}
		return con;

	}
}
