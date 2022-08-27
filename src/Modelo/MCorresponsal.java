package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Controlador.CCorresponsal;
import Vista.VCorresponsal;
import Vista.VUsuario;


public class MCorresponsal {

    PreparedStatement ps;
    ResultSet rs;

    Conexion conexion = new Conexion();
    Cliente cliente = new Cliente();

    String accion = cliente.getAccion();

    Connection con = null;
    Double retirado;

	public void trasferir(VUsuario v, MLogin ml){
        Double dinero;
        accion = "Transferencia";

        try {
            con = conexion.getConection();
            ps = con.prepareStatement("SELECT * FROM usuarios WHERE nID = ?");
            ps.setString(1, v.id.getText());

            if(v.monto.getText().equals("") || v.id.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Hay campos vacio");
            }else{
                retirado = Double.parseDouble(v.monto.getText());
                rs = ps.executeQuery();
                if(retirado <= 0 || retirado > ml.cliente.getDinero()){
                    JOptionPane.showMessageDialog(null, "Valor no validos");
                }else{
                    Double dineroU = rs.getDouble("dinero");
                    dineroU = dineroU + retirado;
                    dinero = ml.cliente.getDinero() - retirado;
                    ml.cliente.setDinero(dinero);

                    ps = con.prepareStatement("UPDATE usuarios SET dinero = '"+dineroU+"' WHERE nID = ?");
                    ps.setString(1, ml.cliente.getID());
                    ps.executeUpdate();

                    actualizar();

                    if(v.id.getText().equals(ml.cliente.getID())){
                        JOptionPane.showMessageDialog(null, "No se puede hacer la transaccion a su propia cuenta");
                        v.id.setText(null);
                        v.monto.setText(null);
                    }else{
                        int res = ps.executeUpdate();
                        if(res > 0){
                            JOptionPane.showMessageDialog(null, "Transferencia exitosa");
                            registrar();
                            v.id.setText(null);
                            v.monto.setText(null);
                    
                        }else{
                            JOptionPane.showMessageDialog(null, "Ocurrio un error");
                            v.id.setText(null);
                            v.monto.setText(null);
                        }
                    }

                }
            }

        } catch (Exception e) {
			System.err.println(e);
        }
	}

    public void retirar(VCorresponsal v, MLogin ml){
        Double dinero;
        accion = "Retirar";

        if(v.MONTOR.getText().equals("")){
            v.MONTOR.setText("0");
        }
        
        retirado = Double.parseDouble(v.MONTOR.getText());

        if(v.MONTOR.getText().equals("0")){
            v.MONTOR.setText(null);
            JOptionPane.showMessageDialog(null, "No se a ingresado ningun valor");
        }else if(retirado > ml.cliente.getDinero()){
            JOptionPane.showMessageDialog(null, "No hay suficiente dineo en la cuenta");
			v.MONTOR.setText(null);
        }else{
            JOptionPane.showMessageDialog(null, "Transaccion exitosa");
            dinero = ml.cliente.getDinero() - retirado;
            ml.cliente.setDinero(dinero);
            v.MONTOR.setText(null);
            actualizar();
            registrar();
        }
    }

    public void agregar(VCorresponsal v, MLogin ml){
        Double dinero;
        accion = "Consignar";

        try {
            con = conexion.getConection();
            if(v.MontoCg.getText().equals("")){
                JOptionPane.showMessageDialog(null, "No se ha ingresado ningun valor");
            }else{
                retirado = Double.parseDouble(v.MontoCg.getText());
                ps = con.prepareStatement("SELECT * FROM usuarios WHERE nID = ?");
                ps.setString(1, ml.cliente.getID());

                rs = ps.executeQuery();

                if(rs.next()){
                    Double dineroU = rs.getDouble("dinero");
                    dineroU = dineroU + retirado;

                    ps = con.prepareStatement("UPDATE usuarios SET dinero = ? WHERE nID = ?");
                    ps.setDouble(1, dineroU);
                    ps.setString(2, ml.cliente.getID());

                    dinero = dineroU;
                    ml.cliente.setDinero(dinero);

                    int res = ps.executeUpdate();
                    if(res > 0){
                        JOptionPane.showMessageDialog(null, "Transferencia exitosa");
                    }
                    registrar();
                }else{
                    JOptionPane.showMessageDialog(null, "Ocurrio un error");
				    v.MontoCg.setText(null);
                }
            }

        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    public void actualizar() {

		try {
			con = conexion.getConection();
			ps = con.prepareStatement("UPDATE usuarios SET dinero = ? WHERE nID = ?");
			ps.setDouble(1, cliente.getDinero());
			ps.setString(2, cliente.getID());
            ps.executeUpdate();

		} catch (Exception e) {
            System.out.println(e);
		}
    }

    public void registrar(){
        try {
            con = conexion.getConection();
            ps = con.prepareStatement("INSERT INTO movimientos (nID, fecha, nID_Des, accion, monto) VALUES(?,?,?,?,?)");
            ps.setString(1, cliente.getID());
            ps.setTimestamp(2, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));;
            ps.setString(3, "");
            ps.setString(4, accion);
            ps.setDouble(5, retirado);
            
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}