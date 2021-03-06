import java.util.ArrayList;

public class Owner {
	private int id;
	private String name;
	private String jobTitle;
	private ArrayList<Device> devices;
	
	public void addDevice(Device device){
		this.devices.add(device);
	}
	
	public ArrayList<Device> getDevices(){
		return this.devices;
	}
	
	public ArrayList<Device> getDevicesLighterThan(double maxWeight){
		ArrayList<Device> devicesLighterThan = new ArrayList<Device>();
		
		for(int i=0;i<getDevices().size();i++){
			if(this.getDevices().get(i) instanceof IConPeso){
				if(this.getDevices().get(i).getWeight() < maxWeight){
					devicesLighterThan.add(getDevices().get(i));
				}
			}
		}
		
		return devicesLighterThan;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}	
}
