package View;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Clases.Parque;
import Clases.Tienda;
import Errores.Errores;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class agrgar {

	private JFrame frame;
	private JTextField Nombre;
	private JTextField Precio;
	private Parque p;
	private Tienda t;
	private JLabel lblNombre;
	private JLabel lblPrecio;
	private JTextField Cantidad;
	private JLabel lblCantidad;
	private JButton button;
	private JButton btnOk;

	/**
	 * Launch the application.
	 */
//	public void agregarP() {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					agrgar window = new agrgar();
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

	public agrgar(Parque p, Tienda t) {
		this.p=p;
		this.t=t;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 240);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(160, 22, 86, 20);
		frame.getContentPane().add(comboBox);
		comboBox.addItem("Premio");
		comboBox.addItem("Recuerdo");
		comboBox.addItem("Comida");
		
		JLabel lblAgregarProducto = new JLabel("");
		lblAgregarProducto.setBounds(291, 22, 109, 121);
		ImageIcon ico=new ImageIcon("src\\Iconos\\add.png"); 
		Icon i=new ImageIcon(ico.getImage().getScaledInstance(lblAgregarProducto.getWidth(), lblAgregarProducto.getHeight(), Image.SCALE_DEFAULT));
		lblAgregarProducto.setIcon(i);		
		frame.getContentPane().add(lblAgregarProducto);
		
		Nombre = new JTextField();
		Nombre.setBounds(160, 47, 86, 20);
		frame.getContentPane().add(Nombre);
		Nombre.setColumns(10);
		
		Precio = new JTextField();
		Precio.setBounds(160, 72, 86, 20);
		frame.getContentPane().add(Precio);
		Precio.setColumns(10);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(65, 50, 60, 14);
		frame.getContentPane().add(lblNombre);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(65, 75, 46, 14);
		frame.getContentPane().add(lblPrecio);
		
		Cantidad = new JTextField();
		Cantidad.setBounds(160, 97, 86, 20);
		frame.getContentPane().add(Cantidad);
		Cantidad.setColumns(10);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(65, 100, 68, 14);
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
		button.setBounds(23, 149, 68, 42);
		frame.getContentPane().add(button);
		
		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String categoria=comboBox.getSelectedItem().toString();
				String Produc=Nombre.getText();
				double prec=Double.parseDouble(Precio.getText());
				int cant=Integer.parseInt(Cantidad.getText());
				if(Produc.compareTo("")!=0 && prec!=0 && cant!=0) {
					if(categoria.compareTo("Comida")==0) {
						try {
							t.AgregarComida(Produc, prec, cant);
							p.actualizarFichero();
							frame.dispose();
							OpcionesTienda op=new OpcionesTienda(p, t);
							op.getFrame().setVisible(true);
						} catch (Errores e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}
					}else {
						if(categoria.compareTo("Premio")==0) {
							try {
								t.AgregarPremio(Produc,(int) prec, cant);
								p.actualizarFichero();
								frame.dispose();
								OpcionesTienda op=new OpcionesTienda(p, t);
								op.getFrame().setVisible(true);
							} catch (Errores e1) {
								// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(null, e1.getMessage());
							}
						}else {
							try {
								t.AgregarRecuerdo(Produc, prec, cant);
								p.actualizarFichero();
								frame.dispose();
								OpcionesTienda op=new OpcionesTienda(p, t);
								op.getFrame().setVisible(true);
							} catch (Errores e1) {
								// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(null, e1.getMessage());
							}
						}
					}
				}
			}
		});
		btnOk.setBounds(157, 146, 89, 23);
		frame.getContentPane().add(btnOk);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(65, 25, 68, 14);
		frame.getContentPane().add(lblCategoria);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}

