package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import Clases.Parque;
import Clases.Tienda;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class OpcionesTienda {

	private JFrame frame;
	private Parque p;
	private Tienda t;
	

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Launch the application.
	 */
//	public void crearT() {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Parque p=new Parque();
//					OpcionesTienda window = new OpcionesTienda(p.leerFihero(),);
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
	public OpcionesTienda(Parque p,Tienda t) {
		this.p=p;
		this.t=t;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 514, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton Venta = new JButton("");
		Venta.setIcon(new ImageIcon("src\\Iconos\\shopping-bag.png"));
		Venta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Vender v=new Vender(t, p);
				v.getFrame().setVisible(true);
			}
		});
		Venta.setBounds(22, 21, 123, 105);
		frame.getContentPane().add(Venta);
		
		JButton Inventario = new JButton("");
		Inventario.setIcon(new ImageIcon("src\\Iconos\\clipboard.png"));
		Inventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ConsultarTienda i= new ConsultarTienda(p,t);
				i.getFrame().setVisible(true);
				
			}
		});
		Inventario.setBounds(170, 21, 123, 105);
		frame.getContentPane().add(Inventario);
		JLabel lblRealizarVenta = new JLabel("Realizar venta");
		lblRealizarVenta.setBounds(43, 124, 89, 28);
		frame.getContentPane().add(lblRealizarVenta);
		
		JLabel lblInventario = new JLabel("Inventario");
		lblInventario.setBounds(191, 124, 84, 28);
		frame.getContentPane().add(lblInventario);
		
		JButton atras = new JButton("Salir");
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Logintienda l= new Logintienda(p);
				l.getFrame().setVisible(true);
				
				
			}
		});
		atras.setBounds(29, 190, 89, 23);
		frame.getContentPane().add(atras);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("src\\Iconos\\add.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				agrgar ag=new agrgar(p,t);
				ag.getFrame().setVisible(true);
			}
		});
		btnNewButton.setBounds(329, 21, 123, 105);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblAgregarProducto = new JLabel("Agregar Producto");
		lblAgregarProducto.setBounds(355, 131, 108, 14);
		frame.getContentPane().add(lblAgregarProducto);
	}

}
