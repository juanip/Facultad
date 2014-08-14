package entidades;

public class Lavarropas extends Electrodomestico {

	public static double CARGADEFAULT = 5;
	
	private double carga;
	
	Lavarropas() { 
		super();
		this.setCarga(CARGADEFAULT);
	}
	
	Lavarropas(double precio, double peso) { 
		super(precio, peso);
		this.setCarga(CARGADEFAULT);
	}
	
	Lavarropas(double precio, double peso, String color, char consumo, double carga) {
		super(precio, peso, color, consumo);
		this.setCarga(carga);
	}
	
	public double precioFinal() { 
		if(this.getCarga() > 30) {
			return super.precioFinal() + 50;
		}
		else {
			return super.precioFinal();
		}
	}

	public double getCarga() {
		return carga;
	}

	public void setCarga(double carga) {
		this.carga = carga;
	}
	
	
}
