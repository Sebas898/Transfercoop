package Vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class VCorresponsal extends JFrame {

	private JPanel contentPane;
	public JPanel barra;
	public JPanel panelD;
	private JPanel panelI;
	public JPanel panelCg;
	public JPanel panelCt;
	public JPanel panelR;
	public JTextField IDCg;
	public JTextField MontoCg;
	private JLabel lblMarca;
	public JTextField IDCt;
	public JTextField ContrasanaCt;
	public JLabel btnConsultarCt;
	public JLabel btnVolverCt;
	public JTextField IDR;
	public JTextField MONTOR;
	public JTextField CONTRASENAR;
	public JLabel btnRetirarR;
	public JLabel btnRetirar;
	public JLabel btnConsultar;
	private JLabel btnConsignar;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_2;
	private JLabel btnSalir;
	private JLabel lblId_1;
	private JLabel lblId;
	private JLabel lblNewLabel_2;
	private JLabel lblID;
	private JLabel lblContrasena;
	private JLabel lblNewLabel_1_3;
	public JLabel btnVolverR;
	private JLabel lblMonto;
	private JLabel lblNewLabel_1_3_1;
	private JLabel Logo;
	private JLabel imagenUser;
	private JLabel lblNombre;
	private JLabel lblContrasea;
	private JTextPane txtFrase;
	private JLabel lblFecha;
	private JLabel lbl_Saldo_t;
	private JLabel lbl_Saldo;
	private JLabel fondo;
	private int mouseX;
    private int mouseY;
    private JLabel cerrar;
    private JLabel minimizar;
//
//	public static void main(String[] args) {
//		VCorresponsal frame = new VCorresponsal();
//		frame.setVisible(true);
//	}

	

	public VCorresponsal() {
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    setUndecorated(true);
		setBackground(new Color(64, 224, 208,0));
		setLocationRelativeTo(null);
		setBounds(100, 100, 800, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 250, 154,0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Logo = new JLabel("");
		Logo.setIcon(new ImageIcon(VCorresponsal.class.getResource("/Vista/img/LOGO ORIGINAL S M.png")));
		Logo.setBounds(340, 20, 350, 127);
		contentPane.add(Logo);
		
		panelD = new JPanel();
		panelD.setBounds(230, 36, 570, 414);
		panelD.setBackground(Color.WHITE);
		contentPane.add(panelD);
		panelD.setLayout(null);
		
		btnConsignar = new JLabel("");
		btnConsignar.setIcon(new ImageIcon(VCorresponsal.class.getResource("/Vista/img/btnCga.png")));
		btnConsignar.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
		btnConsignar.setHorizontalAlignment(SwingConstants.CENTER);
		btnConsignar.setBounds(26, 283, 150, 39);
		panelD.add(btnConsignar);
		
		btnRetirar = new JLabel("");
		btnRetirar.setIcon(new ImageIcon(VCorresponsal.class.getResource("/Vista/img/btnRa.png")));
		btnRetirar.setHorizontalAlignment(SwingConstants.CENTER);
		btnRetirar.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
		btnRetirar.setBounds(216, 283, 150, 39);
		panelD.add(btnRetirar);
		
		btnConsultar = new JLabel("");
		btnConsultar.setIcon(new ImageIcon(VCorresponsal.class.getResource("/Vista/img/btnCtb.png")));
		btnConsultar.setHorizontalAlignment(SwingConstants.CENTER);
		btnConsultar.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
		btnConsultar.setBounds(397, 283, 150, 39);
		panelD.add(btnConsultar);
		
		btnSalir = new JLabel("");
		btnSalir.setIcon(new ImageIcon(VCorresponsal.class.getResource("/Vista/img/btnSa.png")));
		btnSalir.setHorizontalAlignment(SwingConstants.CENTER);
		btnSalir.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
		btnSalir.setBounds(411, 364, 150, 39);
		panelD.add(btnSalir);
		
		lbl_Saldo_t = new JLabel("Cupo Disponible");
		lbl_Saldo_t.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Saldo_t.setFont(new Font("Tw Cen MT", Font.BOLD, 32));
		lbl_Saldo_t.setBounds(136, 103, 318, 39);
		panelD.add(lbl_Saldo_t);
		
		lbl_Saldo = new JLabel("$00000");
		lbl_Saldo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Saldo.setFont(new Font("Tw Cen MT", Font.BOLD, 32));
		lbl_Saldo.setBounds(136, 153, 318, 39);
		panelD.add(lbl_Saldo);
		
		panelCg = new JPanel();
		panelCg.setVisible(false);
		panelCg.setBounds(230, 36, 570, 414);
		panelCg.setBackground(Color.WHITE);
		
		contentPane.add(panelCg);
		panelCg.setLayout(null);
		
		lblNewLabel_1_1 = new JLabel("ID");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
		lblNewLabel_1_1.setBounds(102, 192, 103, 27);
		panelCg.add(lblNewLabel_1_1);
		
		lblNewLabel_1_2 = new JLabel("Monto");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
		lblNewLabel_1_2.setBounds(102, 230, 103, 27);
		panelCg.add(lblNewLabel_1_2);
		
		IDCg = new JTextField();
		IDCg.setBorder(null);
		IDCg.setBackground(Color.LIGHT_GRAY);
		IDCg.setForeground(Color.BLACK);
		IDCg.setHorizontalAlignment(SwingConstants.CENTER);
		IDCg.setFont(new Font("Tw Cen MT", Font.PLAIN, 22));
		IDCg.setBounds(215, 192, 214, 27);
		panelCg.add(IDCg);
		IDCg.setColumns(10);
		
		MontoCg = new JTextField();
		MontoCg.setBorder(null);
		MontoCg.setHorizontalAlignment(SwingConstants.CENTER);
		MontoCg.setForeground(Color.BLACK);
		MontoCg.setFont(new Font("Tw Cen MT", Font.PLAIN, 22));
		MontoCg.setColumns(10);
		MontoCg.setBackground(Color.LIGHT_GRAY);
		MontoCg.setBounds(215, 230, 214, 27);
		panelCg.add(MontoCg);
		
		lblNewLabel_1_3 = new JLabel("Consignar");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
		lblNewLabel_1_3.setBounds(250, 292, 103, 27);
		panelCg.add(lblNewLabel_1_3);
		
		lblNewLabel_1_3_1 = new JLabel("Volver");
		lblNewLabel_1_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3_1.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
		lblNewLabel_1_3_1.setBounds(438, 365, 103, 27);
		panelCg.add(lblNewLabel_1_3_1);

		
		
		barra = new JPanel();
		barra.setBounds(0, 0, 800, 36);
		barra.setBackground(new Color(1,1,1,0));
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
		
		cerrar = new JLabel();
		cerrar.setIcon(new ImageIcon(VCorresponsal.class.getResource("/Vista/img/cerraa.png")));
		cerrar.addMouseListener(new MouseAdapter() {
		    @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            } 
            @Override
            public void mouseEntered(MouseEvent e) {
                cerrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
                cerrar.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/cerrab.png")));
                contentPane.updateUI();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                cerrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
                cerrar.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/cerraa.png")));
                contentPane.updateUI();
            }
        });
		cerrar.setBounds(758, 0, 32, 32);
		barra.add(cerrar);
		
		minimizar = new JLabel();
		minimizar.setIcon(new ImageIcon(VCorresponsal.class.getResource("/Vista/img/minimizara.png")));
		minimizar.addMouseListener(new MouseAdapter() {
		    @Override
            public void mouseClicked(MouseEvent e) {
                setExtendedState(ICONIFIED);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                minimizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
                minimizar.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/minimizara.png")));
                contentPane.updateUI();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                minimizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
                minimizar.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/minimizara.png")));
                contentPane.updateUI();
            }
        });
		minimizar.setBounds(716, 0, 32, 32);
		minimizar.setHorizontalAlignment(SwingConstants.CENTER);
		barra.add(minimizar);
		
		
		panelI = new JPanel();
		panelI.setBounds(0, 36, 230, 414);
		panelI.setBackground(new Color(255,255,255,0));
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
		txtFrase.setText("\"Habia una vez un pollito que respiraba por el culo, se sento y se murio\"\r\n-Alguien que vio el pollito murirse...");
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
		
		panelCt = new JPanel();
		panelCt.setVisible(false);
		panelCt.setBackground(Color.WHITE);
		panelCt.setBounds(230, 36, 570, 414);
		contentPane.add(panelCt);
		panelCt.setLayout(null);
		
		lblId_1 = new JLabel("ID");
		lblId_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblId_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblId_1.setBounds(52, 178, 142, 29);
		panelCt.add(lblId_1);
		
		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblContrasea.setBounds(52, 223, 142, 29);
		panelCt.add(lblContrasea);
		
		IDCt = new JTextField();
		IDCt.setBackground(Color.LIGHT_GRAY);
		IDCt.setBorder(null);
		IDCt.setBounds(219, 183, 216, 30);
		panelCt.add(IDCt);
		IDCt.setColumns(10);
		
		ContrasanaCt = new JTextField();
		ContrasanaCt.setBackground(Color.LIGHT_GRAY);
		ContrasanaCt.setBorder(null);
		ContrasanaCt.setColumns(10);
		ContrasanaCt.setBounds(219, 223, 216, 30);
		panelCt.add(ContrasanaCt);
		
		btnConsultarCt = new JLabel();
		btnConsultarCt.setBorder(null);
		btnConsultarCt.setHorizontalAlignment(SwingConstants.CENTER);
		btnConsultarCt.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnConsultarCt.setText("Consultar");
		btnConsultarCt.setBounds(219, 284, 153, 30);
		panelCt.add(btnConsultarCt);
		
		btnVolverCt = new JLabel();
		btnVolverCt.setBorder(null);
		btnVolverCt.setText("Volver");
		btnVolverCt.setHorizontalAlignment(SwingConstants.CENTER);
		btnVolverCt.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnVolverCt.setBounds(390, 361, 153, 30);
		panelCt.add(btnVolverCt);
		
		panelR = new JPanel();
		panelR.setVisible(false);
		panelR.setBackground(Color.WHITE);
		panelR.setBounds(230, 36, 570, 414);
		contentPane.add(panelR);
		panelR.setLayout(null);
		
		lblNewLabel_2 = new JLabel("Retirar");
		lblNewLabel_2.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(250, 145, 67, 27);
		panelR.add(lblNewLabel_2);
		
		lblID = new JLabel("ID");
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setForeground(Color.BLACK);
		lblID.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
		lblID.setBounds(16, 192, 137, 27);
		panelR.add(lblID);
		
		lblContrasena = new JLabel("Monto");
		lblContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasena.setForeground(Color.BLACK);
		lblContrasena.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
		lblContrasena.setBounds(16, 230, 137, 27);
		panelR.add(lblContrasena);
		
		lblMonto = new JLabel("Contrase\u00F1a");
		lblMonto.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonto.setForeground(Color.BLACK);
		lblMonto.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
		lblMonto.setBounds(16, 268, 137, 27);
		panelR.add(lblMonto);
		
		btnVolverR = new JLabel("Volver");
		btnVolverR.setHorizontalAlignment(SwingConstants.CENTER);
		btnVolverR.setForeground(Color.BLACK);
		btnVolverR.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
		btnVolverR.setBounds(406, 365, 137, 27);
		panelR.add(btnVolverR);
		
		IDR = new JTextField();
		IDR.setBorder(null);
		IDR.setBackground(Color.LIGHT_GRAY);
		IDR.setFont(new Font("Tw Cen MT", Font.PLAIN, 24));
		IDR.setBounds(178, 192, 220, 27);
		panelR.add(IDR);
		IDR.setColumns(10);
		
		MONTOR = new JTextField();
		MONTOR.setBorder(null);
		MONTOR.setBackground(Color.LIGHT_GRAY);
		MONTOR.setFont(new Font("Tw Cen MT", Font.PLAIN, 24));
		MONTOR.setColumns(10);
		MONTOR.setBounds(178, 230, 220, 27);
		panelR.add(MONTOR);
		
		CONTRASENAR = new JTextField();
		CONTRASENAR.setBorder(null);
		CONTRASENAR.setBackground(Color.LIGHT_GRAY);
		CONTRASENAR.setFont(new Font("Tw Cen MT", Font.PLAIN, 24));
		CONTRASENAR.setColumns(10);
		CONTRASENAR.setBounds(178, 268, 220, 27);
		panelR.add(CONTRASENAR);
		
		btnRetirarR = new JLabel("Retirar");
		btnRetirarR.setHorizontalAlignment(SwingConstants.CENTER);
		btnRetirarR.setForeground(Color.BLACK);
		btnRetirarR.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
		btnRetirarR.setBounds(250, 312, 67, 27);
		panelR.add(btnRetirarR);
		
		fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(VCorresponsal.class.getResource("/Vista/img/fondo_user.png")));
		fondo.setBounds(0, 0, 800, 451);
		contentPane.add(fondo);
		
	}
}
