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
        v.lblNombre.setText(mLogin.cliente.getNombre());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == v.btnSalir){
            m.salir(v);
        }
        
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }


}
