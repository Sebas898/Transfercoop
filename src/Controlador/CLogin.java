package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Action;
import javax.swing.JOptionPane;

import Modelo.MLogin;
import Vista.VLogin;

public class CLogin implements MouseListener {
	private VLogin v;
	private MLogin m;

	public CLogin(VLogin v, MLogin m) {
		this.v = v;
		this.m = m;
		v.login.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == v.login) {
			m.mostrar(v);
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