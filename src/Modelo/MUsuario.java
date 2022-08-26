package Modelo;


import java.text.NumberFormat;
import java.util.Locale;

import Controlador.CLogin;
import Vista.VLogin;
import Vista.VUsuario;

public class MUsuario {

    VLogin vLogin = new VLogin();

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
    
    public void volver(VUsuario v) {
    	v.panelP.setVisible(true);
    	v.panelT.setVisible(false);
    }
    
    public void mostrarDatos(VUsuario v, MLogin m){
    	NumberFormat nf = NumberFormat.getInstance(new Locale("es", "COL"));
		
        v.lblNombre.setText(m.cliente.getNombre()+" "+m.cliente.getApellido());
        v.lblId.setText(m.cliente.getID());
        v.lblFecha.setText(java.time.LocalDateTime.now().toLocalDate().toString());
        v.lblDinero.setText(nf.format(m.cliente.getDinero()));
        
    }
}
