import java.util.ArrayList;

public class Cliente {
	private int id;
	private String razonSocial;
	private ArrayList<Venta> ventas = new ArrayList<Venta>();
	
	public Cliente(int id, String razonSocial){
		setId(id);
		setRazonSocial(razonSocial);
	}
	
	public void addVenta(Venta venta){
		this.ventas.add(venta);
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getRazonSocial() {
		return razonSocial;
	}
	
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}	
	
}
