package View;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;

import Clases.Parque;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class AddTienda {

	private JFrame frame;
	private Parque p;
	private JTextField Nombre;
	private JTextField Admin;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Parque p=new Parque();
					AddTienda window = new AddTienda(p.leerFihero());
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Create the application.
	 */
	public AddTienda(Parque p) {
		this.p=p;
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
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(53, 47, 60, 14);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblAdmin = new JLabel("Admin:");
		lblAdmin.setBounds(53, 72, 46, 14);
		frame.getContentPane().add(lblAdmin);
		
		JLabel lblClave = new JLabel("Clave:");
		lblClave.setBounds(53, 98, 46, 14);
		frame.getContentPane().add(lblClave);
		
		Nombre = new JTextField();
		Nombre.setBounds(123, 47, 86, 20);
		frame.getContentPane().add(Nombre);
		Nombre.setColumns(10);
		
		Admin = new JTextField();
		Admin.setBounds(123, 70, 86, 20);
		frame.getContentPane().add(Admin);
		Admin.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(123, 95, 86, 20);
		frame.getContentPane().add(passwordField);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre=Nombre.getText();
				String admin=Admin.getText();
				String pass=passwordField.getText();
				if(nombre.compareTo("")!=0 && admin.compareTo("")!=0 && pass.compareTo("")!=0) {
					if(p.buscarTienda(nombre)==null) {
						if(p.addTienda( nombre, admin, pass)) {
							p.actualizarFichero();
							JOptionPane.showMessageDialog(null, "Se agrego la tienda Satisfactoriamente");
							frame.dispose();
							PrincipalTienda t=new PrincipalTienda(p);
							t.getFrame().setVisible(true);
						}else {
							JOptionPane.showMessageDialog(null, "No se pudo crear la tienda");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Esta Tienda ya existe");
					}
				}else {
					JOptionPane.showMessageDialog(null, "No se permiten espacios en Blanco");
				}
				
			}
		});
		btnOk.setBounds(98, 162, 89, 23);
		frame.getContentPane().add(btnOk);
		
		JLabel lblIconAdd = new JLabel("");
		lblIconAdd.setBounds(285, 47, 124, 117);
		ImageIcon ico=new ImageIcon("src\\\\Iconos\\\\restaurant.png");
		Icon icosalir=new ImageIcon(ico.getImage().getScaledInstance(lblIconAdd.getWidth(), lblIconAdd.getHeight(), Image.SCALE_DEFAULT));
		lblIconAdd.setIcon(icosalir);
	
		frame.getContentPane().add(lblIconAdd);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PrincipalTienda t=new PrincipalTienda(p);
				t.getFrame().setVisible(true);
			}
		});
		button.setIcon(new ImageIcon("src\\Iconos\\back.png"));
		button.setBounds(10, 201, 70, 49);
		frame.getContentPane().add(button);
	}
}
