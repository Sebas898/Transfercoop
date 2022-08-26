package Modelo;

<<<<<<< HEAD

import java.text.NumberFormat;
import java.util.Locale;

import Controlador.CLogin;
=======
import java.text.NumberFormat;
import java.util.Locale;

>>>>>>> 87513003afa8cf91a16b89413b0ebe5607dc3ad7
import Vista.VLogin;
import Vista.VUsuario;

public class MUsuario {

    VLogin vLogin = new VLogin();
    NumberFormat prt = NumberFormat.getInstance(new Locale("es", "COL"));

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
<<<<<<< HEAD
    	NumberFormat nf = NumberFormat.getInstance(new Locale("es", "COL"));
		
        v.lblNombre.setText(m.cliente.getNombre()+" "+m.cliente.getApellido());
        v.lblId.setText(m.cliente.getID());
        v.lblFecha.setText(java.time.LocalDateTime.now().toLocalDate().toString());
        v.lblDinero.setText(nf.format(m.cliente.getDinero()));
        
=======
        v.lblNombre.setText(m.cliente.getNombre()+" "+m.cliente.getApellido());
        v.lblId.setText(m.cliente.getID());
        v.lblDinero.setText(prt.format(m.cliente.getDinero()));
>>>>>>> 87513003afa8cf91a16b89413b0ebe5607dc3ad7
    }
}
