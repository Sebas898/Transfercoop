package MVC;

import Controlador.CLogin;
import Modelo.MLogin;
import Vista.VLogin;

public class MVC {

	public static void main(String[] args) {
		VLogin vLogin = new VLogin();
		MLogin mLogin = new MLogin();
		CLogin cLogin = new CLogin(vLogin, mLogin);
		vLogin.setVisible(true);
	}

}
