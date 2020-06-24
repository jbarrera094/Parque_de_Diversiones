package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import Clases.Parque;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window;

import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrincipalVisitante {

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
					PrincipalVisitante window = new PrincipalVisitante(p.leerFihero());
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
	public PrincipalVisitante(Parque p) {
		this.p=p;
		//System.out.println(p.getVisitantes().length);
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
		
		JLabel lblVer_1 = new JLabel("Ver registro");
		lblVer_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVer_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblVer_1.setBounds(252, 44, 105, 21);
		frame.getContentPane().add(lblVer_1);
		
		JLabel lblAdd_1 = new JLabel("Agregar");
		lblAdd_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdd_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAdd_1.setBounds(73, 42, 99, 25);
		frame.getContentPane().add(lblAdd_1);
		
		JLabel lblBoleta = new JLabel("Boleta");
		lblBoleta.setHorizontalAlignment(SwingConstants.CENTER);
		lblBoleta.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblBoleta.setBounds(179, 13, 77, 18);
		frame.getContentPane().add(lblBoleta);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AddUsuario ru=new AddUsuario(p);
				ru.getFrame().setVisible(true);
			}
		});
		button.setBounds(73, 80, 126, 128);
		ImageIcon icon=new ImageIcon("src\\Iconos\\add.png");
		Icon iconoSalir=new ImageIcon(icon.getImage().getScaledInstance(button.getWidth(),button.getHeight(), Image.SCALE_DEFAULT));
		button.setIcon(iconoSalir);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				//System.out.println(p);
				Tabla5 li=new Tabla5(p);
				li.getFrame().setVisible(true);
			}
		});
		button_1.setBounds(242, 78, 126, 130);
		ImageIcon icon1=new ImageIcon("src\\Iconos\\login (1).png");
		Icon iconoSalir1=new ImageIcon(icon1.getImage().getScaledInstance(button_1.getWidth(),button_1.getHeight(), Image.SCALE_DEFAULT));
		button_1.setIcon(iconoSalir1);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PrincipalParque pa=new PrincipalParque(p);
				pa.getFrame().setVisible(true);
			}
		});
		button_2.setBounds(0, 216, 43, 37);
		ImageIcon icon2=new ImageIcon("src\\Iconos\\back.png");
		Icon iconoSalir2=new ImageIcon(icon2.getImage().getScaledInstance(button_2.getWidth(),button_2.getHeight(), Image.SCALE_DEFAULT));
		button_2.setIcon(iconoSalir2);
		frame.getContentPane().add(button_2);
	}

	public JFrame getFrame() {
		return frame;
	}
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
