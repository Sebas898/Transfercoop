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

public class Consignar extends JPanel implements PanelInterface {

    private static final long serialVersionUID = 1L;
    public JTextField ID;
    public JTextField monto;
    private JLabel lblID;
    private JLabel lblMonto;
    private JLabel titulo;
    public BotonSimulado btnVolver;
    public BotonSimulado btnConsignar;
    private JPanel panel;

    /**
     * Create the panel.
     */
    public Consignar(VCorresponsal corresponsal) {
        setLayout(null);

        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 570, 300);
        add(panel);
        panel.setLayout(null);

        lblID = new JLabel("ID");
        lblID.setHorizontalAlignment(SwingConstants.CENTER);
        lblID.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
        lblID.setBounds(88, 78, 103, 27);
        panel.add(lblID);

        lblMonto = new JLabel("Monto");
        lblMonto.setHorizontalAlignment(SwingConstants.CENTER);
        lblMonto.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
        lblMonto.setBounds(88, 116, 103, 27);
        panel.add(lblMonto);

        ID = new JTextField();
        ID.setHorizontalAlignment(SwingConstants.CENTER);
        ID.setForeground(Color.BLACK);
        ID.setFont(new Font("Tw Cen MT", Font.PLAIN, 22));
        ID.setColumns(10);
        ID.setBorder(null);
        ID.setBackground(Color.LIGHT_GRAY);
        ID.setBounds(201, 78, 214, 27);
        panel.add(ID);

        monto = new JTextField();
        monto.setHorizontalAlignment(SwingConstants.CENTER);
        monto.setForeground(Color.BLACK);
        monto.setFont(new Font("Tw Cen MT", Font.PLAIN, 22));
        monto.setColumns(10);
        monto.setBorder(null);
        monto.setBackground(Color.LIGHT_GRAY);
        monto.setBounds(201, 116, 214, 27);
        panel.add(monto);

        titulo = new JLabel("Consignar");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
        titulo.setBounds(242, 21, 103, 27);
        panel.add(titulo);

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
        btnVolver.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
        btnVolver.setBounds(410, 250, 150, 39);
        panel.add(btnVolver);

        btnConsignar = new BotonSimulado(new ImageIcon(VCorresponsal.class.getResource("/Vista/img/btnCga.png")),
                new ImageIcon(VCorresponsal.class.getResource("/Vista/img/btnCgb.png")),
                panel);
        btnConsignar.setHorizontalAlignment(SwingConstants.CENTER);
        btnConsignar.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
        btnConsignar.setBounds(224, 172, 150, 46);
        panel.add(btnConsignar);

    }

    @Override
    public void configurarPanel() {
        this.setBounds(0, 0, 570, 300);
        this.setVisible(true);
    }
}
