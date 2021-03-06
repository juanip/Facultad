package ui;

import logic.Venta;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class FrmVenta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPelicula;
	private JTextField txtTickets;
	private JTextField txtHorario;
	private JLabel lblCalcImporte;
	private ArrayList<Venta> ventas = new ArrayList<Venta>();
	

	/**
	 * Create the frame.
	 */
	public FrmVenta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblPelicula = new JLabel("Pelicula:");
		
		JLabel lblCantidadDeTickets = new JLabel("Cantidad de tickets");
		
		txtPelicula = new JTextField();
		txtPelicula.setColumns(10);
		
		txtTickets = new JTextField();
		txtTickets.setColumns(10);
		
		JButton btnAceptar = new JButton("Vender");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vender();
			}
		});
		
		JLabel lblImporte = new JLabel("Importe");
		
		lblCalcImporte = new JLabel("$");
		
		JLabel lblCine = new JLabel("Cine DreamFilm");
		lblCine.setFont(new Font("Dialog", Font.BOLD, 22));
		
		JLabel lblHorario = new JLabel("Horario");
		
		txtHorario = new JTextField();
		txtHorario.setColumns(10);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarFrm();
			}
		});
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consultar();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGap(35)
							.addComponent(btnLimpiar)
							.addPreferredGap(ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
							.addComponent(btnConsultar)
							.addGap(18)
							.addComponent(btnAceptar))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(123)
							.addComponent(lblCine))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblHorario)
								.addComponent(lblImporte)
								.addComponent(lblPelicula)
								.addComponent(lblCantidadDeTickets))
							.addGap(31)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtPelicula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTickets, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCalcImporte)
								.addComponent(txtHorario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblCine)
					.addGap(47)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPelicula)
						.addComponent(txtPelicula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHorario)
						.addComponent(txtHorario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCantidadDeTickets)
						.addComponent(txtTickets, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblImporte)
						.addComponent(lblCalcImporte))
					.addGap(15)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAceptar)
						.addComponent(btnLimpiar)
						.addComponent(btnConsultar))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void vender() {
		try {
			int cant;
			cant = Integer.parseInt(this.txtTickets.getText());
			Venta venta = new Venta(this.txtPelicula.getText(), this.txtHorario.getText(), cant);
			
			this.ventas.add(venta);
			
			this.lblCalcImporte.setText("$" + venta.getImporteTotal());
		} 
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "La cant debe ser un numero");
		}		
	}
	
	private void limpiarFrm() {
		this.txtHorario.setText("");
		this.txtPelicula.setText("");
		this.txtTickets.setText("");
		this.lblCalcImporte.setText("");
	}
	
	private void consultar() {
		InfoVenta infoVenta = new InfoVenta(this.txtPelicula.getText(), this.txtHorario.getText(), this.txtTickets.getText());
		infoVenta.setVisible(true);
	}
}
