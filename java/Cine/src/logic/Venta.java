package logic;

public class Venta {

	public static double precioEntrada = 47;
	
	private String pelicula;
	private String horario;
	private int cantEntradas;
	private double importeTotal;
	
	public Venta(String pelicula, String horario, int cantEntradas) {
		setPelicula(pelicula);
		setHorario(horario);
		setCantEntradas(cantEntradas);
		setImporteTotal();
	}
	
	
	public static double getPrecioEntrada() {
		return precioEntrada;
	}
	
	public String getPelicula() {
		return pelicula;
	}
	
	public String getHorario() {
		return horario;
	}
	
	public int getCantEntradas() {
		return cantEntradas;
	}
	
	public String getImporteTotal() {
		return Double.toString(importeTotal);
	}

	public void setPelicula(String pelicula) {
		this.pelicula = pelicula;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public void setCantEntradas(int cantEntradas) {
		this.cantEntradas = cantEntradas;
	}

	private void setImporteTotal() {
		this.importeTotal = Venta.getPrecioEntrada() * getCantEntradas();
	}
}
