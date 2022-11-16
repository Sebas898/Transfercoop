package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Vista.VCorresponsal;
import Vista.VLogin;

public class MVerificacion {

    PreparedStatement ps;
    ResultSet rs;

    Conexion conexion = new Conexion();
    Cliente cliente = new Cliente();
    Encriptacion en = new Encriptacion();
    String a;
    public static boolean r=false;
   
    
   
    public boolean comprobacion(VLogin v) {
        Connection con = Conexion.getConection();
        try {
            ps = con.prepareStatement("SELECT * FROM usuarios WHERE nID = ? AND contrasena = ?");
            ps.setString(1, v.username.getText());
            ps.setString(2, en.encriptar(v.password.getText()));
            rs = ps.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Welcome " + rs.getString("nombre"), "Aviso",
                        JOptionPane.INFORMATION_MESSAGE);
                if (rs.getString("rango").equals("U")) {
                    
                    cliente = new Cliente();

                    cliente.setID(rs.getString("nID"));
                    cliente.setNombre(rs.getString("nombre"));
                    cliente.setApellido(rs.getString("apellido"));
                    cliente.setContrasena(rs.getString("contrasena"));
                    cliente.setFechaN(rs.getDate("fNacimiento"));
                    a = rs.getString("genero");
                    cliente.setSexo(a.charAt(0));
                    a = rs.getString("rango");
                    cliente.setRango(a.charAt(0));
                    cliente.setDinero(rs.getDouble("dinero"));
                    r=true;
                }

            } else {
                JOptionPane.showMessageDialog(null, "Datos no validos", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return r;
    }
    
}
