package Vista.Paneles;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;

import Vista.VCorresponsal;
import Vista.Componentes.BotonSimulado;

import javax.swing.JTextField;
import java.awt.Color;

public class Consultar extends JPanel implements PanelInterface {

    private static final long serialVersionUID = 1L;
    public JTextField ID;
    public JTextField contrasena;
    private JLabel lblID;
    private JLabel lblContrasena;
    public BotonSimulado btnConsultar;
    public BotonSimulado btnVolver;
    private JLabel lblConsultar;

    public Consultar(VCorresponsal corresponsal) {
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 570, 300);
        add(panel);
        panel.setLayout(null);

        lblID = new JLabel("ID");
        lblID.setHorizontalAlignment(SwingConstants.CENTER);
        lblID.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblID.setBounds(46, 72, 142, 29);
        panel.add(lblID);

        lblContrasena = new JLabel("Contraseña");
        lblContrasena.setHorizontalAlignment(SwingConstants.CENTER);
        lblContrasena.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblContrasena.setBounds(46, 117, 142, 29);
        panel.add(lblContrasena);

        ID = new JTextField();
        ID.setColumns(10);
        ID.setBorder(null);
        ID.setBackground(Color.LIGHT_GRAY);
        ID.setBounds(213, 77, 216, 30);
        panel.add(ID);

        contrasena = new JTextField();
        contrasena.setColumns(10);
        contrasena.setBorder(null);
        contrasena.setBackground(Color.LIGHT_GRAY);
        contrasena.setBounds(213, 117, 216, 30);
        panel.add(contrasena);

        btnConsultar = new BotonSimulado(new ImageIcon(VCorresponsal.class.getResource("/Vista/img/btnCta.png")),
                new ImageIcon(VCorresponsal.class.getResource("/Vista/img/btnCtb.png")),
                panel);
        btnConsultar.setHorizontalAlignment(SwingConstants.CENTER);
        btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 24));
        btnConsultar.setBorder(null);
        btnConsultar.setBounds(223, 181, 153, 39);
        panel.add(btnConsultar);

        btnVolver = new BotonSimulado(new ImageIcon(VCorresponsal.class.getResource("/Vista/img/btnVlvrb.png")),
                new ImageIcon(VCorresponsal.class.getResource("/Vista/img/btnVlvra.png")),
                panel);
        btnVolver.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                corresponsal.colocarPanel(corresponsal.PPrincipal);
            }
        });
        btnVolver.setHorizontalAlignment(SwingConstants.CENTER);
        btnVolver.setFont(new Font("Tahoma", Font.BOLD, 24));
        btnVolver.setBorder(null);
        btnVolver.setBounds(407, 250, 153, 39);
        panel.add(btnVolver);

        lblConsultar = new JLabel();
        lblConsultar.setText("Consultar");
        lblConsultar.setHorizontalAlignment(SwingConstants.CENTER);
        lblConsultar.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblConsultar.setBorder(null);
        lblConsultar.setBounds(223, 11, 153, 30);
        panel.add(lblConsultar);

    }

    @Override
    public void configurarPanel() {
        this.setBounds(0, 0, 570, 414);
        this.setVisible(true);
    }
}
