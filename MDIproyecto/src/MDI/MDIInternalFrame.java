package MDI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class MDIInternalFrame extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MDIInternalFrame frame = new MDIInternalFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MDIInternalFrame() {
		setBounds(100, 100, 450, 300);
		

	}

}
