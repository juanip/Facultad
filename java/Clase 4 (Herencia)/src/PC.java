public class PC extends Device {
	private int cores;
	private int ramGb;
	private String OS;
	
	PC(int id, int serial, String name, String brand, String model, int cores, int ramGB, String OS){
		super(id, serial, name, brand, model);
		setCores(cores);
		setRamGb(ramGB);
		setOS(OS);
	}
	
	public int getCores() {
		return cores;
	}
	
	public void setCores(int cores) {
		this.cores = cores;
	}
	
	public int getRamGb() {
		return ramGb;
	}
	
	public void setRamGb(int ramGb) {
		this.ramGb = ramGb;
	}
	
	public String getOS() {
		return OS;
	}
	
	public void setOS(String oS) {
		OS = oS;
	}
	
	
	
}
