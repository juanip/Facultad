import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JComboBox;


public class Porno extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnSalir;
	private JButton btnBuscar;
	private JButton btnGuardar;
	private JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Porno frame = new Porno();
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
	public Porno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(94, 45, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(94, 88, 78, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Boton Buscar");
			}
		});
		btnBuscar.setBounds(94, 8, 117, 25);
		contentPane.add(btnBuscar);
		
		textField_2 = new JTextField();
		textField_2.setBounds(94, 134, 114, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(94, 165, 114, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(154, 211, 117, 25);
		contentPane.add(btnSalir);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(303, 211, 117, 25);
		contentPane.add(btnGuardar);
		
		JLabel lblNmero = new JLabel("Número");
		lblNmero.setBounds(12, 47, 70, 15);
		contentPane.add(lblNmero);
		
		JLabel lblCdigo = new JLabel("Código");
		lblCdigo.setBounds(12, 90, 70, 15);
		contentPane.add(lblCdigo);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(12, 136, 70, 15);
		contentPane.add(lblCantidad);
		
		JLabel lblImporte = new JLabel("Importe");
		lblImporte.setBackground(Color.RED);
		lblImporte.setBounds(12, 167, 70, 15);
		contentPane.add(lblImporte);
	
		list = new JList();
		list.setBackground(Color.RED);
		list.setBounds(253, 57, 129, 114);
		contentPane.add(list);
		
		DefaultComboBoxModel listmodel = new DefaultComboBoxModel();
		listmodel.addElement("Laaaaa");
		listmodel.addElement("Laaasdsfsd333aaa");
		JComboBox comboBox = new JComboBox(listmodel);
		comboBox.setBounds(253, 8, 167, 24);
		contentPane.add(comboBox);
		
		
	}
}
