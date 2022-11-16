package MVC;

import Controlador.CCorresponsal;
import Controlador.CLogin;
import Modelo.MCorresponsal;
import Modelo.MLogin;
import Vista.VCorresponsal;
import Vista.VLogin;

public class MVC {

	public static void main(String[] args) {
		VLogin v = new VLogin();
		MLogin m = new MLogin();
		CLogin c = new CLogin(v, m);
		v.setVisible(true);
	}

}
