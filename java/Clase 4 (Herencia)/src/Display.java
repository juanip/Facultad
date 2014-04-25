public class Display extends Device {
	private String tactilTechnology;
	private String maxResolution;
	private String displaySize;
	
	Display(int id, int serial, String name, String brand, String model, String tactilTechnology, String maxResolution, String displaySize){
		super(id, serial, name, brand, model);
		setTactilTechnology(tactilTechnology);
		setMaxResolution(maxResolution);
		setDisplaySize(displaySize);		
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
