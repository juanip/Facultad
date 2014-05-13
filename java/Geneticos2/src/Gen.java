
public class Gen {

	private boolean valor;
	private int posicion;
	private double decimal;
	
	Gen(int posicion) {
		this.setPosicion(posicion);
		this.setValor();
		this.setDecimal(); 
	}

	private void setDecimal() {
		this.decimal = this.getValor() ? Math.pow(2, this.getPosicion()) : 0;
	}
	
	public void mutar() {
		this.valor = this.valor ? false : true;
		setDecimal();
	}
	//getters & setters 
	
	public double getDecimal() {
		return this.decimal;
	}
	
	public boolean getValor() {
		return valor;
	}

	private void setValor() {
		this.valor = Math.random() < 0.5 ? true : false;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}	
}
