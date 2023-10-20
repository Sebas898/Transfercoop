package Modelo;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.sql.Date;

import javax.swing.JOptionPane;

import Controlador.CLogin;
import Vista.VLogin;
import Vista.VRegistro;

public class MRegistro {

	PreparedStatement preparedStatement;
	ResultSet resultSet;
	
//	VRegistro v = new VRegistro();
	Encriptacion encriptacion = new Encriptacion();
	
	public void comprobarContrasena(VRegistro vRegistro) {
	
		if(vRegistro.txtPassword.getText().equals(vRegistro.txtCpassword.getText())) {
			vRegistro.lblConfirm.setForeground(Color.GREEN);
			vRegistro.lblConfirm.setText("Las contrasenas coinciden");

		}else {
			vRegistro.lblConfirm.setForeground(Color.RED);
			vRegistro.lblConfirm.setText("Las contrasenas no coinciden");
		}
	}
	
	public void volver(VRegistro vRegistro) {
		VLogin vLogin = new VLogin();
		MLogin mLogin = new MLogin();
		CLogin cLogin = new CLogin(vLogin, mLogin);
		vLogin.setVisible(true);
		vRegistro.dispose();
	}

	public void casiilasEnBlanco(VRegistro vRegistro){
		if(vRegistro.txtPassword.getText().equals("") && vRegistro.txtCpassword.getText().equals("")){
			vRegistro.lblConfirm.setText("");
		}
	}

	public void guardar(VRegistro vRegistro){
		Connection connection = null;

		try {

			if(vRegistro.nID.getText().isEmpty() || vRegistro.nombre.getText().isEmpty() || vRegistro.apellido.getText().isEmpty() || vRegistro.dateChooser.getDate()==null ||
					vRegistro.buttonGroup.getSelection().getActionCommand().toString().isEmpty() || vRegistro.txtCpassword.getText().isEmpty() || vRegistro.txtPassword.getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "Hay campos vacios","Error",JOptionPane.ERROR_MESSAGE);

			}else{

				String anho = String.valueOf(vRegistro.dateChooser.getCalendar().get(Calendar.YEAR));
				String mes = String.valueOf(vRegistro.dateChooser.getCalendar().get(Calendar.MONTH));
				String dia = String.valueOf(vRegistro.dateChooser.getCalendar().get(Calendar.DAY_OF_MONTH));
				String fecha = (anho+"-"+mes+"-"+dia);
				Date fechaNacimiento = Date.valueOf(fecha);

				connection = Conexion.getConection();
				preparedStatement = connection.prepareStatement("INSERT INTO usuarios (nID, nombre, apellido, fNacimiento, genero, contrasena, dinero, rango) VALUES (?,?,?,?,?,?,?,?)");
				preparedStatement.setString(1, vRegistro.nID.getText());
				preparedStatement.setString(2, vRegistro.nombre.getText());
				preparedStatement.setString(3, vRegistro.apellido.getText());
				preparedStatement.setDate(4, fechaNacimiento);
				preparedStatement.setString(5, vRegistro.buttonGroup.getSelection().getActionCommand());
				preparedStatement.setString(6, encriptacion.encriptar(vRegistro.txtCpassword.getText()));
				preparedStatement.setDouble(7, 0);
				preparedStatement.setString(8, "U");
				int rs = preparedStatement.executeUpdate();
	
				if(rs > 0){
					JOptionPane.showMessageDialog(null, "Registro exitoso","Aviso",JOptionPane.INFORMATION_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null, "Error al registrar","Error",JOptionPane.ERROR_MESSAGE);
				}
				connection.close();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
