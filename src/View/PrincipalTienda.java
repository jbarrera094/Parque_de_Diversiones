package View;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Clases.Parque;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class PrincipalTienda {

	private JFrame frame;
	private Parque p;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Parque p=new Parque();
					PrincipalTienda window = new PrincipalTienda(p.leerFihero());
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
	public PrincipalTienda(Parque p) {
		this.p=p;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 519, 335);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton ListasTiendas = new JButton("");
		ListasTiendas.setIcon(new ImageIcon("src\\Iconos\\test.png"));
		ListasTiendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ListaTienda t=new ListaTienda(p);
				t.getFrame().setVisible(true);
			}
		});
		ListasTiendas.setBounds(38, 28, 110, 101);
		frame.getContentPane().add(ListasTiendas);
		
		JLabel lblListaTiendas = new JLabel("Lista Tiendas");
		lblListaTiendas.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaTiendas.setBounds(51, 140, 90, 22);
		frame.getContentPane().add(lblListaTiendas);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PrincipalParque par=new PrincipalParque(p);
				par.getFrame().setVisible(true);
			}
		});
		button.setIcon(new ImageIcon("src\\Iconos\\back.png"));
		button.setBounds(10, 199, 70, 51);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon("src\\Iconos\\shopping-cart (2).png"));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AddTienda t=new AddTienda(p);
				t.getFrame().setVisible(true);			
			}
		});
		button_1.setBounds(192, 28, 118, 101);
		frame.getContentPane().add(button_1);
		
		JLabel lblAgregarTienda = new JLabel("Agregar Tienda");
		lblAgregarTienda.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarTienda.setBounds(191, 142, 104, 18);
		frame.getContentPane().add(lblAgregarTienda);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon("src\\Iconos\\add-to-cart.png"));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Logintienda op=new Logintienda(p);
				op.getFrame().setVisible(true);
			}
		});
		button_2.setBounds(343, 28, 121, 101);
		frame.getContentPane().add(button_2);
		
		JLabel lblIngresarATienda = new JLabel("Ingresar a Tienda");
		lblIngresarATienda.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresarATienda.setBounds(353, 140, 102, 22);
		frame.getContentPane().add(lblIngresarATienda);
	}

}
