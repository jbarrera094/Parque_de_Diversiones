package View;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import Clases.Parque;
import Clases.Tienda;

import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class Logintienda {
	
	private JFrame frame;
	private JTextField ID;
	private JPasswordField passwordField;
	private Parque p;
	private JLabel label;
	private JButton button;
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Parque p=new Parque();
					 Logintienda window = new  Logintienda(p.leerFihero());
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

	/**
	 * Create the application.
	 */
	public  Logintienda(Parque p) {
		this.p=p;
		initialize();	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBackground(Color.BLACK);
		getFrame().setBounds(100, 100, 389, 449);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnHolas = new JButton("login");
		btnHolas.setBounds(47, 330, 270, 48);
		btnHolas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
				if(passwordField.getText().compareTo("")!=0 && ID.getText().compareTo("")!=0){
					Tienda t=p.buscarTienda(ID.getText());
					if(t!=null) {
						if(t.getAdmin().compareTo(ID.getText())==0) {
							if(t.getClave().compareTo(passwordField.getText())==0) {
								frame.dispose();
								OpcionesTienda op=new OpcionesTienda(p,p.buscarTienda(ID.getText()));
								op.getFrame().setVisible(true);
							}else {
								JOptionPane.showMessageDialog(null, "Error en la password");
							}
							
						}else {
							JOptionPane.showMessageDialog(null, "Error en Admin");
						}
						
					}else {
						JOptionPane.showMessageDialog(null, "No se encontro una tienda que coincida con sus credenciales");
					}
				}
				else{					
					JOptionPane.showMessageDialog(null, "No se permiten espacion en blanco");				
				}
				
				
				
			}
		});
		getFrame().getContentPane().setLayout(null);
		getFrame().getContentPane().add(btnHolas);
		
		ID = new JTextField();
		ID.setBounds(128, 221, 189, 33);
		ID.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		ID.setForeground(Color.BLACK);
		ID.setBackground(Color.WHITE);
		getFrame().getContentPane().add(ID);
		ID.setColumns(10);
		
		JLabel lblUsuario = new JLabel("ID:");
		lblUsuario.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		lblUsuario.setBounds(47, 221, 84, 33);
		getFrame().getContentPane().add(lblUsuario);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(130, 265, 189, 33);
		getFrame().getContentPane().add(passwordField);
		
		JLabel lblContasea = new JLabel("contrase\u00F1a:");
		lblContasea.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		lblContasea.setBounds(33, 263, 87, 33);
		getFrame().getContentPane().add(lblContasea);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("src\\Iconos\\login (2).png"));
		label.setBounds(111, 30, 133, 163);
		frame.getContentPane().add(label);
		
		button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PrincipalTienda t=new PrincipalTienda(p);
				t.getFrame().setVisible(true);
			}
		});
		button.setIcon(new ImageIcon("src\\Iconos\\back.png"));
		button.setBounds(0, 11, 57, 48);
		frame.getContentPane().add(button);
		
	}

}