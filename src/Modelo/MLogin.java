package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Controlador.CUsuario;
import Vista.VLogin;
import Vista.VUsuario;

public class MLogin {
	private String username;
	private String password;

	public Cliente cliente;

	PreparedStatement ps;
	ResultSet rs;
	String a;
	
	Encriptacion en = new Encriptacion();
	VUsuario vUsuario = new VUsuario();

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

	public void cerrar(VLogin v) {
		VUsuario vU = new VUsuario();
		MUsuario m = new MUsuario();
		CUsuario c = new CUsuario(vU, m, this);
		vU.setVisible(true);
		v.dispose();
	}

	public void login(VLogin v) {
		Connection con = Conexion.getConection();
		try {
			ps = con.prepareStatement("SELECT * FROM usuarios WHERE nID = ? AND contrasena = ?");
			ps.setString(1, v.username.getText());
			ps.setString(2, en.encriptar(v.password.getText()));
			rs = ps.executeQuery();
			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "Welcome " + rs.getString("nombre"), "Aviso",
						JOptionPane.INFORMATION_MESSAGE);

				if (rs.getString("rango").equals("U")) {
					cliente = new Cliente();

					cliente.setID(rs.getString("nID"));
					cliente.setNombre(rs.getString("nombre"));
					cliente.setApellido(rs.getString("apellido"));
					cliente.setContrasena(rs.getString("contrasena"));
					cliente.setFechaN(rs.getDate("fNacimiento"));
					a = rs.getString("genero");
					cliente.setSexo(a.charAt(0));
					a = rs.getString("rango");
					cliente.setRango(a.charAt(0));
					cliente.setDinero(rs.getDouble("dinero"));
					
					cerrar(v);
				}

			} else {
				JOptionPane.showMessageDialog(null, "Datos no validos", "Error", JOptionPane.ERROR_MESSAGE);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
