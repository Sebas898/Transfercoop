package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.mysql.cj.CoreSession;

import Controlador.CCorresponsal;
import Controlador.CRegistro;
import Controlador.CUsuario;
import Vista.VCorresponsal;
import Vista.VLogin;
import Vista.VRegistro;
import Vista.VUsuario;
import Vista.Paneles.Principal;

public class MLogin {
	private String username;
	private String password;

	public Cliente cliente;
	public Corresponsal corresponsal;
	public Usuario usuario;
	public double saldoCliente;

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
	
//	------------------------
	
    public UsuarioFactory getUsuarioFactory(String userType) {
        if (userType.equals("U")) {
            return new ClienteFactory();
        } else if (userType.equals("C")) {
            return new CorresponsalFactory();
        }
        return null;
    }
	
//	------------------------

	public void abrirCliente(VLogin vLogin) {
	    VUsuario vUsuario = new VUsuario();
		MUsuario mUsuario = new MUsuario();
		CUsuario usuario = new CUsuario(vUsuario, mUsuario, this);
		vUsuario.setVisible(true);
		vLogin.dispose();
	}
	
	public void abrirCorresponsal(VLogin vLogin) {
	    VCorresponsal vCorresponsal = new VCorresponsal();
	    Principal p = (Principal) vCorresponsal.PPrincipal;
        MCorresponsal mCorresponsal = new MCorresponsal();
        CCorresponsal cCorresponsal = new CCorresponsal(vCorresponsal, mCorresponsal, this,p);
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
				
				UsuarioFactory factory = getUsuarioFactory(resultSet.getString("rango"));
				usuario = factory.crearUsurio();
				
				usuario.setID(resultSet.getString("nID"));
                usuario.setNombre(resultSet.getString("nombre"));
                usuario.setApellido(resultSet.getString("apellido"));
                usuario.setContrasena(resultSet.getString("contrasena"));
                usuario.setFechaN(resultSet.getDate("fNacimiento"));
                tipo = resultSet.getString("genero");
                usuario.setSexo(tipo.charAt(0));
                tipo = resultSet.getString("rango");
                usuario.setRango(tipo.charAt(0));
				
                if(usuario instanceof Cliente) {
                    cliente = (Cliente) usuario;
                    cliente.setDinero(resultSet.getDouble("dinero"));
                    saldoCliente = cliente.getDinero();
                    abrirCliente(vLogin);
                }else if(usuario instanceof Corresponsal) {
                    corresponsal = (Corresponsal) usuario;
                    corresponsal.setCupo(resultSet.getDouble("dinero"));
                    System.out.println(resultSet.getDouble("dinero"));
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
