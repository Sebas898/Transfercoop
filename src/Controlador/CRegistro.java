package Controlador;

import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;

import org.w3c.dom.events.MouseEvent;

import Modelo.MRegistro;
import Vista.VRegistro;

public class CRegistro {

	private VRegistro v;
	private MRegistro m;
	
	public static void main(String[] args) {
	}
	
	public CRegistro(VRegistro v, MRegistro m) {
		this.v = v;
		this.m = m;
		
		v.btnNext.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				v.btnNext.setIcon(new ImageIcon(VRegistro.class.getResource("/Vista/img/btnSiginup2.png")));
			}

			public void mouseExited(MouseEvent e) {
				v.btnNext.setIcon(new ImageIcon(VRegistro.class.getResource("/Vista/img/btnSiginup1.png")));
				v.contentPane.updateUI();
			}
		});
	}
	
	
}
