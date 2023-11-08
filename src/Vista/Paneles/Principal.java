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

import java.awt.Color;

public class Principal extends JPanel implements PanelInterface {

    private static final long serialVersionUID = 1L;

    public BotonSimulado btnConsignar;
    public BotonSimulado btnRetirar;
    public BotonSimulado btnConsultar;
    public BotonSimulado btnVolver;
    private JLabel lbl_Saldo_t;
    public JLabel lbl_Saldo;
    public Consultar PConsultar;
    public Retirar PRetirar;
    public Consignar PConsignar;
    
    
    public Principal(VCorresponsal corresponsal) {

        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 570, 300);
        add(panel);
        panel.setLayout(null);
        
        
        PRetirar = new Retirar(corresponsal);
        PConsultar = new Consultar(corresponsal);
        PConsignar = new Consignar(corresponsal);
        

        btnConsignar = new BotonSimulado(new ImageIcon(VCorresponsal.class.getResource("/Vista/img/btnCga.png")),
                new ImageIcon(VCorresponsal.class.getResource("/Vista/img/btnCgb.png")),
                panel);
        btnConsignar.setHorizontalAlignment(SwingConstants.CENTER);
        btnConsignar.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
        btnConsignar.setBounds(23, 156, 150, 39);
        btnConsignar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Consignar P");
                setVisible(false);
                PConsignar.setVisible(true);
                corresponsal.colocarPanel(PConsignar);
            }
        });
        panel.add(btnConsignar);

        btnRetirar = new BotonSimulado(new ImageIcon(VCorresponsal.class.getResource("/Vista/img/btnRa.png")),
                new ImageIcon(VCorresponsal.class.getResource("/Vista/img/btnRb.png")),
                panel);
        btnRetirar.setHorizontalAlignment(SwingConstants.CENTER);
        btnRetirar.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
        btnRetirar.setBounds(213, 156, 150, 39);
        btnRetirar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                PRetirar.setVisible(true);
                corresponsal.colocarPanel(PRetirar);
            }
        });
        panel.add(btnRetirar);

        btnConsultar = new BotonSimulado(new ImageIcon(VCorresponsal.class.getResource("/Vista/img/btnCta.png")),
                new ImageIcon(VCorresponsal.class.getResource("/Vista/img/btnCtb.png")),
                panel);
        btnConsultar.setHorizontalAlignment(SwingConstants.CENTER);
        btnConsultar.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
        btnConsultar.setBounds(394, 156, 150, 39);
        btnConsultar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                PConsultar.setVisible(true);
                corresponsal.colocarPanel(PConsultar);
            }
        });
        panel.add(btnConsultar);

        btnVolver = new BotonSimulado(new ImageIcon(VCorresponsal.class.getResource("/Vista/img/btnVlvrb.png")),
                new ImageIcon(VCorresponsal.class.getResource("/Vista/img/btnVlvra.png")),
                panel);
        btnVolver.setHorizontalAlignment(SwingConstants.CENTER);
        btnVolver.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
        btnVolver.setBounds(410, 250, 150, 39);
        panel.add(btnVolver);

        lbl_Saldo_t = new JLabel("Cupo Disponible");
        lbl_Saldo_t.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_Saldo_t.setFont(new Font("Tw Cen MT", Font.BOLD, 32));
        lbl_Saldo_t.setBounds(120, 11, 318, 39);
        panel.add(lbl_Saldo_t);

        lbl_Saldo = new JLabel("$00000");
        lbl_Saldo.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_Saldo.setFont(new Font("Tw Cen MT", Font.BOLD, 32));
        lbl_Saldo.setBounds(120, 83, 318, 39);
        panel.add(lbl_Saldo);

    }

    @Override
    public void configurarPanel() {
        // TODO Auto-generated method stub
        this.setBounds(0, 0, 570, 300);
        this.setVisible(true);
    }

}
