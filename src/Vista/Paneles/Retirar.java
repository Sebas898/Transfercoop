package Vista.Paneles;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

import Vista.VCorresponsal;
import Vista.Componentes.BotonSimulado;

import javax.swing.JTextField;

public class Retirar extends JPanel implements PanelInterface {

    private static final long serialVersionUID = 1L;
    public JTextField monto;
    public JTextField Contrasena;
    public JTextField ID;
    private JLabel lblRetirar;
    private JLabel lblMonto;
    private JLabel lblID;
    public BotonSimulado btnRetirar;
    public BotonSimulado btnVolver;
    private JLabel lblContrasena;

    /**
     * Create the panel.
     */
    public Retirar(VCorresponsal corresponsal) {
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 570, 300);
        add(panel);
        panel.setLayout(null);

        lblRetirar = new JLabel("Retirar");
        lblRetirar.setBounds(247, 11, 67, 27);
        panel.add(lblRetirar);
        lblRetirar.setHorizontalAlignment(SwingConstants.CENTER);
        lblRetirar.setForeground(Color.BLACK);
        lblRetirar.setFont(new Font("Tw Cen MT", Font.BOLD, 24));

        lblMonto = new JLabel("Monto");
        lblMonto.setBounds(86, 65, 64, 27);
        panel.add(lblMonto);
        lblMonto.setHorizontalAlignment(SwingConstants.CENTER);
        lblMonto.setForeground(Color.BLACK);
        lblMonto.setFont(new Font("Tw Cen MT", Font.BOLD, 24));

        lblID = new JLabel("ID");
        lblID.setBounds(86, 114, 21, 27);
        panel.add(lblID);
        lblID.setHorizontalAlignment(SwingConstants.CENTER);
        lblID.setForeground(Color.BLACK);
        lblID.setFont(new Font("Tw Cen MT", Font.BOLD, 24));

        ID = new JTextField();
        ID.setBounds(280, 114, 160, 27);
        panel.add(ID);
        ID.setFont(new Font("Tw Cen MT", Font.PLAIN, 24));
        ID.setColumns(10);
        ID.setBorder(null);
        ID.setBackground(Color.LIGHT_GRAY);

        Contrasena = new JTextField();
        Contrasena.setBounds(280, 155, 160, 27);
        panel.add(Contrasena);
        Contrasena.setFont(new Font("Tw Cen MT", Font.PLAIN, 24));
        Contrasena.setColumns(10);
        Contrasena.setBorder(null);
        Contrasena.setBackground(Color.LIGHT_GRAY);

        btnRetirar = new BotonSimulado(new ImageIcon(VCorresponsal.class.getResource("/Vista/img/btnRa.png")),
                new ImageIcon(VCorresponsal.class.getResource("/Vista/img/btnRb.png")),
                panel);
        btnRetirar.setBounds(200, 209, 160, 39);
        panel.add(btnRetirar);
        btnRetirar.setHorizontalAlignment(SwingConstants.CENTER);
        btnRetirar.setForeground(Color.BLACK);
        btnRetirar.setFont(new Font("Tw Cen MT", Font.BOLD, 24));

        monto = new JTextField();
        monto.setBounds(280, 65, 160, 27);
        panel.add(monto);
        monto.setFont(new Font("Tw Cen MT", Font.PLAIN, 24));
        monto.setColumns(10);
        monto.setBorder(null);
        monto.setBackground(Color.LIGHT_GRAY);

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
        btnVolver.setBounds(406, 243, 154, 46);
        panel.add(btnVolver);
        btnVolver.setHorizontalAlignment(SwingConstants.CENTER);
        btnVolver.setForeground(Color.BLACK);
        btnVolver.setFont(new Font("Tw Cen MT", Font.BOLD, 24));

        lblContrasena = new JLabel("Contraseña");
        lblContrasena.setBounds(86, 155, 115, 27);
        panel.add(lblContrasena);
        lblContrasena.setHorizontalAlignment(SwingConstants.CENTER);
        lblContrasena.setForeground(Color.BLACK);
        lblContrasena.setFont(new Font("Tw Cen MT", Font.BOLD, 24));

    }

    @Override
    public void configurarPanel() {
        this.setBounds(0, 0, 570, 414);
        this.setVisible(true);
    }
}
