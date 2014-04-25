
public class Articulo {
	private int id;
	private String description;
	private int stock;
	private double precio;
	
	public Articulo(int id, String descripcion, int stock, double precio){
		setId(id);
		setDescription(descripcion);
		setStock(stock);
		setPrecio(precio);
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
}
