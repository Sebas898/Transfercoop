package Controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.plaf.synth.SynthScrollBarUI;

import Modelo.MRegistro;
import Vista.VLogin;
import Vista.VRegistro;

public class CRegistro implements MouseListener, KeyListener {

	private VRegistro v;
	private MRegistro m;
	public CRegistro(VRegistro v, MRegistro m) {
		this.v = v;
		this.m = m;
		v.btnNext.addMouseListener(this);
		v.txtCpassword.addKeyListener(this);
		v.txtPassword.addKeyListener(this);
		v.volver1_1.addMouseListener(this);
		m.casiilasEnBlanco(v);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == v.btnNext) {
			m.guardar(v);
		}
		
		if(e.getSource() == v.volver1_1 || e.getSource() == v.volver1_0) {
			m.volver(v);
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getSource()== v.txtCpassword) {
			m.comprobarContrasena(v);		
			m.casiilasEnBlanco(v);
		}
		if(e.getSource()== v.txtPassword) {
			m.comprobarContrasena(v);
			m.casiilasEnBlanco(v);
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

	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}	
}
