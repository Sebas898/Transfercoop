package Vista;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.CUsuario;
import Modelo.MUsuario;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JTextPane;

public class VUsuario extends JFrame {

	private JPanel contentPane;
	private JLabel fondo;
	private JPanel panel;
	private JLabel imagenUser;
	private JLabel lblNombre;
	private JLabel lblId;
	private JLabel lblFecha;
	private JLabel lblMarca;
	private JPanel barra;
	private JLabel minimizar;
	private JLabel cerrar;
	private int mouseX;
	private int mouseY;
	private JLabel lblDinero;
	private JLabel lblSaldo;
	private JLabel btnRetirar;
	private JTextPane txtFrase;
	private JLabel btnTrasferir;
	private JLabel btnMovimientos;
	public JLabel btnSalir;
	private JLabel Logo;

	public static void main(String[] args) {
		VUsuario v = new VUsuario();
		MUsuario m = new MUsuario();
		CUsuario c = new CUsuario(v, m);
		v.setVisible(true);

	}

	public VUsuario() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setBackground(new Color(1,1,1,0));
		setLocationRelativeTo(null);

		barra = new JPanel();
		barra.setLayout(null);
		barra.setBackground(new Color(25,25,25,0));
		barra.setBounds(10, 11, 800, 32);
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
		
		minimizar = new JLabel();
		minimizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				minimizar.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/minimizarb.png")));
				contentPane.updateUI();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				minimizar.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/minimizara.png")));
				contentPane.updateUI();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setExtendedState(ICONIFIED);
			}
		});
		minimizar.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/minimizara.png")));
		minimizar.setHorizontalAlignment(SwingConstants.CENTER);
		minimizar.setBounds(713, 0, 32, 32);
		
		cerrar = new JLabel();
		cerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				cerrar.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/cerrab.png")));
				contentPane.updateUI();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				cerrar.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/cerraa.png")));
				contentPane.updateUI();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		cerrar.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/cerraa.png")));
		cerrar.setBounds(765, 0, 35, 32);
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128,0));
		panel.setBounds(10, 26, 800, 438);
		panel.setLayout(null);
		
		imagenUser = new JLabel("");
		imagenUser.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/login.png")));
		imagenUser.setBounds(47, 11, 128, 128);
		
		lblNombre = new JLabel("Nombre Apellido");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblNombre.setBounds(0, 232, 231, 27);
		
		lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		lblId.setBounds(77, 285, 66, 21);
		
		lblFecha = new JLabel("DD/MM/AAAA");
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setFont(new Font("Tw Cen MT", Font.ITALIC, 16));
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha.setBounds(0, 345, 231, 21);
		
		lblMarca = new JLabel("SJS \u2122");
		lblMarca.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarca.setForeground(Color.WHITE);
		lblMarca.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		lblMarca.setBounds(0, 390, 231, 21);
		
		lblDinero = new JLabel("$ 99999.99");
		lblDinero.setForeground(Color.BLACK);
		lblDinero.setHorizontalAlignment(SwingConstants.CENTER);
		lblDinero.setFont(new Font("Tw Cen MT", Font.BOLD, 30));
		lblDinero.setBounds(431, 186, 144, 33);
		
		txtFrase = new JTextPane();
		txtFrase.setText("\"Habia una vez un pollito que respiraba por el culo, se sento y se murio\"\r\n-Alguien que vio el pollito murirse...");
		txtFrase.setForeground(Color.WHITE);
		txtFrase.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		txtFrase.setBackground(new Color(32, 178, 170,0));
		txtFrase.setBounds(10, 138, 210, 96);
		
		lblSaldo = new JLabel("Saldo");
		lblSaldo.setForeground(Color.BLACK);
		lblSaldo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaldo.setFont(new Font("Tw Cen MT", Font.BOLD, 28));
		lblSaldo.setBounds(431, 138, 144, 33);
		
		btnRetirar = new JLabel("");
		btnRetirar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRetirar.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/btnRb.png")));
				contentPane.updateUI();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnRetirar.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/btnRa.png")));
				contentPane.updateUI();
			}
		});
		btnRetirar.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/btnRa.png")));
		btnRetirar.setBounds(259, 296, 150, 39);
		
		btnTrasferir = new JLabel("");
		btnTrasferir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnTrasferir.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/btnTb.png")));
				contentPane.updateUI();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnTrasferir.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/btnTa.png")));
				contentPane.updateUI();
			}
		});
		btnTrasferir.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/btnTa.png")));
		btnTrasferir.setBounds(445, 296, 150, 39);
		
		btnMovimientos = new JLabel("");
		btnMovimientos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMovimientos.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/btnMb.png")));
				contentPane.updateUI();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnMovimientos.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/btnMa.png")));
				contentPane.updateUI();
			}
		});
		btnMovimientos.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/btnMa.png")));
		btnMovimientos.setBounds(628, 296, 150, 39);
		
		Logo = new JLabel("");
		Logo.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/LOGO ORIGINAL S M.png")));
		Logo.setBounds(332, 12, 350, 127);
		
		btnSalir = new JLabel("");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSalir.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/btnSb.png")));
				contentPane.updateUI();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSalir.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/btnSa.png")));
				contentPane.updateUI();
			}
		});
		btnSalir.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/btnSa.png")));
		btnSalir.setBounds(628, 388, 150, 39);
		
		fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/fondo_user.png")));
		fondo.setBounds(10, 11, 800, 451);
		
		
		
		//Agregar componentes
		
		barra.add(cerrar);
		barra.add(minimizar);
		contentPane.add(panel);
		panel.add(imagenUser);
		panel.add(lblNombre);
		panel.add(lblId);
		panel.add(lblFecha);
		panel.add(lblMarca);
		panel.add(lblDinero);
		panel.add(txtFrase);
		panel.add(btnTrasferir);
		panel.add(lblSaldo);
		panel.add(btnRetirar);
		panel.add(btnMovimientos);
		panel.add(Logo);
		panel.add(btnSalir);
		contentPane.add(fondo);
	}
}
