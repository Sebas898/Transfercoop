package Vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class VUsuario extends JFrame {

	private JPanel contentPane;
	public JLabel btnVolverM;
	private int mouseX;
	private int mouseY;
	private JPanel panelD;
	private JLabel imagenUser;
	public JTextPane txtFrase;
	public JLabel lblId;
	public JLabel lblFecha;
	public JLabel lblNombre;
	private JLabel lblMarca;
	private JPanel barra;
	public JLabel cerrar;
	private JLabel minimizar;
	public JPanel panelP;
	public JLabel lblDinero;
	public JLabel btnTrasferir;
	private JLabel lblSaldo;
	public JLabel btnMovimientos;
	public JLabel btnSalir;
	public JPanel panel;
	private JLabel fondo;
	public JPanel panelT;
	public JTextField id;
	public JTextField monto;
	public JLabel btnTrasferirT;
	private JLabel lblIdEnvio;
	private JLabel lblMonto;
	private JLabel lblTransferir;
	private JLabel Logo;
	public JLabel btnVolverT;
	public JTable table;
	public JPanel panelM;
	JLabel lblMovimientos;
	public JLabel lblApellido;
	private JScrollPane scrollPane;
	private Icon currentImage;

	
//	public static void main(String[] args) {
//		VUsuario v = new VUsuario();
//		MUsuario m = new MUsuario();
//		MLogin mLogin = new MLogin();
//		CUsuario c = new CUsuario(v, m, mLogin);
//		v.setVisible(true);
//	}
	

	
	public VUsuario() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 805, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setBackground(new Color(1,1,1,0));
		setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(1, 1, 1,0));
		panel.setBounds(0, 0, 800, 453);
		contentPane.add(panel);
		panel.setLayout(null);
		
		panelT = new JPanel();
		panelT.setVisible(false);
		
		panelM = new JPanel();
		panelM.setVisible(false);
		panelM.setBounds(229, 36, 571, 417);
		panelM.setBackground(new Color(0,0,0,0));
		panel.add(panelM);
		panelM.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setForeground(Color.BLACK);
		scrollPane.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		scrollPane.setBorder(null);
		scrollPane.setBounds(58, 164, 475, 186);
		panelM.add(scrollPane);
		
		table = new JTable();
		table.setBorder(null);
		table.setForeground(Color.BLACK);
		table.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		
		lblMovimientos = new JLabel("Movimientos");
		lblMovimientos.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovimientos.setForeground(Color.BLACK);
		lblMovimientos.setFont(new Font("Tw Cen MT", Font.BOLD, 32));
		lblMovimientos.setBounds(182, 101, 192, 33);
		panelM.add(lblMovimientos);
		
		btnVolverM = new JLabel("");
		btnVolverM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnVolverM.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/btnVlvra.png")));
				contentPane.updateUI();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnVolverM.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/btnVlvrb.png")));
				contentPane.updateUI();
			}
		});
		btnVolverM.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/btnVlvrb.png")));
		btnVolverM.setFont(new Font("Tw Cen MT", Font.BOLD, 28));
		btnVolverM.setForeground(Color.BLACK);
		btnVolverM.setHorizontalAlignment(SwingConstants.CENTER);
		btnVolverM.setBounds(411, 367, 150, 39);
		panelM.add(btnVolverM);
		panelT.setBackground(new Color(1, 1, 1,0));
		panelT.setLayout(null);
		panelT.setBounds(229, 36, 571, 417);
		panel.add(panelT);
		
		lblIdEnvio = new JLabel("ID:");
		lblIdEnvio.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdEnvio.setForeground(Color.BLACK);
		lblIdEnvio.setFont(new Font("Tw Cen MT", Font.BOLD, 28));
		lblIdEnvio.setBounds(52, 190, 144, 33);
		panelT.add(lblIdEnvio);
		
		lblMonto = new JLabel("Monto:");
		lblMonto.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonto.setForeground(Color.BLACK);
		lblMonto.setFont(new Font("Tw Cen MT", Font.BOLD, 28));
		lblMonto.setBounds(52, 235, 144, 33);
		panelT.add(lblMonto);
		
		id = new JTextField();
		id.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				contentPane.updateUI();
			}
		});
		id.setForeground(Color.BLACK);
		id.setFont(new Font("Tw Cen MT", Font.PLAIN, 28));
		id.setColumns(10);
		id.setCaretColor(Color.BLACK);
		id.setBorder(null);
		id.setBackground(Color.LIGHT_GRAY);
		id.setBounds(214, 200, 200, 22);
		panelT.add(id);
		
		monto = new JTextField();
		monto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				contentPane.updateUI();
			}
		});
		monto.setForeground(Color.BLACK);
		monto.setFont(new Font("Tw Cen MT", Font.PLAIN, 26));
		monto.setColumns(10);
		monto.setCaretColor(Color.BLACK);
		monto.setBorder(null);
		monto.setBackground(Color.LIGHT_GRAY);
		monto.setBounds(214, 245, 200, 22);
		panelT.add(monto);
		
		btnTrasferirT = new JLabel("");
		btnTrasferirT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnTrasferirT.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/btnTb.png")));
				//contentPane.updateUI();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnTrasferirT.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/btnTa.png")));
				//contentPane.updateUI();
			}
		});
		btnTrasferirT.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/btnTa.png")));
		btnTrasferirT.setBounds(214, 309, 150, 39);
		panelT.add(btnTrasferirT);
		
		lblTransferir = new JLabel("Transferir");
		lblTransferir.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransferir.setForeground(Color.BLACK);
		lblTransferir.setFont(new Font("Tw Cen MT", Font.BOLD, 32));
		lblTransferir.setBounds(198, 98, 144, 33);
		panelT.add(lblTransferir);
		
		btnVolverT = new JLabel("");
		btnVolverT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnVolverT.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/btnVlvra.png")));
				contentPane.updateUI();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnVolverT.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/btnVlvrb.png")));
				contentPane.updateUI();
			}
		});
		btnVolverT.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/btnVlvrb.png")));
		btnVolverT.setHorizontalAlignment(SwingConstants.CENTER);
		btnVolverT.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnVolverT.setBounds(411, 367, 150, 39);
		panelT.add(btnVolverT);
		
		panelP = new JPanel();
		panelP.setLayout(null);
		panelP.setBackground(new Color(1, 1, 1,0));
		panelP.setBounds(229, 36, 571, 417);
		panel.add(panelP);
		
		lblDinero = new JLabel("$ 99999.99");
		lblDinero.setHorizontalAlignment(SwingConstants.CENTER);
		lblDinero.setForeground(Color.BLACK);
		lblDinero.setFont(new Font("Tw Cen MT", Font.BOLD, 30));
		lblDinero.setBounds(106, 186, 350, 33);
		panelP.add(lblDinero);
		
		btnTrasferir = new JLabel("");
		btnTrasferir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnTrasferir.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
		btnTrasferir.setBounds(106, 275, 150, 39);
		panelP.add(btnTrasferir);
		
		lblSaldo = new JLabel("Saldo");
		lblSaldo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaldo.setForeground(Color.BLACK);
		lblSaldo.setFont(new Font("Tw Cen MT", Font.BOLD, 28));
		lblSaldo.setBounds(205, 138, 144, 33);
		panelP.add(lblSaldo);
		
		btnMovimientos = new JLabel("");
		currentImage = null;
		btnMovimientos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			    btnMovimientos.setCursor(new Cursor(Cursor.HAND_CURSOR));
				btnMovimientos.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/btnMb.png")));
				contentPane.updateUI();
			}
			
			public void mouseExited(MouseEvent e) {
			    btnMovimientos.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/btnMa.png")));
				contentPane.updateUI();
			}
			
		});
		btnMovimientos.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/btnMa.png")));
		btnMovimientos.setBounds(320, 275, 150, 39);
		panelP.add(btnMovimientos);
		
		btnSalir = new JLabel("");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
		btnSalir.setBounds(411, 367, 150, 39);
		panelP.add(btnSalir);
		
		Logo = new JLabel("");
		Logo.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/LOGO ORIGINAL S M.png")));
		Logo.setBounds(340, 20, 350, 127);
		panel.add(Logo);
		
		barra = new JPanel();
		barra.setBounds(0, 0, 800, 36);
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
		panel.add(barra);
		barra.setLayout(null);
		barra.setBackground(new Color(25, 25, 25, 0));
		
		cerrar = new JLabel();
		cerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				cerrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
				cerrar.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/cerrab.png")));
				contentPane.updateUI();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				cerrar.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/cerraa.png")));
				contentPane.updateUI();
			}
		});
		cerrar.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/cerraa.png")));
		cerrar.setBounds(765, 0, 35, 32);
		barra.add(cerrar);
		
		minimizar = new JLabel();
		minimizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				minimizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
				minimizar.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/minimizara.png")));
				contentPane.updateUI();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				minimizar.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/minimizara.png")));
				contentPane.updateUI();
			}
		});
		minimizar.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/minimizara.png")));
		minimizar.setHorizontalAlignment(SwingConstants.CENTER);
		minimizar.setBounds(713, 0, 32, 32);
		barra.add(minimizar);
		
		panelD = new JPanel();
		panelD.setLayout(null);
		panelD.setBackground(new Color(1, 1, 1, 0));
		panelD.setBounds(0, 36, 229, 417);
		panel.add(panelD);
		
		imagenUser = new JLabel("");
		imagenUser.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/login.png")));
		imagenUser.setBounds(49, 11, 128, 114);
		panelD.add(imagenUser);
		
		txtFrase = new JTextPane();
		txtFrase.setText("\"Habia una vez un pollito que respiraba por el culo, se sento y se murio\"\r\n-Alguien que vio el pollito murirse...");
		txtFrase.setForeground(Color.WHITE);
		txtFrase.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		txtFrase.setBackground(new Color(32, 178, 170, 0));
		txtFrase.setBounds(10, 219, 209, 96);
		txtFrase.setEditable(false);
		StyledDocument doc = txtFrase.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		panelD.add(txtFrase);
		
		lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		lblId.setBounds(0, 187, 230, 21);
		panelD.add(lblId);
		
		lblFecha = new JLabel("DD/MM/AAAA");
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblFecha.setBounds(0, 345, 229, 21);
		panelD.add(lblFecha);
		
		lblNombre = new JLabel();
		lblNombre.setText("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblNombre.setBounds(0, 122, 229, 27);
		panelD.add(lblNombre);
		
		lblMarca = new JLabel("SJS \u2122");
		lblMarca.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarca.setForeground(Color.WHITE);
		lblMarca.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		lblMarca.setBounds(0, 390, 229, 21);
		panelD.add(lblMarca);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblApellido.setBounds(0, 153, 230, 23);
		panelD.add(lblApellido);
		
	
		
		fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/fondo_user.png")));
		fondo.setBounds(0, 0, 800, 451);
		panel.add(fondo);
	}
}
