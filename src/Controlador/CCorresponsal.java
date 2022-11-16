package Controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Modelo.MCorresponsal;
import Modelo.MLogin;
import Vista.VCorresponsal;

public class CCorresponsal implements MouseListener{
	
	private MCorresponsal m;
	private VCorresponsal v;
	private MLogin mLogin;

	public CCorresponsal(VCorresponsal v, MCorresponsal m,MLogin mLogin) {
		this.v = v;
		this.m = m;
		this.mLogin = mLogin;
		v.btnConsultar.addMouseListener(this);
		v.btnRetirar.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==v.btnConsultar) {
		    m.abrirConsultar(v);
		}
		if(e.getSource()==v.btnRetirar) {
		    m.abrirRetirar(v);
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
