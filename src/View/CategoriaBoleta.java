package View;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Clases.Parque;
import Clases.Visitante;

import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class CategoriaBoleta {

	private JFrame frame;
	private Visitante v;
	private Parque p;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CategoriaBoleta window = new CategoriaBoleta();
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
	public CategoriaBoleta(Visitante v, Parque p) {
		this.v=v;
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
		
		JLabel lblCategora = new JLabel("Categor\u00EDa");
		lblCategora.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCategora.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategora.setBounds(141, 4, 138, 31);
		frame.getContentPane().add(lblCategora);
		
		JLabel lblPrecio = new JLabel("$ 40000");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio.setBounds(291, 186, 129, 16);
		frame.getContentPane().add(lblPrecio);
		
		JLabel lblPrecio_1 = new JLabel("$ 70000");
		lblPrecio_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPrecio_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio_1.setBounds(152, 186, 127, 16);
		frame.getContentPane().add(lblPrecio_1);
		
		JLabel lblPrecio_2 = new JLabel("$ 100000");
		lblPrecio_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPrecio_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio_2.setBounds(12, 186, 128, 16);
		frame.getContentPane().add(lblPrecio_2);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.setC(p.getCategorias()[1]);
				p.actualizarFichero();
				frame.dispose();
				PrincipalParque pp=new PrincipalParque(p);
				pp.getFrame().setVisible(true);
			}
		});
		button.setBounds(152, 48, 128, 125);
		ImageIcon icon=new ImageIcon("src\\Iconos\\second.png");
		Icon iconoSalir=new ImageIcon(icon.getImage().getScaledInstance(button.getWidth(),button.getHeight(), Image.SCALE_DEFAULT));
		button.setIcon(iconoSalir);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.setC(p.getCategorias()[2]);
				p.actualizarFichero();
				frame.dispose();
				PrincipalParque pp=new PrincipalParque(p);
				pp.getFrame().setVisible(true);
			}
		});
		button_1.setBounds(292, 48, 128, 125);
		ImageIcon icon1=new ImageIcon("src\\Iconos\\third.png");
		Icon iconoSalir1=new ImageIcon(icon1.getImage().getScaledInstance(button_1.getWidth(),button_1.getHeight(), Image.SCALE_DEFAULT));
		button_1.setIcon(iconoSalir1);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				v.setC(p.getCategorias()[0]);
				p.actualizarFichero();
				frame.dispose();
				PrincipalParque pp=new PrincipalParque(p);
				pp.getFrame().setVisible(true);
			}
		});
		button_2.setBounds(12, 48, 128, 125);
		ImageIcon icon2=new ImageIcon("src\\Iconos\\best.png");
		Icon iconoSalir2=new ImageIcon(icon2.getImage().getScaledInstance(button_2.getWidth(),button_2.getHeight(), Image.SCALE_DEFAULT));
		button_2.setIcon(iconoSalir2);
		frame.getContentPane().add(button_2);
		
		JButton btnReturn = new JButton("");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PrincipalVisitante pv=new PrincipalVisitante(p);
				pv.getFrame().setVisible(true);
			}
		});
		btnReturn.setBounds(0, 219, 43, 34);
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
