package manejoDeErrores;

import java.awt.HeadlessException;

import javax.swing.*;

public class Principal {
	public static void main(String[] args) {
		String rta = JOptionPane.showInputDialog(null, "Ingrese un número", "Ejemplo TryCatch", JOptionPane.INFORMATION_MESSAGE);
		
		try {
			int nro = Integer.parseInt(rta);
			String mensaje;
			if(nro < 10){
				mensaje = "El número ingresado es menor que diez";
			}
			else if(nro > 10){
				mensaje = "El número ingresado es mayor que diez";
			}
			else{
				mensaje = "Hey mannn, pusiste un diez";
			}
			
			
			
			JOptionPane.showMessageDialog(null, mensaje);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Hey, mann, le batiste cualquiera", "Boludo/a!", JOptionPane.QUESTION_MESSAGE );
			} catch (HeadlessException e) {
				e.printStackTrace();
			}
			finally {
				JOptionPane.showMessageDialog(null, "The end.......");
			}
		}

}