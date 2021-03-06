public abstract class Device {
	private int id;
	private int serial;
	private String name;
	private String brand;
	private String model;
	
	Device(int id, int serial, String name, String brand, String model){
		setId(id);
		setSerial(serial);
		setName(name);
		setBrand(brand);
		setModel(model);
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getSerial() {
		return serial;
	}
	
	public void setSerial(int serial) {
		this.serial = serial;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	//reemplazado por interfaz
	//override by weightable classes
	//public double getWeight() {
	//	return -1;
	//}
	
}
