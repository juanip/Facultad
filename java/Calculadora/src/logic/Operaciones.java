package logic;

public class Operaciones {
	private double num1;
	private double num2;
	
	private String limpiarNumero(Double num) {
		return num.toString().endsWith(".0") ? num.toString().replace(".0", "") : num.toString(); 
	}
	
	private void setNumeros(String a, String b) throws NumberFormatException {
		try {
			this.num1 = Double.parseDouble(a);
			this.num2 = Double.parseDouble(b);
		} catch (NumberFormatException e) {
			throw e;
		}
	}
	
	public String sumar(String a, String b) throws NumberFormatException {
		try {
			this.setNumeros(a,b);
		}
		catch (NumberFormatException e) {
			throw e;
		}
		
		Double num3 = this.num1 + this.num2;
		
		return this.limpiarNumero(num3);
	}
	
	public String restar(String a, String b) throws NumberFormatException {
		try {
			this.setNumeros(a,b);
		}
		catch (NumberFormatException e) {
			throw e;
		}
		
		Double num3 = this.num1 - this.num2;
		return this.limpiarNumero(num3);
	}
	
	public String multiplicar(String a, String b) throws NumberFormatException {
		try {
			this.setNumeros(a,b);
		}
		catch (NumberFormatException e) {
			throw e;
		}
		
		Double num3 = this.num1 * this.num2;
		return this.limpiarNumero(num3);
	}
	
	public String dividir(String a, String b) throws DivideByZeroException, NumberFormatException {
		try {
			this.setNumeros(a,b);
		}
		catch (NumberFormatException e) {
			throw e;
		}
		
		if(this.num2 == 0) {
			throw new DivideByZeroException();
		}
		
		Double num3 = this.num1 / this.num2;	
		return this.limpiarNumero(num3);
	}
}