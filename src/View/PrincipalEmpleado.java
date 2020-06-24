package View;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Clases.Parque;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrincipalEmpleado {

	private JFrame frame;
	private Parque p;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PrincipalEmpleado window = new PrincipalEmpleado();
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

	public PrincipalEmpleado(Parque p) {
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
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AddEmpleado ae=new AddEmpleado(p);
				ae.getFrame().setVisible(true);
			}
		});
		button.setBounds(48, 97, 131, 119);
		ImageIcon icon=new ImageIcon("src\\Iconos\\add.png");
		Icon iconoSalir=new ImageIcon(icon.getImage().getScaledInstance(button.getWidth(),button.getHeight(), Image.SCALE_DEFAULT));
		button.setIcon(iconoSalir);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ListaEmpleado le=new ListaEmpleado(p);
				le.getFrame().setVisible(true);
			}
		});
		button_1.setBounds(235, 97, 131, 119);
		ImageIcon icon1=new ImageIcon("src\\Iconos\\clipboard.png");
		Icon iconoSalir1=new ImageIcon(icon1.getImage().getScaledInstance(button_1.getWidth(),button_1.getHeight(), Image.SCALE_DEFAULT));
		button_1.setIcon(iconoSalir1);
		frame.getContentPane().add(button_1);
		
		JLabel lblEmpleados = new JLabel("Empleados");
		lblEmpleados.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpleados.setBounds(169, 13, 83, 16);
		frame.getContentPane().add(lblEmpleados);
		
		JLabel lblAdd = new JLabel("Add");
		lblAdd.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdd.setBounds(82, 68, 56, 16);
		frame.getContentPane().add(lblAdd);
		
		JLabel lblVer = new JLabel("Ver");
		lblVer.setHorizontalAlignment(SwingConstants.CENTER);
		lblVer.setBounds(268, 68, 56, 16);
		frame.getContentPane().add(lblVer);
		
		JButton btnReturn = new JButton("");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PrincipalParque pa=new PrincipalParque(p);
				pa.getFrame().setVisible(true);
			}
		});
		btnReturn.setBounds(0, 216, 39, 37);
		ImageIcon iconR=new ImageIcon("src\\Iconos\\back.png");
		Icon iconoSalirR=new ImageIcon(iconR.getImage().getScaledInstance(btnReturn.getWidth(),btnReturn.getHeight(), Image.SCALE_DEFAULT));
		btnReturn.setIcon(iconoSalirR);
		frame.getContentPane().add(btnReturn);
	}

}
