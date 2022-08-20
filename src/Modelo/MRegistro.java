package Modelo;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.sql.Date;

import javax.swing.JOptionPane;

import Vista.VRegistro;

public class MRegistro {

	PreparedStatement ps;
	ResultSet rs;
	
	VRegistro v = new VRegistro();
	
	public void comprobarContrasena(VRegistro v) {
	
		if(v.txtPassword.getText().equals(v.txtCpassword.getText())) {
			v.lblConfirm.setForeground(Color.GREEN);
			v.lblConfirm.setText("Las contrasenas coinciden");

		}else {
			v.lblConfirm.setForeground(Color.RED);
			v.lblConfirm.setText("Las contrasenas no coinciden");
		}
	}

	public void casiilasEnBlanco(VRegistro v){
		if(v.txtPassword.getText().equals("") && v.txtCpassword.getText().equals("")){
			v.lblConfirm.setText("");
		}
	}

	
	public Date fecha(dateChooser dj) {
		
	}
	
	
	public void guardar(VRegistro v){
		Connection con = null;

		try {

			if(v.nID.getText().isEmpty() || v.nombre.getText().isEmpty() || v.apellido.getText().isEmpty() || v.dateChooser.getDate()==null ||
					v.buttonGroup.getSelection().getActionCommand().toString().isEmpty() || v.txtCpassword.getText().isEmpty() || v.txtPassword.getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "Hay campos vacios","Error",JOptionPane.ERROR_MESSAGE);

			}else{

				String f = String.valueOf(v.dateChooser.getCalendar().get(Calendar.YEAR));
				String f2 = String.valueOf(v.dateChooser.getCalendar().get(Calendar.MONTH));
				String f3 = String.valueOf(v.dateChooser.getCalendar().get(Calendar.DAY_OF_MONTH));
				String fehca = (f+"-"+f2+"-"+f3);
				Date z1 = Date.valueOf(fehca);

				con = Conexion.getConection();
				ps = con.prepareStatement("INSERT INTO usuarios (nID, nombre, apellido, fNacimiento, genero, contrasena, dinero, rango) VALUES (?,?,?,?,?,?,?,?)");
				ps.setString(1, v.nID.getText());
				ps.setString(2, v.nombre.getText());
				ps.setString(3, v.apellido.getText());
				ps.setDate(4, z1);
				ps.setString(5, v.buttonGroup.getSelection().getActionCommand());
				ps.setString(6, v.txtCpassword.getText());
				ps.setDouble(7, 0);
				ps.setString(8, "U");
				int rs = ps.executeUpdate();
	
				if(rs > 0){
					JOptionPane.showMessageDialog(null, "Registro exitoso","Aviso",JOptionPane.INFORMATION_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null, "Error al registrar","Error",JOptionPane.ERROR_MESSAGE);
				}
				con.close();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
