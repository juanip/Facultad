
public class DetalleVenta {
	private double cantidad;
	private Articulo articulo;

	public DetalleVenta(Articulo articulo, double cantidad){
		setArticulo(articulo);
		setCantidad(cantidad);
	}
	
	public void setCantidad(double cantidad){
		this.cantidad = cantidad;
	}
	
	public void setArticulo(Articulo articulo){
		this.articulo = articulo;
	}
	
	public Articulo getArticulo(){
		return this.articulo;
	}
	
	public double getSubtotal(){
		return articulo.getPrecio() * this.cantidad;		
	}
}
