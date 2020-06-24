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
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class ConsultarTienda {

	private JFrame frame;
	private JTable table;
	private Parque p;
	private Tienda t;
	private JTable table_1;
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
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Parque p=new Parque();
//					ConsultarTienda window = new ConsultarTienda(p.leerFihero());
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
	public ConsultarTienda(Parque p,Tienda t) {
		this.p=p;
		this.t=t;
		initialize();	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 451, 345);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		
		button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				OpcionesTienda op=new OpcionesTienda(p, t);
				op.getFrame().setVisible(true);
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\Jeisson\\Google Drive\\Programaci\u00F3n\\Parque-de-Diversiones\\src\\Iconos\\back.png"));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(button)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(27, Short.MAX_VALUE))
		);
		String [] columna= new String[] {"Nombre", "Precio","Cantidad Disp."};
		Object datos [][]= new Object[t.getComidas().length+t.getPremios().length+t.getRecuerdos().length][3];
		int i=0;
		for (i=0;i<t.getComidas().length;i++) {
			datos[i][0]=t.getComidas()[i].getNombre();
			datos[i][1]=t.getComidas()[i].getPrecio();
			datos[i][2]=t.getComidas()[i].getCantidad();
		}
		int j=0;
		int h=i;
		for (h=i;h<(t.getPremios().length+t.getComidas().length);h++) {
			while(j<t.getPremios().length) {
				datos[h][0]=t.getPremios()[j].getNombre();
				datos[h][1]=t.getPremios()[j].getValorpuntos();
				datos[h][2]=t.getPremios()[j].getCantidad();
				j++;
			}
			
		}
		int e=0;
		for (int k = h; k <(t.getPremios().length+t.getComidas().length+t.getRecuerdos().length); k++) {
			while(e<t.getRecuerdos().length) {
				datos[k][0]=t.getRecuerdos()[e].getNombre();
				datos[k][1]=t.getRecuerdos()[e].getPrecio();
				datos[k][2]=t.getRecuerdos()[e].getCantidad();
				e++;
			}
		}
		
		table_1 = new JTable(datos,columna);
		scrollPane.setViewportView(table_1);
		
		DefaultTableModel modelo = new DefaultTableModel();
		frame.getContentPane().setLayout(groupLayout);
	}

}