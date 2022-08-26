package Modelo;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JOptionPane;

import com.mysql.cj.protocol.Resultset;

import Controlador.CLogin;


import Vista.VLogin;
import Vista.VUsuario;

public class MUsuario {

    VLogin vLogin = new VLogin();
    NumberFormat prt = NumberFormat.getInstance(new Locale("es", "COL"));
    Conexion conexion = new Conexion();
    Cliente cliente = new Cliente();

    Double retirado;
    Double dinero = cliente.getDinero();
    
    PreparedStatement ps;
    ResultSet rs;

    public void salir(VUsuario v){
  
    	VLogin vl = new VLogin();
		MLogin m = new MLogin();
		CLogin c = new CLogin(vl, m);
		vl.setVisible(true);
		v.dispose();
    }

    public void abrirVTransferir(VUsuario v) {
    	v.panelP.setVisible(false);
    	v.panelT.setVisible(true);
    	
    }
    
    public void abrirVMovimientos(VUsuario v) {
    	v.panelP.setVisible(false);
    	v.panelM.setVisible(true);
    	
    }
    
    public void volver(VUsuario v) {
    	v.panelP.setVisible(true);
    	v.panelT.setVisible(false);
    	v.panelM.setVisible(false);
    }
    
    public void mostrarDatos(VUsuario v, MLogin m){
    	NumberFormat nf = NumberFormat.getInstance(new Locale("es", "COL"));
		
        v.lblNombre.setText(m.cliente.getNombre()+" "+m.cliente.getApellido());
        v.lblId.setText(m.cliente.getID());
        v.lblFecha.setText(java.time.LocalDateTime.now().toLocalDate().toString());
        v.lblDinero.setText(nf.format(m.cliente.getDinero()));
        
        v.lblNombre.setText(m.cliente.getNombre()+" "+m.cliente.getApellido());
        v.lblId.setText(m.cliente.getID());
        v.lblDinero.setText(prt.format(m.cliente.getDinero()));
    }

    public void listaTransacciones(VUsuario v, MLogin ml){
		Connection con = null;
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

    public void actualizar() {
		Connection con = null;

		try {
			con =conexion.getConection();
			ps = con.prepareStatement("UPDATE usuarios SET dinero = ? WHERE nID = ?");
			ps.setDouble(1, cliente.getDinero());
			ps.setString(2, cliente.getID());
            ps.executeUpdate();

		} catch (Exception e) {
            System.out.println(e);
		}

	}

}
