package Modelo;
import java.sql.Date;

public class Usuario {
	
	private String nombre;
	private String apellido;
	private String contrasena;
	private String ID;
	private char sexo;
	private char rango;
	private Date FechaN;

	public Usuario(String nombre, String apellido, String contrasena, String ID, char sexo, char rango, Date FechaN) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.contrasena = contrasena;
		this.ID = ID;
		this.sexo = sexo;
		this.rango = rango;
		this.FechaN = FechaN;
	}

	public Usuario(){

	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public char getRango() {
		return rango;
	}

	public void setRango(char rango) {
		this.rango = rango;
	}

	public Date getFechaN() {
		return FechaN;
	}

	public void setFechaN(Date fechaN) {
		FechaN = fechaN;
	}

	// Metodos
	public void ingresar() {
		
	}
	
	public void salir() {
		
	}
	
	public void registrar() {
		
	}
}
