package Modelo;

import java.text.NumberFormat;
import java.util.Locale;

import Vista.VLogin;
import Vista.VUsuario;

public class MUsuario {

    VLogin vLogin = new VLogin();
    NumberFormat prt = NumberFormat.getInstance(new Locale("es", "COL"));

    public void salir(VUsuario v){
        v.dispose();
    }

    public void mostrarDatos(VUsuario v, MLogin m){
        v.lblNombre.setText(m.cliente.getNombre()+" "+m.cliente.getApellido());
        v.lblId.setText(m.cliente.getID());
        v.lblDinero.setText(prt.format(m.cliente.getDinero()));
    }
}
