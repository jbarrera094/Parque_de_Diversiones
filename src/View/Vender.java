package View;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Clases.Parque;
import Clases.Tienda;
import Clases.Visitante;
import Errores.Errores;
import Errores.noencontrado;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class Vender {

	private JFrame frame;
	private Tienda t;
	private Parque p;
	private JTextField Visitante;
	private JTextField Producto;
	private JTextField Cantidad;
	private JLabel lblProducto;
	private JLabel lblIdVisitante;
	private JLabel lblCantidad;
	private JButton button;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Vender window = new Vender();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	/**
	 * Create the application.
	 */
	public Vender(Tienda t,Parque p) {
		this.t=t;
		this.p=p;
		initialize();
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblVentaDelDa = new JLabel("Venta del D\u00EDa");
		lblVentaDelDa.setHorizontalAlignment(SwingConstants.CENTER);
		lblVentaDelDa.setBounds(147, 11, 99, 24);
		frame.getContentPane().add(lblVentaDelDa);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(157, 46, 89, 20);
		frame.getContentPane().add(comboBox);
		comboBox.addItem("Premio");
		comboBox.addItem("Recuerdo");
		comboBox.addItem("Comida");
		
		
		JButton btnNewButton = new JButton("calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Visitante v=p.buscarVisitante(Visitante.getText());
				String produc=Producto.getText();
				int cant=Integer.parseInt(Cantidad.getText());
				String Categoria=comboBox.getSelectedItem().toString();
				if(produc.compareTo("")!=0 && cant!=0) {
					if(Categoria.compareTo("Premio")==0) {
						try {
							t.EntregarPremios(cant, produc, v);
						} catch (Errores | noencontrado e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}
					}else {
						if(Categoria.compareTo("Recuerdo")==0) {
							try {
								t.VenderRecuerdos(cant, produc, v);
							} catch (noencontrado | Errores e1) {
								// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(null, e1.getMessage());
							}
						}else {
							try {
								t.VenderComida(cant, produc, v);
							} catch (Errores | noencontrado e1) {
								// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(null, e1.getMessage());
							}
						}
					}
					p.actualizarFichero();
					frame.dispose();
					OpcionesTienda op=new OpcionesTienda(p,t);
					op.getFrame().setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Porfavor ingrese valores validos");
				}
			};
		});
		btnNewButton.setBounds(165, 186, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		Visitante = new JTextField();
		Visitante.setBounds(160, 77, 86, 20);
		frame.getContentPane().add(Visitante);
		Visitante.setColumns(10);
		
		Producto = new JTextField();
		Producto.setBounds(160, 108, 86, 20);
		frame.getContentPane().add(Producto);
		Producto.setColumns(10);
		
		Cantidad = new JTextField();
		Cantidad.setText("");
		Cantidad.setBounds(157, 139, 86, 20);
		frame.getContentPane().add(Cantidad);
		Cantidad.setColumns(10);
		
		lblProducto = new JLabel("Producto:");
		lblProducto.setBounds(75, 111, 75, 14);
		frame.getContentPane().add(lblProducto);
		
		lblIdVisitante = new JLabel("ID Visitante");
		lblIdVisitante.setBounds(75, 80, 75, 14);
		frame.getContentPane().add(lblIdVisitante);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(75, 142, 72, 14);
		frame.getContentPane().add(lblCantidad);
		
		button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				OpcionesTienda op=new OpcionesTienda(p, t);
				op.getFrame().setVisible(true);
			}
		});
		button.setIcon(new ImageIcon("src\\Iconos\\back.png"));
		button.setBounds(10, 211, 72, 39);
		frame.getContentPane().add(button);
		
		
		
	}
	

}
