public class Tablet extends Device implements IConPeso{
	private double weight;
	private String tactilTechnology;
	private String maxResolution;
	private String displaySize;
	
	Tablet(int id, int serial, String name, String brand, String model, double weight, String tactilTechnology, String maxResolution, String displaySize){
		super(id, serial, name, brand, model);
		setWeight(weight);
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
