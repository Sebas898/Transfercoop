package Modelo;

import java.sql.Date;

public class Cliente extends Usuario{

	private Double dinero;

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
	
	// Metodos
	public void verMovimientos() {
		
	}
	
	public void transferirDinero() {
		
	}
	
	public void consultarInformacion() {
		
	}

	public Double getDinero() {
		return dinero;
	}

	public void setDinero(Double dinero) {
		this.dinero = dinero;
	}
}
