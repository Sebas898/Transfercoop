package Modelo;

import Vista.VLogin;
import Vista.VUsuario;

public class MUsuario {

    VLogin vLogin = new VLogin();

    public void salir(VUsuario v){
        v.dispose();
    }

    public void mostrarDatos(VUsuario v, MLogin m){
        v.lblNombre.setText(m.cliente.getNombre());
    }
}
