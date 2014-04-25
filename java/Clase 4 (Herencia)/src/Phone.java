public class Phone extends Device{
	private int number;
	private int freeSms;
	private double freeInternet;
	private double freeCallMinutes;
	private int usedSms;
	private double usedCallMinutes;
	private double usedInternet;
	
	Phone(int id, int serial, String name, String brand, String model, int number, int freeSms, double freeInternet, double freeCallMinutes){
		super(id, serial, name, brand, model);
		setFreeCallMinutes(freeCallMinutes);
		setFreeInternet(freeInternet);
		setFreeSms(freeSms);
		setNumber(number);
	}
	
	public int getRemainingSms(){
		return getFreeSms() - getUsedSms();
	}
	
	public double getRemainsCallMinutes(){
		return getFreeCallMinutes() - getRemainsCallMinutes();
	}
	
	public double getRemainingInternet(){
		return getFreeInternet() - getUsedInternet();
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getFreeSms() {
		return freeSms;
	}

	public void setFreeSms(int freeSms) {
		this.freeSms = freeSms;
	}

	public double getFreeCallMinutes() {
		return freeCallMinutes;
	}

	public void setFreeCallMinutes(double freeCallMinutes) {
		this.freeCallMinutes = freeCallMinutes;
	}

	public int getUsedSms() {
		return usedSms;
	}

	public void setUsedSms(int usedSms) {
		this.usedSms = usedSms;
	}

	public double getUsedCallMinutes() {
		return usedCallMinutes;
	}

	public void setUsedCallMinutes(double usedCallMinutes) {
		this.usedCallMinutes = usedCallMinutes;
	}

	public double getUsedInternet() {
		return usedInternet;
	}

	public void setUsedInternet(double usedInternet) {
		this.usedInternet = usedInternet;
	}

	public double getFreeInternet() {
		return freeInternet;
	}

	public void setFreeInternet(double freeInternet) {
		this.freeInternet = freeInternet;
	}
	
	
}
