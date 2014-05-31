package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.DivideByZeroException;
import logic.Operaciones;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class VentanaPpal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Operaciones op;
	private JTextField txtInput0;
	private JTextField txtInput1;
	private JLabel lblOutput;

	public VentanaPpal(Operaciones op) {
		this.op = op;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panelInput = new JPanel();
		
		JPanel panelOutput = new JPanel();
		
		JPanel panelControl = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panelInput, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelOutput, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE))
						.addComponent(panelControl, GroupLayout.PREFERRED_SIZE, 419, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panelInput, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelOutput, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelControl, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JButton btnSumar = new JButton("Sumar");
		btnSumar.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				sumar();
			}
		});
		panelControl.add(btnSumar);
		
		JButton btnRestar = new JButton("Restar");
		btnRestar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				restar();
			}
		});
		panelControl.add(btnRestar);
		
		JButton btnMultiplicar = new JButton("Multiplicar");
		btnMultiplicar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				multiplicar();
			}
		});
		panelControl.add(btnMultiplicar);
		
		JButton btnDividir = new JButton("Dividir");
		btnDividir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dividir();
			}
		});
		panelControl.add(btnDividir);
		
		lblOutput = new JLabel("0");
		panelOutput.add(lblOutput);
		
		txtInput0 = new JTextField();
		panelInput.add(txtInput0);
		txtInput0.setColumns(10);
		
		txtInput1 = new JTextField();
		panelInput.add(txtInput1);
		txtInput1.setColumns(10);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void sumar(){
		try{
			String output = op.sumar(this.txtInput0.getText(), this.txtInput1.getText());
			this.lblOutput.setText(output);
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Solo se pueden sumar números!", "Error de formato", JOptionPane.QUESTION_MESSAGE );
		}	
	}
	
	public void restar(){
		try{
			String output = op.restar(this.txtInput0.getText(), this.txtInput1.getText());
			this.lblOutput.setText(output);
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Solo se pueden restar números!", "Error de formato", JOptionPane.QUESTION_MESSAGE );
		}	
	}
	
	public void multiplicar(){
		try{
			String output = op.multiplicar(this.txtInput0.getText(), this.txtInput1.getText());
			this.lblOutput.setText(output);
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Solo se pueden multiplicar números!", "Error de formato", JOptionPane.QUESTION_MESSAGE );
		}	
	}
	
	public void dividir(){
		try{
			String output = op.dividir(this.txtInput0.getText(), this.txtInput1.getText());
			this.lblOutput.setText(output);
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Solo se pueden restar números!", "Error de formato", JOptionPane.QUESTION_MESSAGE );
		}	
		catch (DivideByZeroException e) {
			JOptionPane.showMessageDialog(null, "No se puede dividir por cero!", "Operación no definida", JOptionPane.QUESTION_MESSAGE );
		}
	}
}
