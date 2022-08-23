package Modelo;

import java.sql.Date;

public class Sucursal extends Usuario{
	
	private String direccion;
	
	public Sucursal(String nombre, String apellido, String contrasena, String ID, char sexo, char rango, Date FechaN
			, String direccion) {
		super(nombre, apellido, contrasena, ID, sexo, rango, FechaN);
		this.direccion=direccion;
		
	}
	
	
	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	// Metodos
	public void retirar() {
		
	}
	
	public void depositar() {
		
	}
	
	public void consultarInformacion() {
		
	}
}
