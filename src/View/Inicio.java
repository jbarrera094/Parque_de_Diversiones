package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Clases.Parque;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class Inicio {

	private JFrame frame;
	private JTextField textField;
	//MARTA
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio window = new Inicio();
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
	public Inicio() {
		initialize();	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 354, 371);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel label = new JLabel("");		
		label.setBounds(81, 21, 176, 135);
		ImageIcon icon=new ImageIcon("src\\Iconos\\ferris.png");
		Icon iconosalir=new ImageIcon(icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(iconosalir);
		frame.getContentPane().add(label);

		JLabel lblNombreDelParque = new JLabel("Nombre del Parque:");
		lblNombreDelParque.setFont(new Font("Palatino Linotype", Font.BOLD, 14));
		lblNombreDelParque.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreDelParque.setBounds(81, 187, 151, 20);
		frame.getContentPane().add(lblNombreDelParque);

		textField = new JTextField();
		textField.setFont(new Font("Palatino Linotype", Font.PLAIN, 14));
		textField.setBounds(57, 218, 200, 31);
		frame.getContentPane().add(textField);
		textField.setBorder(new LineBorder(new Color(237, 237, 237), 3, true));
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s=textField.getText();
				if(s.compareTo("")!=0) {
					frame.dispose();
					Parque p=new Parque(textField.getText());
					p.actualizarFichero();
					PrincipalParque pa=new PrincipalParque(p);
					pa.getFrame().setVisible(true);
				}else {
					JOptionPane.showMessageDialog( null,"No se pueden dejar espacios en blanco");
				}
			}
		});
		btnNewButton.setBounds(105, 275, 115, 31);
		frame.getContentPane().add(btnNewButton);


	}
}
