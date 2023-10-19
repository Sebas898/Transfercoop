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

	PreparedStatement preparedStatement;
	ResultSet resultSet;
	String tipo;
	
	Encriptacion encriptacion = new Encriptacion();
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

	public void abrirCliente(VLogin vLogin) {
	    VUsuario vUsuario = new VUsuario();
		MUsuario mUsuario = new MUsuario();
		CUsuario usuario = new CUsuario(vUsuario, mUsuario, this);
		vUsuario.setVisible(true);
		vLogin.dispose();
		
	    
	}
	
	public void abrirCorresponsal(VLogin vLogin) {
	    VCorresponsal vCorresponsal = new VCorresponsal();
        MCorresponsal mCorresponsal = new MCorresponsal();
        CCorresponsal cCorresponsal = new CCorresponsal(vCorresponsal, mCorresponsal, this);
        vCorresponsal.setVisible(true);  
        vLogin.dispose();
	}

	public void registro(VLogin vLogin) {

		VRegistro vRegistro = new VRegistro();
		MRegistro mRegistro = new MRegistro();
		CRegistro cRegistro = new CRegistro(vRegistro, mRegistro);
		vRegistro.setVisible(true);
		vLogin.dispose();
		
		
	}
	
	public void login(VLogin vLogin) {
		Connection connection = Conexion.getConection();
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM usuarios WHERE nID = ? AND contrasena = ?");
			preparedStatement.setString(1, vLogin.username.getText());
			preparedStatement.setString(2, encriptacion.encriptar(vLogin.password.getText()));
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				JOptionPane.showMessageDialog(null, "Welcome " + resultSet.getString("nombre"), "Aviso",
						JOptionPane.INFORMATION_MESSAGE);
				if (resultSet.getString("rango").equals("U")) {
				    
					cliente = new Cliente();

					cliente.setID(resultSet.getString("nID"));
					cliente.setNombre(resultSet.getString("nombre"));
					cliente.setApellido(resultSet.getString("apellido"));
					cliente.setContrasena(resultSet.getString("contrasena"));
					cliente.setFechaN(resultSet.getDate("fNacimiento"));
					tipo = resultSet.getString("genero");
					cliente.setSexo(tipo.charAt(0));
					tipo = resultSet.getString("rango");
					cliente.setRango(tipo.charAt(0));
					cliente.setDinero(resultSet.getDouble("dinero"));
					
					abrirCliente(vLogin);
				}else if(resultSet.getString("rango").equals("C")) {
				    
				    corresponsal = new Corresponsal();
				    
				    corresponsal.setID(resultSet.getString("nID"));
				    corresponsal.setNombre(resultSet.getString("nombre"));
				    corresponsal.setApellido(resultSet.getString("apellido"));
				    corresponsal.setContrasena(resultSet.getString("contrasena"));
				    corresponsal.setFechaN(resultSet.getDate("fNacimiento"));
                    tipo = resultSet.getString("genero");
                    corresponsal.setSexo(tipo.charAt(0));
                    tipo = resultSet.getString("rango");
                    corresponsal.setRango(tipo.charAt(0));
                    corresponsal.setCupo(resultSet.getDouble("dinero"));

                    abrirCorresponsal(vLogin);
				}

			} else {
				JOptionPane.showMessageDialog(null, "Datos no validos", "Error", JOptionPane.ERROR_MESSAGE);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
