package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import Clases.Parque;
import Errores.Errores;
import Errores.noencontrado;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import javax.swing.JList;
import javax.swing.JComboBox;

public class AddAtracciones {

	//objetos que se encunetran en la interfaz, donde se tienen los campos para introducir los datos
	private JFrame frame;
	private Parque p;
	private JTextField textFieldName;
	private JTextField textFieldLimPersonas;
	private JTextField textFieldPuntos;
	private JTextField textFieldEstaturaLim;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddAtracciones window = new AddAtracciones();
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
	
	//se requiere de parque como atributo para traer los métodos de dicha clase
	public AddAtracciones(Parque p) {
		System.out.println(p.getAtracciones().length);
		this.p=p;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		//botones, íconos, y demás componentes gráficos
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAadirAtraccin = new JLabel("A\u00F1adir atracci\u00F3n");
		lblAadirAtraccin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAadirAtraccin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAadirAtraccin.setBounds(0, 0, 432, 22);
		frame.getContentPane().add(lblAadirAtraccin);
		
		JLabel lblName = new JLabel("Nombre");
		lblName.setBounds(31, 51, 56, 16);
		frame.getContentPane().add(lblName);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(160, 48, 116, 22);
		frame.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblLimiteDePersonas = new JLabel("L\u00EDmite de personas");
		lblLimiteDePersonas.setBounds(31, 86, 116, 16);
		frame.getContentPane().add(lblLimiteDePersonas);
		
		textFieldLimPersonas = new JTextField();
		textFieldLimPersonas.setBounds(160, 83, 116, 22);
		frame.getContentPane().add(textFieldLimPersonas);
		textFieldLimPersonas.setColumns(10);
		
		JLabel lblPuntos = new JLabel("Puntos");
		lblPuntos.setBounds(31, 121, 56, 16);
		frame.getContentPane().add(lblPuntos);
		
		textFieldPuntos = new JTextField();
		textFieldPuntos.setBounds(160, 118, 116, 22);
		frame.getContentPane().add(textFieldPuntos);
		textFieldPuntos.setColumns(10);
		
		JLabel lblEstaturaLimite = new JLabel("Estatura l\u00EDmite (m)");
		lblEstaturaLimite.setBounds(31, 156, 116, 16);
		frame.getContentPane().add(lblEstaturaLimite);
		
		textFieldEstaturaLim = new JTextField();
		textFieldEstaturaLim.setBounds(160, 153, 116, 22);
		frame.getContentPane().add(textFieldEstaturaLim);
		textFieldEstaturaLim.setColumns(10);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa");
		lblCategora.setBounds(31, 191, 56, 16);
		frame.getContentPane().add(lblCategora);
		
		JButton btnReturn = new JButton("");
		btnReturn.addActionListener(new ActionListener() {
			//botón que permitirá retornar a la pantalla anterior
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PrincipalAtracciones pa=new PrincipalAtracciones(p);
				pa.getFrame().setVisible(true);
			}
		});
		
		btnReturn.setBounds(0, 220, 41, 33);
		ImageIcon icon=new ImageIcon("src\\Iconos\\back.png");
		Icon iconoSalir=new ImageIcon(icon.getImage().getScaledInstance(btnReturn.getWidth(),btnReturn.getHeight(), Image.SCALE_DEFAULT));
		
		//declaración del combobox
		JComboBox comboBoxCategoria = new JComboBox();
		comboBoxCategoria.setBounds(160, 188, 116, 22);
		frame.getContentPane().add(comboBoxCategoria);
		comboBoxCategoria.addItem("Oro");
		comboBoxCategoria.addItem("Plata");
		comboBoxCategoria.addItem("Bronce");
		btnReturn.setIcon(iconoSalir);
		frame.getContentPane().add(btnReturn);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			//botón continuar, que permitirá pasar a la siguiente pantalla y adicional a ello guardará en el registro la atracción que se cree
			public void actionPerformed(ActionEvent e) {
				int validar = JOptionPane.showConfirmDialog(null,"¿Está seguro de que la información es correcta?");
				if (validar == 0) {
					String name=textFieldName.getText();
					int limPer=Integer.parseInt(textFieldLimPersonas.getText());
					int puntos=Integer.parseInt(textFieldPuntos.getText());
					double estLim=Double.parseDouble(textFieldEstaturaLim.getText());
					String categoria=comboBoxCategoria.getSelectedItem().toString();
					if(p.buscaratraccion(name)==null) {
						try {
							if(p.Addatraccion(name, limPer, puntos, estLim, categoria)){
								p.actualizarFichero();
								JOptionPane.showMessageDialog(null, "Creada Satisfactoriamente");
								frame.dispose();
								PrincipalAtracciones pa=new PrincipalAtracciones(p);
								pa.getFrame().setVisible(true);
							}else {
								JOptionPane.showMessageDialog(null, "No se pudo crear la atracción");
							}
						} catch (HeadlessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (noencontrado e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (Errores e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else {
						JOptionPane.showConfirmDialog(null, "Esta atracción ya existe");
					}				
				}else {
					JOptionPane.showConfirmDialog(null, "Error");
				}
			}
		});
		btnContinuar.setBounds(170, 223, 97, 25);
		frame.getContentPane().add(btnContinuar);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
