package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
	private JLabel lblNewLabel;
	private JLabel lblNombre;
	private JLabel lblId;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JPanel barra;
	private JLabel minimizar;
	private JLabel cerrar;
	private int mouseX;
	private int mouseY;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	
	public static void main(String[] args) {
		VUsuario frame = new VUsuario();
		frame.setVisible(true);
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
		barra.add(minimizar);
		
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
		barra.add(cerrar);
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128,0));
		panel.setBounds(10, 42, 800, 422);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/login.png")));
		lblNewLabel.setBounds(47, 11, 128, 128);
		panel.add(lblNewLabel);
		
		lblNombre = new JLabel("Nombre Apellido");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblNombre.setBounds(0, 232, 231, 27);
		panel.add(lblNombre);
		
		lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		lblId.setBounds(77, 285, 66, 21);
		panel.add(lblId);
		
		lblNewLabel_1 = new JLabel("DD/MM/AAAA");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.ITALIC, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 345, 231, 21);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("SJS \u2122");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(0, 390, 231, 21);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("$ 99999.99");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tw Cen MT", Font.BOLD, 30));
		lblNewLabel_3.setBounds(432, 167, 144, 33);
		panel.add(lblNewLabel_3);
		
		JTextPane txtpnhabiaUnaVez = new JTextPane();
		txtpnhabiaUnaVez.setText("\"Habia una vez un pollito que respiraba por el culo, se sento y se murio\"\r\n-Alguien que vio el pollito murirse...");
		txtpnhabiaUnaVez.setForeground(Color.WHITE);
		txtpnhabiaUnaVez.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		txtpnhabiaUnaVez.setBackground(new Color(32, 178, 170,0));
		txtpnhabiaUnaVez.setBounds(10, 138, 207, 75);
		panel.add(txtpnhabiaUnaVez);
		
		lblNewLabel_4 = new JLabel("Saldo");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tw Cen MT", Font.BOLD, 28));
		lblNewLabel_4.setBounds(432, 119, 144, 33);
		panel.add(lblNewLabel_4);
		
		fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(VUsuario.class.getResource("/Vista/img/fondo_user.png")));
		fondo.setBounds(10, 11, 800, 451);
		contentPane.add(fondo);
	}
}
