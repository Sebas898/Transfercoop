package MVC;

import Controlador.CLogin;
import Modelo.MLogin;
import Vista.VLogin;

public class MVC {

	public static void main(String[] args) {
		VLogin v = new VLogin();
		MLogin m = new MLogin();
		CLogin c = new CLogin(v, m);
		v.setVisible(true);
	}

}
