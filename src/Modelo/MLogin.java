package Modelo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JOptionPane;

import Vista.VLogin;

public class MLogin {
	private String username;
	private String password;
	
	
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
		System.out.println("USUARIO: "+v.username.getText()+" CONTRASEÑA: "+v.password.getText());
		if (v.username.getText().equals("1006859078") && v.password.getText().equals("1234")) {
			JOptionPane.showMessageDialog(null, "Acceso Concedido");
		} else {
			JOptionPane.showMessageDialog(null, "Acceso Denegado");
		}
	}

}
