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
public class ListaTienda {

	private JFrame frame;
	private JTable table;
	private Parque p;
	private JTable table_1;
	private JButton atras;

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
					ListaTienda window = new ListaTienda(p.leerFihero());
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
	public ListaTienda(Parque p) {
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
		
		atras = new JButton("Atras");
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PrincipalTienda t=new PrincipalTienda(p);
				t.getFrame().setVisible(true);			
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
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
					.addComponent(atras))
		);
		String [] columna= new String[] {"Estado", "Nombre","Admin","Vent. diaria comida", "Vent. diaira recuerdos"};
		Object datos [][]= new Object[p.getTiendas().length][5];
		for (int i=0;i<p.getTiendas().length;i++) {
			if (p.getTiendas()[i].isEstado()==true) {
				datos[i][0]= "Abierta";
			}else {
				datos[i][0]= "Cerrada";
			}
			datos[i][1]=p.getTiendas()[i].getNombre();
			datos[i][2]=p.getTiendas()[i].getAdmin();
			datos[i][3]=p.getTiendas()[i].CalcularVentasDiarias()[1];
			datos[i][4]=p.getTiendas()[i].CalcularVentasDiarias()[0];
		}
		table_1 = new JTable(datos,columna);
		scrollPane.setViewportView(table_1);
		
		DefaultTableModel modelo = new DefaultTableModel();
		frame.getContentPane().setLayout(groupLayout);
	}

}