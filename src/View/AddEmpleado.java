
package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Window;

import javax.swing.SwingConstants;

import Clases.Parque;

import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddEmpleado {

	//componentes gráficos
	private JFrame frame;
	private Parque p;
	private JTextField textFieldName;
	private JTextField textFieldID;
	private JTextField textFieldPago;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddEmpleado window = new AddEmpleado();
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
	
	//constructor que permitirá traer métodos y atributos de parque
	public AddEmpleado(Parque p) {
		this.p=p;
		initialize();		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//ubicación y declaración de los componentes gráficos
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRegistroDeEmpleados = new JLabel("Registro de empleados");
		lblRegistroDeEmpleados.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroDeEmpleados.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRegistroDeEmpleados.setBounds(0, 0, 432, 25);
		frame.getContentPane().add(lblRegistroDeEmpleados);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setBounds(87, 48, 75, 25);
		frame.getContentPane().add(lblNombre);
		
		
		textFieldName = new JTextField();
		textFieldName.setBounds(191, 51, 116, 22);
		frame.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblId = new JLabel("Cedula:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblId.setBounds(87, 105, 75, 16);
		frame.getContentPane().add(lblId);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(191, 104, 116, 22);
		frame.getContentPane().add(textFieldID);
		textFieldID.setColumns(10);
		
		JLabel lblPago = new JLabel("Pago diario:");
		lblPago.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPago.setBounds(87, 157, 104, 16);
		frame.getContentPane().add(lblPago);
		
		textFieldPago = new JTextField();
		textFieldPago.setColumns(10);
		textFieldPago.setBounds(191, 156, 116, 22);
		frame.getContentPane().add(textFieldPago);
		
		JButton btnReturn = new JButton("");
		btnReturn.addActionListener(new ActionListener() {
			//permitirá que al hacer click en el botón se pueda pasar a la siguiente ventana (interfaz anterior)
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PrincipalEmpleado pe=new PrincipalEmpleado(p);
				pe.getFrame().setVisible(true);
			}
		});
		btnReturn.setBounds(0, 211, 48, 42);
		ImageIcon icon=new ImageIcon("src\\Iconos\\back.png");
		Icon iconoSalir=new ImageIcon(icon.getImage().getScaledInstance(btnReturn.getWidth(),btnReturn.getHeight(), Image.SCALE_DEFAULT));
		btnReturn.setIcon(iconoSalir);
		frame.getContentPane().add(btnReturn);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			//botón continuar, que permitirá pasar a la siguiente pantalla y adicional a ello guardará en el registro el empleado que se cree
			public void actionPerformed(ActionEvent e) {
				int validar = JOptionPane.showConfirmDialog(null,"¿Está seguro de que la información es correcta?");
				if (validar == 0) {
					String nombre=textFieldName.getText();
					String id=textFieldID.getText();
					double pago=Double.parseDouble(textFieldPago.getText());
					if(p.buscarEmpleado(id)==null) {
						if(p.Addempleado(nombre, id, pago)){
							p.actualizarFichero();
							JOptionPane.showMessageDialog(null, "Creado Satisfactoriamente");
							frame.dispose();
							PrincipalParque pa=new PrincipalParque(p);
							pa.getFrame().setVisible(true);
						}else {
							JOptionPane.showMessageDialog(null, "No se pudo crear el empleado");
						}
						
					}else {
						JOptionPane.showConfirmDialog(null, "Este empleado ya existe");
					}				
				}else {
					JOptionPane.showConfirmDialog(null, "Error");
				}
			}
		});
		btnContinuar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnContinuar.setBounds(163, 215, 97, 25);
		frame.getContentPane().add(btnContinuar);
	}

	public JFrame getFrame() {
		return frame;
	}
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
