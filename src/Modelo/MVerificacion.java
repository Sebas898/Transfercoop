package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Vista.VLogin;

public class MVerificacion {

    PreparedStatement preparedStatement;
    ResultSet resultSet;

    Conexion conexion = new Conexion();
    Cliente cliente = new Cliente();
    Encriptacion en = new Encriptacion();
    String tipo;
    public static boolean estado = false;
   
    
   
    public boolean comprobacion(VLogin v) {
        Connection con = Conexion.getConection();
        try {
            preparedStatement = con.prepareStatement("SELECT * FROM usuarios WHERE nID = ? AND contrasena = ?");
            preparedStatement.setString(1, v.username.getText());
            preparedStatement.setString(2, en.encriptar(v.password.getText()));
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                JOptionPane.showMessageDialog(null, "Welcome " + resultSet.getString("nombre"), "Aviso",
                        JOptionPane.INFORMATION_MESSAGE);
                if (resultSet.getString("rango").equals("U")) {
                    
                    cliente = new Cliente();

                    cliente.setID(resultSet.getString("nID"));
                    cliente.setNombre(resultSet.getString("nombre"));
                    cliente.setApellido(resultSet.getString("apellido"));
                    cliente.setContrasena(resultSet.getString("contrasena"));
                    cliente.setFechaN(resultSet.getDate("fNacimiento"));
                    tipo = resultSet.getString("genero");
                    cliente.setSexo(tipo.charAt(0));
                    tipo = resultSet.getString("rango");
                    cliente.setRango(tipo.charAt(0));
                    cliente.setDinero(resultSet.getDouble("dinero"));
                    estado=true;
                }

            } else {
                JOptionPane.showMessageDialog(null, "Datos no validos", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return estado;
    }
    
}
