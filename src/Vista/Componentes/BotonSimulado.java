package Vista.Componentes;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BotonSimulado extends JLabel {
    private ImageIcon imagenEntrada;
    private ImageIcon imagenSalida;

    public BotonSimulado(ImageIcon imagenEntrada, ImageIcon imagenSalida, JPanel pane) {
        this.imagenEntrada = imagenEntrada;
        this.imagenSalida = imagenSalida;
        setIcon(imagenEntrada); 
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
                setIcon(imagenSalida);
                pane.updateUI();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                setIcon(imagenEntrada); 
                pane.updateUI();
            }
        });
    }
}
