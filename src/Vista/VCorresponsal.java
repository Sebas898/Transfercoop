package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class VCorresponsal extends JFrame {

	private JPanel contentPane;
	private JLabel fondo;
	private JPanel barra;
	private JPanel panelD;
	private JPanel panelI;
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public VCorresponsal() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(VCorresponsal.class.getResource("/Vista/img/fondo_user.png")));
		fondo.setBounds(0, 0, 800, 451);
		
		
		barra = new JPanel();
		barra.setBounds(0, 0, 800, 36);
		
		
		panelD = new JPanel();
		panelD.setBounds(230, 36, 570, 414);
		
		
		panelI = new JPanel();
		panelI.setBounds(0, 36, 230, 414);
		
		
		
		contentPane.add(fondo);
		contentPane.add(barra);
		contentPane.add(panelD);
		contentPane.add(panelI);
		
	}
}
