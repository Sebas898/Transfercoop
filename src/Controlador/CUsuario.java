package Controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Modelo.MLogin;
import Modelo.MUsuario;
import Vista.VUsuario;

public class CUsuario implements MouseListener{

    private VUsuario v;
    private MUsuario m;
    private MLogin mLogin;

    public CUsuario(VUsuario v, MUsuario m, MLogin mLogin){
        this.v = v;
        this.m = m;
        this.mLogin = mLogin;
        v.btnSalir.addMouseListener(this);
        v.btnTrasferir.addMouseListener(this);
        v.btnTrasferirT.addMouseListener(this);
        v.btnMovimientos.addMouseListener(this);
        v.btnVolverT.addMouseListener(this);
        v.btnVolverM.addMouseListener(this);
        m.mostrarDatos(v, mLogin);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        
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
    	if(e.getSource() == v.btnSalir){
            m.salir(v);
        }
    	
    	if(e.getSource() == v.btnTrasferir) {
    		m.abrirVTransferir(v);
    	}
    	
    	if(e.getSource() == v.btnVolverM) {
    		m.volver(v);
    		 m.mostrarDatos(v, mLogin);
    	}
    	
    	if(e.getSource() == v.btnVolverT) {
    		m.volver(v);
    		 m.mostrarDatos(v, mLogin);
    		
    	}
    	
    	if(e.getSource() == v.btnMovimientos) {
    		m.abrirVMovimientos(v);
    	}
    	
    	
    	if(e.getSource() == v.btnTrasferirT) {
    		m.trasferir(v, mLogin);
    	}
    	
    	
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }


}
