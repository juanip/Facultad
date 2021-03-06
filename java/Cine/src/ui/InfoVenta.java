package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logic.Venta;

public class InfoVenta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblHor;
	private JLabel lblPel;
	private JLabel lblTot;
	private JLabel lblImp;

	public InfoVenta(String pelicula, String horario, String cantidad) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblP = new JLabel("Cine DreamFilm");
		lblP.setFont(new Font("Dialog", Font.BOLD, 22));
		JLabel lblPelicula = new JLabel("Pelicula:");
		JLabel lblHorario = new JLabel("Horario:");
		JLabel lblCantidadTickets = new JLabel("Cantidad Tickets:");
		JLabel lblImporteTotal = new JLabel("Importe Total:");
		lblPel = new JLabel("");
		lblHor = new JLabel("");
		lblTot = new JLabel("");
		lblImp = new JLabel("");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(120)
							.addComponent(lblP))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblHorario)
								.addComponent(lblPelicula))
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGap(72)
									.addComponent(lblPel))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGap(50)
									.addComponent(lblHor))))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblCantidadTickets)
							.addGap(18)
							.addComponent(lblTot)))
					.addContainerGap(121, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap(195, Short.MAX_VALUE)
					.addComponent(lblImporteTotal)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblImp)
					.addGap(93))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(lblP)
					.addGap(31)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPelicula)
						.addComponent(lblPel))
					.addGap(26)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHorario)
						.addComponent(lblHor))
					.addGap(26)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCantidadTickets)
						.addComponent(lblTot))
					.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblImporteTotal)
						.addComponent(lblImp))
					.addGap(25))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		
		this.lblHor.setText(horario);
		this.lblPel.setText(pelicula);
		this.lblTot.setText(cantidad);
		
		double cant = Venta.getPrecioEntrada() * Double.parseDouble(cantidad);
		this.lblImp.setText(String.valueOf(cant));
		
		
	}

}
