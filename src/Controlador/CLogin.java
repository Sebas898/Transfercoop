package Controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Modelo.Cliente;
import Modelo.MLogin;
import Modelo.MVerificacion;
import Vista.VLogin;

public class CLogin implements MouseListener, KeyListener {
	private VLogin vLogin;
	private MLogin mLogin;
	private MVerificacion mVerificacion;
	private String modelo;
	public boolean verificacion;
	public Class<? extends MLogin> datos;

	public CLogin(VLogin vLogin, MLogin mLogin) {
		this.vLogin = vLogin;
		this.mLogin = mLogin;
		vLogin.login.addMouseListener(this);
		vLogin.username.requestFocus();
		vLogin.registrate.addMouseListener(this);
		vLogin.password.addKeyListener(this);
		modelo = "l";
	}
	
	public CLogin(VLogin vLogin, MVerificacion mVerificacion) {
        this.vLogin = vLogin;
        this.mVerificacion = mVerificacion;
        vLogin.login.addMouseListener(this);
        vLogin.username.requestFocus();
        vLogin.password.addKeyListener(this);
        vLogin.registrate.setVisible(false);
        modelo="v";
    }

	@Override
	public void mouseClicked(MouseEvent e) {
	    if(modelo.equals("l")) {
	        if (e.getSource() == vLogin.login) {
	            mLogin.login(vLogin);
	            
	        }
	        if(e.getSource() == vLogin.registrate) {
	            mLogin.registro(vLogin);
	        }
	    }
		
		if (modelo.equals("v")) {
		    if (e.getSource() == vLogin.login) {
		        mVerificacion.comprobacion(vLogin);
		        if(mVerificacion.estado==true) {
		            vLogin.dispose();
		            System.out.println(mVerificacion.estado);
		        }
            }
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if ( e.getSource() == vLogin.password) {
			if(e.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
				mLogin.login(vLogin);
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
