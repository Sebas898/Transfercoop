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
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class VCorresponsal extends JFrame {

	private JPanel contentPane;
	private JLabel fondo;
	private JPanel barra;
	private JPanel panelD;
	private JPanel panelI;
	private JPanel panelCg;
	private JTextField textField;
	private JTextField textField_1;
	private JPanel panelCt;
	private JLabel lblMarca;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField txtConsultar;
	private JTextField textField_4;
	private JPanel panelR;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JLabel btnRetirar;
	private JLabel btnConsultar;

	

	public VCorresponsal() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		barra = new JPanel();
		barra.setBounds(0, 0, 800, 36);
		barra.setBackground(new Color(1,1,1,0));
		
		
		panelI = new JPanel();
		panelI.setBounds(0, 36, 230, 414);
		panelI.setBackground(new Color(1,1,1,0));
		
		panelD = new JPanel();
		panelD.setBounds(230, 36, 570, 414);
		panelD.setBackground(new Color(1,1,1,0));
		panelCg.setBounds(panelD.getBounds());
		panelR.setBounds(panelD.getBounds());
		contentPane.add(panelD);
		panelD.setLayout(null);
		
		JLabel btnConsignar = new JLabel("Consignar");
		btnConsignar.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
		btnConsignar.setHorizontalAlignment(SwingConstants.CENTER);
		btnConsignar.setBounds(66, 198, 104, 27);
		panelD.add(btnConsignar);
		
		btnRetirar = new JLabel("Retirar");
		btnRetirar.setHorizontalAlignment(SwingConstants.CENTER);
		btnRetirar.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
		btnRetirar.setBounds(221, 198, 104, 27);
		panelD.add(btnRetirar);
		
		btnConsultar = new JLabel("Consulta");
		btnConsultar.setHorizontalAlignment(SwingConstants.CENTER);
		btnConsultar.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
		btnConsultar.setBounds(393, 198, 104, 27);
		panelD.add(btnConsultar);
		
		JLabel btnSalir = new JLabel("Salir");
		btnSalir.setHorizontalAlignment(SwingConstants.CENTER);
		btnSalir.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
		btnSalir.setBounds(411, 362, 104, 27);
		panelD.add(btnSalir);
		panelCt.setBounds(panelD.getBounds());
		
		panelR = new JPanel();
		contentPane.add(panelR);
		panelR.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Retirar");
		lblNewLabel_2.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(250, 145, 67, 27);
		panelR.add(lblNewLabel_2);
		
		JLabel lblID = new JLabel("ID");
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setForeground(Color.BLACK);
		lblID.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
		lblID.setBounds(16, 192, 137, 27);
		panelR.add(lblID);
		
		JLabel lblContrasena = new JLabel("Monto");
		lblContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasena.setForeground(Color.BLACK);
		lblContrasena.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
		lblContrasena.setBounds(16, 230, 137, 27);
		panelR.add(lblContrasena);
		
		JLabel lblMonto = new JLabel("Contrase\u00F1a");
		lblMonto.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonto.setForeground(Color.BLACK);
		lblMonto.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
		lblMonto.setBounds(16, 268, 137, 27);
		panelR.add(lblMonto);
		
		JLabel btnVolver = new JLabel("Volver");
		btnVolver.setHorizontalAlignment(SwingConstants.CENTER);
		btnVolver.setForeground(Color.BLACK);
		btnVolver.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
		btnVolver.setBounds(406, 365, 137, 27);
		panelR.add(btnVolver);
		
		textField_5 = new JTextField();
		textField_5.setBorder(null);
		textField_5.setBackground(Color.LIGHT_GRAY);
		textField_5.setFont(new Font("Tw Cen MT", Font.PLAIN, 24));
		textField_5.setBounds(178, 192, 220, 27);
		panelR.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBorder(null);
		textField_6.setBackground(Color.LIGHT_GRAY);
		textField_6.setFont(new Font("Tw Cen MT", Font.PLAIN, 24));
		textField_6.setColumns(10);
		textField_6.setBounds(178, 230, 220, 27);
		panelR.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setBorder(null);
		textField_7.setBackground(Color.LIGHT_GRAY);
		textField_7.setFont(new Font("Tw Cen MT", Font.PLAIN, 24));
		textField_7.setColumns(10);
		textField_7.setBounds(178, 268, 220, 27);
		panelR.add(textField_7);
		
		JLabel btnRetirar = new JLabel("Retirar");
		btnRetirar.setHorizontalAlignment(SwingConstants.CENTER);
		btnRetirar.setForeground(Color.BLACK);
		btnRetirar.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
		btnRetirar.setBounds(250, 312, 67, 27);
		panelR.add(btnRetirar);
		
		panelCg = new JPanel();
		
		contentPane.add(panelCg);
		panelCg.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Consignar");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
		lblNewLabel_1.setBounds(250, 141, 103, 27);
		panelCg.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("ID");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
		lblNewLabel_1_1.setBounds(117, 192, 103, 27);
		panelCg.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Monto");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
		lblNewLabel_1_2.setBounds(117, 230, 103, 27);
		panelCg.add(lblNewLabel_1_2);
		
		textField = new JTextField();
		textField.setBorder(null);
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setForeground(Color.BLACK);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tw Cen MT", Font.PLAIN, 22));
		textField.setBounds(230, 199, 214, 20);
		panelCg.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBorder(null);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setForeground(Color.BLACK);
		textField_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 22));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.LIGHT_GRAY);
		textField_1.setBounds(230, 237, 214, 20);
		panelCg.add(textField_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Consignar");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
		lblNewLabel_1_3.setBounds(250, 292, 103, 27);
		panelCg.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Volver");
		lblNewLabel_1_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3_1.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
		lblNewLabel_1_3_1.setBounds(438, 365, 103, 27);
		panelCg.add(lblNewLabel_1_3_1);
		
		JLabel Logo = new JLabel("");
		Logo.setIcon(new ImageIcon(VCorresponsal.class.getResource("/Vista/img/LOGO ORIGINAL S M.png")));
		Logo.setBounds(340, 20, 350, 127);
		contentPane.add(Logo);
		
		contentPane.add(barra);
		contentPane.add(panelI);
		panelI.setLayout(null);
		
		JLabel imagenUser = new JLabel("");
		imagenUser.setIcon(new ImageIcon(VCorresponsal.class.getResource("/Vista/img/login.png")));
		imagenUser.setBounds(50, 0, 128, 114);
		panelI.add(imagenUser);
		
		JLabel lblNombre = new JLabel();
		lblNombre.setText("Nombre Apellido");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblNombre.setBounds(1, 111, 229, 27);
		panelI.add(lblNombre);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		lblId.setBounds(0, 149, 230, 21);
		panelI.add(lblId);
		
		JTextPane txtFrase = new JTextPane();
		txtFrase.setText("\"Habia una vez un pollito que respiraba por el culo, se sento y se murio\"\r\n-Alguien que vio el pollito murirse...");
		txtFrase.setForeground(Color.WHITE);
		txtFrase.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		txtFrase.setEditable(false);
		txtFrase.setBackground(new Color(32, 178, 170, 0));
		txtFrase.setBounds(11, 192, 209, 96);
		panelI.add(txtFrase);
		
		JLabel lblFecha = new JLabel("DD/MM/AAAA");
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
		
		fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(VCorresponsal.class.getResource("/Vista/img/fondo_user.png")));
		fondo.setBounds(0, 0, 800, 451);
		
		
		
		contentPane.add(fondo);
		
		panelCt = new JPanel();
		panelCt.setBackground(Color.WHITE);
		contentPane.add(panelCt);
		panelCt.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Consultar");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(225, 132, 114, 29);
		panelCt.add(lblNewLabel);
		
		JLabel lblId_1 = new JLabel("ID");
		lblId_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblId_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblId_1.setBounds(52, 178, 142, 29);
		panelCt.add(lblId_1);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblContrasea.setBounds(52, 223, 142, 29);
		panelCt.add(lblContrasea);
		
		textField_2 = new JTextField();
		textField_2.setBackground(Color.LIGHT_GRAY);
		textField_2.setBorder(null);
		textField_2.setBounds(219, 183, 216, 30);
		panelCt.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBackground(Color.LIGHT_GRAY);
		textField_3.setBorder(null);
		textField_3.setColumns(10);
		textField_3.setBounds(219, 223, 216, 30);
		panelCt.add(textField_3);
		
		txtConsultar = new JTextField();
		txtConsultar.setBorder(null);
		txtConsultar.setHorizontalAlignment(SwingConstants.CENTER);
		txtConsultar.setFont(new Font("Tahoma", Font.BOLD, 24));
		txtConsultar.setText("Consultar");
		txtConsultar.setColumns(10);
		txtConsultar.setBounds(219, 284, 153, 30);
		panelCt.add(txtConsultar);
		
		textField_4 = new JTextField();
		textField_4.setBorder(null);
		textField_4.setText("Consultar");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 24));
		textField_4.setColumns(10);
		textField_4.setBounds(390, 361, 153, 30);
		panelCt.add(textField_4);
		
	}
}
