package Controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Modelo.MLogin;
import Modelo.MVerificacion;
import Vista.VLogin;

public class CLogin implements MouseListener, KeyListener {
	private VLogin v;
	private MLogin ml;
	private MVerificacion mv;
	private String modelo;
	public boolean verificacion;
	public Class<? extends MLogin> datos;

	public CLogin(VLogin v, MLogin m) {
		this.v = v;
		this.ml = m;
		v.login.addMouseListener(this);
		v.username.requestFocus();
		v.registrate.addMouseListener(this);
		v.password.addKeyListener(this);
		modelo="l";
	}
	
	public CLogin(VLogin v, MVerificacion m) {
        this.v = v;
        this.mv = m;
        v.login.addMouseListener(this);
        v.username.requestFocus();
        v.password.addKeyListener(this);
        v.registrate.setVisible(false);
        modelo="v";
    }

	@Override
	public void mouseClicked(MouseEvent e) {
	    if(modelo.equals("l")) {
	        if (e.getSource() == v.login) {
	            ml.login(v);
	            
	        }
	        if(e.getSource() == v.registrate) {
	            ml.registro(v);
	        }
	    }
		
		if (modelo.equals("v")) {
		    if (e.getSource() == v.login) {
		        mv.comprobacion(v);
		        if(mv.r==true) {
		            v.dispose();
		            System.out.println(mv.r);
		        }
            }
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if ( e.getSource() == v.password) {
			if(e.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
				ml.login(v);
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
