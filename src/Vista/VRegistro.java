package Vista;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import AppPackage.AnimationClass;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;
import rojerusan.RSPanelsSlider;
import rojerusan.RSPanelsSlider.DIRECT;
import com.toedter.components.JLocaleChooser;

public class VRegistro extends JFrame {

	public JPanel contentPane;
	private JLabel fondo;
	private JPanel barra;
	private int mouseX;
	private int mouseY;
	private JLabel cerrar;
	private JLabel minimizar;
	private JLabel logo;
	private JLabel lblSingup;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public JLabel btnNext;
	private JTextField nombre;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JTextField textField;
	private JLabel lblGenero;
	private JTextField textField_1;
	private JRadioButton rbFemenino;
	private JRadioButton rdbtnMasculino;
	private JRadioButton rdbtnOtro;
	private JLabel lblFechaDeNacimiento;
	private JLabel lbl;
	private JLabel lblApellidos_2;
	private JLabel lblApellidos_3;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JLabel lblNewLabel;
	private JDateChooser dateChooser;
	private JTextPane txtpnSiYaEstas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VRegistro frame = new VRegistro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * 
	 */

	

	public VRegistro() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 635);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				contentPane.updateUI();
			}
		});
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		contentPane.setBackground(new Color(1, 1, 1, 0));
		setBackground(new Color(1, 1, 1, 0));

		barra = new JPanel();

		barra.setBounds(10, 10, 700, 32);
		barra.setBackground(new Color(1, 1, 1, 0));
		barra.setLayout(null);
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

		cerrar = new JLabel();
		cerrar.setIcon(new ImageIcon(VLogin.class.getResource("/Vista/img/cerraa.png")));
		cerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				cerrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
				cerrar.setIcon(new ImageIcon(VLogin.class.getResource("/Vista/img/cerrab.png")));
				contentPane.updateUI();

			}

			@Override
			public void mouseExited(MouseEvent e) {
				cerrar.setIcon(new ImageIcon(VLogin.class.getResource("/Vista/img/cerraa.png")));
				contentPane.updateUI();
			}
		});
		cerrar.setBounds(665, 0, 35, 32);

		minimizar = new JLabel();
		minimizar.setIcon(new ImageIcon(VLogin.class.getResource("/Vista/img/minimizara.png")));
		minimizar.setHorizontalAlignment(SwingConstants.CENTER);
		minimizar.setBounds(623, 0, 32, 32);
		minimizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setExtendedState(ICONIFIED);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				minimizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
				minimizar.setIcon(new ImageIcon(VLogin.class.getResource("/Vista/img/minimizarb.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				minimizar.setIcon(new ImageIcon(VLogin.class.getResource("/Vista/img/minimizara.png")));
				contentPane.updateUI();
			}
		});

		logo = new JLabel("");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setIcon(new ImageIcon(VRegistro.class.getResource("/Vista/img/LOGO PEQUE\u00D1O.png")));
		logo.setBounds(479, 37, 231, 80);

		lblSingup = new JLabel("RESGISTRO");
		lblSingup.setForeground(Color.BLACK);
		lblSingup.setFont(new Font("Tw Cen MT", Font.BOLD, 38));
		lblSingup.setHorizontalAlignment(SwingConstants.CENTER);
		lblSingup.setBounds(10, 37, 470, 30);

		btnNext = new JLabel();
		btnNext.setIcon(new ImageIcon(VRegistro.class.getResource("/Vista/img/btnSiginup1.png")));
		btnNext.setHorizontalAlignment(SwingConstants.CENTER);
		btnNext.setBounds(169, 570, 150, 39);

		fondo = new JLabel();
		fondo.setIcon(new ImageIcon(VRegistro.class.getResource("/Vista/img/fondo_singup.png")));
		fondo.setBounds(10, 10, 700, 625);
		
		nombre = new JTextField();
		nombre.setBackground(Color.LIGHT_GRAY);
		nombre.setForeground(Color.BLACK);
		nombre.setFont(new Font("Tw Cen MT", Font.BOLD, 22));
		nombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				contentPane.updateUI();
			}
		});
		nombre.setBorder(null);
		nombre.setBounds(169, 103, 289, 26);
		nombre.setColumns(10);
		
		lblNombre = new JLabel("Nombres:");
		lblNombre.setForeground(Color.BLACK);
		lblNombre.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
		lblNombre.setBounds(30, 99, 98, 27);
		
		
		
		// Agregar componentes

		barra.add(minimizar);
		barra.add(cerrar);
		
		JLabel lblNewLabel_1 = new JLabel("Confirmacion");
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		lblNewLabel_1.setForeground(Color.GREEN);
		lblNewLabel_1.setBounds(198, 524, 118, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblGenero_1 = new JLabel("Genero");
		lblGenero_1.setForeground(Color.BLACK);
		lblGenero_1.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
		lblGenero_1.setBounds(27, 192, 112, 27);
		contentPane.add(lblGenero_1);
		
		txtpnSiYaEstas = new JTextPane();
		txtpnSiYaEstas.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		txtpnSiYaEstas.setBackground(new Color(1, 1, 1,0));
		txtpnSiYaEstas.setText("Si ya estas registrado\r\n        clickea aqui !");
		txtpnSiYaEstas.setForeground(Color.WHITE);
		txtpnSiYaEstas.setBounds(501, 288, 209, 80);
		contentPane.add(txtpnSiYaEstas);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VRegistro.class.getResource("/Vista/img/login.png")));
		lblNewLabel.setBounds(531, 149, 128, 128);
		contentPane.add(lblNewLabel);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBackground(Color.LIGHT_GRAY);
		passwordField_1.setBorder(null);
		passwordField_1.setForeground(Color.BLACK);
		passwordField_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 24));
		passwordField_1.setBounds(198, 487, 257, 27);
		contentPane.add(passwordField_1);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(Color.LIGHT_GRAY);
		passwordField.setBorder(null);
		passwordField.setForeground(Color.BLACK);
		passwordField.setFont(new Font("Tw Cen MT", Font.PLAIN, 24));
		passwordField.setBounds(198, 436, 257, 27);
		contentPane.add(passwordField);
		
		lblApellidos_3 = new JLabel("Confirmar: ");
		lblApellidos_3.setForeground(Color.BLACK);
		lblApellidos_3.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
		lblApellidos_3.setBounds(30, 488, 136, 27);
		contentPane.add(lblApellidos_3);
		
		lbl = new JLabel("Identificacion: ");
		lbl.setForeground(Color.BLACK);
		lbl.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
		lbl.setBounds(30, 382, 150, 27);
		
		
		lblApellidos_2 = new JLabel("Contrase\u00F1a: ");
		lblApellidos_2.setForeground(Color.BLACK);
		lblApellidos_2.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
		lblApellidos_2.setBounds(30, 436, 136, 27);
		
		
		lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setForeground(Color.BLACK);
		lblFechaDeNacimiento.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
		lblFechaDeNacimiento.setBounds(30, 289, 239, 27);

		
		dateChooser = new JDateChooser();
		dateChooser.setForeground(Color.BLACK);
		dateChooser.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		dateChooser.getCalendarButton().setBorder(null);
		dateChooser.getCalendarButton().setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		dateChooser.setBorder(null);
		dateChooser.setBackground(new Color(1,1,1,0));
		dateChooser.setBounds(30, 327, 239, 26);
		
		
		rdbtnOtro = new JRadioButton("Otro");
		rdbtnOtro.setForeground(Color.BLACK);
		buttonGroup.add(rdbtnOtro);
		rdbtnOtro.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		rdbtnOtro.setBackground(new Color(1, 1, 1, 0));
		rdbtnOtro.setBounds(371, 239, 84, 23);
		
		
		rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setForeground(Color.BLACK);
		buttonGroup.add(rdbtnMasculino);
		rdbtnMasculino.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		rdbtnMasculino.setBackground(new Color(1, 1, 1, 0));
		rdbtnMasculino.setBounds(180, 239, 136, 23);
		
		
		rbFemenino = new JRadioButton("Femenino");
		rbFemenino.setForeground(Color.BLACK);
		buttonGroup.add(rbFemenino);
		rbFemenino.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		rbFemenino.setBounds(30, 239, 109, 23);
		rbFemenino.setBackground(new Color(1,1,1,0));
		
		
		textField = new JTextField();
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Tw Cen MT", Font.BOLD, 22));
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBounds(169, 144, 289, 26);
		
		
		textField_1 = new JTextField();
		textField_1.setBackground(Color.LIGHT_GRAY);
		textField_1.setForeground(Color.BLACK);
		textField_1.setFont(new Font("Tw Cen MT", Font.BOLD, 22));
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBounds(198, 383, 260, 26);
	
		
		lblGenero = new JLabel("Genero");
		lblGenero.setForeground(Color.BLACK);
		lblGenero.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
		lblGenero.setBounds(30, 191, 98, 27);
		
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setForeground(Color.BLACK);
		lblApellidos.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
		lblApellidos.setBounds(30, 140, 112, 27);
		
		
		
		contentPane.add(lbl);
		contentPane.add(lblApellidos_2);
		contentPane.add(lblFechaDeNacimiento);
		contentPane.add(dateChooser);
		contentPane.add(rdbtnOtro);
		contentPane.add(rdbtnMasculino);
		contentPane.add(rbFemenino);
		contentPane.add(textField);
		contentPane.add(textField_1);
		contentPane.add(lblApellidos);
		contentPane.add(nombre);
		contentPane.add(lblNombre);
		contentPane.add(barra);
		contentPane.add(lblSingup);
		contentPane.add(logo);
		contentPane.add(btnNext);
		contentPane.add(fondo);
	}
}
