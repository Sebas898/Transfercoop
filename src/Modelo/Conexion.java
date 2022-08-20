package Modelo;

import java.sql.*;

public class Conexion {
	private static String URL = "jdbc:mysql://139.144.51.53:3306/Transfercoop";
	private static String USERNAME = "juan";
	private static String PASSWORD = ".16794300.@";
	
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
