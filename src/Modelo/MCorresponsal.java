package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Controlador.CLogin;
import Vista.VCorresponsal;
import Vista.VLogin;
import Vista.VUsuario;


public class MCorresponsal {
    
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    Conexion conexion = new Conexion();
    Cliente cliente = new Cliente();

    String accion = cliente.getAccion();

    Connection connection = null;
    Double retirado;
    
    public void actualizar() {

        try {
            connection = conexion.getConection();
            preparedStatement = connection.prepareStatement("UPDATE usuarios SET dinero = ? WHERE nID = ?");
            preparedStatement.setDouble(1, cliente.getDinero());
            preparedStatement.setString(2, cliente.getID());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void registrar(){
        try {
            connection = conexion.getConection();
            preparedStatement = connection.prepareStatement("INSERT INTO movimientos (nID, fecha, nID_Des, accion, monto) VALUES(?,?,?,?,?)");
            preparedStatement.setString(1, cliente.getID());
            preparedStatement.setTimestamp(2, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));;
            preparedStatement.setString(3, "");
            preparedStatement.setString(4, accion);
            preparedStatement.setDouble(5, retirado);
            
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    
    public boolean verificador() {
        VLogin vLogin = new VLogin();
        MVerificacion verificacion = new MVerificacion();
        CLogin cLogin = new CLogin(vLogin, verificacion);
        vLogin.setVisible(true);
        if(verificacion.estado) {
           return true; 
        }else {
            return false;
        }
        
    }

    public void abrirConsultar(VCorresponsal vCorresponsal) {
        vCorresponsal.panelD.setVisible(false);
        vCorresponsal.panelCg.setVisible(false);
        vCorresponsal.panelCt.setVisible(true);
        vCorresponsal.panelR.setVisible(false);
    }
    
    public void abrirConsignar(VCorresponsal vCorresponsal) {
        vCorresponsal.panelD.setVisible(false);
        vCorresponsal.panelCg.setVisible(true);
        vCorresponsal.panelCt.setVisible(false);
        vCorresponsal.panelR.setVisible(false);
    }
    
    public void abrirRetirar(VCorresponsal vCorresponsal) {
        if(verificador()) {
        vCorresponsal.panelD.setVisible(false);
        vCorresponsal.panelCg.setVisible(false);
        vCorresponsal.panelCt.setVisible(false);
        vCorresponsal.panelR.setVisible(true);
//        System.out.println("Hola");
        }
    }
    
    public void abrirMenu(VCorresponsal vCorresponsal) {
        vCorresponsal.panelD.setVisible(true);
        vCorresponsal.panelCg.setVisible(false);
        vCorresponsal.panelCt.setVisible(false);
        vCorresponsal.panelR.setVisible(false);
    }
    
	public void trasferir(VUsuario vUsuario, MLogin mLogin){
        Double dinero;
        accion = "Transferencia";

        try {
            connection = conexion.getConection();
            preparedStatement = connection.prepareStatement("SELECT * FROM usuarios WHERE nID = ?");
            preparedStatement.setString(1, vUsuario.id.getText());

            if(vUsuario.monto.getText().equals("") || vUsuario.id.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Hay campos vacio");
            }else{
                retirado = Double.parseDouble(vUsuario.monto.getText());
                resultSet = preparedStatement.executeQuery();
                if(retirado <= 0 || retirado > mLogin.cliente.getDinero()){
                    JOptionPane.showMessageDialog(null, "Valor no validos");
                }else{
                    Double dineroU = resultSet.getDouble("dinero");
                    dineroU = dineroU + retirado;
                    dinero = mLogin.cliente.getDinero() - retirado;
                    mLogin.cliente.setDinero(dinero);

                    preparedStatement = connection.prepareStatement("UPDATE usuarios SET dinero = '"+dineroU+"' WHERE nID = ?");
                    preparedStatement.setString(1, mLogin.cliente.getID());
                    preparedStatement.executeUpdate();

                    actualizar();

                    if(vUsuario.id.getText().equals(mLogin.cliente.getID())){
                        JOptionPane.showMessageDialog(null, "No se puede hacer la transaccion a su propia cuenta");
                        vUsuario.id.setText(null);
                        vUsuario.monto.setText(null);
                    }else{
                        int res = preparedStatement.executeUpdate();
                        if(res > 0){
                            JOptionPane.showMessageDialog(null, "Transferencia exitosa");
                            registrar();
                            vUsuario.id.setText(null);
                            vUsuario.monto.setText(null);
                    
                        }else{
                            JOptionPane.showMessageDialog(null, "Ocurrio un error");
                            vUsuario.id.setText(null);
                            vUsuario.monto.setText(null);
                        }
                    }

                }
            }

        } catch (Exception e) {
			System.err.println(e);
        }
	}

    public void retirar(VCorresponsal vCorresponsal, MLogin mLogin){
        Double dinero;
        accion = "Retirar";

        if(vCorresponsal.MONTOR.getText().equals("")){
            vCorresponsal.MONTOR.setText("0");
        }
        
        retirado = Double.parseDouble(vCorresponsal.MONTOR.getText());

        if(vCorresponsal.MONTOR.getText().equals("0")){
            vCorresponsal.MONTOR.setText(null);
            JOptionPane.showMessageDialog(null, "No se a ingresado ningun valor");
        }else if(retirado > mLogin.cliente.getDinero()){
            JOptionPane.showMessageDialog(null, "No hay suficiente dineo en la cuenta");
			vCorresponsal.MONTOR.setText(null);
        }else{
            JOptionPane.showMessageDialog(null, "Transaccion exitosa");
            dinero = mLogin.cliente.getDinero() - retirado;
            mLogin.cliente.setDinero(dinero);
            vCorresponsal.MONTOR.setText(null);
            actualizar();
            registrar();
        }
    }

    public void agregar(VCorresponsal vCorresponsal, MLogin mLogin){
        Double dinero;
        accion = "Consignar";

        try {
            connection = conexion.getConection();
            if(vCorresponsal.MontoCg.getText().equals("")){
                JOptionPane.showMessageDialog(null, "No se ha ingresado ningun valor");
            }else{
                retirado = Double.parseDouble(vCorresponsal.MontoCg.getText());
                preparedStatement = connection.prepareStatement("SELECT * FROM usuarios WHERE nID = ?");
                preparedStatement.setString(1, mLogin.cliente.getID());

                resultSet = preparedStatement.executeQuery();

                if(resultSet.next()){
                    Double dineroU = resultSet.getDouble("dinero");
                    dineroU = dineroU + retirado;

                    preparedStatement = connection.prepareStatement("UPDATE usuarios SET dinero = ? WHERE nID = ?");
                    preparedStatement.setDouble(1, dineroU);
                    preparedStatement.setString(2, mLogin.cliente.getID());

                    dinero = dineroU;
                    mLogin.cliente.setDinero(dinero);

                    int res = preparedStatement.executeUpdate();
                    if(res > 0){
                        JOptionPane.showMessageDialog(null, "Transferencia exitosa");
                    }
                    registrar();
                }else{
                    JOptionPane.showMessageDialog(null, "Ocurrio un error");
				    vCorresponsal.MontoCg.setText(null);
                }
            }

        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}