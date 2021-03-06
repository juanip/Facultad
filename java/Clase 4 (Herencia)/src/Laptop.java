public class Laptop extends PC implements IConPeso{
	private double weight;
	private String ensurenceCompany;
	private int ensurenceContract;
	private String tactilTechnology;
	private String maxResolution;
	private String displaySize;
	
	Laptop(int id, int serial, String name, String brand, String model, int cores, int ramGB, String OS, double weight, String ensurenceCompany, int ensurenceContract, String tactilTechnology, String maxResolution, String displaySize){
		super(id, serial, name, brand, model, cores, ramGB, OS);
		setWeight(weight);
		setEnsurenceCompany(ensurenceCompany);
		setEnsurenceContract(ensurenceContract);
		setTactilTechnology(tactilTechnology);
		setMaxResolution(maxResolution);
		setDisplaySize(displaySize);
	}

		
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public String getEnsurenceCompany() {
		return ensurenceCompany;
	}
	
	public void setEnsurenceCompany(String ensurenceCompany) {
		this.ensurenceCompany = ensurenceCompany;
	}
	
	public int getEnsurenceContract() {
		return ensurenceContract;
	}
	
	public void setEnsurenceContract(int ensurenceContract) {
		this.ensurenceContract = ensurenceContract;
	}
	
	public String getTactilTechnology() {
		return tactilTechnology;
	}
	
	public void setTactilTechnology(String tactilTechnology) {
		this.tactilTechnology = tactilTechnology;
	}
	
	public String getMaxResolution() {
		return maxResolution;
	}
	
	public void setMaxResolution(String maxResolution) {
		this.maxResolution = maxResolution;
	}
	
	public String getDisplaySize() {
		return displaySize;
	}
	
	public void setDisplaySize(String displaySize) {
		this.displaySize = displaySize;
	}
	
	
}
