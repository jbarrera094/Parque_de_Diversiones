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
import java.awt.event.ActionEvent;public class ListaEmpleado {

	private JFrame frame;
	private JTable table;
	private Parque p;
	private JTable table_1;
	private JButton btnAtras;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Parque p=new Parque();
					ListaEmpleado window = new ListaEmpleado(p.leerFihero());
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Create the application.
	 */
	public ListaEmpleado(Parque p) {
		this.p=p;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 619, 401);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		
		btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PrincipalEmpleado em=new PrincipalEmpleado(p);
				em.getFrame().setVisible(true);
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
						.addComponent(btnAtras))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAtras)
					.addContainerGap())
		);
		String [] columna= new String[] {"Nombre", "Cedula", "Salario"};
		Object datos [][]= new Object[p.getEmpleados().length][3];
		for (int i=0;i<p.getEmpleados().length;i++) {
			datos[i][0]=p.getEmpleados()[i].getNombre();
			datos[i][1]=p.getEmpleados()[i].getId();
			datos[i][2]=p.getEmpleados()[i].getPagoDiario();
			
		}
		table_1 = new JTable(datos,columna);
		scrollPane.setViewportView(table_1);
		
		DefaultTableModel modelo = new DefaultTableModel();
		frame.getContentPane().setLayout(groupLayout);
	}

}