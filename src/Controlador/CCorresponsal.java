package Controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Modelo.MCorresponsal;
import Modelo.MLogin;
import Vista.VCorresponsal;
import Vista.Paneles.Principal;

public class CCorresponsal implements MouseListener{
	
	private MCorresponsal mCorresponsal;
	private VCorresponsal vCorresponsal;
	private MLogin mLogin;
	private Principal p;

	public CCorresponsal(VCorresponsal vCorresponsal, MCorresponsal mCorresponsal, MLogin mLogin, Principal p) {
		this.vCorresponsal = vCorresponsal;
		this.mCorresponsal = mCorresponsal;
		this.mLogin = mLogin;
		this.p = p;
		p.btnVolver.addMouseListener(this);
		p.PConsultar.btnConsultar.addMouseListener(this);
		p.PConsignar.btnConsignar.addMouseListener(this);;
		p.PRetirar.btnRetirar.addMouseListener(this);
		mCorresponsal.mostrarDatos(vCorresponsal, mLogin, p);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==p.btnVolver) {
		    mCorresponsal.volver(vCorresponsal);
		}
		if(e.getSource()==p.PConsignar.btnConsignar) {
		    mCorresponsal.consignar(vCorresponsal, p, mLogin);
		}
		if(e.getSource()==p.PConsultar.btnConsultar) {
		    mCorresponsal.consultar(vCorresponsal, p);
		}
		if(e.getSource()==p.PRetirar.btnRetirar) {
		    mCorresponsal.retirar(vCorresponsal, p, mLogin);
		}
		if(e.getSource()==p.PConsignar.btnVolver) {
		    mCorresponsal.mostrarDatos(vCorresponsal, mLogin, p);
		}
		if(e.getSource()==p.PConsultar.btnVolver) {
		    mCorresponsal.mostrarDatos(vCorresponsal, mLogin, p);
		}
		if(e.getSource()==p.PRetirar.btnVolver) {
		    mCorresponsal.mostrarDatos(vCorresponsal, mLogin, p);
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
