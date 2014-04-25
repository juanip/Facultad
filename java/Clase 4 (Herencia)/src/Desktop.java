public class Desktop extends PC {
	private int box;
	
	Desktop(int id, int serial, String name, String brand, String model, int cores, int ramGB, String OS, int box){
		super(id, serial, name, brand, model, cores, ramGB, OS);
		setBox(box);
	}
	
	public void setBox(int box){
		this.box = box;
	}
	
	public int getBox(){
		return this.box;
	}
}
