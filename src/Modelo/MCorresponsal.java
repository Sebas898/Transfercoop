package Modelo;

import Controlador.CUsuario;
import Vista.VLogin;
import Vista.VUsuario;

public class MCorresponsal {

	public void cerrar(VLogin v) {
		VCorresponsal vU = new MCorresponsal();
		MCorresponsal m = new MCorresponsal();
		MCorresponsal c = new MCorresponsal(vU, m, this);
		vU.setVisible(true);
		v.dispose();
	}
	
}
