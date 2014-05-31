package logic;

public class Operaciones {
	private double num1;
	private double num2;
	
	private void setNumeros(String a, String b) throws NumberFormatException {
		try {
			this.num1 = Double.parseDouble(a);
		} catch (NumberFormatException e) {
			throw e;
		}
		
		try {
			this.num2 = Double.parseDouble(b);
		} catch (NumberFormatException e) {
			throw e;
		}
	}
	
	public String sumar(String a, String b) throws NumberFormatException{
		try {
			this.setNumeros(a,b);
		}
		catch (NumberFormatException e) {
			throw e;
		}
		
		Double num3 = this.num1 + this.num2;
		return num3.toString();
	}
	
	public String restar(String a, String b) {
		try {
			this.setNumeros(a,b);
		}
		catch (NumberFormatException e) {
			throw e;
		}
		
		Double num3 = this.num1 - this.num2;
		return num3.toString();
	}
	
	public String multiplicar(String a, String b) {
		try {
			this.setNumeros(a,b);
		}
		catch (NumberFormatException e) {
			throw e;
		}
		
		Double num3 = this.num1 * this.num2;
		return num3.toString();
	}
	
	public String dividir(String a, String b) throws DivideByZeroException {
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
		return num3.toString();
	}
}
