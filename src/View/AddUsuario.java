package View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Clases.Parque;

import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddUsuario {

	private JFrame frame;
	private Parque p;
	private JTextField Name;
	private JTextField Edad;
	private JTextField Estatura;
	private JTextField CC;
	private JTextField Money;
	private String nombre;
	private String cc;
	private double estatura;
	private double dinero;
	private int edad;

	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//
	//		EventQueue.invokeLater(new Runnable() {
	//			public void run() {
	//				try {
	//					AddUsuario window = new AddUsuario();
	//					window.frame.setVisible(true);
	//				} catch (Exception e) {
	//					e.printStackTrace();
	//				}
	//			}
	//		});
	//	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public Parque getP() {
		return p;
	}

	public void setP(Parque p) {
		this.p = p;
	}

	/**
	 * Create the application.
	 */
	public AddUsuario(Parque a) {
		this.p=a;
		initialize();		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblUsuario = new JLabel("Registro de Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setBounds(98, 0, 220, 34);
		frame.getContentPane().add(lblUsuario);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombre.setBounds(58, 47, 79, 19);
		frame.getContentPane().add(lblNombre);

		Name = new JTextField();
		Name.setBounds(179, 47, 176, 22);
		frame.getContentPane().add(Name);
		Name.setColumns(10);

		JLabel lblCC = new JLabel("CC");
		lblCC.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCC.setBounds(58, 82, 56, 16);
		frame.getContentPane().add(lblCC);

		CC = new JTextField();
		CC.setBounds(179, 82, 176, 22);
		frame.getContentPane().add(CC);
		CC.setColumns(10);

		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEdad.setBounds(58, 117, 56, 16);
		frame.getContentPane().add(lblEdad);

		Edad = new JTextField();
		Edad.setBounds(179, 117, 176, 22);
		frame.getContentPane().add(Edad);
		Edad.setColumns(10);

		JLabel lblEstatura = new JLabel("Estatura (m)");
		lblEstatura.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEstatura.setBounds(54, 158, 113, 16);
		frame.getContentPane().add(lblEstatura);

		Estatura = new JTextField();
		Estatura.setBounds(179, 152, 176, 22);
		frame.getContentPane().add(Estatura);
		Estatura.setColumns(10);

		JLabel lblDinero = new JLabel("Dinero");
		lblDinero.setHorizontalAlignment(SwingConstants.LEFT);
		lblDinero.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDinero.setBounds(58, 193, 113, 16);
		frame.getContentPane().add(lblDinero);

		Money = new JTextField();
		Money.setColumns(10);
		Money.setBounds(179, 187, 176, 22);
		frame.getContentPane().add(Money);

		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int validar = JOptionPane.showConfirmDialog(null,"¿Está seguro de que la información es correcta?");
				if (validar == 0) {
					//p.addVisitante(Name.getName(), CC.getText(), Double.parseDouble(Estatura.getText()),Double.parseDouble(Money.getText()),Integer.parseInt(Edad.getText()));
					nombre=Name.getText();
					cc=CC.getText();
					estatura=Double.parseDouble(Estatura.getText());
					dinero=Double.parseDouble(Money.getText());
					edad=Integer.parseInt(Edad.getText());
					if(p.addVisitante(nombre, cc, estatura, dinero,edad)) {
						p.actualizarFichero();
						JOptionPane.showMessageDialog(null, "Creado Satisfactoriamente");
						frame.dispose();
						CategoriaBoleta c=new CategoriaBoleta(p.getVisitantes()[p.getVisitantes().length-1], p);
						c.getFrame().setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "No se pudo crear el usuario");
					}
				}else {
					JOptionPane.showConfirmDialog(null, "Error");
				}
			}
		});
		btnContinuar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnContinuar.setBounds(164, 228, 97, 25);
		frame.getContentPane().add(btnContinuar);

		JButton btnReturn = new JButton("");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PrincipalVisitante pv=new PrincipalVisitante(p);
				pv.getFrame().setVisible(true);
			}
		});

		btnReturn.setBounds(0, 219, 39, 34);
		ImageIcon icon=new ImageIcon("src\\Iconos\\back.png");
		Icon iconoSalir=new ImageIcon(icon.getImage().getScaledInstance(btnReturn.getWidth(),btnReturn.getHeight(), Image.SCALE_DEFAULT));
		btnReturn.setIcon(iconoSalir);
		btnReturn.setBounds(0, 213, 48, 40);
		frame.getContentPane().add(btnReturn);
	}
}
