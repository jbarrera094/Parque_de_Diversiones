package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;

import Clases.Parque;

public class PrincipalAtracciones {

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
					PrincipalAtracciones window = new PrincipalAtracciones(p.leerFihero());
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	public PrincipalAtracciones(Parque p) {
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
		
		JLabel lblNewLabel = new JLabel("Atracciones");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(159, 0, 111, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnAdd = new JButton("");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AddAtracciones aa=new AddAtracciones(p);
				aa.getFrame().setVisible(true);
			}
		});
		btnAdd.setBounds(12, 54, 121, 122);
		ImageIcon icon=new ImageIcon("src\\Iconos\\add.png");
		Icon iconoSalir=new ImageIcon(icon.getImage().getScaledInstance(btnAdd.getWidth(),btnAdd.getHeight(), Image.SCALE_DEFAULT));
		
		JLabel lblAdd = new JLabel("Add");
		lblAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdd.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdd.setBounds(33, 29, 56, 16);
		frame.getContentPane().add(lblAdd);
		btnAdd.setIcon(iconoSalir);
		frame.getContentPane().add(btnAdd);
		
		JButton btnVer = new JButton("");
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ListaAtracciones la=new ListaAtracciones(p);
				la.getFrame().setVisible(true);
			}
		});
		btnVer.setBounds(290, 54, 130, 131);
		btnVer.setBounds(290, 54, 139, 138);
		ImageIcon icon1=new ImageIcon("src\\Iconos\\clipboard.png");
		Icon iconoSalir1=new ImageIcon(icon1.getImage().getScaledInstance(btnVer.getWidth(),btnVer.getHeight(), Image.SCALE_DEFAULT));
		btnVer.setIcon(iconoSalir1);
		frame.getContentPane().add(btnVer);
		
		JButton btnIngresar = new JButton("");
		btnIngresar.setForeground(Color.WHITE);
		btnIngresar.setBounds(145, 109, 133, 131);
		ImageIcon icon2=new ImageIcon("src\\Iconos\\login (1).png");
		Icon iconoSalir2=new ImageIcon(icon2.getImage().getScaledInstance(btnIngresar.getWidth(),btnIngresar.getHeight(), Image.SCALE_DEFAULT));
		
		
		btnIngresar.setIcon(iconoSalir2);
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				IngresoAtraccion ia=new IngresoAtraccion(p);
				ia.getFrame().setVisible(true);
			}
		});
		frame.getContentPane().add(btnIngresar);
		
		JLabel lblVerRegistro = new JLabel("Ver atracciones");
		lblVerRegistro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVerRegistro.setBounds(305, 29, 115, 17);
		frame.getContentPane().add(lblVerRegistro);
		
		JLabel lblIngresar = new JLabel("Ingreso de visitante");
		lblIngresar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIngresar.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresar.setBounds(145, 80, 133, 25);
		frame.getContentPane().add(lblIngresar);
		
		JButton btnReturn = new JButton("");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PrincipalParque pa=new PrincipalParque(p);
				pa.getFrame().setVisible(true);
			}
		});
		btnReturn.setBounds(0, 210, 46, 43);
		ImageIcon icon3=new ImageIcon("src\\Iconos\\back.png");
		Icon iconoSalir3=new ImageIcon(icon3.getImage().getScaledInstance(btnReturn.getWidth(),btnReturn.getHeight(), Image.SCALE_DEFAULT));
		btnReturn.setIcon(iconoSalir3);
		frame.getContentPane().add(btnReturn);
	}

	public JFrame getFrame() {
		return frame;
	}
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
