package Modelo;

import java.sql.Date;


public class Cliente extends Usuario{
	
	private double dinero;
	
	public Cliente(String nombre, String apellido, String contrasena, String ID, char sexo, char rango, Date FechaN
			, double dinero){
		super(nombre, apellido, contrasena, ID, rango, rango, FechaN);
		this.dinero=dinero;
	}
	
	
	
	public double getDinero() {
		return dinero;
	}



	public void setDinero(double dinero) {
		this.dinero = dinero;
	}



	// Metodos
	public void verMovimientos() {
		
	}
	
	public void transferirDinero() {
		
	}
	
	public void consultarInformacion() {
		
	}
	
}
