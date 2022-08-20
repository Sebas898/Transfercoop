package Modelo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Vista.VLogin;

public class MLogin {
	private String username;
	private String password;
	
	PreparedStatement ps;
	ResultSet rs;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

	
	public void mostrar(VLogin v) {
		Connection con = null;
		try {
			con = Conexion.getConection();
			ps = con.prepareStatement("SELECT * FROM usuarios WHERE nID = ? AND contrasena = ?");
			ps.setString(1, v.username.getText());
			ps.setString(2, v.password.getText());
			rs = ps.executeQuery();
			if(rs.next()){
				JOptionPane.showMessageDialog(null, "Welcome "+rs.getString("nombre"), "Aviso", JOptionPane.INFORMATION_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(null, "Datos no validos", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
