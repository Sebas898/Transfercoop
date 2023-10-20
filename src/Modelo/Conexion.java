package Modelo;

import java.sql.*;

public class Conexion {

	private static String URL = "jdbc:mysql://localhost/transfercoop";
	private static String USERNAME = "juan";
	private static String PASSWORD = ".16794300.@";
	
	public static Connection getConection() {
		Connection connection = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);

		}

		catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("ERROR AL CONECTAR");
			e.printStackTrace();
		}
		return connection;

	}
}
