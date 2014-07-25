package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.DivideByZeroException;
import logic.Operaciones;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaPpal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Operaciones op;
	private JTextField txtInput0;
	private JTextField txtInput1;
	private JLabel lblOutput;
	private JLabel lblError;

	public VentanaPpal(Operaciones op) {
		setResizable(false);
		setTitle("Calculadora");
		this.op = op;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panelInput = new JPanel();
		panelInput.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JPanel panelOutput = new JPanel();
		panelOutput.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JPanel panelControl = new JPanel();
		panelControl.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JPanel panelError = new JPanel();
		panelError.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelInput, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelOutput, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(13, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelError, GroupLayout.PREFERRED_SIZE, 416, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelControl, GroupLayout.PREFERRED_SIZE, 419, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panelInput, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelOutput, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(panelControl, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelError, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(34, Short.MAX_VALUE))
		);
		panelError.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblError = new JLabel("");
		lblError.setFont(new Font("DejaVu Sans", Font.BOLD, 18));
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		panelError.add(lblError);
		
		JButton btnSumar = new JButton("+");
		btnSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sumar();
			}
		});
		btnSumar.setFont(new Font("DejaVu Sans", Font.BOLD, 50));
		panelControl.setLayout(new GridLayout(0, 4, 0, 0));
		panelControl.add(btnSumar);
		
		JButton btnMultiplicar = new JButton("×");
		btnMultiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				multiplicar();
			}
		});
		btnMultiplicar.setFont(new Font("DejaVu Sans", Font.BOLD, 50));
		
		JButton btnRestar = new JButton("−");
		btnRestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				restar();
			}
		});
		btnRestar.setFont(new Font("DejaVu Sans", Font.BOLD, 50));
		panelControl.add(btnRestar);
		panelControl.add(btnMultiplicar);
		
		JButton btnDividir = new JButton("÷");
		btnDividir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dividir();				
			}
		});
		btnDividir.setFont(new Font("DejaVu Sans", Font.BOLD, 50));

		panelControl.add(btnDividir);
		panelOutput.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblOutput = new JLabel("0");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setFont(new Font("DejaVu Sans", Font.PLAIN, 32));
		panelOutput.add(lblOutput);
		panelInput.setLayout(new GridLayout(0, 1, 0, 0));
		
		txtInput0 = new JTextField();
		txtInput0.setFont(new Font("DejaVu Sans", Font.PLAIN, 30));
		panelInput.add(txtInput0);
		txtInput0.setColumns(10);
		
		txtInput1 = new JTextField();
		txtInput1.setFont(new Font("DejaVu Sans", Font.PLAIN, 30));
		panelInput.add(txtInput1);
		txtInput1.setColumns(10);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void mostrarResultado(String output) {
		this.lblOutput.setText(output);
		this.lblError.setText("=)");
	}
	
	private void sumar(){
		try{
			String output = op.sumar(this.txtInput0.getText(), this.txtInput1.getText());
			this.mostrarResultado(output);
		}
		catch (NumberFormatException e) {
			this.lblError.setText("Solo se pueden sumar números!");
			this.lblOutput.setText("Error");
		}	
	}
	
	private void restar(){
		try{
			String output = op.restar(this.txtInput0.getText(), this.txtInput1.getText());
			this.mostrarResultado(output);
		}
		catch (NumberFormatException e) {
			this.lblError.setText("Solo se pueden restar números!");
			this.lblOutput.setText("Error");
		}	
	}
	
	private void multiplicar(){
		try{
			String output = op.multiplicar(this.txtInput0.getText(), this.txtInput1.getText());
			this.mostrarResultado(output);
		}
		catch (NumberFormatException e) {
			this.lblError.setText("Solo se pueden multiplicar números!");
			this.lblOutput.setText("Error");
		}	
	}
	
	private void dividir(){
		try{
			String output = op.dividir(this.txtInput0.getText(), this.txtInput1.getText());
			this.mostrarResultado(output);
		}
		catch (NumberFormatException e) {
			this.lblError.setText("Solo se pueden dividir números!");
			this.lblOutput.setText("Error");
		}	
		catch (DivideByZeroException e) {
			this.lblError.setText("No se puede dividir por 0!");
			this.lblOutput.setText("Error");
		}
	}
}