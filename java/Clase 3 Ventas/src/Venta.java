import java.util.ArrayList;

public class Venta {
	private int nroFactura;
	private double porcetajeDescuento;
	private ArrayList<DetalleVenta> detallesVenta = new ArrayList<DetalleVenta>();
	
	public Venta(int nroFactura, double porcentajeDescuento){
		setNroFactura(nroFactura);
		setPorcetajeDescuento(porcentajeDescuento);
	}
	
	public void addArticulo(Articulo articulo, double cantidad){
		DetalleVenta detalleVenta = new DetalleVenta(articulo,cantidad);
		this.detallesVenta.add(detalleVenta);
	}
	
	public int getNroFactura() {
		return nroFactura;
	}
	
	public void setNroFactura(int nroFactura) {
		this.nroFactura = nroFactura;
	}
	
	public double getPorcetajeDescuento() {
		return porcetajeDescuento;
	}
	
	public void setPorcetajeDescuento(double porcetajeDescuento) {
		this.porcetajeDescuento = porcetajeDescuento;
	}
	
	public double getTotal(){
		return getTotalSinDto() - (getTotalSinDto() * this.porcetajeDescuento);		
	}
	
	public double getTotalSinDto(){
		double totalSinDto = 0;
		for(int i=0;i<this.detallesVenta.size();i++){
			totalSinDto += detallesVenta.get(i).getSubtotal();
		}		
		return totalSinDto;
	}
	
}
