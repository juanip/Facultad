
public class Gen {
	private boolean value;
	private int posicion;

	Gen(int posicion){
		boolean value = Math.random() < 0.5 ? true : false;
		this.setValue(value);
		this.setPosicion(posicion);
	}
	
	public void mutar() {
		this.value = this.value ? false : true;
	}
	
	public double getDecimal() {
		return this.value ? Math.pow(2, this.getPosicion()) : 0;
	}
	
	public boolean getValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}
	
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	
	public int getPosicion() {
		return this.posicion;
	}
		
}
