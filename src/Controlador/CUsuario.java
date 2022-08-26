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
        v.btnVolver.addMouseListener(this);
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
    	
    	if(e.getSource() == v.btnVolver) {
    		m.volver(v);
    	}
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }


}