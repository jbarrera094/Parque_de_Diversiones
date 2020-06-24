package View;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Clases.*
;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class ListaAtracciones {

	private JFrame frame;
	private JTable table;
	private Parque p;
	private JTable table_1;

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
					ListaAtracciones window = new ListaAtracciones(p.leerFihero());
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
	public ListaAtracciones(Parque p) {
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
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton atras = new JButton("Atras");
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PrincipalAtracciones a=new PrincipalAtracciones(p);
				a.getFrame().setVisible(true);
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
						.addComponent(atras))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
					.addComponent(atras)
					.addContainerGap())
		);
		String [] columna= new String[] {"Nombre", "Lim. personas", "Puntos","Estatura","Categoria req."};
		Object datos [][]= new Object[p.getAtracciones().length][7];
		for (int i=0;i<p.getAtracciones().length;i++) {
			datos[i][0]=p.getAtracciones()[i].getNombre();
			datos[i][1]=p.getAtracciones()[i].getLimitePersonas();
			datos[i][2]=p.getAtracciones()[i].getPuntosAtraccion();
			datos[i][3]=p.getAtracciones()[i].getEstaturaLimite();
			datos[i][4]=p.getAtracciones()[i].getCategoriaRequerida();		
		}
		table_1 = new JTable(datos,columna);
		scrollPane.setViewportView(table_1);
		
		DefaultTableModel modelo = new DefaultTableModel();
		frame.getContentPane().setLayout(groupLayout);
	}
}