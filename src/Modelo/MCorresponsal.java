package Modelo;

import Controlador.CCorresponsal;
import Vista.VCorresponsal;


public class MCorresponsal {

	public void cerrar(VCorresponsal v) {
		VCorresponsal vU = new VCorresponsal();
		MCorresponsal m = new MCorresponsal();
		CCorresponsal c = new CCorresponsal(vU, m, this);
		vU.setVisible(true);
		v.dispose();
	}
	
}
