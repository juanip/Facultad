package entidades;

public class ConsumoEnergetico {

	public static ConsumoEnergetico DEFAULT = new ConsumoEnergetico('F');
	
	private char clasificacion;

	ConsumoEnergetico(char clasificacion) {
		this.setClasificacion(clasificacion);
	}
	
	public double recargoConsumo() {
		switch (this.getClasificacion()) {
		case 'A':
			return 100;
			
		case 'B':
			return 80;
			
		case 'C':
			return 60;
			
		case 'D':
			return 50;
			
		case 'E':
			return 30;
			
		case 'F':
			return 10;
			
		default:
			return 10;
		}
	}
	
	
	public char getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(char clasificacion) {
		this.clasificacion = clasificacion;
	}
	
	
}
