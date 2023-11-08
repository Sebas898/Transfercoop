package Vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Vista.Componentes.BotonSimulado;
import Vista.Paneles.Consignar;
import Vista.Paneles.Consultar;
import Vista.Paneles.PanelInterface;
import Vista.Paneles.Principal;
import Vista.Paneles.Retirar;

public class VCorresponsal extends JFrame {

    private JPanel contentPane;
    public JPanel barra;
    public JPanel panelI;
    public JLabel lblMarca;
    public JLabel lblId;
    private JLabel Logo;
    public JLabel imagenUser;
    public JLabel lblNombre;
    public JTextPane txtFrase;
    public JLabel lblFecha;
    private JLabel fondo;
    private int mouseX;
    private int mouseY;
    private BotonSimulado cerrar;
    private BotonSimulado minimizar;
    private JPanel panel;
    private PanelInterface PRetirar;
    public PanelInterface PPrincipal;
    private PanelInterface PConsultar;
    private PanelInterface PConsignar;

//    public static void main(String[] args) {
//        VCorresponsal frame = new VCorresponsal();
//        frame.setVisible(true);
//    }

    public VCorresponsal() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setBackground(new Color(64, 224, 208, 0));
        setLocationRelativeTo(null);
        setBounds(100, 100, 800, 450);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 250, 154, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Se crean los paneles
        PPrincipal = new Principal(this);

        Logo = new JLabel("");
        Logo.setIcon(new ImageIcon(VCorresponsal.class.getResource("/Vista/img/LOGO ORIGINAL S M.png")));
        Logo.setBounds(340, 20, 350, 127);
        contentPane.add(Logo);

        barra = new JPanel();
        barra.setBounds(0, 0, 800, 36);
        barra.setBackground(new Color(1, 1, 1, 0));
        barra.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                setLocation(getX() + e.getX() - mouseX, getY() + e.getY() - mouseY);
            }
        });
        barra.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                mouseX = e.getX();
                mouseY = e.getY();

            }
        });

        contentPane.add(barra);
        barra.setLayout(null);

        cerrar = new BotonSimulado(new ImageIcon(VCorresponsal.class.getResource("/Vista/img/cerraa.png")),
                new ImageIcon(VCorresponsal.class.getResource("/Vista/img/cerrab.png")),
                contentPane);
        cerrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
        cerrar.setBounds(758, 0, 32, 32);
        barra.add(cerrar);

        minimizar = new BotonSimulado(new ImageIcon(VCorresponsal.class.getResource("/Vista/img/minimizara.png")),
                new ImageIcon(VCorresponsal.class.getResource("/Vista/img/minimizarb.png")),
                contentPane);
        minimizar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setExtendedState(ICONIFIED);
            }

        });
        minimizar.setBounds(716, 0, 32, 32);
        minimizar.setHorizontalAlignment(SwingConstants.CENTER);
        barra.add(minimizar);

        panelI = new JPanel();
        panelI.setBounds(0, 36, 230, 414);
        panelI.setBackground(new Color(255, 255, 255, 0));
        contentPane.add(panelI);
        panelI.setLayout(null);

        imagenUser = new JLabel("");
        imagenUser.setIcon(new ImageIcon(VCorresponsal.class.getResource("/Vista/img/login.png")));
        imagenUser.setBounds(50, 0, 128, 114);
        panelI.add(imagenUser);

        lblNombre = new JLabel();
        lblNombre.setText("Nombre Apellido");
        lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
        lblNombre.setForeground(Color.WHITE);
        lblNombre.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
        lblNombre.setBounds(1, 111, 229, 27);
        panelI.add(lblNombre);

        lblId = new JLabel("ID");
        lblId.setHorizontalAlignment(SwingConstants.CENTER);
        lblId.setForeground(Color.WHITE);
        lblId.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
        lblId.setBounds(0, 149, 230, 21);
        panelI.add(lblId);

        txtFrase = new JTextPane();
        txtFrase.setText(
                "\"Habia una vez un pollito que respiraba por el culo, se sento y se murio\"\r\n-Alguien que vio el pollito murirse...");
        txtFrase.setForeground(Color.WHITE);
        txtFrase.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
        txtFrase.setEditable(false);
        txtFrase.setBackground(new Color(32, 178, 170, 0));
        txtFrase.setBounds(11, 192, 209, 96);
        panelI.add(txtFrase);

        lblFecha = new JLabel("DD/MM/AAAA");
        lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
        lblFecha.setForeground(Color.WHITE);
        lblFecha.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
        lblFecha.setBounds(1, 334, 229, 21);
        panelI.add(lblFecha);

        lblMarca = new JLabel("SJS \u2122");
        lblMarca.setHorizontalAlignment(SwingConstants.CENTER);
        lblMarca.setForeground(Color.WHITE);
        lblMarca.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
        lblMarca.setBounds(1, 379, 229, 21);
        panelI.add(lblMarca);

        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(230, 130, 570, 320);
        panel.setLayout(null);
        contentPane.add(panel);

        colocarPanel(PPrincipal);
        
        fondo = new JLabel("");
        fondo.setIcon(new ImageIcon(VCorresponsal.class.getResource("/Vista/img/fondo_user.png")));
        fondo.setBounds(0, 0, 800, 451);
        contentPane.add(fondo);

    }

    public void colocarPanel(PanelInterface panelI) {
        panelI.configurarPanel();
        this.panel.add((Component) panelI);
    }

}
