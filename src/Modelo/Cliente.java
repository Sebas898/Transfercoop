package Modelo;

import java.sql.Date;

import Controlador.CUsuario;
import Vista.VLogin;
import Vista.VUsuario;

public class Cliente extends Usuario{

	private Double dinero;
	private String accion = "";

	public Cliente(String nombre, String apellido, String contrasena, String ID, char sexo, char rango, Date fechaN) {
		super(nombre, apellido, contrasena, ID, sexo, rango, fechaN);
		this.setDinero(0d);
	}
	
	public Cliente(){
		this.setNombre(""); 
		this.setApellido("");;
		this.setContrasena("");;
		this.setID("");
		this.setSexo(' ');
		this.setRango(' ');
		this.setFechaN(null);
		this.setDinero(0d);
	}

	public Double getDinero() {
		return dinero;
	}

	public void setDinero(Double dinero) {
		this.dinero = dinero;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}
}
