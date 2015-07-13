package InfoDialogo;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class InfoDialogo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	

	/**
	 * Create the dialog (Autogenerado por el maravilloso 'New Other JDialog').
	 */
	public InfoDialogo() {
		setModal(true);
		setResizable(false);
		setType(Type.UTILITY);
		setTitle("Info 'Gesti\u00F3n Empleados'");
		setBounds(100, 100, 635, 422);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{207, 418, 0};
		gbl_contentPanel.rowHeights = new int[]{333, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("images/javi2.png"));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
			gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			JTextPane txtpnDfgsdfgsdfg = new JTextPane();
			txtpnDfgsdfgsdfg.setEditable(false);
			txtpnDfgsdfgsdfg.setText("3\u00AA Parte del Proyecto 'GESTI\u00D3N DE EMPLEADOS'\r\n\r\nHe tratado de hacer la aplicaci\u00F3n lo m\u00E1s intuitiva y pr\u00E1ctica posible. Me he decantado por el JList s\u00F3lo por llevar la contraria a la tendencia de la mayor\u00EDa por el JTable, eso s\u00ED, no sin haber complicado el ejercicio sobremanera.\r\n\r\nSoy consciente de que podr\u00EDa haber simplificado mucho m\u00E1s el c\u00F3digo creando nuevos paquetes donde almacenar los m\u00E9todos de la clase principal 'MainGestionPersonalGUI', pero el tiempo se me ha echado encima y he hecho lo que he podido.\r\n\r\nEn caso de alguna duda, por favor, no dudes en preguntarme lo que sea sobre el c\u00F3digo, ya que a\u00FAn a pesar de ser tan largo, le he dedicado un buen tiempo a cada l\u00EDnea para su comprensi\u00F3n.\r\n\r\n\u00A1Muchas gracias!\r\n\r\n@autor Javier Latorre L\u00F3pez-Villalta\r\n@email jlalovi@gmail.com\r\n@version 1.0 (probablemente la \u00FAltima)\r\n");
			GridBagConstraints gbc_txtpnDfgsdfgsdfg = new GridBagConstraints();
			gbc_txtpnDfgsdfgsdfg.fill = GridBagConstraints.BOTH;
			gbc_txtpnDfgsdfgsdfg.gridx = 1;
			gbc_txtpnDfgsdfgsdfg.gridy = 0;
			contentPanel.add(txtpnDfgsdfgsdfg, gbc_txtpnDfgsdfgsdfg);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						InfoDialogo.this.setVisible(false);
					}
				});
				okButton.setFocusable(false);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
