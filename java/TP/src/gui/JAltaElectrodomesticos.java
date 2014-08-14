package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import java.awt.Font;

public class JAltaElectrodomesticos extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JAltaElectrodomesticos frame = new JAltaElectrodomesticos();
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
	public JAltaElectrodomesticos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Alta");
		
		JPanel pnlTipoElectrodomestico = new JPanel();
		
		JPanel pnlDatosGenerales = new JPanel();
		
		JPanel pnlDatosEspecificos = new JPanel();
		
		JButton btnAceptar = new JButton("Aceptar");
		
		JButton btnCancelar = new JButton("Cancelar");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(pnlTipoElectrodomestico, GroupLayout.PREFERRED_SIZE, 531, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(btnAceptar)
								.addGap(18)
								.addComponent(btnCancelar))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(pnlDatosGenerales, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(pnlDatosEspecificos, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnlTipoElectrodomestico, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(pnlDatosGenerales, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
						.addComponent(pnlDatosEspecificos, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnAceptar))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		pnlDatosEspecificos.setLayout(new CardLayout(0, 0));
		
		JPanel pnlTelevisor = new JPanel();
		pnlDatosEspecificos.add(pnlTelevisor, "name_2263819518681");
		
		JLabel lblNewLabel_6 = new JLabel("Resoluci\u00F3n");
		
		JLabel lblNewLabel_7 = new JLabel("TDT");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JCheckBox checkBox = new JCheckBox("");
		GroupLayout gl_pnlTelevisor = new GroupLayout(pnlTelevisor);
		gl_pnlTelevisor.setHorizontalGroup(
			gl_pnlTelevisor.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlTelevisor.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_pnlTelevisor.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_6)
						.addComponent(lblNewLabel_7))
					.addGap(18)
					.addGroup(gl_pnlTelevisor.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkBox))
					.addContainerGap(82, Short.MAX_VALUE))
		);
		gl_pnlTelevisor.setVerticalGroup(
			gl_pnlTelevisor.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlTelevisor.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_pnlTelevisor.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_6))
					.addGap(27)
					.addGroup(gl_pnlTelevisor.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_7)
						.addComponent(checkBox))
					.addContainerGap(168, Short.MAX_VALUE))
		);
		pnlTelevisor.setLayout(gl_pnlTelevisor);
		
		JPanel pnlLavarropas = new JPanel();
		pnlDatosEspecificos.add(pnlLavarropas, "name_2296713964484");
		
		JLabel lblNewLabel_1 = new JLabel("Precio Base");
		
		JLabel lblNewLabel_2 = new JLabel("Peso");
		
		JLabel lblNewLabel_3 = new JLabel("Color");
		
		JLabel lblNewLabel_4 = new JLabel("Consumo");
		
		JLabel lblNewLabel_5 = new JLabel("Descripci\u00F3n");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		
		JComboBox comboBox_1 = new JComboBox();
		
		JTextPane textPane = new JTextPane();
		GroupLayout gl_pnlDatosGenerales = new GroupLayout(pnlDatosGenerales);
		gl_pnlDatosGenerales.setHorizontalGroup(
			gl_pnlDatosGenerales.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlDatosGenerales.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlDatosGenerales.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlDatosGenerales.createSequentialGroup()
							.addComponent(lblNewLabel_5)
							.addGap(18)
							.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlDatosGenerales.createSequentialGroup()
							.addGroup(gl_pnlDatosGenerales.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_4)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_1))
							.addGap(18)
							.addGroup(gl_pnlDatosGenerales.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox, 0, 110, Short.MAX_VALUE)
								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
								.addComponent(textField)
								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(19, GroupLayout.PREFERRED_SIZE))
		);
		gl_pnlDatosGenerales.setVerticalGroup(
			gl_pnlDatosGenerales.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlDatosGenerales.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_pnlDatosGenerales.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(26)
					.addGroup(gl_pnlDatosGenerales.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addGap(27)
					.addGroup(gl_pnlDatosGenerales.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addGap(26)
					.addGroup(gl_pnlDatosGenerales.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4))
					.addGap(27)
					.addGroup(gl_pnlDatosGenerales.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlDatosGenerales.createSequentialGroup()
							.addComponent(lblNewLabel_5)
							.addContainerGap(43, Short.MAX_VALUE))
						.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)))
		);
		pnlDatosGenerales.setLayout(gl_pnlDatosGenerales);
		
		JRadioButton rdbtnTelevisor = new JRadioButton("Televisor");
		
		JRadioButton rdbtnLavarropas = new JRadioButton("Lavarropas");
		GroupLayout gl_pnlTipoElectrodomestico = new GroupLayout(pnlTipoElectrodomestico);
		gl_pnlTipoElectrodomestico.setHorizontalGroup(
			gl_pnlTipoElectrodomestico.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlTipoElectrodomestico.createSequentialGroup()
					.addContainerGap(139, Short.MAX_VALUE)
					.addComponent(rdbtnTelevisor)
					.addGap(109)
					.addComponent(rdbtnLavarropas)
					.addGap(135))
		);
		gl_pnlTipoElectrodomestico.setVerticalGroup(
			gl_pnlTipoElectrodomestico.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlTipoElectrodomestico.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_pnlTipoElectrodomestico.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnTelevisor)
						.addComponent(rdbtnLavarropas))
					.addContainerGap())
		);
		pnlTipoElectrodomestico.setLayout(gl_pnlTipoElectrodomestico);
		contentPane.setLayout(gl_contentPane);
	}
}
