package Controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Modelo.MLogin;
import Vista.VLogin;

public class CLogin implements MouseListener, KeyListener {
	private VLogin v;
	private MLogin m;

	public CLogin(VLogin v, MLogin m) {
		this.v = v;
		this.m = m;
		v.login.addMouseListener(this);
		v.username.requestFocus();
		v.registrate.addMouseListener(this);
		v.password.addKeyListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == v.login) {
			m.login(v);
		}
		if(e.getSource() == v.registrate) {
			m.registro(v);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if ( e.getSource() == v.password) {
			if(e.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
				m.login(v);
			}
			
	
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


}
