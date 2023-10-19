package Modelo;

import java.sql.*;

public class Conexion {
	private static String URL = "jdbc:mysql://localhost/TransfercoopDB";
	private static String USERNAME = "sebastian";
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
			System.out.println("ERROR AL CONECTAR");
			e.printStackTrace();
		}
		return con;

	}
}
