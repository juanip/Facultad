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
import javax.swing.border.BevelBorder;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.SwingConstants;


public class VentanaPpal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Operaciones op;
	private JTextField txtInput0;
	private JTextField txtInput1;
	private JLabel lblOutput;

	public VentanaPpal(Operaciones op) {
		setResizable(false);
		setTitle("Calculadora");
		this.op = op;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panelInput = new JPanel();
		panelInput.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JPanel panelOutput = new JPanel();
		panelOutput.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JPanel panelControl = new JPanel();
		panelControl.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelInput, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelOutput, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(142, Short.MAX_VALUE)
					.addComponent(panelControl, GroupLayout.PREFERRED_SIZE, 419, GroupLayout.PREFERRED_SIZE)
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
					.addContainerGap(41, Short.MAX_VALUE))
		);
		
		JButton btnSumar = new JButton("+");
		btnSumar.setFont(new Font("DejaVu Sans", Font.BOLD, 50));
		btnSumar.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				sumar();
			}
		});
		panelControl.setLayout(new GridLayout(0, 4, 0, 0));
		panelControl.add(btnSumar);
		
		JButton btnMultiplicar = new JButton("×");
		btnMultiplicar.setFont(new Font("DejaVu Sans", Font.BOLD, 50));
		btnMultiplicar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				multiplicar();
			}
		});
		
		JButton btnRestar = new JButton("−");
		btnRestar.setFont(new Font("DejaVu Sans", Font.BOLD, 50));
		btnRestar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				restar();
			}
		});
		panelControl.add(btnRestar);
		panelControl.add(btnMultiplicar);
		
		JButton btnDividir = new JButton("÷");
		btnDividir.setFont(new Font("DejaVu Sans", Font.BOLD, 50));
		btnDividir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dividir();
			}
		});
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
			JOptionPane.showMessageDialog(null, "Solo se pueden dividir números!", "Error de formato", JOptionPane.QUESTION_MESSAGE );
		}	
		catch (DivideByZeroException e) {
			JOptionPane.showMessageDialog(null, "No se puede dividir por cero!", "Operación no definida", JOptionPane.QUESTION_MESSAGE );
		}
	}
}
