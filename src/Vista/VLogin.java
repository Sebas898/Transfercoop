package Vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VLogin extends JFrame {

	private JPanel contentPane;
	private JPanel barra;
	public JTextField username;
	public JPasswordField password;
	private JLabel lblUsername;
	private JLabel lblPassword;
	public JLabel login;
	private JLabel lblLogo;
	private JLabel lblLogin;
	private JLabel fondo;
	private JLabel cerrar;
	private JLabel minimizar;
	private JLabel creador;
	private int mouseX;
	private int mouseY;
	public JLabel registrate;

	
	public VLogin() {

		// Crear componentes
		
		setSize(400, 420);
		setTitle("Login");
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setFocusable(true);

		contentPane.setBackground(new Color(1, 1, 1, 0));
		setBackground(new Color(1, 1, 1, 0));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		barra = new JPanel();

		barra.setBounds(10, 11, 380, 32);
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

		lblUsername = new JLabel("Username:");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		lblUsername.setBounds(40, 205, 86, 20);

		lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		lblPassword.setBounds(40, 243, 86, 18);

		username = new JTextField();
		username.setForeground(Color.WHITE);
		username.setBackground(new Color(1, 1, 1, 0));
		username.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		username.setBounds(136, 205, 200, 22);
		username.setBorder(null);
		username.setCaretColor(Color.white);
		username.setColumns(10);
		username.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (c < '0' || c > '9')
					e.consume();
				contentPane.updateUI();
			}
		});
		username.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				contentPane.updateUI();
			}
		});

		password = new JPasswordField();
		password.setFont(new Font("Tahoma", Font.PLAIN, 18));
		password.setForeground(Color.WHITE);
		password.setBackground(new Color(1, 1, 1, 0));
		password.setBounds(136, 242, 200, 20);
		password.setBorder(null);
		password.setCaretColor(Color.white);
		password.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				contentPane.updateUI();
			}
		});
		password.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				contentPane.updateUI();
			}
		});

		login = new JLabel("");
		login.setIcon(new ImageIcon(VLogin.class.getResource("/Vista/img/btnLogin.png")));
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				login.setCursor(new Cursor(Cursor.HAND_CURSOR));
				login.setIcon(new ImageIcon(VLogin.class.getResource("/Vista/img/btnLogin2.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				login.setCursor(new Cursor(Cursor.HAND_CURSOR));
				login.setIcon(new ImageIcon(VLogin.class.getResource("/Vista/img/btnLogin.png")));

			}
		});
		login.setHorizontalAlignment(SwingConstants.CENTER);
		login.setForeground(Color.WHITE);
		login.setBackground(new Color(50, 205, 50));
		login.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		login.setBounds(125, 286, 150, 39);

		lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon(VLogin.class.getResource("/Vista/img/LOGO PEQUENO.png")));
		lblLogo.setBounds(29, 54, 342, 78);

		lblLogin = new JLabel("Hola bienvenido a Transfercoop");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Tw Cen MT", Font.BOLD, 22));
		lblLogin.setBounds(22, 143, 355, 32);

		fondo = new JLabel("");
		fondo.setHorizontalAlignment(SwingConstants.CENTER);
		fondo.setIcon(new ImageIcon(VLogin.class.getResource("/Vista/img/FONDO1.png")));
		fondo.setBounds(0, 0, 400, 420);

		creador = new JLabel("Creado por SJS\u2122");
		creador.setForeground(Color.WHITE);
		creador.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		creador.setHorizontalAlignment(SwingConstants.CENTER);
		creador.setBounds(10, 390, 380, 14);

		cerrar = new JLabel();
		cerrar.setIcon(new ImageIcon(VLogin.class.getResource("/Vista/img/cerraa.png")));
		cerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    
			    dispose();
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
		cerrar.setBounds(345, 0, 35, 32);

		minimizar = new JLabel();
		minimizar.setIcon(new ImageIcon(VLogin.class.getResource("/Vista/img/minimizara.png")));
		minimizar.setHorizontalAlignment(SwingConstants.CENTER);
		minimizar.setBounds(303, 0, 32, 32);
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
		
		
		barra.add(minimizar);
		barra.add(cerrar);
		
		registrate = new JLabel("!!! Registrate aqui \u00A1\u00A1\u00A1");
		registrate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(HAND_CURSOR);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(DEFAULT_CURSOR);
			}
		});
		registrate.setHorizontalAlignment(SwingConstants.CENTER);
		registrate.setForeground(Color.WHITE);
		registrate.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 18));
		registrate.setBounds(108, 346, 183, 21);
		contentPane.add(registrate);

		// Agregar componentes
		contentPane.add(creador);
		contentPane.add(lblUsername);
		contentPane.add(username);
		contentPane.add(password);
		contentPane.add(lblPassword);
		contentPane.add(login);
		contentPane.add(lblLogin);
		contentPane.add(barra);
		contentPane.add(lblLogo);
		contentPane.add(fondo);

	}
}
