package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;

import Clases.Atraccion;
import Clases.Parque;
import Errores.Errores;
import Errores.noencontrado;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IngresoAtraccion {

	private JFrame frame;
	private Parque p;
	private Atraccion a;
	private JTextField textFieldId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Parque p=new Parque();
					IngresoAtraccion window = new IngresoAtraccion(p.leerFihero());
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
	
	public IngresoAtraccion(Parque p) {
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
		
		JLabel lblAtraccin = new JLabel("Atracci\u00F3n:");
		lblAtraccin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAtraccin.setBounds(99, 75, 75, 24);
		frame.getContentPane().add(lblAtraccin);
		
		JComboBox comboBoxAtracciones = new JComboBox();
		comboBoxAtracciones.setBounds(167, 77, 116, 22);
		frame.getContentPane().add(comboBoxAtracciones);
		for (int i = 0; i < p.getAtracciones().length; i++) {
			comboBoxAtracciones.addItem(p.getAtracciones()[i].getNombre());
		}
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(99, 130, 56, 16);
		frame.getContentPane().add(lblId);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a=p.buscaratraccion(comboBoxAtracciones.getSelectedItem().toString());
				if(p.buscarVisitante(textFieldId.getText())!=null) {
					if(a.verificarEntrada(p.buscarVisitante(textFieldId.getText()).getEstatura(),
							p.buscarVisitante(textFieldId.getText()).getC().getNombre())) {
						p.asignarPuntos(textFieldId.getText(), comboBoxAtracciones.getSelectedItem().toString());
						JOptionPane.showMessageDialog( null,"Los puntos han sido asignados");
						p.actualizarFichero();
						frame.dispose();
						PrincipalAtracciones a=new PrincipalAtracciones(p);
						a.getFrame().setVisible(true);
					}else
						JOptionPane.showMessageDialog( null,"El visitante no pertenece a esta categoría");
				}else
					JOptionPane.showMessageDialog( null,"No se pudo encontrar al visitante");
			}
		});
		
		textFieldId = new JTextField();
		textFieldId.setBounds(167, 128, 116, 22);
		frame.getContentPane().add(textFieldId);
		textFieldId.setColumns(10);
		btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnIngresar.setBounds(158, 179, 97, 25);
		frame.getContentPane().add(btnIngresar);
		
		JButton btnReturn = new JButton("");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PrincipalAtracciones pa=new PrincipalAtracciones(p);
				pa.getFrame().setVisible(true);
			}
		});
		btnReturn.setBounds(0, 212, 43, 41);
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
