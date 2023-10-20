package Modelo;

import java.sql.Date;

public class Corresponsal extends Usuario {
    double cupo;

    public Corresponsal(String nombre, String apellido, String contrasena, String ID, char sexo, char rango,
            Date fechaN) {
        super(nombre, apellido, contrasena, ID, sexo, rango, fechaN);
        this.setCupo(0d);
    }

    public Corresponsal() {
        this.setNombre(""); 
        this.setApellido("");;
        this.setContrasena("");;
        this.setID("");
        this.setSexo(' ');
        this.setRango(' ');
        this.setFechaN(null);
        this.setCupo(0d);
    }
    
    // Metodos
    public double getCupo() {
        return cupo;
    }

    public void retirar() {

    }

    public void depositar() {

    }

    public void setCupo(double cupo) {
        this.cupo = cupo;
    }

    public void consultarInformacion() {

    }
}
