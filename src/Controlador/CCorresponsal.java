package Controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Modelo.MCorresponsal;
import Modelo.MLogin;
import Vista.VCorresponsal;

public class CCorresponsal implements MouseListener{
	
	private MCorresponsal mCorresponsal;
	private VCorresponsal vCorresponsal;
	private MLogin mLogin;

	public CCorresponsal(VCorresponsal vCorresponsal, MCorresponsal mCorresponsal, MLogin mLogin) {
		this.vCorresponsal = vCorresponsal;
		this.mCorresponsal = mCorresponsal;
		this.mLogin = mLogin;
		vCorresponsal.btnConsultar.addMouseListener(this);
		vCorresponsal.btnRetirar.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==vCorresponsal.btnConsultar) {
		    mCorresponsal.abrirConsultar(vCorresponsal);
		}
		if(e.getSource()==vCorresponsal.btnRetirar) {
		    mCorresponsal.abrirRetirar(vCorresponsal);
		}

		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
