
public class Cromosoma {

	private int ruleta;
	private double fObjetivo;
	private double fFitness;
	private long decimal;
	private int generacion;
	private Gen[] genes;
	
	Cromosoma(int generacion, Gen[] genes) {
		this.setGeneracion(generacion);
		this.setGenes(genes);
		this.setDecimal();
		this.setfObjetivo();
	}
	
	public void setDecimal() {
		long decimal = 0;
		for(int i=0;i<30;i++){
			decimal += this.getGen(i).getDecimal();
		}
		this.decimal = decimal;
	}
	
	public void setfObjetivo() {
		this.fObjetivo = this.getDecimal() / (Math.pow(2, 30) - 1);
	}
	
	public void setGenes(Gen[] genes){
		this.genes = genes;
	}
	
	public Gen getGen(int index) {
		return this.getGenes()[index];
	}
	
	public Gen[] getGenes() {
		return this.genes;
	}
	
	public double getRuleta() {
		return ruleta;
	}
	public void setRuleta(int ruleta) {
		this.ruleta = ruleta;
	}
	public double getfObjetivo() {
		return fObjetivo;
	}
	
	public double getfFitness() {
		return fFitness;
	}
	public void setfFitness(double fFitness) {
		this.fFitness = fFitness;
	}
	public long getDecimal() {
		return decimal;
	}
	
	public int getGeneracion() {
		return generacion;
	}
	public void setGeneracion(int generacion) {
		this.generacion = generacion;
	}
	
	
}
