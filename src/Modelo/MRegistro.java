package Modelo;

import java.awt.Color;

import Vista.VRegistro;

public class MRegistro {
	
	VRegistro v = new VRegistro();
	
	public void comprobarContrasena(VRegistro v) {
	
		if(v.txtPassword.getText().equals(v.txtCpassword.getText())) {
			v.lblConfirm.setForeground(Color.GREEN);
			v.lblConfirm.setText("Las contraseñas coinciden");
		}else {
			v.lblConfirm.setForeground(Color.RED);
			v.lblConfirm.setText("Las contraseñas no coinciden");
		}
	}
	
}
