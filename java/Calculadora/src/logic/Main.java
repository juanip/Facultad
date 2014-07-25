package logic;

import ui.VentanaPpal;

public class Main {

	public static void main(String[] args) {

		Operaciones op = new Operaciones();
		VentanaPpal ventana = new VentanaPpal(op);
		
		ventana.setVisible(true);
	}

}