package View;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class buscar {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void Busqueda() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					buscar window = new buscar();
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
	public buscar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
