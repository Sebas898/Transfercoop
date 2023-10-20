package Controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Modelo.MRegistro;
import Vista.VRegistro;

public class CRegistro implements MouseListener, KeyListener {

	private VRegistro vRegistro;
	private MRegistro mRegistro;
	
	public CRegistro(VRegistro vRegistro, MRegistro mRegistro) {
		this.vRegistro = vRegistro;
		this.mRegistro = mRegistro;
		vRegistro.btnNext.addMouseListener(this);
		vRegistro.txtCpassword.addKeyListener(this);
		vRegistro.txtPassword.addKeyListener(this);
		vRegistro.volver1_1.addMouseListener(this);
		mRegistro.casiilasEnBlanco(vRegistro);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == vRegistro.btnNext) {
			mRegistro.guardar(vRegistro);
		}
		
		if(e.getSource() == vRegistro.volver1_1 || e.getSource() == vRegistro.volver1_0) {
			mRegistro.volver(vRegistro);
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getSource()== vRegistro.txtCpassword) {
			mRegistro.comprobarContrasena(vRegistro);		
			mRegistro.casiilasEnBlanco(vRegistro);
		}
		if(e.getSource()== vRegistro.txtPassword) {
			mRegistro.comprobarContrasena(vRegistro);
			mRegistro.casiilasEnBlanco(vRegistro);
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
