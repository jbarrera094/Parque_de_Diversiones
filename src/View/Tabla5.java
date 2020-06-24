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
import java.awt.event.ActionEvent;public class Tabla5 {

	private JFrame frame;
	private JTable table;
	private Parque p;
	private JTable table_1;
	private JButton btnAtras;

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
					Tabla5 window = new Tabla5(p.leerFihero());
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
	public Tabla5(Parque p) {
		this.p=p;
		initialize();	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 377);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		
		btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PrincipalVisitante pr=new PrincipalVisitante(p);
				pr.getFrame().setVisible(true);
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
						.addComponent(btnAtras))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
					.addComponent(btnAtras)
					.addContainerGap())
		);
		String [] columna= new String[] {"Nombre", "Cedula", "Categoria","Saldo","Puntos","Edad","Estatura"};
		Object datos [][]= new Object[p.getVisitantes().length][7];
		for (int i=0;i<p.getVisitantes().length;i++) {
			datos[i][0]=p.getVisitantes()[i].getNombre();
			datos[i][1]=p.getVisitantes()[i].getId();
			datos[i][2]=p.getVisitantes()[i].getC().getNombre();
			datos[i][3]=p.getVisitantes()[i].getDinero();
			datos[i][4]=p.getVisitantes()[i].getPuntos();
			datos[i][5]=p.getVisitantes()[i].getEdad();
			datos[i][6]=p.getVisitantes()[i].getEstatura();			
		}
		table_1 = new JTable(datos,columna);
		scrollPane.setViewportView(table_1);
		
		DefaultTableModel modelo = new DefaultTableModel();
		frame.getContentPane().setLayout(groupLayout);
	}

}