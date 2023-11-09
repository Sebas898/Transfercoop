package Vista.Paneles;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Consulta extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Consulta frame = new Consulta();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private JLabel lblConsulta;
    private JLabel lblNombres;
    public JLabel nombre;
    private JLabel lblSaldo;
    public JLabel saldo;
    private JLabel lblGraciasPorPreferir;
    public JLabel lblDate;
    public Consulta() {
        setType(Type.UTILITY);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 379, 484);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
         lblConsulta = new JLabel("Consulta");
        lblConsulta.setHorizontalAlignment(SwingConstants.CENTER);
        lblConsulta.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
        lblConsulta.setBounds(10, 11, 343, 36);
        contentPane.add(lblConsulta);
        
         lblNombres = new JLabel("Nombres");
        lblNombres.setHorizontalAlignment(SwingConstants.CENTER);
        lblNombres.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
        lblNombres.setBounds(10, 74, 343, 36);
        contentPane.add(lblNombres);
        
         nombre = new JLabel("#############");
        nombre.setHorizontalAlignment(SwingConstants.CENTER);
        nombre.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
        nombre.setBounds(10, 121, 343, 36);
        contentPane.add(nombre);
        
        lblSaldo = new JLabel("Saldo");
        lblSaldo.setHorizontalAlignment(SwingConstants.CENTER);
        lblSaldo.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
        lblSaldo.setBounds(10, 178, 343, 36);
        contentPane.add(lblSaldo);
        
         saldo = new JLabel("#############");
        saldo.setHorizontalAlignment(SwingConstants.CENTER);
        saldo.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
        saldo.setBounds(10, 225, 343, 36);
        contentPane.add(saldo);
        
         lblGraciasPorPreferir = new JLabel("Gracias por preferir Transfercoop");
        lblGraciasPorPreferir.setHorizontalAlignment(SwingConstants.CENTER);
        lblGraciasPorPreferir.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
        lblGraciasPorPreferir.setBounds(10, 326, 343, 36);
        contentPane.add(lblGraciasPorPreferir);
        
         lblDate = new JLabel("####/##/##");
        lblDate.setHorizontalAlignment(SwingConstants.CENTER);
        lblDate.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
        lblDate.setBounds(10, 398, 343, 36);
        contentPane.add(lblDate);
    }

}
