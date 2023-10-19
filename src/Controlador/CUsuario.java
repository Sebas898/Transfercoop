package Controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Modelo.MLogin;
import Modelo.MUsuario;
import Vista.VUsuario;

public class CUsuario implements MouseListener{

    private VUsuario vUsuario;
    private MUsuario mUsuario;
    private MLogin mLogin;

    public CUsuario(VUsuario vUsuario, MUsuario mUsuario, MLogin mLogin){
        this.vUsuario = vUsuario;
        this.mUsuario = mUsuario;
        this.mLogin = mLogin;
        vUsuario.btnSalir.addMouseListener(this);
        vUsuario.btnTrasferir.addMouseListener(this);
        vUsuario.btnTrasferirT.addMouseListener(this);
        vUsuario.btnMovimientos.addMouseListener(this);
        vUsuario.btnVolverT.addMouseListener(this);
        vUsuario.btnVolverM.addMouseListener(this);
        vUsuario.cerrar.addMouseListener(this);
        mUsuario.mostrarDatos(vUsuario, mLogin);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    	if(e.getSource() == vUsuario.cerrar) {
    		mUsuario.salir(vUsuario);
    	}
    	
    	if(e.getSource() == vUsuario.btnSalir){
            mUsuario.salir(vUsuario);
        }
    	
    	if(e.getSource() == vUsuario.btnTrasferir) {
    		mUsuario.abrirVTransferir(vUsuario);
    	}
    	
    	if(e.getSource() == vUsuario.btnVolverM) {
    		mUsuario.volver(vUsuario);
    		mUsuario.mostrarDatos(vUsuario, mLogin);
    	}
    	
    	if(e.getSource() == vUsuario.btnVolverT) {
    		mUsuario.volver(vUsuario);
    		 mUsuario.mostrarDatos(vUsuario, mLogin);
    		
    	}
    	
    	if(e.getSource() == vUsuario.btnMovimientos) {
    		mUsuario.abrirVMovimientos(vUsuario, mLogin);
    		
    	}
    	
    	if(e.getSource() == vUsuario.btnTrasferirT) {
    		mUsuario.trasferir(vUsuario, mLogin);
    	}
        
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
    public void mousePressed(MouseEvent e) {
    	
    	
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }


}
