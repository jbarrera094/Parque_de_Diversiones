package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JMenu;
import java.awt.Color;
import javax.swing.SwingConstants;

import Clases.Parque;

public class PrincipalParque {

	private JFrame frame;
	private JLabel Atraccion;
	private Parque p;

	public JLabel getAtraccion() {
		return Atraccion;
	}

	public void setAtraccion(JLabel atraccion) {
		Atraccion = atraccion;
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Parque p=new Parque();
					PrincipalParque window = new PrincipalParque(p.leerFihero());
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

	public Parque getP() {
		return p;
	}

	public void setP(Parque p) {
		this.p = p;
	}

	/**
	 * Create the application.
	 */
	public PrincipalParque(Parque p) {
		this.p=p.leerFihero();
		initialize();		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 522, 407);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
// Updated upstream
		JButton Tienda = new JButton("");
		Tienda.setIcon(new ImageIcon("src\\Iconos\\shopping-cart.png"));
		Tienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				PrincipalTienda prin=new PrincipalTienda(p);
				prin.getFrame().setVisible(true);
			}
		});
		Tienda.setSelectedIcon(null);
		Tienda.setBounds(79, 53, 138, 120);
		frame.getContentPane().add(Tienda);
		
		
		JButton Atraccion = new JButton("");
		Atraccion.setIcon(new ImageIcon("src\\Iconos\\roller-coaster.png"));
		Atraccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PrincipalAtracciones a=new PrincipalAtracciones(p);
				a.getFrame().setVisible(true);
				
			}
		});
		Atraccion.setBounds(298, 53, 138, 120);
		frame.getContentPane().add(Atraccion);
				
		
		JButton Visitante = new JButton("");
		Visitante.setIcon(new ImageIcon("src\\Iconos\\family.png"));
		Visitante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PrincipalVisitante v=new PrincipalVisitante(p);
				v.getFrame().setVisible(true);
			}
		});
		Visitante.setBounds(79, 208, 138, 126);
		frame.getContentPane().add(Visitante);
		
		JButton Empleado = new JButton("");
		Empleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PrincipalEmpleado e2=new PrincipalEmpleado(p);
				e2.getFrame().setVisible(true);
			}
		});
		Empleado.setIcon(new ImageIcon("src\\Iconos\\business-person.png"));
		Empleado.setBounds(298, 208, 148, 126);
		frame.getContentPane().add(Empleado);
		
		String Tut="Bienvenido al Parque "+p.getNombre();
		JLabel Titulo = new JLabel(Tut);
		Titulo.setFont(new Font("Poor Richard", Font.BOLD, 17));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setBounds(96, 11, 328, 29);
		frame.getContentPane().add(Titulo);
		
		JLabel lblNewLabel = new JLabel("Tienda");
		lblNewLabel.setFont(new Font("Palatino Linotype", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(110, 184, 71, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblAtraccin = new JLabel("Atracci\u00F3n");
		lblAtraccin.setFont(new Font("Palatino Linotype", Font.PLAIN, 14));
		lblAtraccin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtraccin.setBounds(320, 184, 81, 14);
		frame.getContentPane().add(lblAtraccin);
		
		JLabel lblNewLabel_1 = new JLabel("Visitante");
		lblNewLabel_1.setFont(new Font("Palatino Linotype", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(103, 345, 78, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Empleado");
		lblNewLabel_2.setFont(new Font("Palatino Linotype", Font.PLAIN, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(330, 345, 81, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
	}

}
