package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Controlador.CCorresponsal;
import Controlador.CRegistro;
import Controlador.CUsuario;
import Vista.VCorresponsal;
import Vista.VLogin;
import Vista.VRegistro;
import Vista.VUsuario;

public class MLogin {
	private String username;
	private String password;

	public Cliente cliente;
	public Corresponsal corresponsal;

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

	public void abrirCliente(VLogin v) {
	    VUsuario vU = new VUsuario();
		MUsuario m = new MUsuario();
		CUsuario c = new CUsuario(vU, m, this);
		vU.setVisible(true);
		v.dispose();
		
	    
	}
	
	public void abrirCorresponsal(VLogin v) {
	    VCorresponsal vC = new VCorresponsal();
        MCorresponsal m = new MCorresponsal();
        CCorresponsal c = new CCorresponsal(vC, m, this);
        vC.setVisible(true);  
        v.dispose();
	}

	public void registro(VLogin v) {

		VRegistro vU = new VRegistro();
		MRegistro m = new MRegistro();
		CRegistro c = new CRegistro(vU, m);
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
					
					abrirCliente(v);
				}else if(rs.getString("rango").equals("C")) {
				    
				    corresponsal = new Corresponsal();
				    
				    corresponsal.setID(rs.getString("nID"));
				    corresponsal.setNombre(rs.getString("nombre"));
				    corresponsal.setApellido(rs.getString("apellido"));
				    corresponsal.setContrasena(rs.getString("contrasena"));
				    corresponsal.setFechaN(rs.getDate("fNacimiento"));
                    a = rs.getString("genero");
                    corresponsal.setSexo(a.charAt(0));
                    a = rs.getString("rango");
                    corresponsal.setRango(a.charAt(0));
                    corresponsal.setCupo(rs.getDouble("dinero"));

                    abrirCorresponsal(v);
				}

			} else {
				JOptionPane.showMessageDialog(null, "Datos no validos", "Error", JOptionPane.ERROR_MESSAGE);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
